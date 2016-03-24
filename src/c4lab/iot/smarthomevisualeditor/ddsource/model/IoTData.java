package c4lab.iot.smarthomevisualeditor.ddsource.model;

import java.util.ArrayList;
import java.util.List;

import c4lab.iot.smarthomevisualeditor.ddsource.model.ClassID;
import c4lab.iot.smarthomevisualeditor.ddsource.model.ResourceID;
import c4lab.iot.smarthomevisualeditor.ddsource.model.TypeID;

public class IoTData {

	List<TypeID> typeIDs = new ArrayList<>();
	List<ClassID> classIDs = new ArrayList<>();
	List<ResourceID> resourceIDs = new ArrayList<>();

	public IoTData() {
		initData();
	}

	private void initData() {
		initclassid();
		inittypeid();
		initresourceid();
	}

	private void initresourceid() {
		// 空氣清淨機 resource
		resourceIDs.add(new ResourceID(1, 8, 0, "開關", 1));
		resourceIDs.add(new ResourceID(2, 8, 0, "風量", 1));
		resourceIDs.add(new ResourceID(3, 8, 0, "負離子", 1));
		resourceIDs.add(new ResourceID(4, 8, 0, "定時", 1));

		// 電風扇
		resourceIDs.add(new ResourceID(1, 15, 0, "弱", 1));
		resourceIDs.add(new ResourceID(2, 15, 0, "中", 1));
		resourceIDs.add(new ResourceID(3, 15, 0, "強", 1));

		// 智慧插座
		resourceIDs.add(new ResourceID(1, 100, 0, "開關1", 1));
		resourceIDs.add(new ResourceID(2, 100, 0, "開關2", 1));
		resourceIDs.add(new ResourceID(3, 100, 0, "開關3", 1));
		resourceIDs.add(new ResourceID(4, 100, 0, "開關4", 1));

		// 智慧插座
		resourceIDs.add(new ResourceID(3, 101, 0, "中", 1));
		resourceIDs.add(new ResourceID(4, 101, 0, "強", 1));

		// Kinect/vedioCam
		resourceIDs.add(new ResourceID(1, 102, 0, "人數", 0));
		resourceIDs.add(new ResourceID(2, 102, 0, "姿勢", 0));
		resourceIDs.add(new ResourceID(3, 102, 0, "聲音", 0));
		resourceIDs.add(new ResourceID(4, 102, 0, "左手", 0));
		resourceIDs.add(new ResourceID(5, 102, 0, "右手", 0));

		resourceIDs.add(new ResourceID(6, 102, 0, "溫度", 0));
		resourceIDs.add(new ResourceID(7, 102, 0, "濕度", 0));
		resourceIDs.add(new ResourceID(8, 102, 0, "大氣壓力", 0));
		resourceIDs.add(new ResourceID(9, 102, 0, "天氣", 0));
		resourceIDs.add(new ResourceID(10, 102, 0, "地點", 0));

		// 掃地機
		resourceIDs.add(new ResourceID(1, 104, 0, "開/關", 1));

		// 咖啡機
		resourceIDs.add(new ResourceID(1, 105, 0, "開/關", 1));
		resourceIDs.add(new ResourceID(2, 105, 0, "啟動", 1));
		resourceIDs.add(new ResourceID(3, 105, 0, "杯數/濃度", 1));
		resourceIDs.add(new ResourceID(4, 105, 0, "數量(-)", 1));

		// 感測器
		resourceIDs.add(new ResourceID(1, 121, 0, "溫度", 0));
		resourceIDs.add(new ResourceID(2, 121, 0, "濕度", 0));
		resourceIDs.add(new ResourceID(3, 121, 0, "光感計", 0));
		resourceIDs.add(new ResourceID(4, 121, 0, "磁力", 0));
		resourceIDs.add(new ResourceID(5, 121, 0, "顏色", 0));
		resourceIDs.add(new ResourceID(6, 121, 0, "土壤濕度", 0));
		resourceIDs.add(new ResourceID(7, 121, 0, "震動", 0));
		resourceIDs.add(new ResourceID(8, 121, 0, "傾斜", 0));
		resourceIDs.add(new ResourceID(10, 121, 0, "煙霧", 0));
		resourceIDs.add(new ResourceID(11, 121, 0, "灰塵", 0));
		resourceIDs.add(new ResourceID(12, 121, 0, "火焰", 0));
		resourceIDs.add(new ResourceID(13, 121, 0, "可燃性氣體", 0));
		resourceIDs.add(new ResourceID(14, 121, 0, "一氧化碳", 0));
		resourceIDs.add(new ResourceID(20, 121, 0, "黑色線追蹤", 0));
		resourceIDs.add(new ResourceID(21, 121, 0, "避障", 0));
		resourceIDs.add(new ResourceID(30, 121, 0, "紅外線IR", 0));
		resourceIDs.add(new ResourceID(31, 121, 0, "聲音", 0));
		resourceIDs.add(new ResourceID(32, 121, 0, "超音波", 0));
		resourceIDs.add(new ResourceID(33, 121, 0, "PIR", 0));
		resourceIDs.add(new ResourceID(40, 121, 0, "心跳", 0));
		resourceIDs.add(new ResourceID(41, 121, 0, "體溫", 0));
		resourceIDs.add(new ResourceID(42, 121, 0, "腦波", 0));
		resourceIDs.add(new ResourceID(50, 121, 0, "觸摸", 0));
		resourceIDs.add(new ResourceID(51, 121, 0, "按鍵", 0));

		// 致動器
		resourceIDs.add(new ResourceID(200, 122, 0, "LED", 1));
		resourceIDs.add(new ResourceID(201, 122, 0, "兩色LED", 1));
		resourceIDs.add(new ResourceID(202, 122, 0, "三色LED", 1));
		resourceIDs.add(new ResourceID(203, 122, 0, "IR（send）", 1));
		resourceIDs.add(new ResourceID(210, 122, 0, "繼電器Relay", 1));
		resourceIDs.add(new ResourceID(220, 122, 0, "蜂鳴器", 1));

		// 檯燈
		resourceIDs.add(new ResourceID(1, 200, 0, "開關", 1));
		resourceIDs.add(new ResourceID(2, 200, 0, "亮度", 2));
		resourceIDs.add(new ResourceID(3, 200, 0, "顏色", 2));

		// 捕蚊燈
		resourceIDs.add(new ResourceID(1, 201, 0, "開關", 1));

		// 電腦
		resourceIDs.add(new ResourceID(1, 202, 0, "電腦", 1));

		// 顯示器
		resourceIDs.add(new ResourceID(1, 203, 0, "顯示器", 1));

		// 顯示器
		resourceIDs.add(new ResourceID(1, 204, 0, "MAC", 0));
		resourceIDs.add(new ResourceID(2, 204, 0, "語音指令", 0));

		// 暖氣機
		resourceIDs.add(new ResourceID(1, 106, 0, "開關", 1));
		resourceIDs.add(new ResourceID(2, 106, 0, "送風/暖氣/溫度", 1));
		resourceIDs.add(new ResourceID(3, 106, 0, "溫度+", 1));
		resourceIDs.add(new ResourceID(4, 106, 0, "溫度-", 1));
		resourceIDs.add(new ResourceID(5, 106, 0, "旋轉", 1));
	}

