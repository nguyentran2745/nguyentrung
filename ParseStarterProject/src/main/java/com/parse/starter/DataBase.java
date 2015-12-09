package com.parse.starter;

import java.util.ArrayList;
import java.util.List;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

public class DataBase extends SQLiteOpenHelper {
	private static final String KEY_MA_LOAI = "Maloai";
	private static final String KEY_TEN_LOAI = "TenLoai";
	private static final String KEY_TABLE1 = "PhanLoai";

	private static final String KEY_MA_GD = "MaGD";
	private static final String KEY_DATE = "NgayGD";
	private static final String KEY_MONEY = "Tien";
	private static final String KEY_LOAI_GD = "LoaiGD";
	private static final String KEY_MA_KHOAN = "Makhoan";
	private static final String KEY_CHI_TIET = "Chitiet";
	private static final String KEY_TABLE2 = "GiaoDich";

	private static final String KEY_MA_KHOAN1 = "Makhoan";
	private static final String KEY_TEN_KHOAN = "TenKhoan";
	private static final String KEY_NHOM = "Nhom";
	private static final String KEY_TABLE3 = "ThuChi";

	public DataBase(Context context, String name, CursorFactory factory,
			int version) {
		super(context, name, factory, version);

	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		String bang1 = "CREATE TABLE " + KEY_TABLE1 + "(" + KEY_MA_LOAI
				+ " TEXT PRIMARY KEY, " + KEY_TEN_LOAI + " TEXT" + ")";
		db.execSQL(bang1);
		String bang2 = "CREATE TABLE " + KEY_TABLE2 + "(" + KEY_MA_GD
				+ " TEXT PRIMARY KEY, " + KEY_DATE + " DATETIME, " + KEY_MONEY
				+ " INTEGER, " + KEY_LOAI_GD + " TEXT," + KEY_MA_KHOAN
				+ " TEXT, " + KEY_CHI_TIET + " TEXT" + ")";
		db.execSQL(bang2);
		String bang3 = "CREATE TABLE " + KEY_TABLE3 + "(" + KEY_MA_KHOAN1
				+ " INTEGER PRIMARY KEY, " + KEY_TEN_KHOAN + " TEXT, "
				+ KEY_NHOM + " TEXT" + ")";
		db.execSQL(bang3);
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		db.execSQL("DROP IT IF EXIST " + KEY_TABLE1);
		db.execSQL("DROP IT IF EXIST " + KEY_TABLE2);
		db.execSQL("DROP IT IF EXIST " + KEY_TABLE3);
		onCreate(db);
	}

	public List<PhanLoai> selecttable1() {
		ArrayList<PhanLoai> phan = new ArrayList<PhanLoai>();
		String chon = "SELECT * FROM " + KEY_TABLE1;
		SQLiteDatabase db = this.getWritableDatabase();
		Cursor cursor = db.rawQuery(chon, null);
		if (cursor.moveToFirst()) {
			do {
				String Maloai = cursor.getString(0);
				String TenLoai = cursor.getString(1);
				PhanLoai phannhom = new PhanLoai(Maloai, TenLoai);
				phan.add(phannhom);
			} while (cursor.moveToNext());
		}
		return phan;
	}

	public List<GiaoDich> selecttable2() {
		ArrayList<GiaoDich> phan = new ArrayList<GiaoDich>();
		String chon = "SELEct * FROM " + KEY_TABLE2;
		SQLiteDatabase db = this.getWritableDatabase();
		Cursor cursor = db.rawQuery(chon, null);
		if (cursor.moveToFirst()) {
			do {
				String MaGD = cursor.getString(0);
				String Date = cursor.getString(1);
				int Money = Integer.parseInt(cursor.getString(2));
				String LoaiGD = cursor.getString(3);
				String MaKhoan = cursor.getString(4);
				String Chitiet = cursor.getString(5);
				GiaoDich phannhom = new GiaoDich(MaGD, Date, Money, LoaiGD,
						MaKhoan, Chitiet);
				phan.add(phannhom);
			} while (cursor.moveToNext());
		}
		return phan;
	}

