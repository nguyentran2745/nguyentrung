package com.parse.starter;

import java.util.List;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

public class MyArrayAdapter extends ArrayAdapter<GiaoDich> {
public MyArrayAdapter (Activity context,List<GiaoDich> item){
	super(context,R.layout.dialogdateon1,item);
} 
	@SuppressLint({ "InflateParams", "ViewHolder" }) @Override
	public View getView(int position,View convertView,ViewGroup parent){
		Activity context = (Activity)getContext();
		LayoutInflater flater = context.getLayoutInflater();
		View row = flater.inflate(R.layout.dialogdateon1, null,true);
		
		TextView text1 = (TextView)row.findViewById(R.id.textView6);
		TextView text2 = (TextView)row.findViewById(R.id.textView2);
		TextView text3 = (TextView)row.findViewById(R.id.textView12);
		TextView text4 = (TextView)row.findViewById(R.id.textView14);
		TextView text5 = (TextView)row.findViewById(R.id.textView8);
		TextView text6 = (TextView)row.findViewById(R.id.textView10);
		
		GiaoDich item = getItem(position);
		
		text1.setText(item.MaGD);
		text2.setText(item.Date);
		text3.setText(String.valueOf(item.money));
		text4.setText(String.valueOf(item.LoaiGD));
		text5.setText(item.MaKhoan);
		text6.setText(item.Chitiet);
		
		return row;
		
	}
}