	private void inittypeid() {
		typeIDs.add(new TypeID(8, 0, "空氣清淨機"));
		typeIDs.add(new TypeID(15, 0, "電風扇"));
		typeIDs.add(new TypeID(100, 0, "智慧插座"));
		typeIDs.add(new TypeID(101, 0, "果汁機"));
		typeIDs.add(new TypeID(102, 0, "Kinect/vedioCam/webservice"));
		typeIDs.add(new TypeID(104, 0, "掃地機"));
		typeIDs.add(new TypeID(105, 0, "咖啡機"));
		typeIDs.add(new TypeID(106, 0, "暖氣機"));

		typeIDs.add(new TypeID(120, 0, "感測器+致動器"));
		typeIDs.add(new TypeID(121, 0, "感測器"));
		typeIDs.add(new TypeID(122, 0, "致動器"));

		typeIDs.add(new TypeID(200, 0, "檯燈"));
		typeIDs.add(new TypeID(201, 0, "捕蚊燈"));
		typeIDs.add(new TypeID(202, 0, "電腦"));
		typeIDs.add(new TypeID(203, 0, "顯示器"));
		typeIDs.add(new TypeID(204, 0, "手機"));

		typeIDs.add(new TypeID(300, 0, "充電器"));
	}

	private void initclassid() {
		classIDs.add(new ClassID(0, "家電類"));
	}

	public ResourceID getResourceData(String typeid, String resourceid) {
		ResourceID resourceData = null;

		for (ResourceID data : resourceIDs) {
			String data_typeid = "" + data.getTypeId();
			String data_resourceid = "" + data.getId();
			if (data_typeid.equals(typeid) && data_resourceid.equals(resourceid)) {
				resourceData = data;
				break;
			}

		}

		return resourceData;
	}

	public List<ResourceID> getResourceData(String typeid) {
		List<ResourceID> resourceData = new ArrayList<>();

		for (ResourceID data : resourceIDs) {
			String data_typeid = "" + data.getTypeId();
			if (data_typeid.equals(typeid)) {
				resourceData.add(data);
			}

		}

		return resourceData;
	}

	public TypeID getTypeData(String typeid) {
		TypeID typeData = null;

		for (TypeID data : typeIDs) {
			String data_typeid = "" + data.getId();
			if (data_typeid.equals(typeid)) {
				typeData = data;
				break;
			}

		}

		return typeData;
	}
	
	public List<TypeID> getTypeIDs() {
		return typeIDs;
	}
}
