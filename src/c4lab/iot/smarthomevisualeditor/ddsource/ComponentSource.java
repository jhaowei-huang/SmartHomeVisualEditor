package c4lab.iot.smarthomevisualeditor.ddsource;

import com.vaadin.ui.Button;

import fi.jasoft.dragdroplayouts.DDVerticalLayout;

public class ComponentSource extends Source {
	public ComponentSource(String name) {
		super(new Button(name), name);
		this.setIsContainer(false);
		DDVerticalLayout parent = (DDVerticalLayout) this.getContent().getParent();
		parent.setHeightUndefined();
	}
}
