package com.example.wishingapp1;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class FormActivity extends Activity implements OnClickListener

{
	public Button btsubmit;
	public EditText edfName,edlName;
	public ListView studentListview;
	public ListAdapter listAdapter;
	public List<String> myList;
	
	public MyDBAdapter dbAdapter;
	public  DatePicker datePicker;
	   private Calendar calendar;
	   private TextView dateView;
	   private int year, month, day;
	
	public FormActivity (){
		myList=new ArrayList<String>();
		dbAdapter=new MyDBAdapter(this);
	    }

	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_form);
		
		 studentListview =(ListView)findViewById(R.id.listView1);
	        edfName=(EditText)findViewById(R.id.editText1);
	        edlName=(EditText)findViewById(R.id.editText2);
	        btsubmit=(Button)findViewById(R.id.btnsubmit);
	        btsubmit.setOnClickListener(this);
	      
	        
	        dateView = (TextView) findViewById(R.id.tvdate);
	        calendar = Calendar.getInstance();
	        year = calendar.get(Calendar.YEAR);
	        
	        month = calendar.get(Calendar.MONTH);
	        day = calendar.get(Calendar.DAY_OF_MONTH);
	        showDate(year, month+1, day);
	       
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
	
	
public void onClick(View v1) {
		
		if(btsubmit==v1)
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


@SuppressWarnings("deprecation")
public void setDate(View view) {
   showDialog(999);
   Toast.makeText(getApplicationContext(), "ca", 
      Toast.LENGTH_SHORT)
   .show();
}

@Override
protected Dialog onCreateDialog(int id) {
   // TODO Auto-generated method stub
   if (id == 999) {
      return new DatePickerDialog(this, 
         myDateListener, year, month, day);
   }
   return null;
}

private DatePickerDialog.OnDateSetListener myDateListener = new 
   DatePickerDialog.OnDateSetListener() {
   @Override
   public void onDateSet(DatePicker arg0, 
      int arg1, int arg2, int arg3) {
      // TODO Auto-generated method stub
      // arg1 = year
      // arg2 = month
      // arg3 = day
      showDate(arg1, arg2+1, arg3);
   }
};

private void showDate(int year, int month, int day) {
   dateView.setText(new StringBuilder().append(day).append("/")
   .append(month).append("/").append(year));
}




}