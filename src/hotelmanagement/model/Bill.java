package hotelmanagement.model;

public class Bill {
	private int idHoaDon;
	private int idNhanVien;
	private int idKhachHang;
	private int idQLDPhong;
	private int idDichVu;
	private float tong;
	
	public int getIdHoaDon() {
		return idHoaDon;
	}
	public void setIdHoaDon(int idHoaDon) {
		this.idHoaDon = idHoaDon;
	}
	public int getIdNhanVien() {
		return idNhanVien;
	}
	public void setIdNhanVien(int idNhanVien) {
		this.idNhanVien = idNhanVien;
	}
	public int getIdKhachHang() {
		return idKhachHang;
	}
	public void setIdKhachHang(int idKhachHang) {
		this.idKhachHang = idKhachHang;
	}
	public int getIdQLDPhong() {
		return idQLDPhong;
	}
	public void setIdQLDPhong(int idQLDPhong) {
		this.idQLDPhong = idQLDPhong;
	}
	public int getIdDichVu() {
		return idDichVu;
	}
	public void setIdDichVu(int idDichVu) {
		this.idDichVu = idDichVu;
	}
	public float getTong() {
		return tong;
	}
	public void setTong(float tong) {
		this.tong = tong;
	}
}