	public List<ThuChi> selecttable3() {
		ArrayList<ThuChi> phan = new ArrayList<ThuChi>();
		String chon = "SELEct * FROM " + KEY_TABLE3;
		SQLiteDatabase db = this.getWritableDatabase();
		Cursor cursor = db.rawQuery(chon, null);
		if (cursor.moveToFirst()) {
			do {
				String MaKhoan = cursor.getString(0);
				String TenKhoan = cursor.getString(1);
				String Nhom = cursor.getString(2);
				ThuChi phannhom = new ThuChi(MaKhoan, TenKhoan, Nhom);
				phan.add(phannhom);
			} while (cursor.moveToNext());
		}
		return phan;
	}

	public void addtable1(PhanLoai phan) {
		SQLiteDatabase db = this.getWritableDatabase();
		ContentValues content = new ContentValues();
		content.put(KEY_MA_LOAI, phan.Maloai);
		content.put(KEY_TEN_LOAI, phan.Tenloai);
		db.insert(KEY_TABLE1, null, content);
		db.close();
	}

	public void addtable2(GiaoDich phan) {
		SQLiteDatabase db = this.getWritableDatabase();
		ContentValues content = new ContentValues();
		content.put(KEY_MA_GD, phan.MaGD);
		content.put(KEY_DATE, phan.Date);
		content.put(KEY_MONEY, phan.money);
		content.put(KEY_LOAI_GD, phan.LoaiGD);
		content.put(KEY_MA_KHOAN, phan.MaKhoan);
		content.put(KEY_CHI_TIET, phan.Chitiet);
		db.insert(KEY_TABLE2, null, content);
		db.close();
	}

	public void addtable3(ThuChi phan) {
		SQLiteDatabase db = this.getWritableDatabase();
		ContentValues content = new ContentValues();
		content.put(KEY_MA_KHOAN1, phan.Makhoan);
		content.put(KEY_TEN_KHOAN, phan.Tenkhoan);
		content.put(KEY_NHOM, phan.Nhom);
		db.insert(KEY_TABLE3, null, content);
		db.close();
	}

	public ArrayList<String> getName() {
		ArrayList<String> nguyen = new ArrayList<String>();
		SQLiteDatabase db = this.getWritableDatabase();
		String select = "SELECT " + KEY_TEN_KHOAN + " FROM " + KEY_TABLE3;
		Cursor cursor = db.rawQuery(select, null);
		if (cursor.moveToFirst()) {
			do {
				String name = cursor.getString(0);
				nguyen.add(name);
			} while (cursor.moveToNext());

		}
		return nguyen;
	}
	public ArrayList<String>getnameloai(){
		ArrayList<String>nguyen = new ArrayList<String>();
		SQLiteDatabase db = this.getWritableDatabase();
		String chon = "SELECT DISTINCT "+KEY_TEN_LOAI+" FROM "+KEY_TABLE1;
		Cursor cursor = db.rawQuery(chon,null);
		if(cursor.moveToFirst()){
			do{
				String name = cursor.getString(0);
				nguyen.add(name);
			}while(cursor.moveToNext());
		}
		return nguyen;
	}
	public int updatetable1(PhanLoai phan) {
		SQLiteDatabase db = this.getWritableDatabase();
		ContentValues content = new ContentValues();
		content.put(KEY_MA_LOAI, phan.Maloai);
		content.put(KEY_TEN_LOAI, phan.Tenloai);
		return db.update(KEY_TABLE1, content, KEY_MA_LOAI,
				new String[] { String.valueOf(phan.Maloai) });
	}

	public int updatetable2(GiaoDich phan) {
		SQLiteDatabase db = this.getWritableDatabase();
		ContentValues content = new ContentValues();
		content.put(KEY_MA_GD, phan.MaGD);
		content.put(KEY_DATE, phan.Date);
		content.put(KEY_MONEY, phan.money);
		content.put(KEY_LOAI_GD, phan.LoaiGD);
		content.put(KEY_MA_KHOAN, phan.MaKhoan);
		content.put(KEY_CHI_TIET, phan.Chitiet);
		return db.update(KEY_TABLE2, content, KEY_MA_GD,
				new String[] { String.valueOf(phan.MaGD) });
	}

	public int updatetable3(ThuChi phan) {
		SQLiteDatabase db = this.getWritableDatabase();
		ContentValues content = new ContentValues();
		content.put(KEY_MA_KHOAN1, phan.Makhoan);
		content.put(KEY_TEN_KHOAN, phan.Tenkhoan);
		content.put(KEY_NHOM, phan.Nhom);
		return db.update(KEY_TABLE3, content, KEY_MA_KHOAN1,
				new String[] { String.valueOf(phan.Makhoan) });
	}

