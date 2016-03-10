package c4lab.iot.smarthomevisualeditor.page;

import com.vaadin.event.dd.DragAndDropEvent;
import com.vaadin.event.dd.DropHandler;
import com.vaadin.ui.Component;
import com.vaadin.ui.Alignment;

import c4lab.iot.smarthomevisualeditor.ddsource.RoomSource;
import c4lab.iot.smarthomevisualeditor.ddsource.Source;
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
		// �Ȥ��\drop�����grid layout���C��cell��
		target.setComponentHorizontalDropRatio(0f);
		target.setComponentVerticalDropRatio(0f);
		target.setDropHandler(new DefaultGridLayoutDropHandler(Alignment.TOP_CENTER) {
			@Override
			public void drop(DragAndDropEvent event) {
				// ���odrop�ت���T
				GridLayoutTargetDetails details = (GridLayoutTargetDetails) event.getTargetDetails();
				// �ndrop�� gridlayout(row, column)
				int row = details.getOverRow();
				int column = details.getOverColumn();
				// �Y�񪺦�m�w�g����Lroom�h�����o����drop event
				if (target.getComponent(column, row) != null)
					return;
				// ��LayoutBoundTransferable�Ө��odrop component
				LayoutBoundTransferable transferable = (LayoutBoundTransferable) event.getTransferable();
				Component component = transferable.getComponent();
				// component�q����accordion�즲�L�Ӫ�
				if(component.getClass().equals(Source.class)) {
					Source source = (Source) component;
					// �즲��component�O�ж������~�s�W��grid layout
					if (source.isContainer()) {
						// �NSource�ഫ��RoomSource���A�A��m���T����l��
						RoomSource rs = new RoomSource(source.getName());
						target.addComponent(rs, column, row);
					}
				} else { // component�bgrid layou������
					// ���ʦ�m
					RoomSource rs = (RoomSource) component.getParent();
					target.removeComponent(rs);
					target.addComponent(rs, column, row);
				}

				System.out.println(component.getParent().getClass().getName());
			}
		});
		
		target.setDragMode(LayoutDragMode.CAPTION);
	}
}
