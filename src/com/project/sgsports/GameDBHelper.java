package com.project.sgsports;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class GameDBHelper extends SQLiteOpenHelper {
	
	public static final String TABLE_NAME = "games";
	public static final String COLUMN_NAME_ID = "_id";
	public static final String COLUMN_NAME_SPORTNAME = "sportname";
	public static final String COLUMN_NAME_DATE = "date";
	public static final String COLUMN_NAME_TIMESTART = "timestart";
	public static final String COLUMN_NAME_TIMEEND = "timeend";
	public static final String COLUMN_NAME_LOCATION = "location";
	public static final String COLUMN_NAME_MAPLAT = "maplat";
	public static final String COLUMN_NAME_MAPLNG = "maplng";
	public static final String COLUMN_NAME_MINPLAYERS = "minplayers";
	public static final String COLUMN_NAME_MAXPLAYERS = "maxplayers";
	public static final String COLUMN_NAME_CURRENTPLAYERS = "currentplayers";

	
	private static final String SQL_CREATE = 
			"CREATE TABLE " + TABLE_NAME + " (" + 
	         COLUMN_NAME_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
	         COLUMN_NAME_SPORTNAME + " TEXT NOT NULL," +
	         COLUMN_NAME_DATE + " TEXT NOT NULL," +
	         COLUMN_NAME_TIMESTART + " TEXT NOT NULL," +
	         COLUMN_NAME_TIMEEND + " TEXT NOT NULL," +
	         COLUMN_NAME_LOCATION + " TEXT NOT NULL," +
	         COLUMN_NAME_MAPLAT + " TEXT NOT NULL," +
	         COLUMN_NAME_MAPLNG + " TEXT NOT NULL," +
	         COLUMN_NAME_MINPLAYERS + " TEXT NOT NULL," +
	         COLUMN_NAME_MAXPLAYERS + " TEXT NOT NULL," +
	         COLUMN_NAME_CURRENTPLAYERS + " TEXT NOT NULL);";
	
	private static final String SQL_DELETE =
			"DROP TABLE IF EXISTS " + TABLE_NAME;
	
	public static final int DATABASE_VERSION = 1;
	
	public static final String DATABASE_NAME = "userDB";
	
	public GameDBHelper(Context context) {
		super(context, DATABASE_NAME, null, DATABASE_VERSION);
	}
	
	@Override
	public void onCreate(SQLiteDatabase db) {
		db.execSQL(SQL_CREATE);
	}
	
	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// upgrade policy here is simply to discard the data and start all over
		db.execSQL(SQL_DELETE);
		onCreate(db);
	}
}