	public void deletetable1(PhanLoai phan) {
		SQLiteDatabase db = this.getWritableDatabase();
		db.delete(KEY_TABLE1, KEY_MA_LOAI + " = ?",
				new String[] { String.valueOf(phan.Maloai) });
		db.close();
	}

	public void deletetable2(GiaoDich phan) {
		SQLiteDatabase db = this.getWritableDatabase();
		db.delete(KEY_TABLE2, KEY_MA_GD + " = ?",
				new String[] { String.valueOf(phan.MaGD) });
		db.close();
	}

	public void deletetable3(ThuChi phan) {
		SQLiteDatabase db = this.getWritableDatabase();
		db.delete(KEY_TABLE3, KEY_MA_KHOAN1 + " = ?",
				new String[] { String.valueOf(phan.Makhoan) });
		db.close();
	}

	public int Tindung() {
		int nguyen = 0;
		SQLiteDatabase db = this.getWritableDatabase();
		String chon = "SELECT SUM(" + KEY_MONEY + ") " + "FROM " + KEY_TABLE2
				+ " WHERE " + KEY_MA_KHOAN + " LIKE 'Tín dụng' " + "AND "
				+ KEY_LOAI_GD + " LIKE 'thu'";
		Cursor cursor = db.rawQuery(chon, null);
		if (cursor.moveToFirst()) {
			do {
				nguyen = cursor.getInt(0);

			} while (cursor.moveToNext());

		}
		return nguyen;
	}

	public int TienMat() {
		int nguyen = 0;
		SQLiteDatabase db = this.getWritableDatabase();
		String chon = "SELECT SUM(" + KEY_MONEY + ") " + "FROM " + KEY_TABLE2
				+ " WHERE " + KEY_MA_KHOAN + " LIKE 'Tiền Mặt' " + "AND "
				+ KEY_LOAI_GD + " LIKE 'thu'";
		Cursor cursor = db.rawQuery(chon, null);
		if (cursor.moveToFirst()) {
			do {
				nguyen = cursor.getInt(0);

			} while (cursor.moveToNext());
		}
		return nguyen;
	}

	public int Tietkiem() {
		int nguyen = 0;
		SQLiteDatabase db = this.getWritableDatabase();
		String chon = "SELECT SUM(" + KEY_MONEY + ") " + "FROM " + KEY_TABLE2
				+ " WHERE " + KEY_MA_KHOAN + " LIKE 'Tiết Kiệm' " + "AND "
				+ KEY_LOAI_GD + " LIKE 'thu'";
		Cursor cursor = db.rawQuery(chon, null);
		if (cursor.moveToFirst()) {
			do {
				nguyen = cursor.getInt(0);

			} while (cursor.moveToNext());
		}
		return nguyen;
	}

	public int Tindungchi() {
		int nguyen = 0;
		SQLiteDatabase db = this.getWritableDatabase();
		String chon = "SELECT SUM(" + KEY_MONEY + ") " + "FROM " + KEY_TABLE2
				+ " WHERE " + KEY_MA_KHOAN + " LIKE 'Tín dụng' " + "AND "
				+ KEY_LOAI_GD + " LIKE 'chi'";
		Cursor cursor = db.rawQuery(chon, null);
		if (cursor.moveToFirst()) {
			do {
				nguyen = cursor.getInt(0);

			} while (cursor.moveToNext());

		}
		return nguyen;
	}

	public int TienMatchi() {
		int nguyen = 0;
		SQLiteDatabase db = this.getWritableDatabase();
		String chon = "SELECT SUM(" + KEY_MONEY + ") " + "FROM " + KEY_TABLE2
				+ " WHERE " + KEY_MA_KHOAN + " LIKE 'Tiền Mặt' " + "AND "
				+ KEY_LOAI_GD + " LIKE 'chi'";
		Cursor cursor = db.rawQuery(chon, null);
		if (cursor.moveToFirst()) {
			do {
				nguyen = cursor.getInt(0);

			} while (cursor.moveToNext());
		}
		return nguyen;
	}

