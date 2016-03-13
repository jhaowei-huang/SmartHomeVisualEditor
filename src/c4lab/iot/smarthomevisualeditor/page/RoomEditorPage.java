package c4lab.iot.smarthomevisualeditor.page;

import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.VerticalLayout;

import c4lab.iot.smarthomevisualeditor.design.RoomEditorPageDesign;
import fi.jasoft.dragdroplayouts.DDGridLayout;

public class RoomEditorPage extends RoomEditorPageDesign {
	private DDGridLayout previous;
	private String roomName;
	private String roomType;
	
	public RoomEditorPage() {
		super();
		
		btnSaveReturn.addClickListener(new Button.ClickListener() {
		    public void buttonClick(ClickEvent event) {
		        VerticalLayout parent = (VerticalLayout) RoomEditorPage.this.getParent();
		        parent.removeAllComponents();
		        parent.addComponent(previous);
		    }
		});
	}
	
	public void setPrevious(DDGridLayout previous) {
		this.previous = previous;
	}
	
	public void setRoomName(String roomName) {
		this.roomName = roomName;
		lblRoomName.setValue(" Name: " + roomName);
	}
	
	public void setRoomType(String roomType) {
		this.roomType = roomType;
		lblRoomType.setValue(" Type: " + roomType);
	}
}
