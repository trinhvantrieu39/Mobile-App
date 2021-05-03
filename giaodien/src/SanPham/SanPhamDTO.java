package SanPham;

public class SanPhamDTO {
	public String masp;
	public String tensp;
	public String maloai;
	public String soluong;
	public String dongia;
	public String hinhanh;
	public SanPhamDTO() {
		this.masp= null;
		this.tensp= null;
		this.maloai= null;
		this.soluong= null;
		this.dongia= null;
		this.hinhanh= null;
	}
	public SanPhamDTO(String masp, String tensp, String maloai, String soluong, String dongia, String hinhanh) {
		this.masp= masp;
		this.tensp= tensp;
		this.maloai= maloai;
		this.soluong= soluong;
		this.dongia= dongia;
		this.hinhanh= hinhanh;
	}
	public String getMasp() {
		return masp;
	}
	public void setMasp(String masp) {
		this.masp = masp;
	}
	public String getTensp() {
		return tensp;
	}
	public void setTensp(String tensp) {
		this.tensp = tensp;
	}
	public String getMaloai() {
		return maloai;
	}
	public void setMaloai(String maloai) {
		this.maloai = maloai;
	}
	public String getSoluong() {
		return soluong;
	}
	public void setSoluong(String soluong) {
		this.soluong = soluong;
	}
	public String getDongia() {
		return dongia;
	}
	public void setDongia(String dongia) {
		this.dongia = dongia;
	}
	public String getHinhanh() {
		return hinhanh;
	}
	public void setHinhanh(String hinhanh) {
		this.hinhanh = hinhanh;
	}
	
	
}

