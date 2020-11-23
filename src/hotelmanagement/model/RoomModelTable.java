package hotelmanagement.model;

import java.util.List;

import javax.swing.table.AbstractTableModel;

public class RoomModelTable extends AbstractTableModel{
	
	private List<RoomManage> lstRoom;
	private String[] columnNames = {"ID", "Tầng", "Mã Phòng", "Tên Khách Hàng", "Loại Phòng", "Giá Phòng"};
	

	public List<RoomManage> getLstRoom() {
		return lstRoom;
	}

	public void setLstRoom(List<RoomManage> lstRoom) {
		this.lstRoom = lstRoom;
	}

	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return lstRoom.size();
	}

	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return columnNames.length;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		Object temp = null;
		
		switch (columnIndex) {
		case -1:
			temp = lstRoom.get(rowIndex).getIdQLDPhong();
			break;
		case 0:
			temp = lstRoom.get(rowIndex).getTang();
			break;
		case 1:
			temp = lstRoom.get(rowIndex).getMaPhong();
			break;
		case 2:
			temp = lstRoom.get(rowIndex).getHoTen();
			break;
		case 3:
			temp = lstRoom.get(rowIndex).getTenLoai();
			break;
		default:
			temp = lstRoom.get(rowIndex).getDonGia();
			break;
		}
		
		return temp;
	}

}
