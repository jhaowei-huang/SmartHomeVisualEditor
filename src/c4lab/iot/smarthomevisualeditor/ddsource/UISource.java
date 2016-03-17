package c4lab.iot.smarthomevisualeditor.ddsource;

import com.vaadin.ui.Component;
import fi.jasoft.dragdroplayouts.DDVerticalLayout;

public class UISource extends DDVerticalLayout {
	private boolean isContainer = false;
	
	private String id = "";
	private String name = "";
	private String type = "";
	private Component content = null;
	private Class contentClass = null;

	public UISource(String name) {
		super();
		this.setSizeFull();
		this.name = name;
	}
	
	public UISource(Component c, String name) {
		super();
		this.setSizeFull();
		this.name = name;
		
		c.setSizeFull();
		this.setContent(c);
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
	
	public void setContent(Component content) {
		this.content = content;
		this.contentClass = content.getClass();
		this.addComponent(this.content);
	}

	public Class getContentClass() {
		return contentClass;
	}
}
