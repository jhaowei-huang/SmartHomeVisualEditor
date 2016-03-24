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
	private final String applianceList[] = { "�Ů�M�b��", "�q��", "�@�ؾ�", "�q�O", "�x���", "Kinect/��v��", "���a�����H" };
	private AccordionTab tabs[];

	public EditorPage() {
		super();
		accordion.setDragMode(LayoutDragMode.NONE);

		int numOfTab = 0;
		tabs = new AccordionTab[3];
		// Ū��room�M��Bsensor�M��H�ήa�q�M��A�[�Jaccordion��
		addTabToAccordion(roomList, "Room", numOfTab++, true);
		// addTabToAccordion(sensorList, "Sensor", numOfTab++, false);
		// addTabToAccordion(applianceList, "Home Appliance", numOfTab++,
		// false);

		final IoTData iotData = new IoTData();
		addTabToAccordion("Sensor", numOfTab++);
		addTabToAccordion("Home Appliance", numOfTab++);
		addComponentToTab(iotData.getTypeIDs());
	}

	private void addTabToAccordion(String[] list, String nameOfTab, int position, boolean isContainer) {
		AccordionTab tab = new AccordionTab();

		for (String name : list) {
			UISource rs = new UISource(new Button(name), name);
			rs.setIsContainer(isContainer);
			tab.addComponentToDDLayout(rs);
		}
		tabs[position] = tab;
		Tab t = accordion.addTab(tab, position);
		t.setCaption(nameOfTab);
	}

	private void addTabToAccordion(String nameOfTab, int position) {
		AccordionTab tab = new AccordionTab();
		tabs[position] = tab;
		Tab t = accordion.addTab(tab, position);
		t.setCaption(nameOfTab);
	}

	private void addComponentToTab(List<TypeID> list) {
		// typeid = 120, 121, 122
		for (TypeID t : list) {
			UISource rs = new UISource(new Button(t.getName()), t.getName());
			rs.setType(t.getId() + "");
			rs.setIsContainer(false);
			// sensor tab
			if (t.getId() == 120 || t.getId() == 121 || t.getId() == 122) {
				AccordionTab tab = tabs[1];
				tab.addComponentToDDLayout(rs);
			} else {
				AccordionTab tab = tabs[2];
				tab.addComponentToDDLayout(rs);
			}
		}
	}
}
