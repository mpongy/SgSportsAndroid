package com.project.sgsports;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class UserDBHelper extends SQLiteOpenHelper {
	public static final String TABLE_NAME = "users";
	public static final String COLUMN_NAME_ID = "_id";
	public static final String COLUMN_NAME_USERNAME = "username";
	public static final String COLUMN_NAME_PASSWORD = "password";
	private static final String SQL_CREATE = 
			"CREATE TABLE " + TABLE_NAME + " (" + 
	         COLUMN_NAME_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
	         COLUMN_NAME_USERNAME + " TEXT NOT NULL," +
	         COLUMN_NAME_PASSWORD + " TEXT NOT NULL);";
	
	private static final String SQL_DELETE =
			"DROP TABLE IF EXISTS " + TABLE_NAME;
	
	public static final int DATABASE_VERSION = 1;
	
	public static final String DATABASE_NAME = "userDB";
	
	public UserDBHelper(Context context) {
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
