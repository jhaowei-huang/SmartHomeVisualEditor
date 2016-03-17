package c4lab.iot.smarthomevisualeditor.page;

import com.vaadin.ui.Button;
import com.vaadin.ui.Panel;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.VerticalLayout;

import c4lab.iot.smarthomevisualeditor.ddsource.RoomUISource;
import c4lab.iot.smarthomevisualeditor.design.RoomEditorPageDesign;
import fi.jasoft.dragdroplayouts.DDGridLayout;

public class RoomEditorPage extends RoomEditorPageDesign {
	private DDGridLayout previous;
	private RoomUISource rs;
	private int rsColumns = 0;
	private int rsRows = 0;
	
	public RoomEditorPage(RoomUISource rs) {
		super();
		this.rs = rs;
		lblRoomName.setValue(" Name: " + rs.getName());
		lblRoomType.setValue(" Type: " + rs.getType());
		
		btnSaveReturn.addClickListener(new Button.ClickListener() {
		    public void buttonClick(ClickEvent event) {
		        VerticalLayout parent = (VerticalLayout) RoomEditorPage.this.getParent();
		        parent.removeAllComponents();
		        parent.addComponent(previous);
		        detailLayout.removeAllComponents();
		        rs.hideToSchematic();
		        previous.addComponent(rs, rsColumns, rsRows);
		    }
		});
	}
	
	public void setPrevious(DDGridLayout previous) {
		this.previous = previous;
		rsColumns = previous.getComponentArea(rs).getColumn1();
		rsRows = previous.getComponentArea(rs).getRow1();
	}
	
	public void changeToDetailPage() {
		detailLayout.addComponent(rs);
		rs.penddingToDetail();
	}
	
	public void changeToSchematicPage() {
		
	}
}
