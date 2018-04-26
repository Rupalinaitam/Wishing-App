package com.example.wishingapp1;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class HomeActivity extends Activity {

	Button btnm;
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_home);
		
		btnm=(Button)findViewById(R.id.btnmenu);
		btnm.setOnClickListener(new OnClickListener() {
			
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				
				Intent intent=new Intent(HomeActivity.this,MenuDemoActivity.class);
				startActivity(intent);
			}
		});
		
		
	}

}
