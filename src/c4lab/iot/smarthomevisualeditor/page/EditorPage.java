package c4lab.iot.smarthomevisualeditor.page;

import com.vaadin.ui.Button;
import com.vaadin.ui.TabSheet.Tab;
import com.vaadin.ui.VerticalLayout;

import c4lab.iot.smarthomevisualeditor.ddsource.ComponentSource;
import c4lab.iot.smarthomevisualeditor.ddsource.RoomSource;
import c4lab.iot.smarthomevisualeditor.ddsource.Source;
import c4lab.iot.smarthomevisualeditor.design.EditorPageDesign;
import fi.jasoft.dragdroplayouts.client.ui.LayoutDragMode;

public class EditorPage extends EditorPageDesign {
	private final String roomList[] = { "Living Room", "Bedroom", "Bathroom", "Kitchen" };
	private final String sensorList[] = { "temperature", "humidity", "bright", "Smoke", "CO", "PIR" };
	private final String applianceList[] = { "�Ů�M�b��", "�q��", "�@�ؾ�", "�q�O", "�x���", "Kinect/��v��", "���a�����H" };
	private Tab tabs[];

	public EditorPage() {
		super();
		accordion.setDragMode(LayoutDragMode.NONE);

		int numOfTab = 0;
		tabs = new Tab[3];
		// Ū��room�M��Bsensor�M��H�ήa�q�M��A�[�Jaccordion��
		addTabToAccordion(roomList, "Room", numOfTab++, true);
		addTabToAccordion(sensorList, "Sensor", numOfTab++, false);
		addTabToAccordion(applianceList, "Home Appliance", numOfTab++, false);
	}

	private void addTabToAccordion(String[] list, String nameOfTab, int position, boolean isContainer) {
		AccordionTab tab = new AccordionTab();
		
		for (String name : list) {
			Source rs = new Source(new Button(name), name);
			rs.setIsContainer(isContainer);		
			tab.addComponentToDDLayout(rs);
		}
		
		tabs[position] = accordion.addTab(tab, position);
		tabs[position].setCaption(nameOfTab);
	}
}