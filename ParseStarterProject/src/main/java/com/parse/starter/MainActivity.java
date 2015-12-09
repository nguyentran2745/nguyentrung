package com.parse.starter;



import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.DatePickerDialog.OnDateSetListener;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TabHost;
import android.widget.TextView;
import android.widget.Toast;

import com.parse.Parse;
import com.parse.ParseObject;


public class MainActivity extends Activity {
	Button nbt3,nbt4,nbt5,nbt6,bt1,bt2,bt3,bt4,nguyenbutton,btok1,btcancel1,btcc1;
	EditText nguyenedit111,nedit1,nedit2;
	Dialog dialog1,dialog2;
	Dialog dialog;
	Object object1,object2;
	String string,string1,string2;
	ArrayAdapter<String>adapter,adapterz,adaptert;
	MyArrayAdapter adapter1,adapter1_1 ;
	MyArrayAdapter2 adapter2;
	String[]loaithu={"-------","thu","chi"};
	EditText edit1,edit2,edit3,edit4;
	String money;
	Object ob,ob1;
	ListView listview,listview1,listview2,listview3;
	List<String> list;
	List<GiaoDich>list1,list1_1;
	List<PhanLoai>list2;	
	Spinner spin1,spin2,spin3,spintab2;
	AlertDialog alert,alert1;
	String magd,NgayGD;
	Spinner chitiet;
	Animation anim ;
	DataBase data;
	String stringn1,stringn2,stringn3,stringn4;
	ThuChi thuchi;
	String datestart,dateend;
	Calendar cal;
	String m,m2;
	Date m1;
	String strDate1,strDate2;
	String strTime1,strTime2;
	String s,s1;
	SimpleDateFormat dft1,dft2;
	Date dateFinish;
	//DateFormat dateme = DateFormat.getDateInstance();
	TextView textme1,textme2;
	//Calendar calen = Calendar.getInstance();
//	DatePickerDialog.OnDateSetListener m = new DatePickerDialog.OnDateSetListener() {
//		
//		@Override
//		public void onDateSet(DatePicker view, int year, int monthOfYear,
//				int dayOfMonth) {
//			calen.set(Calendar.YEAR,year);
//			calen.set(Calendar.MONTH, monthOfYear);
//			calen.set(Calendar.DAY_OF_MONTH, dayOfMonth);
//			textme1.setText(dateme.format(calen.getTime()));
//			datestart =dateme.format(calen.getTime());
//		}
//	};
//	DatePickerDialog.OnDateSetListener n = new DatePickerDialog.OnDateSetListener() {
//		
//		@Override
//		public void onDateSet(DatePicker view, int year, int monthOfYear,
//				int dayOfMonth) {
//			calen.set(Calendar.YEAR, year);
//			calen.set(Calendar.MONTH, monthOfYear);
//			calen.set(Calendar.DAY_OF_MONTH, dayOfMonth);
//			textme2.setText(dateme.format(calen.getTime()));
//			dateend=dateme.format(calen.getTime());
//		}
//	};
	
