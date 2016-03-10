package c4lab.iot.smarthomevisualeditor.page;

import com.vaadin.ui.Component;

import c4lab.iot.smarthomevisualeditor.design.AccordionTabDesign;
import fi.jasoft.dragdroplayouts.client.ui.LayoutDragMode;

public class AccordionTab extends AccordionTabDesign {
	public AccordionTab() {
		super();
		
		verticalLayout.setHeightUndefined();
		verticalLayout.setDragMode(LayoutDragMode.CLONE);
	}
	
	public void addComponentToDDLayout(Component c) {
		verticalLayout.addComponent(c);
		verticalLayout.setExpandRatio(c, 0f);
	}
}
