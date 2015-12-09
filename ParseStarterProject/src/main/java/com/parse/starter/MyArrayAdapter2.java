package com.parse.starter;

import java.util.List;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

public class MyArrayAdapter2 extends ArrayAdapter<PhanLoai>{

	public MyArrayAdapter2(Activity context,List<PhanLoai> list2) {
		super(context,R.layout.dialogcustomt3, list2);
		// TODO Auto-generated constructor stub
	}
	@SuppressLint({ "ViewHolder", "InflateParams" }) @Override
	public View getView(int position,View convertView,ViewGroup parent){
		Activity context = (Activity)getContext();
		LayoutInflater inflater = context.getLayoutInflater();
		View row = inflater.inflate(R.layout.dialogcustomt3, null,true);
		
		TextView text1 = (TextView)row.findViewById(R.id.ntextView1);
		TextView text2 = (TextView)row.findViewById(R.id.ntextView2);
		
		PhanLoai phan = getItem(position);
		text1.setText(phan.Maloai);
		text2.setText(phan.Tenloai);
		return row;
		
	}

}
