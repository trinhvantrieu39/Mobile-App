package sinhvien;

import java.util.Vector;


import java.util.Enumeration;

public class DanhSachSinhVien {
	private Vector<SinhVien> sv ;
	
	DanhSachSinhVien(){
		sv = new Vector<SinhVien>();
	}
	// true neu them thanh cong
	public boolean themSinhVien(SinhVien sinhvien) {
		Enumeration enu = sv.elements();
		
		while(enu.hasMoreElements()) {
			SinhVien svien = (SinhVien)enu.nextElement();
			if(sinhvien.getMasv().equals(svien.getMasv())) {
				
					System.out.println("False ");
					System.out.print( svien.getMasv()+ "\t");
					System.out.print( svien.getHoten()+ "\t");
					System.out.print( svien.getMalop()+ "\t");
					System.out.print( svien.getLt()+ "\t");
					System.out.print( svien.getTh()+ "\n");
				
				return false;	
			}
		}
		
		sv.add(sinhvien);
		
		return true;
	}
	
	//them sv nhanh
	public void themsv(SinhVien sinhvien) {
		sv.add(sinhvien);
	}
	//xoa sv
	public boolean xoaSinhVien(String masv) {
		for(SinhVien i : sv) {
			if(i.getMasv().equals(masv)) {
				sv.remove(i);
				return true;
			}
		}
		return false;
	}
	//sua sv
	public boolean suaSinhVien(String masv, SinhVien sinhvien) {
		for(SinhVien i : sv ) {
			if(i.getMasv().equals(masv)) {
				
				i.setHoten(sinhvien.getHoten());
				i.setLt(sinhvien.getLt());
				i.setTh(sinhvien.getTh());
				i.setMalop(sinhvien.getMalop());
				return true;
			}
		}
		return false ;
	}
	public SinhVien timSinhVien(String masv) {
		SinhVien svien = new SinhVien("");
		for(SinhVien i : sv){
			if(i.getMasv().equals(masv)) {
				svien =  i;
			}
		}
		return svien;
	}
	public SinhVien getSinhVien(int i) {
		int n=0;
		SinhVien svien = new SinhVien("");
		for(SinhVien j : sv){
			if(n==i) {
				svien = j;
			}
			n++;
		}
		return svien;
	}
	public int tongSinhVien() {
		int s=0;
		for(SinhVien i : sv) {
			s++;
		}
		return s;
	}
	public void printdata() {
		if(sv== null ) {
			System.out.println();
		}
		for(SinhVien i : sv) {
			System.out.print( i.getMasv()+ "\t");
			System.out.print( i.getHoten()+ "\t");
			System.out.print( i.getMalop()+ "\t");
			System.out.print( i.getLt()+ "\t");
			System.out.print( i.getTh()+ "\n");
			
		}
		System.out.println();
	}
	public void print() {
		Enumeration enu = sv.elements();
		
		while(enu.hasMoreElements()) {
			SinhVien sv= (SinhVien)enu.nextElement();
			System.out.print( sv.getMasv()+ "\t");
			System.out.print( sv.getHoten()+ "\t");
			System.out.print( sv.getMalop()+ "\t");
			System.out.print( sv.getLt()+ "\t");
			System.out.print( sv.getTh()+ "\n");
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DanhSachSinhVien sinhvien = new DanhSachSinhVien();
		
		SinhVien sv1= new SinhVien("massv1","hoten1","malop1",7.9,9.2);
		SinhVien sv2 = new SinhVien("mav2","hoten2","mallop2",8,9);
		
		//sinhvien.themsv(sv1);		//them sinh vien vao danh sach
		sinhvien.themsv(sv2);
		
		//them sv vao danh sach-tra ve true neu them dc
		System.out.println("add "+sinhvien.themSinhVien(sv1));
		sinhvien.print();
		
		System.out.println("search ");
		System.out.print( sinhvien.timSinhVien("mav2").getMasv()+ "\t");
		System.out.print( sinhvien.timSinhVien("mav2").getHoten()+ "\t");
		System.out.print( sinhvien.timSinhVien("mav2").getMalop()+ "\t");
		System.out.print( sinhvien.timSinhVien("mav2").getLt()+ "\t");
		System.out.print( sinhvien.timSinhVien("mav2").getTh()+ "\n");
	}

}
