package c4lab.iot.smarthomevisualeditor.ddsource;

import com.vaadin.event.MouseEvents;
import com.vaadin.event.MouseEvents.ClickEvent;
import com.vaadin.event.dd.DragAndDropEvent;
import com.vaadin.shared.ui.dd.VerticalDropLocation;
import com.vaadin.ui.AbstractOrderedLayout;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Component;
import com.vaadin.ui.Panel;
import com.vaadin.ui.VerticalLayout;

import c4lab.iot.smarthomevisualeditor.page.RoomEditorPage;
import c4lab.iot.smarthomevisualeditor.page.TargetDisplay;
import fi.jasoft.dragdroplayouts.DDGridLayout;
import fi.jasoft.dragdroplayouts.DDVerticalLayout;
import fi.jasoft.dragdroplayouts.client.ui.LayoutDragMode;
import fi.jasoft.dragdroplayouts.drophandlers.DefaultVerticalLayoutDropHandler;
import fi.jasoft.dragdroplayouts.events.LayoutBoundTransferable;

public class RoomSource extends Source {
	private DDVerticalLayout roomLayout = new DDVerticalLayout();
	ArrayList<ComponentSource> 
	public RoomSource(String name) {
		super(new Panel(name), name);
		setIsContainer(true);
		this.setDragMode(LayoutDragMode.CAPTION);
		roomLayout.setSizeFull();

		Panel panel = (Panel) this.getContent();
		panel.setContent(roomLayout);
		roomLayout.setDropHandler(new DefaultVerticalLayoutDropHandler(Alignment.TOP_CENTER) {
			@Override
			public void drop(DragAndDropEvent event) {
				LayoutBoundTransferable transferable = (LayoutBoundTransferable) event
		                .getTransferable();
				
				VerticalLayoutTargetDetails details = (VerticalLayoutTargetDetails) event
		                .getTargetDetails();
		        AbstractOrderedLayout layout = (AbstractOrderedLayout) details
		                .getTarget();
		        // Component source = event.getTransferable().getSourceComponent();
		        int idx = details.getOverIndex();
				VerticalDropLocation loc = details.getDropLocation();
				Component component = transferable.getComponent();
				
				if (loc == VerticalDropLocation.MIDDLE || loc == VerticalDropLocation.BOTTOM)
		            idx++;
				
				Source source = (Source) component;
				
				if(!source.isContainer()) {
					ComponentSource cs = new ComponentSource(source.getName());
			        if (idx >= 0) {
			        	layout.addComponent(cs, idx);
			        } else {
			        	layout.addComponent(cs);
			        }
				}
			}
		});
		
		panel.addClickListener(new MouseEvents.ClickListener() {
			@Override
			public void click(ClickEvent event) {
				if(event.isDoubleClick()) {
					RoomSource rs = (RoomSource) event.getComponent().getParent();
					DDGridLayout grid = (DDGridLayout) event.getComponent().getParent().getParent();
					VerticalLayout parent = (VerticalLayout) grid.getParent();
					parent.removeAllComponents();
					RoomEditorPage roomEditorPage = new RoomEditorPage();
					roomEditorPage.setPrevious(grid);
					roomEditorPage.setRoomName(rs.getName());
					roomEditorPage.setRoomType(rs.getType());
					parent.addComponent(roomEditorPage);
					
					System.out.println(rs.getName());
				}
			}
		});
	}
	
}