	public int Tietkiemchi() {
		int nguyen = 0;
		SQLiteDatabase db = this.getWritableDatabase();
		String chon = "SELECT SUM(" + KEY_MONEY + ") " + "FROM " + KEY_TABLE2
				+ " WHERE " + KEY_MA_KHOAN + " LIKE 'Tiết Kiệm' " + "AND "
				+ KEY_LOAI_GD + " LIKE 'chi'";
		Cursor cursor = db.rawQuery(chon, null);
		if (cursor.moveToFirst()) {
			do {
				nguyen = cursor.getInt(0);

			} while (cursor.moveToNext());
		}
		return nguyen;
	}

	public int tongthu() {
		int nguyen = 0;
		SQLiteDatabase db = this.getWritableDatabase();
		String chon = "SELECT SUM(" + KEY_MONEY + ") " + "FROM " + KEY_TABLE2
				+ " WHERE " + KEY_LOAI_GD + " LIKE 'thu'";
		Cursor cursor = db.rawQuery(chon, null);
		if (cursor.moveToFirst()) {
			do {
				nguyen = cursor.getInt(0);
			} while (cursor.moveToNext());
		}
		return nguyen;
	}

	public int tongchi() {
		int nguyen = 0;
		SQLiteDatabase db = this.getWritableDatabase();
		String chon = "SELECT SUM(" + KEY_MONEY + ") " + "FROM " + KEY_TABLE2
				+ " WHERE " + KEY_LOAI_GD + " LIKE 'chi'";
		Cursor cursor = db.rawQuery(chon, null);
		if (cursor.moveToFirst()) {
			do {
				nguyen = cursor.getInt(0);
			} while (cursor.moveToNext());
		}
		return nguyen;
	}

	public int date(String date) {
		int aray = 0;
		SQLiteDatabase db = this.getWritableDatabase();
		String chon = "SELECT " + "SUM(" + KEY_MONEY + ")" + " FROM "
				+ KEY_TABLE2 + " WHERE " + KEY_DATE + " LIKE '%" + date + "%'";
		Cursor cursor = db.rawQuery(chon, null);
		if (cursor.moveToFirst()) {
			do {

				aray = cursor.getInt(0);
			} while (cursor.moveToNext());
		}
		return aray;
	}

	public List<GiaoDich> tongngay(String date) {
		ArrayList<GiaoDich> tong = new ArrayList<GiaoDich>();
		SQLiteDatabase db = this.getWritableDatabase();
		String chon = "SELECT * FROM " + KEY_TABLE2 + " WHERE " + KEY_DATE
				+ " LIKE '%" + date + "%'";
		Cursor cursor = db.rawQuery(chon, null);
		if (cursor.moveToFirst()) {
			do {
				String MaGD = cursor.getString(0);
				String Date = cursor.getString(1);
				int Money = Integer.parseInt(cursor.getString(2));
				String LoaiGD = cursor.getString(3);
				String MaKhoan = cursor.getString(4);
				String Chitiet = cursor.getString(5);
				GiaoDich phannhom = new GiaoDich(MaGD, Date, Money, LoaiGD,
						MaKhoan, Chitiet);
				tong.add(phannhom);
			} while (cursor.moveToNext());
		}
		return tong;
	}

	public int tuan(String date) {
		int aray = 0;
		SQLiteDatabase db = this.getWritableDatabase();
		String chon = "SELECT SUM(Tien), strftime('%d/%m/%Y', date('now', 'weekday 0', '-6 day')) AS start,"
				+ " strftime('%d/%m/%Y', date('now', 'weekday 0')) AS end from "
				+ KEY_TABLE2
				+ " WHERE "
				+ KEY_DATE
				+ ">= start "
				+ " AND "
				+ KEY_DATE + " <= end";
		Cursor cursor = db.rawQuery(chon, null);
		if (cursor.moveToFirst()) {
			do {
				aray = cursor.getInt(0);
			} while (cursor.moveToNext());
		}
		return aray;
	}

