package hotelmanagement.model;

public class Room {
	private String maPhong;
	private int tang;
	private int idLoai;
	private int giuong;
	private int giaPhong;
	private int trangThai;
	
	public String getMaPhong() {
		return maPhong;
	}
	public void setMaPhong(String maPhong) {
		this.maPhong = maPhong;
	}
	public int getTang() {
		return tang;
	}
	public void setTang(int tang) {
		this.tang = tang;
	}
	public int getIdLoai() {
		return idLoai;
	}
	public void setIdLoai(int idLoai) {
		this.idLoai = idLoai;
	}
	public int getGiuong() {
		return giuong;
	}
	public void setGiuong(int giuong) {
		this.giuong = giuong;
	}
	public int getGiaPhong() {
		return giaPhong;
	}
	public void setGiaPhong(int giaPhong) {
		this.giaPhong = giaPhong;
	}
	public int getTrangThai() {
		return trangThai;
	}
	public void setTrangThai(int trangThai) {
		this.trangThai = trangThai;
	}
}
