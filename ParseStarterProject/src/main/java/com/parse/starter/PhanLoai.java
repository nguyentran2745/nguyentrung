package com.parse.starter;

public class PhanLoai {
	String Maloai;
	String Tenloai;
	public PhanLoai(String Maloai,String TenLoai){
		this.Maloai = Maloai;
		this.Tenloai = TenLoai;
	}
	public PhanLoai(){
		
	}
	public String getMaloai() {
		return Maloai;
	}
	public void setMaloai(String maloai) {
		Maloai = maloai;
	}
	public String getTenloai() {
		return Tenloai;
	}
	public void setTenloai(String tenloai) {
		Tenloai = tenloai;
	}
	@Override
	public String toString(){
		return Maloai + Tenloai;
	}
}
