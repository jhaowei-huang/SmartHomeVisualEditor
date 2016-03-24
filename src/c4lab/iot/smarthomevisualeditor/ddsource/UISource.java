package c4lab.iot.smarthomevisualeditor.ddsource;

import java.security.SecureRandom;

import com.vaadin.ui.Component;
import fi.jasoft.dragdroplayouts.DDVerticalLayout;

public class UISource extends DDVerticalLayout {
	static final String SET = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
	static SecureRandom rnd = new SecureRandom();

	private boolean isContainer = false;

	private String uid = "";
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

	public static String randomString() {
		int len = 10;
		StringBuilder sb = new StringBuilder(len);
		for (int i = 0; i < len; i++)
			sb.append(SET.charAt(rnd.nextInt(SET.length())));
		return sb.toString();
	}

	public boolean isContainer() {
		return isContainer;
	}

	public void setIsContainer(boolean isContainer) {
		this.isContainer = isContainer;
	}

	public String getUid() {
		return uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
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
