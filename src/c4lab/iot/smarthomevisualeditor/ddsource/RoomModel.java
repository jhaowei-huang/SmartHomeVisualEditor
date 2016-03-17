package c4lab.iot.smarthomevisualeditor.ddsource;

import java.util.ArrayList;

public class RoomModel {
	// room status
	private String id;
	private String typeId;
	private String temperature;
	private String humidity;
	private String brightness;
	private int peopleCount;
	private String co2;
	private String pm25;
	private String co;
	private String vco;
	private ArrayList<ComponentModel> componentModelList;
	// user preference
	private String typeIdPref;
	private String temperaturePref;
	private String humidityPref;
	private String brightnessPref;
	private String co2Pref;
	private String pm25Pref;
	private String coPref;
	private String vcoPref;

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

	public String getTemperature() {
		return temperature;
	}

	public void setTemperature(String temperature) {
		this.temperature = temperature;
	}

	public String getHumidity() {
		return humidity;
	}

	public void setHumidity(String humidity) {
		this.humidity = humidity;
	}

	public String getBrightness() {
		return brightness;
	}

	public void setBrightness(String brightness) {
		this.brightness = brightness;
	}

	public int getPeopleCount() {
		return peopleCount;
	}

	public void setPeopleCount(int peopleCount) {
		this.peopleCount = peopleCount;
	}

	public String getCo2() {
		return co2;
	}

	public void setCo2(String co2) {
		this.co2 = co2;
	}

	public String getPm25() {
		return pm25;
	}

	public void setPm25(String pm25) {
		this.pm25 = pm25;
	}

	public String getCo() {
		return co;
	}

	public void setCo(String co) {
		this.co = co;
	}

	public String getVco() {
		return vco;
	}

	public void setVco(String vco) {
		this.vco = vco;
	}

	public ArrayList<ComponentModel> getComponentModelList() {
		return componentModelList;
	}

	public void setComponentModelList(ArrayList<ComponentModel> componentModelList) {
		this.componentModelList = componentModelList;
	}
	
	public String getTypeIdPref() {
		return typeIdPref;
	}

	public void setTypeIdPref(String typeIdPref) {
		this.typeIdPref = typeIdPref;
	}

	public String getTemperaturePref() {
		return temperaturePref;
	}

	public void setTemperaturePref(String temperaturePref) {
		this.temperaturePref = temperaturePref;
	}

	public String getHumidityPref() {
		return humidityPref;
	}

	public void setHumidityPref(String humidityPref) {
		this.humidityPref = humidityPref;
	}

	public String getBrightnessPref() {
		return brightnessPref;
	}

	public void setBrightnessPref(String brightnessPref) {
		this.brightnessPref = brightnessPref;
	}

	public String getCo2Pref() {
		return co2Pref;
	}

	public void setCo2Pref(String co2Pref) {
		this.co2Pref = co2Pref;
	}

	public String getPm25Pref() {
		return pm25Pref;
	}

	public void setPm25Pref(String pm25Pref) {
		this.pm25Pref = pm25Pref;
	}

	public String getCoPref() {
		return coPref;
	}

	public void setCoPref(String coPref) {
		this.coPref = coPref;
	}

	public String getVcoPref() {
		return vcoPref;
	}

	public void setVcoPref(String vcoPref) {
		this.vcoPref = vcoPref;
	}
}
