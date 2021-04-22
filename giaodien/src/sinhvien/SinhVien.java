package sinhvien;

public class SinhVien {
	private String masv;
	private String hoten;
	private String malop;
	private double lt;
	private double th;
	SinhVien(String msv, String hoten, String malop, double lt, double th){
		this.masv = msv;
		this.hoten = hoten;
		this.malop = malop;
		this.lt = lt;
		this.th = th;
	}
	SinhVien(String masv){
		this.masv = masv;
	}
	public String getMasv() {
		return masv;
	}
	public void setMasv(String masv) {
		this.masv = masv;
	}
	public String getHoten() {
		return hoten;
	}
	public void setHoten(String hoten) {
		this.hoten = hoten;
	}
	public String getMalop() {
		return malop;
	}
	public void setMalop(String malop) {
		this.malop = malop;
	}
	public double getLt() {
		return lt;
	}
	public void setLt(double lt) {
		this.lt = lt;
	}
	public double getTh() {
		return th;
	}
	public void setTh(double th) {
		this.th = th;
	}
	public double diemTB() {
		return (lt+th)/2;
	}
	public String ketqua() {
		return diemTB()>=5 ? "Đậu":"Rớt";
	}
}
