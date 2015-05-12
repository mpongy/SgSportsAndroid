package com.project.sgsports;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

public class UserDB {
    final Context context;
    UserDBHelper DBHelper;
    SQLiteDatabase db;
   
	public UserDB(Context ctx) {
		this.context = ctx;
		DBHelper = new UserDBHelper(this.context);
	}
	
	// opens the database
	public UserDB open() throws SQLException {
		db = DBHelper.getWritableDatabase();
		return this;
	}
	
	// closes the database
	public void close() {
		DBHelper.close();
	}
	
	//insert a contact into the database 
	public long insertUser(String username, String password) {
	   
		ContentValues initialValues = new ContentValues();
		       
		initialValues.put(UserDBHelper.COLUMN_NAME_USERNAME, username);
		   
		initialValues.put(UserDBHelper.COLUMN_NAME_PASSWORD, password);
		
		return db.insert(UserDBHelper.TABLE_NAME, null, 
		initialValues);
	}
	
	//  retrieves all the contacts (*** NOT SURE WHETHER ENOUGH NULLS AT THE END)
	   
	public Cursor getAllUsers() {    
	return db.query(UserDBHelper.TABLE_NAME, new String[] {
			UserDBHelper.COLUMN_NAME_ID,
			UserDBHelper.COLUMN_NAME_USERNAME,
			UserDBHelper.COLUMN_NAME_PASSWORD, }, 
	null, null, null, null, null);
	}
	   
	// retrieves a particular contact  (*** NOT SURE WHETHER ENOUGH NULLS AT THE END)
	public Cursor getUser(long rowId) throws SQLException {
	    Cursor mCursor = 
	    db.query(true, UserDBHelper.TABLE_NAME,
		new String[] { 
				UserDBHelper.COLUMN_NAME_ID,
				UserDBHelper.COLUMN_NAME_USERNAME,
				UserDBHelper.COLUMN_NAME_PASSWORD, },
		    		UserDBHelper.COLUMN_NAME_ID + "=" + rowId, 
		null, null, null, null, null);
		   
		    if (mCursor != null) {
		    mCursor.moveToFirst();
		}
		    return mCursor;
	}
	
	// delete a particular contact 
	public boolean deleteUser(long rowId) {
	    return db.delete(UserDBHelper.TABLE_NAME, 
	    		UserDBHelper.COLUMN_NAME_ID + "=" + rowId, null) > 0;
	}
	
	// update a contact 
	public boolean updateUser(long rowId, String sportname, String timestart, String timeend, String maplocation) {
	    ContentValues initialValues = new ContentValues();
	        
		initialValues.put(UserDBHelper.COLUMN_NAME_USERNAME, sportname);
		   
		initialValues.put(UserDBHelper.COLUMN_NAME_USERNAME, timestart);
		
		return db.update(UserDBHelper.TABLE_NAME,   
		initialValues,
		UserDBHelper.COLUMN_NAME_ID + "=" + 
		rowId, null) > 0;   
	}
}        // closing brace of public class contactDB