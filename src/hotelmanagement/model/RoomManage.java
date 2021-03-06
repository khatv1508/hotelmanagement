package hotelmanagement.model;

public class RoomManage {
	private int idQLDPhong;
	private int tang;
	private String maPhong;
	private String hoTen;
	private String tenLoai;
	private String checkIn;
	private String checkOut;
	private double donGia;
	private String trangThai;
	
	
	public int getIdQLDPhong() {
		return idQLDPhong;
	}
	public void setIdQLDPhong(int idQLDPhong) {
		this.idQLDPhong = idQLDPhong;
	}
	
	public int getTang() {
		return tang;
	}
	public void setTang(int tang) {
		this.tang = tang;
	}
	
	public String getMaPhong() {
		return maPhong;
	}
	public void setMaPhong(String maPhong) {
		this.maPhong = maPhong;
	}
	
	public String getHoTen() {
		return hoTen;
	}
	public void setHoTen(String hoTen) {
		this.hoTen = hoTen;
	}
	
	public String getTenLoai() {
		return tenLoai;
	}
	public void setTenLoai(String tenLoai) {
		this.tenLoai = tenLoai;
	}
	
	public String getCheckIn() {
		return checkIn;
	}
	public void setCheckIn(String checkIn) {
		this.checkIn = checkIn;
	}
	
	public String getCheckOut() {
		return checkOut;
	}
	public void setCheckOut(String checkOut) {
		this.checkOut = checkOut;
	}

	public double getDonGia() {
		return donGia;
	}
	public void setDonGia(float donGia) {
		this.donGia = donGia;
	}

	public String getTrangThai() {
		return trangThai;
	}
	public void setTrangThai(String trangThai) {
		this.trangThai = trangThai;
	}
}
