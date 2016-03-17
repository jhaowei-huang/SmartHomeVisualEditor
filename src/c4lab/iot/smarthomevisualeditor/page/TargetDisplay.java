package c4lab.iot.smarthomevisualeditor.page;

import com.vaadin.event.dd.DragAndDropEvent;
import com.vaadin.event.dd.DropHandler;
import com.vaadin.ui.Component;
import com.vaadin.ui.Alignment;

import c4lab.iot.smarthomevisualeditor.ddsource.RoomUISource;
import c4lab.iot.smarthomevisualeditor.ddsource.UISource;
import c4lab.iot.smarthomevisualeditor.design.TargetDisplayDesign;
import fi.jasoft.dragdroplayouts.DDGridLayout.GridLayoutTargetDetails;
import fi.jasoft.dragdroplayouts.client.ui.LayoutDragMode;
import fi.jasoft.dragdroplayouts.drophandlers.DefaultGridLayoutDropHandler;
import fi.jasoft.dragdroplayouts.events.LayoutBoundTransferable;

public class TargetDisplay extends TargetDisplayDesign {
	public TargetDisplay() {
		super();

		target.setColumns(3);
		target.setRows(3);
		// 僅允許drop物件至grid layout的每個cell中
		target.setComponentHorizontalDropRatio(0f);
		target.setComponentVerticalDropRatio(0f);
		target.setDropHandler(new DefaultGridLayoutDropHandler(Alignment.TOP_CENTER) {
			@Override
			public void drop(DragAndDropEvent event) {
				// 取得drop目的資訊
				GridLayoutTargetDetails details = (GridLayoutTargetDetails) event.getTargetDetails();
				// 要drop到 gridlayout(row, column)
				int row = details.getOverRow();
				int column = details.getOverColumn();
				// 若放的位置已經有其他room則忽略這次的drop event
				if (target.getComponent(column, row) != null)
					return;
				// 用LayoutBoundTransferable來取得drop component
				LayoutBoundTransferable transferable = (LayoutBoundTransferable) event.getTransferable();
				Component component = transferable.getComponent();
				// component從左方accordion拖曳過來的
				if(component.getClass().equals(UISource.class)) {
					UISource source = (UISource) component;
					// 拖曳的component是房間類的才新增至grid layout
					if (source.isContainer()) {
						// 將Source轉換成RoomSource型態，放置正確的格子中
						RoomUISource rs = new RoomUISource(source.getName());
						rs.setType(source.getName());
						target.addComponent(rs, column, row);
					}
				} else { // component在grid layou內移動
					// 移動位置
					RoomUISource rs = (RoomUISource) component.getParent();
					target.removeComponent(rs);
					target.addComponent(rs, column, row);
				}

				// System.out.println(component.getParent().getClass().getName());
			}
		});
		
		target.setDragMode(LayoutDragMode.CAPTION);
	}
}
