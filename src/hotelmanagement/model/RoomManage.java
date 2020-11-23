package hotelmanagement.model;

public class RoomManage {
	private int idQLDPhong;
	private int tang;
	private String maPhong;
	private String hoTen;
	private String tenLoai;
	private int donGia;
	
	
	
	@Override
	public String toString() {
		return "RoomManage [idQLDPhong=" + idQLDPhong + ", tang=" + tang + ", maPhong=" + maPhong + ", hoTen=" + hoTen
				+ ", tenLoai=" + tenLoai + ", donGia=" + donGia + "]";
	}
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
	public float getDonGia() {
		return donGia;
	}
	public void setDonGia(int donGia) {
		this.donGia = donGia;
	}

}
