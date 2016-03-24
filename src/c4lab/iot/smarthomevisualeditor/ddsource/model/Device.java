package c4lab.iot.smarthomevisualeditor.ddsource.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by pcuser on 2015/10/23.
 */
public class Device {
    private String ip;
    private String deviceIp;
    private String name;
    private boolean flags;
    private int classID;
    private int typeID;
    private List<Integer> resourceId;
    private List<String> sensors_resourceId;
    private List<String> actuator_resourceId;
    private String version;

    public Device() {
        sensors_resourceId = new ArrayList<>();
        actuator_resourceId = new ArrayList<>();
        resourceId = new ArrayList<>();
    }

    public Device(String ip) {
        this.ip = ip;
        sensors_resourceId = new ArrayList<>();
        actuator_resourceId = new ArrayList<>();
        resourceId = new ArrayList<>();
    }

    public Device(String ip, String name) {
        this.ip = ip;
        this.name = name;
        sensors_resourceId = new ArrayList<>();
        actuator_resourceId = new ArrayList<>();
        resourceId = new ArrayList<>();
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getDeviceIp() {
        return deviceIp;
    }

    public void setDeviceIp(String deviceIp) {
        this.deviceIp = deviceIp;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public boolean getFlags() {
        return flags;
    }

    public void setFlags(boolean flags) {
        this.flags = flags;
    }

    public int gettypeID() {
        return typeID;
    }

    public void settypeID(int typeID) {
        this.typeID = typeID;
    }

    public int getclassID() {
        return classID;
    }

    public void setclassID(int classID) {
        this.classID = classID;
    }

    public void addsensor(String sensor) {
        this.sensors_resourceId.add(sensor);
    }

    public List<String> getsensor() {
        return sensors_resourceId;
    }

    public void addactuator(String actuator) {
        this.actuator_resourceId.add(actuator);
    }

    public List<String> getactuator() {
        return actuator_resourceId;
    }

    public void addresourceId(Integer resourceId) {
        this.resourceId.add(resourceId);
    }

    public List<Integer> getresourceId() {
        return resourceId;
    }

}