    public static String now(String dateFormat) {
        Calendar cal = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);
       return sdf.format(cal.getTime());
    }
	 @Override
	    protected void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	        setContentView(R.layout.activity_main);


		 loadtab();
	        
	        
	        data = new DataBase(this, "QuanliGiaoDich", null, 1);
	        listview1 = (ListView)findViewById(R.id.lisst1);
	        show();	        
	        adapter2.notifyDataSetChanged();
	        listview2 = (ListView)findViewById(R.id.mylist1);
	    	listview3 = (ListView)findViewById(R.id.mylist2);
	    	show3(m);
	        show4(m);
	        adapter1.notifyDataSetChanged();

	        
			bt1 = (Button)findViewById(R.id.nbt1);
			bt2 = (Button)findViewById(R.id.nbt2);	
	    	nbt3 = (Button)findViewById(R.id.nbt3); 
	    	nbt4 = (Button)findViewById(R.id.bt4);
	    	nbt5 = (Button)findViewById(R.id.bt5);
	    	nbt6 = (Button)findViewById(R.id.bt6);
	    	nguyenbutton= (Button)findViewById(R.id.nguyenbutton1);
	    	spin3 = (Spinner)findViewById(R.id.spin3);
	    	textme1 = (TextView)findViewById(R.id.textViewme1);
	    	textme2 = (TextView)findViewById(R.id.textViewme2);
	    	//tao mot animation voi hieu ung duoc viet bang xml o trong res/anim
	    	anim = AnimationUtils.loadAnimation(this, R.anim.fade_anim);

	    	//textme2 = (TextView)findViewById(R.id.textViewme2);
	    	//datestart = textme1.getText().toString();
	        //dateend   = textme2.getText().toString();
	    	cal=Calendar.getInstance();
	    	dateFinish=cal.getTime();
	    	getDefaultInfor();
	    	getDefaultInfor1();
	    	
	    	Button butdatestart = (Button)findViewById(R.id.bttimestart);
	    	butdatestart.setOnClickListener(new Button.OnClickListener(){

				@Override
				public void onClick(View v) {
					showDatePickerDialog();
					listview2 = (ListView)findViewById(R.id.mylist1);
			    	listview3 = (ListView)findViewById(R.id.mylist2);
			    	show3_1(m, m2);
			        show4_1(m, m2);
				}
	    		
	    	});
	    	Button butdateend = (Button)findViewById(R.id.bttimeend);
	    	butdateend.setOnClickListener(new Button.OnClickListener(){
	    		@Override
	    		public void onClick(View v){
	    			showDatePickerDialog1();
	    			listview2 = (ListView)findViewById(R.id.mylist1);
	    	    	listview3 = (ListView)findViewById(R.id.mylist2);
					show3_1(m, m2);
					show4_1(m, m2);
	    		}
	    	});
	    	
	    	show2();
	    	adapterz.notifyDataSetChanged();
	    	//tao mot spinner trong layoout tab3 , ham show1 dung de load du lieu len, neu den day thi dung nhung
	    	//loi
	    	spin3.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

				@Override
				public void onItemSelected(final AdapterView<?> parent, View view,
						final int position, long id) {
					 anim.setAnimationListener(new Animation.AnimationListener() {
		                    @Override
		                    public void onAnimationStart(Animation animation) {
		 
		                    }
		 
		                    @Override
		                    public void onAnimationRepeat(Animation animation) {
		 
		                    }
		 
		                    @Override
		                    public void onAnimationEnd(Animation animation) {
		                    	ob = parent.getItemAtPosition(position);
		    					stringn3 = (String)ob;		
		    					show1(stringn3);
		                    }
		                });
					 //loi dong nay 
		                //view.startAnimation(anim);
					
					
				}

				@Override
				public void onNothingSelected(AdapterView<?> parent) {
					// TODO Auto-generated method stub
					
				}
	    		
	    	});
	    		
	    	hienthi();
			hienthi1();
			hienthi2();
			hienthi3();
			
			bt1.setOnClickListener(new Button.OnClickListener(){
				@Override
				public void onClick(View v){
					them();
					them1();
					them2();
					dialog= new Dialog(MainActivity.this);
					dialog.setContentView(R.layout.newdialog);
					dialog.setTitle("WELCOME");
					bt3 = (Button)dialog.findViewById(R.id.btxOK);
					bt4 = (Button)dialog.findViewById(R.id.btxCancel);
					edit1 = (EditText)dialog.findViewById(R.id.magd);
					edit2 = (EditText)dialog.findViewById(R.id.NgayGD);
					edit3 = (EditText)dialog.findViewById(R.id.tien);
					chitiet = (Spinner)dialog.findViewById(R.id.mact);
					spin1 = (Spinner)dialog.findViewById(R.id.loaigd);
					spin2 = (Spinner)dialog.findViewById(R.id.makhoan);
					
					list = data.getnameloai();
			    	adapterz = new ArrayAdapter<String>(MainActivity.this,android.R.layout.simple_spinner_item,list);
			    	chitiet.setAdapter(adapterz);
					
			    	chitiet.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

						@Override
						public void onItemSelected(AdapterView<?> parent, View view,
								int position, long id) {
							ob1 = parent.getItemAtPosition(position);
							stringn4 = (String)ob1;
							
						}

						@Override
						public void onNothingSelected(AdapterView<?> parent) {
							// TODO Auto-generated method stub
							
						}
			    		
			    	});
					
					list = data.getName();
					
					adapter=new ArrayAdapter<String>(MainActivity.this,android.R.layout.simple_spinner_item,loaithu);
					spin1.setAdapter(adapter);
					
					adapter = new ArrayAdapter<String>(MainActivity.this,android.R.layout.simple_spinner_item,list);
					spin2.setAdapter(adapter);
					spin1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
					
					
						@Override
						public void onItemSelected(
								AdapterView<?> parent, View view,
								int position, long id) {
							object1 = parent.getItemAtPosition(position);
							string = (String)object1;
						}

						@Override
						public void onNothingSelected(
								AdapterView<?> parent) {
								
						}
					
					});
									
					spin2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

						@Override
						public void onItemSelected(
								AdapterView<?> parent, View view,
								int position, long id) {
							object2 = parent.getItemAtPosition(position);
							string1 = (String)object2;
						}

						@Override
						public void onNothingSelected(
								AdapterView<?> parent) {
							
						}
					
					});
					bt4.setOnClickListener(new Button.OnClickListener(){
						@Override
						public void onClick(View v){
							dialog.dismiss();
						}
					});
					bt3.setOnClickListener(new Button.OnClickListener(){
						@Override
						public void onClick(View v){
							magd = edit1.getText().toString();
							 NgayGD = edit2.getText().toString();
							 money = edit3.getText().toString();
							 
							if(magd.trim().equalsIgnoreCase("")){
								Toast.makeText(MainActivity.this, "Khong Duoc De Ma Giao Dich Trong", Toast.LENGTH_SHORT).show();
								Toast.makeText(MainActivity.this,m, Toast.LENGTH_SHORT).show();
							}else if(NgayGD.trim().equalsIgnoreCase("")){
								Toast.makeText(MainActivity.this, "Khong Duoc De Ngay Giao Dich Trong", Toast.LENGTH_SHORT).show();
							}
							else if(!NgayGD.matches("(0?[1-9]|[12][0-9]|3[01])/(0?[1-9]|1[012])/((19|20)\\d\\d)")) {
								Toast.makeText(MainActivity.this,
										"Sai dinh dang ngày tháng nam ",
										Toast.LENGTH_SHORT).show();
							}else if(money.trim().equalsIgnoreCase("")){
								Toast.makeText(MainActivity.this, "Khong Duoc De So tien Trong", Toast.LENGTH_SHORT).show();
							}
							else if(string.trim().equalsIgnoreCase("-------")){
								Toast.makeText(MainActivity.this, "Vui long chon loai GD", Toast.LENGTH_SHORT).show();
							}else{
								 alert = NewAlert();
								alert.show();
							}
						}
					});
					dialog.show();					
					
				}
			});
				nbt3.setOnClickListener(new Button.OnClickListener(){
					
							@Override
							public void onClick(View v){
								
									
								    dialog1 = new Dialog(MainActivity.this);
									dialog1.setContentView(R.layout.layoutdateon);
								    listview = (ListView)dialog1.findViewById(R.id.listthongke);
								    chon(now("dd/MM/yyyy"));
								    chon1();
								    TextView textview = (TextView)dialog1.findViewById(R.id.textview3);
								    textview.setText("Tổng Số Tiền Là : ");
								
								    Button button = (Button)dialog1.findViewById(R.id.btx1);
									button.setOnClickListener(new Button.OnClickListener(){
										@Override
										public void onClick(View v){
											dialog1.dismiss();
										}
									});
									dialog1.show();
								
								
							}
						});
				nbt4.setOnClickListener(new Button.OnClickListener(){
					@Override
					public void onClick(View v){
						  dialog1 = new Dialog(MainActivity.this);
							dialog1.setContentView(R.layout.layoutdateon);
						    listview = (ListView)dialog1.findViewById(R.id.listthongke);
						    chontuan(now("dd/MM/yyyy"));
						    chontongtuan();
						    TextView textview = (TextView)dialog1.findViewById(R.id.textview3);
						    textview.setText("Tổng Số Tiền Là : ");
						
						    Button button = (Button)dialog1.findViewById(R.id.btx1);
							button.setOnClickListener(new Button.OnClickListener(){
								@Override
								public void onClick(View v){
									dialog1.dismiss();
								}
							});
							dialog1.show();
					}
				});
				nbt5.setOnClickListener(new Button.OnClickListener(){
					@Override
					public void onClick(View v){
						  dialog1 = new Dialog(MainActivity.this);
							dialog1.setContentView(R.layout.layoutdateon);
						    listview = (ListView)dialog1.findViewById(R.id.listthongke);
						    chonthang(now("MM/yyyy"));
						    chontongthang();
						    TextView textview = (TextView)dialog1.findViewById(R.id.textview3);
						    textview.setText("Tổng Số Tiền Là : ");
						    
						    Button button = (Button)dialog1.findViewById(R.id.btx1);
							button.setOnClickListener(new Button.OnClickListener(){
								@Override
								public void onClick(View v){
									dialog1.dismiss();
								}
							});
							dialog1.show();
					}
				});
				nbt6.setOnClickListener(new Button.OnClickListener(){
					@Override
					public void onClick(View v){
						 dialog1 = new Dialog(MainActivity.this);
							dialog1.setContentView(R.layout.layoutdateon);
						    listview = (ListView)dialog1.findViewById(R.id.listthongke);
						    chonnam(now("yyyy"));
						    tongnam();
						    TextView textview = (TextView)dialog1.findViewById(R.id.textview3);
						    textview.setText("Tổng Số Tiền Là : ");
						    
						    Button button = (Button)dialog1.findViewById(R.id.btx1);
							button.setOnClickListener(new Button.OnClickListener(){
								@Override
								public void onClick(View v){
									dialog1.dismiss();
								}
							});
							dialog1.show();
					}
				});
					nguyenbutton.setOnClickListener(new Button.OnClickListener(){
						@Override
						public void onClick(View v){
							dialog2 = new Dialog(MainActivity.this);
							dialog2.setContentView(R.layout.newdialog1);
							 btok1 = (Button)dialog2.findViewById(R.id.btxOK1);
							 btcancel1 = (Button)dialog2.findViewById(R.id.btxCancel1);
							 btcancel1.setOnClickListener(new Button.OnClickListener(){
								 @Override
								 public void onClick(View v){
									 dialog2.dismiss();
								 }
							 });
							 nedit1 = (EditText)dialog2.findViewById(R.id.makhoan1);
							 nedit2 = (EditText)dialog2.findViewById(R.id.Tenkhoan);
							 
							 btok1.setOnClickListener(new Button.OnClickListener(){
								 @Override
								 public void onClick(View v){
									 stringn1 = nedit1.getText().toString();
									 stringn2 = nedit2.getText().toString();
									 if(stringn1.trim().equalsIgnoreCase("")){
										 Toast.makeText(MainActivity.this, "Khong Duoc de Ma Loai Trong", Toast.LENGTH_SHORT).show();
									 }else if(stringn2.trim().equalsIgnoreCase("")){
										 Toast.makeText(MainActivity.this, "Khong Duoc de Ten Loai Trong", Toast.LENGTH_SHORT).show();
									 }else{
										 alert1 = nguyen1();
										 alert1.show();
										 
									 }
								 }
							 });
							dialog2.show();
							
						}
					});
	 }	    
	 public void chon(String date){
		 TextView text = (TextView)dialog1.findViewById(R.id.textview4);
		 text.setText(String.valueOf(data.date(date)));
		 text.setTextSize(20);
	 }
	 public void chon1(){
		 list1 = data.tongngay(now("dd/MM/yyyy"));		 
		 adapter1 = new MyArrayAdapter(this,list1);
		 listview.setAdapter(adapter1);
	 }
	 public void chontuan(String date){
		 TextView text = (TextView)dialog1.findViewById(R.id.textview4);
		 text.setText(String.valueOf(data.tuan(date)));
		 text.setTextSize(20);
	 }
	 public void chontongtuan(){
		 list1 = data.tongtuan(now("dd/MM/yyyy"));
		 adapter1 = new MyArrayAdapter(this,list1);
		 listview.setAdapter(adapter1);
	 }
	 public void chonthang(String date){
		 TextView text =(TextView)dialog1.findViewById(R.id.textview4);
		 text.setText(String.valueOf(data.thang(date)));
		 text.setTextSize(20);
	 }
	 public void chontongthang(){
		 list1 = data.tongthang(now("MM/yyyy"));
		 adapter1 = new MyArrayAdapter(this,list1);
		 listview.setAdapter(adapter1);
	 }
	 public void chonnam(String date){
		 TextView text = (TextView)dialog1.findViewById(R.id.textview4);
		 text.setText(String.valueOf(data.nam(date)));
		 text.setTextSize(20);
	 }
	 public void tongnam(){
		 list1 = data.tongnam(now("yyyy"));
		 adapter1 = new MyArrayAdapter(this,list1);
		 listview.setAdapter(adapter1);
	 }
	 private AlertDialog NewAlert(){
		 AlertDialog.Builder xay = new AlertDialog.Builder(MainActivity.this);
		 xay.setTitle("Thong Bao");
		 xay.setMessage("Ban That su Muon them?");
		 xay.setNegativeButton("Yes",new DialogInterface.OnClickListener(){

			@Override
			public void onClick(DialogInterface dialog, int which) {
				Toast.makeText(MainActivity.this, "Da them Thanh Cong", Toast.LENGTH_LONG).show();
				themgiaodich();
				hienthi();
				hienthi1();
				hienthi2();
				hienthi3();
				dialog.dismiss();
			}
		 });
		 xay.setNeutralButton("No",new DialogInterface.OnClickListener(){

			@Override
			public void onClick(DialogInterface dialog, int which) {
				Toast.makeText(MainActivity.this, "Da Huy Thanh Cong", Toast.LENGTH_LONG).show();
				alert.dismiss();
			}
			 
		 });
		 AlertDialog nguyen = xay.create();
		 return nguyen;
	 }
	 
	 private AlertDialog nguyen1(){
		 AlertDialog.Builder xay = new AlertDialog.Builder(MainActivity.this);
		 xay.setTitle("Thong Bao");
		 xay.setMessage("Ban That su Muon them?");
		 xay.setNegativeButton("Yes",new DialogInterface.OnClickListener(){

			@Override
			public void onClick(DialogInterface dialog, int which) {
				Toast.makeText(MainActivity.this, "Da them Thanh Cong", Toast.LENGTH_LONG).show();
				themloai();
				show2();
				adapter2.notifyDataSetChanged();
				adapterz.notifyDataSetChanged();
				dialog2.dismiss();
			}
		 });
		 xay.setNeutralButton("No",new DialogInterface.OnClickListener(){

			@Override
			public void onClick(DialogInterface dialog, int which) {
				Toast.makeText(MainActivity.this, "Da Huy Thanh Cong", Toast.LENGTH_LONG).show();
				alert1.dismiss();
			}
			 
		 });
		 AlertDialog nguyen = xay.create();
		 return nguyen;
	 }
	     public void loadtab(){
	 		//Lấy Tabhost id ra trước (cái này của built - in android
	 		final TabHost tab=(TabHost) findViewById
	 				(android.R.id.tabhost);
	 		
	 		tab.setup();
	 		TabHost.TabSpec spec;
	 		
	 		spec=tab.newTabSpec("t1");
	 		spec.setContent(R.id.tab1);
	 		spec.setIndicator("Thu Chi");
	 		tab.addTab(spec);
	 		
	 		spec=tab.newTabSpec("t2");
	 		spec.setContent(R.id.tab2);
	 		spec.setIndicator("Thong Ke");
	 		tab.addTab(spec);
	 		
	 		spec=tab.newTabSpec("Cai Dat");
	 		spec.setContent(R.id.tab3);
	 		spec.setIndicator("Cai Dat");
	 		tab.addTab(spec);
	 		
	 		tab.setCurrentTab(0);
	    	  
	     }
	     public void themgiaodich(){
	    	GiaoDich giao = new GiaoDich();
			 ParseObject gameScore = new ParseObject("GiaoDich");
			 gameScore.put("MaGD", edit1.getText().toString());
			 gameScore.put("Date", edit2.getText().toString());
			 gameScore.put("money", Integer.parseInt(edit3.getText().toString()));
			 gameScore.put("LoaiGD", string.toString());
			 gameScore.put("MaKhoan", string1.toString());
			 gameScore.put("Chitiet", stringn4.toString());
	    	giao.MaGD = edit1.getText().toString();
	    	giao.Date = edit2.getText().toString();
	    	giao.money = Integer.parseInt(edit3.getText().toString());
	    	giao.LoaiGD = string.toString();
	    	giao.MaKhoan = string1.toString();
	    	giao.Chitiet = stringn4.toString();
			 gameScore.saveInBackground();
	    	data.addtable2(giao);

	     }
	     public void themloai(){
	    	 list2 = new ArrayList<PhanLoai>();
	    	 PhanLoai phan = new PhanLoai();
			 ParseObject gameScore = new ParseObject("Themloai");
			 gameScore.put("MaLoai", nedit1.getText().toString());
			 gameScore.put("TenLoai", nedit2.getText().toString());
	    	 phan.Maloai = nedit1.getText().toString();
	    	 phan.Tenloai = nedit2.getText().toString();
			 gameScore.saveInBackground();
	    	 data.addtable1(phan);
	    	 list2 = data.selecttable1();
	    	 adapter2 = new MyArrayAdapter2(this,list2);
	    	 listview1.setAdapter(adapter2);
	     }
	     public void show(){
	    	 list2 = data.selecttable1();
	    	 adapter2 = new MyArrayAdapter2(this,list2);
	    	 listview1.setAdapter(adapter2);
	     }
	     public void show1(String string){
	    	 list2 = data.tongdl(string);
	    	 adapter2 = new MyArrayAdapter2(this,list2);
	    	 listview1.setAdapter(adapter2);
	     }
	     public void show2(){
	    	    list = data.getnameloai();
		    	adapterz = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,list);
		    	spin3.setAdapter(adapterz);
	     }
	     public void show3(String date1){
	    	 list1 = data.tonggdthu(date1);
			 adapter1 = new MyArrayAdapter(this,list1);
			 listview2.setAdapter(adapter1);
			 adapter1.notifyDataSetChanged();
	     }
	     public void show4(String date1){
	    	 list1 = data.tonggdchi(date1);
			 adapter1 = new MyArrayAdapter(this,list1);
			 listview3.setAdapter(adapter1);
			 adapter1.notifyDataSetChanged();
	     }

	public void show3_1(String date1,String date2){
		list1 = data.tonggdthu1(date1, date2);
		adapter1 = new MyArrayAdapter(this,list1);
		listview2.setAdapter(adapter1);
		adapter1.notifyDataSetChanged();
	}
	public void show4_1(String date1,String date2){
		list1_1 = data.tonggdchi1(date1, date2);
		adapter1_1 = new MyArrayAdapter(this,list1_1);
		listview3.setAdapter(adapter1_1);
		adapter1_1.notifyDataSetChanged();
	}
