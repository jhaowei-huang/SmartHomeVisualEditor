package c4lab.iot.smarthomevisualeditor.page;

import java.util.List;

import com.vaadin.ui.Button;
import com.vaadin.ui.TabSheet.Tab;

import c4lab.iot.smarthomevisualeditor.ddsource.UISource;
import c4lab.iot.smarthomevisualeditor.design.EditorPageDesign;
import c4lab.iot.smarthomevisualeditor.ddsource.model.IoTData;
import c4lab.iot.smarthomevisualeditor.ddsource.model.TypeID;
import fi.jasoft.dragdroplayouts.client.ui.LayoutDragMode;

public class EditorPage extends EditorPageDesign {
	private final String roomList[] = { "Living Room", "Bedroom", "Bathroom", "Kitchen" };
	private final String sensorList[] = { "temperature", "humidity", "bright", "Smoke", "CO2", "PIR" };
	private final String applianceList[] = { "空氣清淨機", "電扇", "咖啡機", "電燈", "暖氣機", "Kinect/攝影機", "掃地機器人" };
	private Tab tabs[];

	public EditorPage() {
		super();
		accordion.setDragMode(LayoutDragMode.NONE);

		int numOfTab = 0;
		tabs = new Tab[3];
		// 讀取room清單、sensor清單以及家電清單，加入accordion裡
		addTabToAccordion(roomList, "Room", numOfTab++, true);
		// addTabToAccordion(sensorList, "Sensor", numOfTab++, false);
		// addTabToAccordion(applianceList, "Home Appliance", numOfTab++, false);
		
		final IoTData iotData = new IoTData();
		addTabToAccordion(iotData.getTypeIDs(), "Sensor", numOfTab++, false);
		addTabToAccordion(iotData.getTypeIDs(), "Home Appliance", numOfTab++, false);
	}

	private void addTabToAccordion(String[] list, String nameOfTab, int position, boolean isContainer) {
		AccordionTab tab = new AccordionTab();
		
		for (String name : list) {
			UISource rs = new UISource(new Button(name), name);
			rs.setIsContainer(isContainer);		
			tab.addComponentToDDLayout(rs);
		}
		
		tabs[position] = accordion.addTab(tab, position);
		tabs[position].setCaption(nameOfTab);
	}
	
	private void addTabToAccordion(List<TypeID> list, String nameOfTab, int position, boolean isContainer) {
		AccordionTab tab = new AccordionTab();
		
		for(TypeID t : list) {
			System.out.println(t.getName() + " = " + t.getId());
			UISource rs = new UISource(new Button(t.getName()), t.getName());
			rs.setType(t.getId() + "");
			rs.setIsContainer(isContainer);		
			tab.addComponentToDDLayout(rs);
		}
		
		tabs[position] = accordion.addTab(tab, position);
		tabs[position].setCaption(nameOfTab);
	}
}
