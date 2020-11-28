package hotelmanagement.service;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import hotelmanagement.db.DBHelper;
import hotelmanagement.model.Customer;
import hotelmanagement.model.ResultMessage;
import hotelmanagement.model.RoomManage;

public class ContractService {
	private String SELECT_ROOM = "select" + 
			"	qldp.ID_QLDPhong" + 
			"	, p.Tang" + 
			"	, p.MaPhong" + 
			"	, kh.HoTen" + 
			"	, lp.TenLoai" + 
			"	, p.GiaPhong " + 
			"from Phong p " + 
			"	LEFT JOIN QuanLyDatPhong qldp on (p.MaPhong = qldp.MaPhong)" + 
			"	LEFT JOIN KhachHang kh on (kh.ID_KH = qldp.ID_KH )" + 
			"	LEFT JOIN LoaiPhong lp on (lp.ID_Loai = p.ID_Loai)"; 
	
	private  String INSERT_CUSTOMER = "INSERT INTO KhachHang" +
			"(HoTen, GioiTinh, SDT, CMND, QuocTich) " +
			"VALUES(?, ?, ?, ?, ?)";
	
	private String INSERT_ADDROOM = "INSERT INTO QuanLyDatPhong" +
			"(ID_KH, MaPhong, Gia, PhuThu) " +
			"VALUES(?, ?, ?, ?)";
	
	private String SELECT_ROOM_MANAGE = "SELECT * FROM QuanLyDatPhong WHERE ID_QLDPhong = ?";
	
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
	
	// Ham insert hop dong moi
	public ResultMessage createContract(Customer customer, RoomManage roomManage) throws SQLException{
		ResultMessage resultMessage = new ResultMessage();
		// INSERT cai borrower truoc
		PreparedStatement preparedStatement = DBHelper.getPreparedStatement(INSERT_CUSTOMER);
		int row = 0;

		if (preparedStatement != null){
		// set cac tham so cho cau SQL khach hang
			preparedStatement.setString(1, customer.getHoTen());
			preparedStatement.setString(2, customer.getGioiTinh());
			preparedStatement.setString(3, customer.getSdt());
			preparedStatement.setString(4, customer.getCmnd());
			preparedStatement.setString(5, customer.getQuocTich());
			
			// lay so row insert
			row = preparedStatement.executeUpdate();
		}

		// INSERT cai contract
		if (row >= 1){
			ResultSet generatedKeys = preparedStatement.getGeneratedKeys();
			if (generatedKeys.next()) {
				roomManage.setIdQLDPhong(generatedKeys.getInt(1));
	        }
			preparedStatement = DBHelper.getPreparedStatement(INSERT_ADDROOM);
			if (preparedStatement != null){
				// set cac tham so cho cau SQL quan ly dat phong
				preparedStatement.setInt(1, roomManage.getIdQLDPhong());
				preparedStatement.setString(2, roomManage.getMaPhong());
				preparedStatement.setFloat(3, roomManage.getDonGia());
				

				// lay so row insert
				row = preparedStatement.executeUpdate();
				if (row >= 1){
					resultMessage.setMsgCode(ResultMessage.MSG_CODE_SUCCESS);
					resultMessage.setContent(ResultMessage.MSG_ADD);
				}
			}

		} else {
			throw new SQLException(ResultMessage.MSG_CODE_FAIL);
		}
		return resultMessage;
	}
	
	// Ham select room_manage
		public RoomManage getRoomManage(int idQLDPhong) throws SQLException{
			RoomManage roomManage = new RoomManage();
			PreparedStatement preparedStatement = DBHelper.getPreparedStatement(SELECT_ROOM_MANAGE);
			if (preparedStatement != null){
				preparedStatement.setInt(1, idQLDPhong);
		        ResultSet rs = preparedStatement.executeQuery();
		        while (rs.next()) {
		        	roomManage.setIdQLDPhong(rs.getInt("idQLDPhong"));
		        	roomManage.setTang(rs.getInt("tang"));
		        	roomManage.setMaPhong(rs.getString("maPhong"));
		        	roomManage.setHoTen(rs.getString("hoTen"));
		        	roomManage.setTenLoai(rs.getString("tenLoai"));
		        	roomManage.setDonGia(rs.getLong("donGia"));
		        }
			}
			return roomManage;	
		}
}
