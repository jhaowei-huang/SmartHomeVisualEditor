package c4lab.iot.smarthomevisualeditor.ddsource;

import com.vaadin.ui.Button;
import com.vaadin.ui.Component;
import com.vaadin.ui.Label;

import fi.jasoft.dragdroplayouts.DDVerticalLayout;

public class ComponentUISource extends UISource {
	private ComponentModel model;
	private int positionX = 0;
	private int positionY = 0;
	
	public ComponentUISource(Component c, String name) {
		super(c, name);
		this.setIsContainer(false);
		DDVerticalLayout parent = (DDVerticalLayout) this.getContent().getParent();
		parent.setHeightUndefined();
	}
	
	public ComponentUISource(ComponentUISource cs) {
		super(cs.getName());
		this.setWidthUndefined();
		this.setHeightUndefined();
		this.setId(cs.getId());
		this.setContent(new Button(cs.getName()));
	}
	
	public ComponentModel getModel() {
		return this.model;
	}
	
	public ComponentUISource caseToDetailComponentUISource() {
		// ComponentUISource clone = new ComponentUISource(this);
		this.setWidthUndefined();
		return this;
	}

	public int getPositionX() {
		return positionX;
	}

	public void setPositionX(int positionX) {
		this.positionX = positionX;
	}

	public int getPositionY() {
		return positionY;
	}

	public void setPositionY(int positionY) {
		this.positionY = positionY;
	}
}
