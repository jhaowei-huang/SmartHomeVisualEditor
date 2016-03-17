package c4lab.iot.smarthomevisualeditor.ddsource;

import java.util.ArrayList;

public class RoomModel {
	private String id;
	private String typeId;
	private ArrayList<ComponentModel> componentModelList;
	private boolean flag;
	
	public RoomModel() {
		super();
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

	public ArrayList<ComponentModel> getComponentModelList() {
		return componentModelList;
	}

	public boolean isFlag() {
		return flag;
	}

	public void setFlag(boolean flag) {
		this.flag = flag;
	}
	
}
