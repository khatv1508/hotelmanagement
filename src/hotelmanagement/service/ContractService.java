package hotelmanagement.service;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import hotelmanagement.db.DBHelper;
import hotelmanagement.model.CreateRoom;
import hotelmanagement.model.Customer;
import hotelmanagement.model.ResultMessage;
import hotelmanagement.model.Room;
import hotelmanagement.model.RoomManage;
import hotelmanagement.model.Service;
import hotelmanagement.model.Staff;
import hotelmanagement.model.UseService;

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
	private String SELECT_CUSTOMER = "SELECT * FROM KhachHang";
	private String UPDATE_CUSTOMER = "UPDATE KhachHang set GioiTinh = ?, SDT = ?, CMND = ?, QuocTich = ? WHERE HoTen = ?";
	private String DELETE_CUSTOMER = "DELETE KhachHang WHERE HoTen = ?";
	
	private String INSERT_STAFF = "INSERT INTO NhanVien(HoTen, DienThoai, TaiKhoan, MatKhau, Loai) VALUES(?,?,?,?,?)";
	private String SELECT_STAFF = "SELECT * FROM NhanVien";
	private String UPDATE_STAFF = "UPDATE NhanVien set DienThoai=?, TaiKhoan=?, MatKhau=?, Loai=? WHERE HoTen=?";
	private String DELETE_STAFF = "DELETE NhanVien WHERE HoTen=?";
	
	private String INSERT_ROOM = "INSERT INTO Phong(MaPhong, Tang, ID_Loai, SoGiuong, GiaPhong) VALUES(?,?,?,?,?)";
	private String SELECT_ROOMs = "SELECT * FROM Phong";
	private String UPDATE_ROOM = "UPDATE Phong set Tang=?, ID_Loai=?, SoGiuong=?, GiaPhong=? WHERE MaPhong=?";
	private String DELETE_ROOM = "DELETE Phong WHERE MaPhong=?";
	
	private String INSERT_ADDROOM = "INSERT INTO QuanLyDatPhong" +
			"(ID_KH, MaPhong, Check_in, Check_out, SoKhach, Nam, TreEm, GiaPhong, TienCoc, TrangThai) " + 
			"VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
	
	private String SELECT_ROOM_TYPE = "select" + 
			"	p.MaPhong" + 
			"	, p.Tang" + 
			"	, lp.TenLoai" + 
			"	, p.SoGiuong" + 
			"	, p.GiaPhong " + 
			"from Phong p" + 
			"	INNER JOIN LoaiPhong lp ON (lp.ID_Loai = p.ID_Loai)" +
			"Where p.MaPhong = ?";
	
	private String SELECT_ROOM_MANAGE = "select * from QuanLyDatPhong qldp where qldp.ID_QLDPhong = ?";
	
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
			roomManage.setCheckIn(rs.getString(6));
			roomManage.setCheckOut(rs.getString(7));
			roomManage.setDonGia(rs.getInt(8));
			roomManage.setTrangThai(rs.getString(9));
			
			//
			lstResults.add(roomManage);
			roomManage = new RoomManage();
			
			
		}
	return lstResults;
	}
	
	// Ham select room
	public Room getRoom(String maPhong) throws SQLException{
		Room room = new Room();
		PreparedStatement preparedStatement = DBHelper.getPreparedStatement(SELECT_ROOM_TYPE);
		if (preparedStatement != null){
			preparedStatement.setString(1, maPhong);
	        ResultSet rs = preparedStatement.executeQuery();
	        while (rs.next()) {
	        	room.setMaPhong(rs.getString("MaPhong"));
	        	room.setTang(rs.getInt("Tang"));
	        	room.setGiuong(rs.getInt("SoGiuong"));
	        	room.setTenLoai(rs.getString("TenLoai"));
	        	room.setGiaPhong(rs.getLong("GiaPhong"));
	        }
		}
		return room;	
	}
		
	// list khach hang
	public ArrayList<Customer> getListCustomer(){
        ArrayList<Customer> list = new ArrayList<>();
        Customer customer = new Customer();
        try {
            PreparedStatement ps = DBHelper.getPreparedStatement(SELECT_CUSTOMER);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
            	customer.setIdKhachHang(rs.getInt("ID_KH"));
            	customer.setHoTen(rs.getString("HoTen"));
            	customer.setGioiTinh(rs.getString("GioiTinh"));
            	customer.setSdt(rs.getString("Sdt"));
            	customer.setCmnd(rs.getString("Cmnd"));
            	customer.setQuocTich(rs.getString("QuocTich"));
               
               list.add(customer);
               customer = new Customer();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return list;
    }
	
	// insert khach hang
	public boolean addCustomer(Customer c){
        try {
            PreparedStatement ps = DBHelper.getPreparedStatement(INSERT_CUSTOMER);
            ps.setString(1, c.getHoTen());
            ps.setString(2, c.getGioiTinh());
            ps.setString(3, c.getSdt());
            ps.setString(4, c.getCmnd());
            ps.setString(5, c.getQuocTich());
            
            return ps.executeUpdate() > 0;
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return false;
    }
	
	// update khach hang
	public boolean updateCustomer(Customer c){
        try {
            PreparedStatement ps = DBHelper.getPreparedStatement(UPDATE_CUSTOMER);
            ps.setString(1, c.getGioiTinh());
            ps.setString(2, c.getSdt());
            ps.setString(3, c.getCmnd());
            ps.setString(4, c.getQuocTich());
            ps.setString(5, c.getHoTen());
            return ps.executeUpdate() > 0;
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return false;
    }
	
	// delete khach hang
    public boolean deleteCustomer(Customer c){
        try {
            PreparedStatement ps = DBHelper.getPreparedStatement(DELETE_CUSTOMER);
            ps.setString(1, c.getHoTen());            
            return ps.executeUpdate() > 0;
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return false;
    }
    
    
    
    // list nhan vien
    public ArrayList<Staff> getListStaff(){
        ArrayList<Staff> list = new ArrayList<>(); 
        Staff staff = new Staff();
        try {
            PreparedStatement ps = DBHelper.getPreparedStatement(SELECT_STAFF);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
            	staff.setHoTen(rs.getString("HoTen"));
            	staff.setSdThoai(rs.getString("DienThoai"));
            	staff.setTaiKhoan(rs.getString("TaiKhoan"));
            	staff.setMatKhau(rs.getString("MatKhau"));
            	staff.setChucVu(rs.getInt("Loai"));
               
               list.add(staff);
               staff = new Staff();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return list;
    }
    
    // insert nhan vien
	public boolean addStaff(Staff s){
	    try {
	        PreparedStatement ps = DBHelper.getPreparedStatement(INSERT_STAFF);
	        ps.setString(1, s.getHoTen());
	        ps.setString(2, s.getSdThoai());
	        ps.setString(3, s.getTaiKhoan());
	        ps.setString(4, s.getMatKhau());
	        ps.setInt(5, s.getChucVu());
	        
	        return ps.executeUpdate() > 0;
	        
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    
	    return false;
	}
	
	// update nhan vien
	public boolean updateStaff(Staff s){
	    try {
	        PreparedStatement ps = DBHelper.getPreparedStatement(UPDATE_STAFF);
	        
	        ps.setString(1, s.getSdThoai());
	        ps.setString(2, s.getTaiKhoan());
	        ps.setString(3, s.getMatKhau());
	        ps.setInt(4, s.getChucVu());
	        ps.setString(5, s.getHoTen());
	        return ps.executeUpdate() > 0;
	        
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    
	    return false;
	}
	
	// delete nhan vien
	public boolean deleteStaff(Staff s){
	    try {
	        PreparedStatement ps = DBHelper.getPreparedStatement(DELETE_STAFF);
	        ps.setString(1, s.getHoTen());            
	        return ps.executeUpdate() > 0;
	        
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    
	    return false;
	}
	
	// list phong
	public ArrayList<Room> getListRoom(){
	    ArrayList<Room> list = new ArrayList<>(); 
	    Room room = new Room();
	    try {
	        PreparedStatement ps = DBHelper.getPreparedStatement(SELECT_ROOMs);
	        ResultSet rs = ps.executeQuery();
	        while(rs.next()){
	        	
	        	room.setMaPhong(rs.getString("MaPhong"));
	        	room.setTang(rs.getInt("Tang"));
	        	room.setTenLoai(rs.getString("ID_Loai"));
	        	room.setGiuong(rs.getInt("SoGiuong"));
	        	room.setGiaPhong(rs.getLong("GiaPhong"));
	           
	           list.add(room);
	           room = new Room();
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    
	    return list;
	}
	
	// insert phong
	public boolean addRoom(Room r){
	    try {
	        PreparedStatement ps = DBHelper.getPreparedStatement(INSERT_ROOM);
	        ps.setString(1, r.getMaPhong());
	        ps.setInt(2, r.getTang());
	        ps.setString(3, r.getTenLoai());
	        ps.setInt(4, r.getGiuong());
	        ps.setLong(5, r.getGiaPhong());
	        
	        return ps.executeUpdate() > 0;
	        
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    
	    return false;
	}
	
	// update phong
	public boolean updateRoom(Room r){
	    try {
	        PreparedStatement ps = DBHelper.getPreparedStatement(UPDATE_STAFF);
	        
	        
	        ps.setInt(1, r.getTang());
	        ps.setString(2, r.getTenLoai());
	        ps.setInt(3, r.getGiuong());
	        ps.setLong(4, r.getGiaPhong());
	        ps.setString(5, r.getMaPhong());
	        return ps.executeUpdate() > 0;
	        
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    
	    return false;
		}
	
	// delete phong
	public boolean deleteRoom(Room r){
	    try {
	        PreparedStatement ps = DBHelper.getPreparedStatement(DELETE_ROOM);
	        ps.setString(1, r.getMaPhong());            
	        return ps.executeUpdate() > 0;
	        
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    
	    return false;
	}
	
	// insert dat phong
    public ResultMessage createRoom(CreateRoom createRoom) throws SQLException{
		ResultMessage resultMessage = new ResultMessage();
		PreparedStatement preparedStatement = DBHelper.getPreparedStatement(INSERT_ADDROOM);
		if (preparedStatement != null){
			preparedStatement.setInt(1, createRoom.getIdKhachHang());
			preparedStatement.setString(2, createRoom.getMaPhong());
			preparedStatement.setString(3, createRoom.getCheckIn());
			preparedStatement.setString(4, createRoom.getCheckOut());
			preparedStatement.setInt(5, createRoom.getSoKhach());
			preparedStatement.setInt(6, createRoom.getNam());
			preparedStatement.setInt(7, createRoom.getTreEm());
			preparedStatement.setDouble(8, createRoom.getDonGia());
			preparedStatement.setDouble(9, createRoom.getTienCoc());
			preparedStatement.setString(10, createRoom.getTrangThai());
			
			preparedStatement.executeUpdate();
			resultMessage.setMsgCode(ResultMessage.MSG_ADD_ROOM);
		}
		
		return resultMessage;
    }
    
    // Ham select roomManage
 	public CreateRoom getRoomManage(int idQLDPhong) throws SQLException{
 		CreateRoom roomManage = new CreateRoom();
 		PreparedStatement preparedStatement = DBHelper.getPreparedStatement(SELECT_ROOM_MANAGE);
		if (preparedStatement != null){
			preparedStatement.setInt(1, idQLDPhong);
	        ResultSet rs = preparedStatement.executeQuery();
	        while (rs.next()) {
	        	roomManage.setIdQLDPhong(rs.getInt("ID_QLDPhong"));
	        	roomManage.setKhachHang(rs.getInt("ID_KH"));
	        	roomManage.setMaPhong(rs.getString("MaPhong"));
	        	roomManage.setCheckIn(rs.getString("Check_in"));
	        	roomManage.setCheckOut(rs.getString("Check_out"));
	        	roomManage.setSoKhach(rs.getInt("SoKhach"));
	        	roomManage.setNam(rs.getInt("Nam"));
	        	roomManage.setTreEm(rs.getInt("TreEm"));
	        	roomManage.setDonGia(rs.getLong("GiaPhong"));
	        	roomManage.setPhuThu(rs.getLong("PhuThu"));
	        	roomManage.setTienCoc(rs.getLong("TienCoc"));
	        	roomManage.setTrangThai(rs.getString("trangThai"));
	        }
		}
		return roomManage;		
 	}
 	
 	// list dich vu
 	public ArrayList<Service> getListService(){
         ArrayList<Service> list = new ArrayList<>();
         Service service = new Service();
         try {
             PreparedStatement ps = DBHelper.getPreparedStatement(SELECT_CUSTOMER);
             ResultSet rs = ps.executeQuery();
             while(rs.next()){
            	 service.setIdDichVu(rs.getInt("ID_DV"));
            	 service.setTenDV(rs.getString("TenDV"));
            	 service.setDvt(rs.getString("DVT"));
            	 service.setGiaDV(rs.getDouble("GiaDV"));
                
                list.add(service);
                service = new Service();
             }
         } catch (Exception e) {
             e.printStackTrace();
         }
         
         return list;
     }
}
