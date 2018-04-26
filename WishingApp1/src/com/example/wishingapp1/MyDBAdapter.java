package com.example.wishingapp1;

import android.content.ContentValues;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class MyDBAdapter {
	
		
	private static final String DB_NAME="MY_DATABASE";
	private static final String DB_TABLE="student";
	private static final int DB_VERSION=1;
	
	
	private static final String COL_ID="_id";
	private static final String COL_FIRST_NAME="firstname";
	private static final String COL_LAST_NAME="lastname";
	
	private static final String DB_CREATE="create table student(_id integer primary key autoincrement,firstname text not null,lastname text not null);";
	private SQLiteDatabase database;
	private MyDBHelper helper;
	public MyDBAdapter (Context context)
	{
		helper=new MyDBHelper(context,DB_NAME,null,DB_VERSION);
		
	}
	public MyDBAdapter open()
	{
		database=helper.getWritableDatabase();
		return this;
		
	}
	
	public void close()
	{
		database.close();
		
	}
	
	
	public Cursor getAllEntries()
	{
		return database.query(DB_TABLE, new String[]{COL_ID,COL_FIRST_NAME,COL_LAST_NAME},null,null,null,null,null);
	}
	
	public long  insertEntry(String firstname,String lastname)
	{
		ContentValues contentValues=new ContentValues();
		contentValues.put(COL_FIRST_NAME,firstname);
		contentValues.put(COL_LAST_NAME,lastname);
		return database.insert(DB_TABLE, null, contentValues);
		
		
	}
	
	public boolean removeEntry(long rowIndex)
	{
		return database.delete(DB_TABLE,COL_ID+"="+rowIndex,null)>0;
		
	}
	
	public int updateEntry(long rowIndex,String newfirstname,String newlastname)
	{
		ContentValues updateValues=new ContentValues();
		updateValues.put(COL_FIRST_NAME,newfirstname);
		updateValues.put(COL_LAST_NAME,newlastname);
		return database.update(DB_TABLE, updateValues, COL_ID+"="+rowIndex,null);
		
	}
	
	
	
	private static class MyDBHelper extends SQLiteOpenHelper{
		
		public MyDBHelper(Context context,String name,SQLiteDatabase.CursorFactory factory,int version)
		{
			
			super(context,name,factory,version);
			
			
		}

		@Override
		public void onCreate(SQLiteDatabase db) {
			
			db.execSQL(DB_CREATE);
			// TODO Auto-generated method stub
			
		}

		@Override
		public void onUpgrade(SQLiteDatabase db, int arg1, int arg2) {
			
			Log.w("Updation","databaste version is updated" );
			db.execSQL("DROP TABLE IF EXITS" +DB_TABLE);
			onCreate(db);
			
			// TODO Auto-generated method stub
			
		}
		}
}
	
	
	





