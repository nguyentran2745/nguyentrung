package com.parse.starter;

public class ThuChi {
String Makhoan;
String Tenkhoan;
String Nhom;
	public ThuChi(String Makhoan, String Tenkhoan, String Nhom){
		this.Makhoan = Makhoan;
		this.Tenkhoan = Tenkhoan;
		this.Nhom = Nhom;
	}
	public ThuChi(){
		
	}
	public String getMakhoan() {
		return Makhoan;
	}
	public void setMakhoan(String makhoan) {
		Makhoan = makhoan;
	}
	public String getTenkhoan() {
		return Tenkhoan;
	}
	public void setTenkhoan(String tenkhoan) {
		Tenkhoan = tenkhoan;
	}
	public String getNhom() {
		return Nhom;
	}
	public void setNhom(String nhom) {
		Nhom = nhom;
	}
	
}
