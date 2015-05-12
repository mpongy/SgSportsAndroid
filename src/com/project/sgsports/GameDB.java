package com.project.sgsports;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

public class GameDB {
    final Context context;
    GameDBHelper DBHelper;
    SQLiteDatabase db;
   
	public GameDB(Context ctx) {
		this.context = ctx;
		DBHelper = new GameDBHelper(this.context);
	}
	
	// opens the database
	public GameDB open() throws SQLException {
		db = DBHelper.getWritableDatabase();
		return this;
	}
	
	// closes the database
	public void close() {
		DBHelper.close();
	}
	
	//insert a game into the database 
	public long insertGame(String sportname, String date, String timestart, String timeend, String location, String mapLat, String mapLng, String minplayers, String maxplayers, String currentplayers) {
	   
		ContentValues initialValues = new ContentValues();
		       
		initialValues.put(GameDBHelper.COLUMN_NAME_SPORTNAME, sportname);
		 
		initialValues.put(GameDBHelper.COLUMN_NAME_DATE, date);
		
		initialValues.put(GameDBHelper.COLUMN_NAME_TIMESTART, timestart);
		
		initialValues.put(GameDBHelper.COLUMN_NAME_TIMEEND, timeend);
		
		initialValues.put(GameDBHelper.COLUMN_NAME_LOCATION, location);
		
		initialValues.put(GameDBHelper.COLUMN_NAME_MAPLAT, mapLat);
		
		initialValues.put(GameDBHelper.COLUMN_NAME_MAPLNG, mapLng);
		
		initialValues.put(GameDBHelper.COLUMN_NAME_MINPLAYERS, minplayers);
		
		initialValues.put(GameDBHelper.COLUMN_NAME_MAXPLAYERS, maxplayers);
		
		initialValues.put(GameDBHelper.COLUMN_NAME_CURRENTPLAYERS, currentplayers);
		   
		return db.insert(GameDBHelper.TABLE_NAME, null, 
		initialValues);
	}
	
	//  retrieves all the games 
	   
	public Cursor getAllGames() {    
	return db.query(GameDBHelper.TABLE_NAME, new String[] {
			GameDBHelper.COLUMN_NAME_ID,
			GameDBHelper.COLUMN_NAME_SPORTNAME,
			GameDBHelper.COLUMN_NAME_DATE,
			GameDBHelper.COLUMN_NAME_TIMESTART,
			GameDBHelper.COLUMN_NAME_TIMEEND,
			GameDBHelper.COLUMN_NAME_LOCATION,
			GameDBHelper.COLUMN_NAME_MAPLAT, 
			GameDBHelper.COLUMN_NAME_MAPLNG,
			GameDBHelper.COLUMN_NAME_MINPLAYERS,
			GameDBHelper.COLUMN_NAME_MAXPLAYERS,
			GameDBHelper.COLUMN_NAME_CURRENTPLAYERS }, 
	null, null, null, null, null);
	}
	   
	// retrieves a particular game
	public Cursor getGame(long rowId) throws SQLException {
	    Cursor mCursor = 
	    db.query(true, GameDBHelper.TABLE_NAME,
		new String[] { 
					GameDBHelper.COLUMN_NAME_ID,
					GameDBHelper.COLUMN_NAME_SPORTNAME,
					GameDBHelper.COLUMN_NAME_DATE,
					GameDBHelper.COLUMN_NAME_TIMESTART,
					GameDBHelper.COLUMN_NAME_TIMEEND,
					GameDBHelper.COLUMN_NAME_LOCATION,
					GameDBHelper.COLUMN_NAME_MAPLAT,
					GameDBHelper.COLUMN_NAME_MAPLNG,
					GameDBHelper.COLUMN_NAME_MINPLAYERS,
					GameDBHelper.COLUMN_NAME_MAXPLAYERS,
					GameDBHelper.COLUMN_NAME_CURRENTPLAYERS },
		    		GameDBHelper.COLUMN_NAME_ID + "=" + rowId, 
		null, null, null, null, null);
		   
		    if (mCursor != null) {
		    mCursor.moveToFirst();
		}
		    return mCursor;
	}
	
	// delete a particular game 
	public boolean deleteGame(long rowId) {
	    return db.delete(GameDBHelper.TABLE_NAME, 
	    		GameDBHelper.COLUMN_NAME_ID + "=" + rowId, null) > 0;
	}
	
	// update a game 
	public boolean updateGame(long rowId, String sportname, String date, String timestart, String timeend, String location, String mapLat, String mapLng, String minplayers, String maxplayers, String currentplayers) {
	    ContentValues initialValues = new ContentValues();
	        
		initialValues.put(GameDBHelper.COLUMN_NAME_SPORTNAME, sportname);
		
		initialValues.put(GameDBHelper.COLUMN_NAME_DATE, date);
		   
		initialValues.put(GameDBHelper.COLUMN_NAME_TIMESTART, timestart);
		
		initialValues.put(GameDBHelper.COLUMN_NAME_TIMEEND, timeend);
		
		initialValues.put(GameDBHelper.COLUMN_NAME_LOCATION, location);
		
		initialValues.put(GameDBHelper.COLUMN_NAME_MAPLAT, mapLat);
		
		initialValues.put(GameDBHelper.COLUMN_NAME_MAPLNG, mapLng);
		
		initialValues.put(GameDBHelper.COLUMN_NAME_MINPLAYERS, minplayers);
		
		initialValues.put(GameDBHelper.COLUMN_NAME_MAXPLAYERS, maxplayers);
		
		initialValues.put(GameDBHelper.COLUMN_NAME_CURRENTPLAYERS, currentplayers);
		
		return db.update(GameDBHelper.TABLE_NAME,   
		initialValues,
		GameDBHelper.COLUMN_NAME_ID + "=" + 
		rowId, null) > 0;   
	}
}        // closing brace of public class gameDB