package hotelmanagement.model;

public class Room {
	private String maPhong;
	private int tang;
	private String tenLoai;
	private int giuong;
	private long giaPhong;
	
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
	public String getTenLoai() {
		return tenLoai;
	}
	public void setTenLoai(String tenLoai) {
		this.tenLoai = tenLoai;
	}
	public int getGiuong() {
		return giuong;
	}
	public void setGiuong(int giuong) {
		this.giuong = giuong;
	}
	public long getGiaPhong() {
		return giaPhong;
	}
	public void setGiaPhong(long giaPhong) {
		this.giaPhong = giaPhong;
	}
}
