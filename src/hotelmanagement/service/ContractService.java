package hotelmanagement.service;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import hotelmanagement.db.DBHelper;
import hotelmanagement.model.Customer;
import hotelmanagement.model.ResultMessage;
import hotelmanagement.model.Room;
import hotelmanagement.model.RoomManage;

@SuppressWarnings("unused")
public class ContractService {
	private String SELECT_ROOM = "select" + 
			"	qldp.ID_QLDPhong" + 
			"	, p.Tang" + 
			"	, p.MaPhong" + 
			"	, kh.HoTen" + 
			"	, lp.TenLoai" + 
			"	, qldp.Check_in" + 
			"	, qldp.Check_out" + 
			"	, p.GiaPhong" + 
			"	, qldp.TrangThai " + 
			"from Phong p" + 
			"	LEFT JOIN QuanLyDatPhong qldp on (p.MaPhong = qldp.MaPhong)" + 
			"	LEFT JOIN KhachHang kh on (kh.ID_KH = qldp.ID_KH )" + 
			"	LEFT JOIN LoaiPhong lp on (lp.ID_Loai = p.ID_Loai)"; 
	
	private  String INSERT_CUSTOMER = "INSERT INTO KhachHang" +
			"(HoTen, GioiTinh, SDT, CMND, QuocTich) " +
			"VALUES(?, ?, ?, ?, ?)";
	
	private String INSERT_ADDROOM = "INSERT INTO QuanLyDatPhong" +
			"(ID_KH, MaPhong, Check_in, Check_out, SoKhach, Nam, TreEm, GiaPhong, PhuThu, TienCoc, TrangThai) " + 
			"VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
	
	private String SELECT_ROOM_TYPE = "select" + 
			"	p.MaPhong" + 
			"	, p.Tang" + 
			"	, lp.TenLoai" + 
			"	, p.SoGiuong" + 
			"	, p.GiaPhong " + 
			"from Phong p" + 
			"	INNER JOIN LoaiPhong lp ON (lp.ID_Loai = p.ID_Loai)";
	
	// list room
	public List<RoomManage> lstRoom(int tang) throws SQLException{
		//
		List<RoomManage> lstResults = new ArrayList<>();
		RoomManage roomManage = new RoomManage();
		
		String sqlStr = SELECT_ROOM;
		PreparedStatement preparedStatement  = null;
		ResultSet rs  = null;
		if(tang != 0){
			sqlStr = sqlStr + "WHERE p.Tang = ?";
			preparedStatement = DBHelper.getPreparedStatement(sqlStr);
			preparedStatement.setInt(1, tang);
		} else {
			preparedStatement = DBHelper.getPreparedStatement(sqlStr);
		}
		
		rs = preparedStatement.executeQuery();
		while (rs.next()) {
			//
			roomManage.setIdQLDPhong(rs.getInt(1));
			roomManage.setTang(rs.getInt(2));
			roomManage.setMaPhong(rs.getString(3));
			roomManage.setHoTen(rs.getString(4));
			roomManage.setTenLoai(rs.getString(5));
			roomManage.setCheckIn(rs.getDate(6));
			roomManage.setCheckOut(rs.getDate(7));
			roomManage.setDonGia(rs.getInt(8));
			roomManage.setTrangThai(rs.getString(9));
			
			//
			lstResults.add(roomManage);
			roomManage = new RoomManage();
			
			
		}
	return lstResults;
	}
	
	// insert khach hang
	public Customer getCustomer() throws SQLException{
		Customer customer = new Customer();
		PreparedStatement preparedStatement = DBHelper.getPreparedStatement(INSERT_CUSTOMER);
		if (preparedStatement != null){
//			preparedStatement.setInt(1, 1);
	        ResultSet rs = preparedStatement.executeQuery();
	        while (rs.next()) {
	        	customer.setHoTen(rs.getString(1));
	        	customer.setGioiTinh(rs.getString(2));
	        	customer.setSdt(rs.getString(3));
	        	customer.setCmnd(rs.getString(4));
	        	customer.setQuocTich(rs.getString(5));
	        }
		}
		return customer;	
	}
	
	// Ham select room
		public Room getRoom(String maPhong) throws SQLException{
			Room room = new Room();
			PreparedStatement preparedStatement = DBHelper.getPreparedStatement(SELECT_ROOM_TYPE);
			if (preparedStatement != null){
				preparedStatement.setString(1, maPhong);
		        ResultSet rs = preparedStatement.executeQuery();
		        while (rs.next()) {
		        	room.setMaPhong(rs.getString("maPhong"));
		        	room.setTang(rs.getInt("tang"));
		        	room.setTenLoai(rs.getString("tenLoai"));
		        	room.setGiuong(rs.getInt("giuong"));
		        	room.setGiaPhong(rs.getLong("giaPhong"));
		        }
			}
			return room;	
		}
}
