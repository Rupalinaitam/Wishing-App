package com.example.wishingapp1;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MenuDemoActivity extends Activity {

	Button btnadd,btnshow;
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_menu_demo);
		
		btnadd=(Button)findViewById(R.id.btnadd1);
		//btnshow=(Button)findViewById(R.id.btnshow);
		
	
		btnadd.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent intent= new Intent(MenuDemoActivity.this,FormActivity.class);
				startActivity(intent);
				
			}
		});
		
      /* btnshow.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent intent= new Intent(MenuDemoActivity.this,MainActivity.class);
				startActivity(intent);
				
			}
		});*/
		
		
		
	}

	

}