	public List<GiaoDich> tongtuan(String date) {
		ArrayList<GiaoDich> tong = new ArrayList<GiaoDich>();
		SQLiteDatabase db = this.getWritableDatabase();
		String chon = "SELECT *, strftime('%d/%m/%Y', date('now', 'weekday 0', '-6 day')) AS start,"
				+ " strftime('%d/%m/%Y', date('now', 'weekday 0')) AS end from "
				+ KEY_TABLE2
				+ " WHERE "
				+ KEY_DATE
				+ ">= start "
				+ " AND "
				+ KEY_DATE + " <= end";
		Cursor cursor = db.rawQuery(chon, null);
		if (cursor.moveToFirst()) {
			do {
				String MaGD = cursor.getString(0);
				String Date = cursor.getString(1);
				int Money = Integer.parseInt(cursor.getString(2));
				String LoaiGD = cursor.getString(3);
				String MaKhoan = cursor.getString(4);
				String Chitiet = cursor.getString(5);
				GiaoDich phannhom = new GiaoDich(MaGD, Date, Money, LoaiGD,
						MaKhoan, Chitiet);
				tong.add(phannhom);
			} while (cursor.moveToNext());
		}
		return tong;
	}

	public int thang(String time) {
		int aray = 0;
		SQLiteDatabase db = this.getWritableDatabase();
		String chon =" SELECT SUM( Tien ) FROM  GiaoDich where NgayGD like '%%/"+time+"'";		
		Cursor cursor = db.rawQuery(chon,null);
		if(cursor.moveToFirst()){
			do{
				aray = cursor.getInt(0);
				
			}while(cursor.moveToNext());
		}
		
		return aray;
	}
	public List<GiaoDich>tongthang(String time){
		ArrayList<GiaoDich> tong = new ArrayList<GiaoDich>();
		SQLiteDatabase db = this.getWritableDatabase();
		String chon =" SELECT * FROM  GiaoDich where NgayGD like '%%/"+time+"'";	
		Cursor cursor = db.rawQuery(chon, null);
		if (cursor.moveToFirst()) {
			do {
				String MaGD = cursor.getString(0);
				String Date = cursor.getString(1);
				int Money = Integer.parseInt(cursor.getString(2));
				String LoaiGD = cursor.getString(3);
				String MaKhoan = cursor.getString(4);
				String Chitiet = cursor.getString(5);
				GiaoDich phannhom = new GiaoDich(MaGD, Date, Money, LoaiGD,
						MaKhoan, Chitiet);
				tong.add(phannhom);
			} while (cursor.moveToNext());
		}
		return tong;
	}
	public int nam(String time){
		int aray =0;
		SQLiteDatabase db = this.getWritableDatabase();
		String chon = "SELECT SUM(Tien) FROM "+ KEY_TABLE2+" WHERE "+KEY_DATE +" LIKE '%%/%%/"+time+"'";
		Cursor cursor = db.rawQuery(chon, null);
		if(cursor.moveToFirst()){
			do{
				aray = cursor.getInt(0);
			}while(cursor.moveToNext());
		}
		return aray;
		}
	public List<GiaoDich>tongnam(String time){
		ArrayList<GiaoDich> tong = new ArrayList<GiaoDich>();
		SQLiteDatabase db = this.getWritableDatabase();
		String chon = "SELECT * FROM "+ KEY_TABLE2+" WHERE "+KEY_DATE +" LIKE '%%/%%/"+time+"'";	
		Cursor cursor = db.rawQuery(chon, null);
		if (cursor.moveToFirst()) {
			do {
				String MaGD = cursor.getString(0);
				String Date = cursor.getString(1);
				int Money = Integer.parseInt(cursor.getString(2));
				String LoaiGD = cursor.getString(3);
				String MaKhoan = cursor.getString(4);
				String Chitiet = cursor.getString(5);
				GiaoDich phannhom = new GiaoDich(MaGD, Date, Money, LoaiGD,
						MaKhoan, Chitiet);
				tong.add(phannhom);
			} while (cursor.moveToNext());
		}
		return tong;
	}
	public List<PhanLoai>tongdl(String name){
		ArrayList<PhanLoai> list = new ArrayList<PhanLoai>();
		SQLiteDatabase db = this.getWritableDatabase();
		String chon = "SELECT * FROM "+KEY_TABLE1 + " WHERE "+KEY_TEN_LOAI +" LIKE '"+ name+"'" ;
		Cursor cursor = db.rawQuery(chon,null);
		if(cursor.moveToFirst()){
			do{
				String maloai = cursor.getString(0);
				String tenloai = cursor.getString(1);
				PhanLoai pl = new PhanLoai(maloai,tenloai);
				list.add(pl);
			}while(cursor.moveToNext());
		}
		return list;
	}
	public List<GiaoDich> tonggdthu(String date1){
		ArrayList<GiaoDich> date = new ArrayList<GiaoDich>();
		SQLiteDatabase db = this.getWritableDatabase();
		String chon = "SELECT * FROM " + KEY_TABLE2 + " WHERE "+KEY_LOAI_GD + " LIKE 'thu' AND "+KEY_DATE+" LIKE '"+date1+"'";
		Cursor cursor = db.rawQuery(chon, null);
		if(cursor.moveToFirst()){
			do{
				String MaGD = cursor.getString(0);
				String Date = cursor.getString(1);
				int Money = Integer.parseInt(cursor.getString(2));
				String LoaiGD = cursor.getString(3);
				String MaKhoan = cursor.getString(4);
				String Chitiet = cursor.getString(5);
				GiaoDich phannhom = new GiaoDich(MaGD, Date, Money, LoaiGD,
						MaKhoan, Chitiet);
				date.add(phannhom);
			}while(cursor.moveToNext());
		}
		return date;
	}
	public List<GiaoDich> tonggdchi(String date1){
		ArrayList<GiaoDich> date = new ArrayList<GiaoDich>();
		SQLiteDatabase db = this.getWritableDatabase();
		String chon = "SELECT * FROM " + KEY_TABLE2 + " WHERE "+KEY_LOAI_GD + " LIKE 'chi' AND "+KEY_DATE+" LIKE '"+date1+"'";
		Cursor cursor = db.rawQuery(chon, null);
		if(cursor.moveToFirst()){
			do{
				String MaGD = cursor.getString(0);
				String Date = cursor.getString(1);
				int Money = Integer.parseInt(cursor.getString(2));
				String LoaiGD = cursor.getString(3);
				String MaKhoan = cursor.getString(4);
				String Chitiet = cursor.getString(5);
				GiaoDich phannhom = new GiaoDich(MaGD, Date, Money, LoaiGD,
						MaKhoan, Chitiet);
				date.add(phannhom);
			}while(cursor.moveToNext());
		}
		return date;
	}

