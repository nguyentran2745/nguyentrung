package com.parse.starter;

public class GiaoDich {
	String MaGD;
	String Date;
	int money;
	String LoaiGD;
	String MaKhoan;
	String Chitiet;
	
public GiaoDich(String MaGD,String Date,int money,String LoaiGD,String MaKhoan,String Chitiet){
	this.MaGD = MaGD;
	this.Date  = Date;
	this.money = money;
	this.LoaiGD = LoaiGD;
	this.MaKhoan = MaKhoan;
	this.Chitiet = Chitiet;
}
public GiaoDich(){
	
}
public String getMaGD() {
	return MaGD;
}
public void setMaGD(String maGD) {
	MaGD = maGD;
}
public String getDate() {
	return Date;
}
public void setDate(String date) {
	Date = date;
}
public int getMoney() {
	return money;
}
public void setMoney(int money) {
	this.money = money;
}
public String getLoaiGD() {
	return LoaiGD;
}
public void setLoaiGD(String loaiGD) {
	LoaiGD = loaiGD;
}
public String getMaKhoan() {
	return MaKhoan;
}
public void setMaKhoan(String maKhoan) {
	MaKhoan = maKhoan;
}
public String getChitiet() {
	return Chitiet;
}
public void setChitiet(String chitiet) {
	Chitiet = chitiet;
}

	@Override
	public String toString(){
		return "MA GD : "+ MaGD + ",Ngay GD :" +  Date+" ,So Tien : "+ money+",Loai GD : " +LoaiGD+
				"Ma Khoan: "+ MaKhoan+"Thong tin Chi Tiet " + Chitiet ;
	}
}
