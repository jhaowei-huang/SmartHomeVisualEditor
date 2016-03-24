package c4lab.iot.smarthomevisualeditor.ddsource;

import java.util.ArrayList;

import com.vaadin.event.MouseEvents;
import com.vaadin.event.MouseEvents.ClickEvent;
import com.vaadin.event.dd.DragAndDropEvent;
import com.vaadin.server.Sizeable;
import com.vaadin.server.ThemeResource;
import com.vaadin.shared.ui.dd.HorizontalDropLocation;
import com.vaadin.shared.ui.dd.VerticalDropLocation;
import com.vaadin.ui.AbsoluteLayout.ComponentPosition;
import com.vaadin.ui.Button;
import com.vaadin.ui.Component;
import com.vaadin.ui.Embedded;
import com.vaadin.ui.Image;
import com.vaadin.ui.Panel;
import com.vaadin.ui.VerticalLayout;

import c4lab.iot.smarthomevisualeditor.page.RoomEditorPage;
import fi.jasoft.dragdroplayouts.DDAbsoluteLayout;
import fi.jasoft.dragdroplayouts.DDCssLayout;
import fi.jasoft.dragdroplayouts.DDCssLayout.CssLayoutTargetDetails;
import fi.jasoft.dragdroplayouts.DDGridLayout;
import fi.jasoft.dragdroplayouts.client.ui.LayoutDragMode;
import fi.jasoft.dragdroplayouts.details.AbsoluteLayoutTargetDetails;
import fi.jasoft.dragdroplayouts.drophandlers.DefaultAbsoluteLayoutDropHandler;
import fi.jasoft.dragdroplayouts.drophandlers.DefaultCssLayoutDropHandler;
import fi.jasoft.dragdroplayouts.events.LayoutBoundTransferable;

public class RoomUISource extends UISource {
	private DDCssLayout roomLayout = new DDCssLayout();
	private DDAbsoluteLayout roomDetailLayout = new DDAbsoluteLayout();

	private RoomModel model;
	private ArrayList<ComponentUISource> componentsList = new ArrayList<ComponentUISource>();

	public RoomUISource(String name) {
		super(new Panel(name), name);
		setIsContainer(true);
		this.setDragMode(LayoutDragMode.CAPTION);
		final Panel panel = (Panel) this.getContent();
		roomLayout.setSizeFull();
		roomLayout.setDropHandler(new DefaultCssLayoutDropHandler() {
			@Override
			public void drop(DragAndDropEvent event) {
				LayoutBoundTransferable transferable = (LayoutBoundTransferable) event.getTransferable();
				CssLayoutTargetDetails details = (CssLayoutTargetDetails) event.getTargetDetails();
				DDCssLayout layout = (DDCssLayout) details.getTarget();
				HorizontalDropLocation hl = details.getHorizontalDropLocation();
				VerticalDropLocation vl = details.getVerticalDropLocation();
				Component s = event.getTransferable().getSourceComponent();
				s.setWidthUndefined();
				int idx = details.getOverIndex();
				// VerticalDropLocation loc = details.getDropLocation();
				Component component = transferable.getComponent();
				Component over = details.getOverComponent();
				// if (loc == VerticalDropLocation.MIDDLE || loc ==
				// VerticalDropLocation.BOTTOM)
				// idx++;
				if (over == layout) {
		            if (vl == VerticalDropLocation.TOP
		                    || hl == HorizontalDropLocation.LEFT) {
		                idx = 0;
		            } else if (vl == VerticalDropLocation.BOTTOM
		                    || hl == HorizontalDropLocation.RIGHT) {
		                idx = -1;
		            }
		        } else {
		            if (vl == VerticalDropLocation.BOTTOM
		                    || hl == HorizontalDropLocation.RIGHT) {
		                idx++;
		            }
		        }
				
				UISource source = (UISource) component;

				if (!source.isContainer()) {
					ThemeResource res = new ThemeResource("svg/" + source.getType() + ".svg");
					Image btn = new Image(source.getName(), res);
					btn.setDescription(source.getName());
					ComponentUISource cs = new ComponentUISource(btn, source.getName());
					cs.setUid(UISource.randomString());
					cs.setSizeUndefined();
					cs.getContent().setSizeUndefined();
					
					btn.setWidth("40px");
					btn.setHeight("40px");
					System.out.println(cs.getUid());
					componentsList.add(cs);
					if (idx >= 0) {
						layout.addComponent(cs, idx);
					} else {
						layout.addComponent(cs);
					}
				}
				
				s.setWidth("100%");
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
					int leftPixelPosition = (details.getRelativeLeft() / 30) * 30; 
					int topPixelPosition = (details.getRelativeTop() / 30) * 30;
					// System.out.println(leftPixelPosition + ", " + topPixelPosition);
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
			// cs.setWidth("100%");
			// cs.getContent().setWidth("100%");
			roomLayout.addComponent(cs);
		}

		Panel panel = (Panel) this.getContent();
		panel.setContent(roomLayout);
	}
}