	public List<GiaoDich> tonggdthu1(String date1,String date2){
		ArrayList<GiaoDich> date = new ArrayList<GiaoDich>();
		SQLiteDatabase db = this.getWritableDatabase();
		String chon = "SELECT * FROM " + KEY_TABLE2 + " WHERE "+KEY_LOAI_GD + " LIKE 'thu' AND "+KEY_DATE+" BETWEEN '"+date1+"' AND '" +date2 +"'";
		Cursor cursor = db.rawQuery(chon, null);
		if(cursor.moveToFirst()){
			do{
				String MaGD = cursor.getString(0);
				String Date = cursor.getString(1);
				int Money = Integer.parseInt(cursor.getString(2));
				String LoaiGD = cursor.getString(3);
				String MaKhoan = cursor.getString(4);
				String Chitiet = cursor.getString(5);
				GiaoDich phannhom = new GiaoDich(MaGD, Date, Money, LoaiGD,
						MaKhoan, Chitiet);
				date.add(phannhom);
			}while(cursor.moveToNext());
		}
		return date;
	}
	public List<GiaoDich> tonggdchi1(String date1 , String date2){
		ArrayList<GiaoDich> date = new ArrayList<GiaoDich>();
		SQLiteDatabase db = this.getWritableDatabase();
		String chon = "SELECT * FROM " + KEY_TABLE2 + " WHERE "+KEY_LOAI_GD + " LIKE 'chi' AND "+KEY_DATE+" BETWEEN '"+date1+"' AND '" +date2 +"'";
		Cursor cursor = db.rawQuery(chon, null);
		if(cursor.moveToFirst()){
			do{
				String MaGD = cursor.getString(0);
				String Date = cursor.getString(1);
				int Money = Integer.parseInt(cursor.getString(2));
				String LoaiGD = cursor.getString(3);
				String MaKhoan = cursor.getString(4);
				String Chitiet = cursor.getString(5);
				GiaoDich phannhom = new GiaoDich(MaGD, Date, Money, LoaiGD,
						MaKhoan, Chitiet);
				date.add(phannhom);
			}while(cursor.moveToNext());
		}
		return date;
	}
}