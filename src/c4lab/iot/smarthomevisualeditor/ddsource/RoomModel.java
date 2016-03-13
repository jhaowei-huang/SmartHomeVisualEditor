package c4lab.iot.smarthomevisualeditor.ddsource;

import java.util.ArrayList;

public class RoomModel {
	private String id;
	private String typeId;
	private ArrayList<String> resourceId;
	private boolean flag;
	
	public RoomModel() {
		
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTypeId() {
		return typeId;
	}

	public void setTypeId(String typeId) {
		this.typeId = typeId;
	}

	public ArrayList<String> getResourceId() {
		return resourceId;
	}

	public void setResourceId(ArrayList<String> resourceId) {
		this.resourceId = resourceId;
	}

	public boolean isFlag() {
		return flag;
	}

	public void setFlag(boolean flag) {
		this.flag = flag;
	}
	
}
