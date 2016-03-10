package c4lab.iot.smarthomevisualeditor.ddsource;

import com.vaadin.ui.Component;
import fi.jasoft.dragdroplayouts.DDVerticalLayout;

public class Source extends DDVerticalLayout {
	private boolean isContainer = false;
	private String id = "";
	private String name = "";
	private String type = "";
	private Component content = null;
	private Class contentClass = null;

	public Source(String name) {
		super();
		this.setSizeFull();
		this.name = name;
	}
	
	public Source(Component c, String name) {
		super();
		this.setSizeFull();
		c.setSizeFull();
		this.content = c;
		this.name = name;
		this.contentClass = c.getClass();
		this.addComponent(this.content);
	}
	
	public boolean isContainer() {
		return isContainer;
	}

	public void setIsContainer(boolean isContainer) {
		this.isContainer = isContainer;
	}
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Component getContent() {
		return content;
	}

	public Class getContentClass() {
		return contentClass;
	}
}
