package com.example.wishingapp1;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class AddEventActivity extends Activity {

	private ListAdapter listAdapter;
   	private List<String> myList;
 	private ListView studentListview;
	private MyDBAdapter dbAdapter;
	private EditText edfName,edlName;
	Button btnshow;
   	
	
	
	
	public AddEventActivity()
	{
   		myList=new ArrayList<String>();
   		dbAdapter=new MyDBAdapter(this);
   	}
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_add_event);
		
		studentListview =(ListView)findViewById(R.id.listView1);
		populateData();
		
	}
	
	
	private void populateData()
    {
    	myList.clear();
    	dbAdapter.open();
    	Cursor cur=dbAdapter.getAllEntries();
    	cur.moveToFirst();
    	for(int i=0;i<cur.getCount();i++)
    	{
    		myList.add(""+cur.getInt(0)+":"+cur.getString(1)+":"+cur.getString(2));
    		cur.moveToNext();
    }
    dbAdapter.close();
    listAdapter=new ArrayAdapter<String>(this,android.R.layout.simple_expandable_list_item_1,myList);
    studentListview.setAdapter(listAdapter);
     }
	
public void onClick(View v) {
   		
   		if(btnshow==v)
   		{
   			String fName=edfName.getText().toString();
   			String lName=edlName.getText().toString();
   			
   			MyDBAdapter adapter=new MyDBAdapter(this);
   			adapter.open();
   			adapter.insertEntry(fName, lName);
   			adapter.close();
   			Toast.makeText(this,"Record inserted successfully",Toast.LENGTH_LONG).show();
   			populateData();
   			
   		}
   		
   	}
	
	

	
}