//	     public void themgiaodich1(){
//		    	GiaoDich giao = new GiaoDich();
//		    	giao.MaGD = "0";
//		    	
//		    	giao.money = 0;
//		    	giao.LoaiGD = "thu";
//		    	giao.MaKhoan = string1.toString();
//		    	giao.Chitiet = edit4.getText().toString();
//		    	
//		    	data.addtable2(giao);
//		    	
//		     }
//	     public void themgiaodich2(){
//		    	GiaoDich giao = new GiaoDich();
//		    	giao.MaGD = edit1.getText().toString();
//		    	giao.Date = edit2.getText().toString();
//		    	giao.money = Integer.parseInt(edit3.getText().toString());
//		    	giao.LoaiGD = string.toString();
//		    	giao.MaKhoan = string1.toString();
//		    	giao.Chitiet = edit4.getText().toString();
//		    	
//		    	data.addtable2(giao);
//		    	
//		     }
	     public void them(){
	    	 thuchi = new ThuChi();
	    	 thuchi.Makhoan = "1";
	    	 thuchi.Tenkhoan = "Tín dụng";
			 thuchi.Nhom = "Tiền Thu và Chi";

	    	 data.addtable3(thuchi);
	     }
	     public void them1(){
	    	 thuchi = new ThuChi();
	    	 thuchi.Makhoan = "2";
	    	 thuchi.Tenkhoan = "Tiết Kiệm";
	    	 thuchi.Nhom = "Tiền Thu và Chi";
	    	 data.addtable3(thuchi);
	     }
	     public void them2(){
	    	 thuchi = new ThuChi();
	    	 thuchi.Makhoan = "3";
	    	 thuchi.Tenkhoan = "Tiền Mặt";
			 thuchi.Nhom = "Tiền Thu và Chi";
	    	 data.addtable3(thuchi);
	     }
	     public void hienthi(){
	    	 TextView textview1 = (TextView)findViewById(R.id.txt2);
	    	 textview1.setText(String.valueOf(data.TienMat()-data.TienMatchi()));
	     }
	     public void hienthi1(){
	    	 TextView textview1 = (TextView)findViewById(R.id.txt4);
	    	 textview1.setText(String.valueOf(data.Tietkiem()-data.Tietkiemchi()));
	     }
	     public void hienthi2(){
	    	 TextView textview1 = (TextView)findViewById(R.id.txt6);
	    	 textview1.setText(String.valueOf(data.Tindung()-data.Tindungchi()));
     }
	     public void hienthi3(){
	    	 TextView textview1 = (TextView)findViewById(R.id.txt8);
	    	 textview1.setText(String.valueOf(data.tongthu()-data.tongchi()));
	     }
	    @Override
	    public boolean onCreateOptionsMenu(Menu menu) {
	        // Inflate the menu; this adds items to the action bar if it is present.
	        getMenuInflater().inflate(R.menu.main, menu);
	        return true;
	    }
	    public void getDefaultInfor()
		{
			//lấy ngày hiện tại của hệ thống
			cal=Calendar.getInstance();
			 dft1=null;
		
			//Định dạng ngày / tháng /năm
			dft1=new SimpleDateFormat("dd/MM/yyyy",Locale.getDefault());
			
			strDate1=dft1.format(cal.getTime());
			
			//hiển thị lên giao diện
			textme1.setText(strDate1);

			//Định dạng giờ phút am/pm
			dft1=new SimpleDateFormat("hh:mm a",Locale.getDefault());
			
			strTime1=dft1.format(cal.getTime());

			//đưa lên giao diện		
			dateFinish=cal.getTime();

		}
	    public void getDefaultInfor1()
		{
			//lấy ngày hiện tại của hệ thống
			cal=Calendar.getInstance();
			 dft2=null;
		
			//Định dạng ngày / tháng /năm
			dft2=new SimpleDateFormat("dd/MM/yyyy",Locale.getDefault());
			
			strDate2=dft2.format(cal.getTime());
			
			//hiển thị lên giao diện
			textme2.setText(strDate2);

			//Định dạng giờ phút am/pm
			dft1=new SimpleDateFormat("hh:mm a",Locale.getDefault());
			
			strTime2=dft2.format(cal.getTime());

			//đưa lên giao diện		
			dateFinish=cal.getTime();

		}
	    public void showDatePickerDialog()
	    {
	    	 OnDateSetListener callback=new OnDateSetListener() {
	    		 public void onDateSet(DatePicker view, int year,
	    		 int monthOfYear,
	    		 int dayOfMonth) {
	    		cal=Calendar.getInstance();
	    		 dft1=new SimpleDateFormat("dd/MM/yyyy",Locale.getDefault());
	    		 cal.set(Calendar.YEAR,year);
	 			cal.set(Calendar.MONTH, monthOfYear);
	 			cal.set(Calendar.DAY_OF_MONTH, dayOfMonth);
	 			textme1.setText(dft1.format(cal.getTime()));
	 			m=dft1.format(cal.getTime());
	 			 listview2 = (ListView)findViewById(R.id.mylist1);
	 	    	listview3 = (ListView)findViewById(R.id.mylist2);
					 Toast.makeText(MainActivity.this,m, Toast.LENGTH_LONG).show();
					 show3_1(m,m2);
					 show4_1(m,m2);
	    		 }
	    		 };
	    		  s=textme1.getText()+"";
	    			String strArrtmp[]=s.split("/");
	    			int ngay=Integer.parseInt(strArrtmp[0]);
	    			int thang=Integer.parseInt(strArrtmp[1])-1;
	    			int nam=Integer.parseInt(strArrtmp[2]);
	    			DatePickerDialog pic=new DatePickerDialog(
	    					MainActivity.this, 
	    					callback, nam, thang, ngay);
	    			pic.setTitle("Chọn ngày hoàn thành");
	    			pic.show();
	    }
	    public void showDatePickerDialog1()
	    {
	    	 OnDateSetListener callback=new OnDateSetListener() {
	    		 public void onDateSet(DatePicker view, int year,
	    		 int monthOfYear,
	    		 int dayOfMonth) {
	    	textme2.setText(
					(dayOfMonth) + "/" + (monthOfYear + 1) + "/" + year);
	    		 cal.set(year, monthOfYear, dayOfMonth);
	    		 dateFinish=cal.getTime();
					 dft2=new SimpleDateFormat("dd/MM/yyyy",Locale.getDefault());
					 m2=dft2.format(cal.getTime());
					 Toast.makeText(MainActivity.this,m2,Toast.LENGTH_SHORT).show();
					 show3_1(m,m2);
					 show4_1(m,m2);
	    		 }	    		 
	    		 };
	    		  s1=textme2.getText()+"";
	    			String strArrtmp[]=s1.split("/");
	    			int ngay=Integer.parseInt(strArrtmp[0]);
	    			int thang=Integer.parseInt(strArrtmp[1])-1;
	    			int nam=Integer.parseInt(strArrtmp[2]);
	    			DatePickerDialog pic=new DatePickerDialog(
	    					MainActivity.this, 
	    					callback, nam, thang, ngay);
	    			pic.setTitle("Chọn ngày hoàn thành");
	    			pic.show();
	    }
	    @Override
	    public boolean onOptionsItemSelected(MenuItem item) {
	        // Handle action bar item clicks here. The action bar will
	        // automatically handle clicks on the Home/Up button, so long
	        // as you specify a parent activity in AndroidManifest.xml.
	        int id = item.getItemId();
	        if (id == R.id.action_settings) {
	            return true;
	        }
	        return super.onOptionsItemSelected(item);
	    }

}
