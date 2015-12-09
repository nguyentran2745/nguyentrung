package com.parse.starter;

import android.app.Dialog;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Tab1 extends ActionBarActivity {
	Button bt1,bt2;
	Dialog dialog;
	EditText edit1,edit2,edit3,edit4;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_tab1);
		
		
		bt1 = (Button)findViewById(R.id.nbt1);
		bt2 = (Button)findViewById(R.id.nbt2);
		
		bt1.setOnClickListener(new Button.OnClickListener(){
			@Override
			public void onClick(View v){
				dialog= new Dialog(Tab1.this);
				dialog.setContentView(R.layout.newdialog);
				dialog.setTitle("WELCOME");
				dialog.show();
				
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.tab1, menu);
		return true;
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
