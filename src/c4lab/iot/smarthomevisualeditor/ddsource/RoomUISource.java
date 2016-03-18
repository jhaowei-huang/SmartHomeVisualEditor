package c4lab.iot.smarthomevisualeditor.ddsource;

import java.util.ArrayList;

import com.vaadin.event.MouseEvents;
import com.vaadin.event.MouseEvents.ClickEvent;
import com.vaadin.event.dd.DragAndDropEvent;
import com.vaadin.server.Sizeable;
import com.vaadin.shared.ui.dd.VerticalDropLocation;
import com.vaadin.ui.AbsoluteLayout.ComponentPosition;
import com.vaadin.ui.AbstractOrderedLayout;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.Component;
import com.vaadin.ui.ComponentContainer;
import com.vaadin.ui.Panel;
import com.vaadin.ui.SingleComponentContainer;
import com.vaadin.ui.VerticalLayout;

import c4lab.iot.smarthomevisualeditor.page.RoomEditorPage;
import c4lab.iot.smarthomevisualeditor.page.TargetDisplay;
import fi.jasoft.dragdroplayouts.DDAbsoluteLayout;
import fi.jasoft.dragdroplayouts.DDGridLayout;
import fi.jasoft.dragdroplayouts.DDVerticalLayout;
import fi.jasoft.dragdroplayouts.client.ui.LayoutDragMode;
import fi.jasoft.dragdroplayouts.details.AbsoluteLayoutTargetDetails;
import fi.jasoft.dragdroplayouts.drophandlers.DefaultAbsoluteLayoutDropHandler;
import fi.jasoft.dragdroplayouts.drophandlers.DefaultVerticalLayoutDropHandler;
import fi.jasoft.dragdroplayouts.events.LayoutBoundTransferable;

public class RoomUISource extends UISource {
	private DDVerticalLayout roomLayout = new DDVerticalLayout();
	private DDAbsoluteLayout roomDetailLayout = new DDAbsoluteLayout();

	private RoomModel model;
	private ArrayList<ComponentUISource> componentsList = new ArrayList<ComponentUISource>();

	public RoomUISource(String name) {
		super(new Panel(name), name);
		setIsContainer(true);
		this.setDragMode(LayoutDragMode.CAPTION);
		final Panel panel = (Panel) this.getContent();
		roomLayout.setSizeFull();
		roomLayout.setDropHandler(new DefaultVerticalLayoutDropHandler(Alignment.TOP_CENTER) {
			@Override
			public void drop(DragAndDropEvent event) {
				LayoutBoundTransferable transferable = (LayoutBoundTransferable) event.getTransferable();

				VerticalLayoutTargetDetails details = (VerticalLayoutTargetDetails) event.getTargetDetails();
				AbstractOrderedLayout layout = (AbstractOrderedLayout) details.getTarget();
				// Component source =
				// event.getTransferable().getSourceComponent();
				int idx = details.getOverIndex();
				VerticalDropLocation loc = details.getDropLocation();
				Component component = transferable.getComponent();

				if (loc == VerticalDropLocation.MIDDLE || loc == VerticalDropLocation.BOTTOM)
					idx++;

				UISource source = (UISource) component;

				if (!source.isContainer()) {
					ComponentUISource cs = new ComponentUISource(new Button(source.getName()), source.getName());
					cs.setUid(UISource.randomString());
					System.out.println(cs.getUid());
					componentsList.add(cs);
					if (idx >= 0) {
						layout.addComponent(cs, idx);
					} else {
						layout.addComponent(cs);
					}
				}
			}
		});
		roomDetailLayout.setSizeFull();
		roomDetailLayout.setDragMode(LayoutDragMode.CLONE);
		roomDetailLayout.setDropHandler(new DefaultAbsoluteLayoutDropHandler() {
			@Override
			public void drop(DragAndDropEvent event) {
				LayoutBoundTransferable transferable = (LayoutBoundTransferable) event.getTransferable();
				Component component = transferable.getComponent();
				AbsoluteLayoutTargetDetails details = (AbsoluteLayoutTargetDetails) event.getTargetDetails();
				DDAbsoluteLayout layout = (DDAbsoluteLayout) details.getTarget();
				if (component.getClass().equals(ComponentUISource.class)) {
					// move component
					int leftPixelPosition = details.getRelativeLeft();
					int topPixelPosition = details.getRelativeTop();
					ComponentPosition position = layout.getPosition(component);
					position.setLeft((float) leftPixelPosition, Sizeable.Unit.PIXELS);
					position.setTop((float) topPixelPosition, Sizeable.Unit.PIXELS);
					ComponentUISource cs = (ComponentUISource) component;
					cs.setPositionX(leftPixelPosition);
					cs.setPositionY(topPixelPosition);
				} else if (component.getClass().equals(UISource.class)) {
					// drop to create new component
					UISource source = (UISource) component;
					if (!source.isContainer()) {
						ComponentUISource cs = new ComponentUISource(new Button(source.getName()), source.getName());
						cs.setUid(UISource.randomString());
						cs.setSizeUndefined();
						cs.getContent().setSizeUndefined();
						int leftPixelPosition = details.getRelativeLeft();
						int topPixelPosition = details.getRelativeTop();
						layout.addComponent(cs, "left:" + leftPixelPosition + "px;top:" + topPixelPosition + "px");
						cs.setPositionX(leftPixelPosition);
						cs.setPositionY(topPixelPosition);
						componentsList.add(cs);
					}
				}
			}
		});
		panel.addClickListener(new MouseEvents.ClickListener() {
			@Override
			public void click(ClickEvent event) {
				if (event.isDoubleClick() && panel.getContent() != roomDetailLayout) {
					RoomUISource rs = (RoomUISource) event.getComponent().getParent();
					DDGridLayout grid = (DDGridLayout) event.getComponent().getParent().getParent();
					VerticalLayout parent = (VerticalLayout) grid.getParent();
					parent.removeAllComponents();
					RoomEditorPage roomEditorPage = new RoomEditorPage(RoomUISource.this);
					roomEditorPage.setPrevious(grid);
					parent.addComponent(roomEditorPage);
					roomEditorPage.changeToDetailPage();
				}
			}
		});

		panel.setContent(roomLayout);
	}

	public void penddingToDetail() {
		roomDetailLayout.removeAllComponents();
		for (ComponentUISource cs : componentsList) {
			roomDetailLayout.addComponent(cs.caseToDetailComponentUISource(),
					"top:" + cs.getPositionY() + "px;left:" + cs.getPositionX() + "px");
		}

		Panel panel = (Panel) this.getContent();
		panel.setContent(roomDetailLayout);
	}

	public void hideToSchematic() {
		roomLayout.removeAllComponents();
		for (ComponentUISource cs : componentsList) {
			cs.setWidth("100%");
			cs.getContent().setWidth("100%");
			roomLayout.addComponent(cs);
		}

		Panel panel = (Panel) this.getContent();
		panel.setContent(roomLayout);
	}
}
