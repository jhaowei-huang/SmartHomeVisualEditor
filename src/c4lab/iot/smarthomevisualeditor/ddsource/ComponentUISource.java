package c4lab.iot.smarthomevisualeditor.ddsource;

import com.vaadin.event.ContextClickEvent;
import com.vaadin.ui.Button;
import com.vaadin.ui.Component;
import com.vaadin.ui.Image;
import com.vaadin.ui.Notification;
import com.vaadin.ui.UI;
import com.vaadin.ui.Window;

import c4lab.iot.smarthomevisualeditor.page.ComponentEditorPage;
import fi.jasoft.dragdroplayouts.DDVerticalLayout;
import fi.jasoft.dragdroplayouts.client.ui.LayoutDragMode;

public class ComponentUISource extends UISource {
	private ComponentModel model;
	private int positionX = 0;
	private int positionY = 0;
	
	public ComponentUISource(Component c, String name) {
		super(c, name);
		c.addStyleName("btnnobackground");
		this.setIsContainer(false);
		DDVerticalLayout parent = (DDVerticalLayout) this.getContent().getParent();
		parent.setHeightUndefined();
		parent.setDragMode(LayoutDragMode.CLONE);
		if(c.getClass().equals(Image.class)) {
			Image img = (Image) c;
			img.setCaption(null);
			img.addContextClickListener(new ContextClickEvent.ContextClickListener() {
				@Override
				public void contextClick(ContextClickEvent event) {
					final Window window = new Window(ComponentUISource.this.getName() + " edit window");
				    window.setWidth(300.0f, Unit.PIXELS);
				    ComponentEditorPage content = new ComponentEditorPage(ComponentUISource.this.getName());
				    window.setContent(content);
				    window.setModal(true);
				    UI.getCurrent().addWindow(window);
				}
			});
		}
	}
	
	public ComponentUISource(ComponentUISource cs) {
		super(cs.getName());
		this.setWidthUndefined();
		this.setHeightUndefined();
		this.setUid(cs.getUid());
		this.setContent(new Button(cs.getName()));
	}
	
	public ComponentModel getModel() {
		return this.model;
	}
	
	public ComponentUISource caseToDetailComponentUISource() {
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
