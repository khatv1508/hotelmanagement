package hotelmanagement.model;

public class CreateRoom {
	private int idQLDPhong;
	private String maPhong;
	private int idKhachHang;
	private String checkIn;
	private String checkOut;
	private int soKhach;
	private int nam;
	private int treEm;
	private double donGia;
	private double tienCoc;
	private double phuThu;
	private String trangThai;
	
	public int getIdQLDPhong() {
		return idQLDPhong;
	}
	public void setIdQLDPhong(int idQLDPhong) {
		this.idQLDPhong = idQLDPhong;
	}
	
	public String getMaPhong() {
		return maPhong;
	}
	public void setMaPhong(String maPhong) {
		this.maPhong = maPhong;
	}
	
	public int getIdKhachHang() {
		return idKhachHang;
	}
	public void setKhachHang(int idKhachHang) {
		this.idKhachHang = idKhachHang;
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
	
	public int getSoKhach() {
		return soKhach;
	}
	public void setSoKhach(int soKhach) {
		this.soKhach = soKhach;
	}
	
	public int getNam() {
		return nam;
	}
	public void setNam(int nam) {
		this.nam = nam;
	}
	
	public int getTreEm() {
		return treEm;
	}
	public void setTreEm(int treEm) {
		this.treEm = treEm;
	}
	
	public double getDonGia() {
		return donGia;
	}
	public void setDonGia(long donGia) {
		this.donGia = donGia;
	}
	
	public double getTienCoc() {
		return tienCoc;
	}
	public void setTienCoc(long tienCoc) {
		this.tienCoc = tienCoc;
	}
	
	public double getPhuThu() {
		return phuThu;
	}
	public void setPhuThu(long phuThu) {
		this.phuThu = phuThu;
	}
	
	public String getTrangThai() {
		return trangThai;
	}
	public void setTrangThai(String trangThai) {
		this.trangThai = trangThai;
	}
}
