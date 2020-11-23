package hotelmanagement.service;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import hotelmanagement.db.DBHelper;
import hotelmanagement.model.Customer;
import hotelmanagement.model.Room;
import hotelmanagement.model.RoomManage;

public class ContractService {
	private static final String SELECT_ROOM = "select" + 
			"	qldp.ID_QLDPhong" + 
			"	, p.Tang" + 
			"	, p.MaPhong" + 
			"	, kh.HoTen" + 
			"	, lp.TenLoai" + 
			"	, p.DonGia " + 
			"from Phong p " + 
			"	LEFT JOIN QuanLyDatPhong qldp on (p.MaPhong = qldp.MaPhong)" + 
			"	LEFT JOIN KhachHang kh on (kh.ID_KH = qldp.ID_KH )" + 
			"	LEFT JOIN LoaiPhong lp on (lp.ID_Loai = p.ID_Loai)"; 
	private static final String INSERT_CUSTOMER = "INSERT INTO KhachHang" +
			"(HoTen, GioiTinh, SDT, CMND, QuocTich) " +
			"VALUES(?, ?, ?, ?, ?)";
	
	
	// list room
	public List<RoomManage> lstRoom(int idQLDPhong) throws SQLException{
		//
		List<RoomManage> lstResults = new ArrayList<>();
		RoomManage roomManage = new RoomManage();
		
		String sqlStr = SELECT_ROOM;
		PreparedStatement preparedStatement  = null;
		ResultSet rs  = null;
		if(idQLDPhong != 0){
			sqlStr = sqlStr + "WHERE p.Tang = ?";
			preparedStatement = DBHelper.getPreparedStatement(sqlStr);
			preparedStatement.setInt(1, idQLDPhong);
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
			roomManage.setDonGia(rs.getInt(6));
			
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
}
