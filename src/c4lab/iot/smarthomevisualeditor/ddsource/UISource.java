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
		switch (type) {
		case "8":
			break;
		case "15":
			break;
		case "100":
			break;
		case "101":
			break;
		case "102":
			break;
		case "104":
			break;
		case "105":
			break;
		case "106":
			break;
		case "120":
			break;
		case "121":
			break;
		case "122":
			break;
		case "200":
			break;
		case "201":
			break;
		case "202":
			break;
		case "203":
			break;
		case "204":
			break;
		case "300":
			break;
		default:
			break;
		}
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
