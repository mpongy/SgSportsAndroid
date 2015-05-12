package com.project.sgsports;

import java.util.ArrayList;

import android.database.Cursor;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class getgameslistbyadapter extends MainActivity{

	//*** WE TRIED TO USE AN ADAPTER TO PASS THE DATABASE VALUES BACK TO A LIST VIEW BUT IT DOESNT WORK :(
	
	GameDB database;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.allgameslist);

		database = new GameDB(this);
		populateListView();
	}
	
	public void populateListView(){
		//create list of items
		
		
		// --get all contacts---
		database.open();
		Cursor c = database.getAllGames();
		ArrayList<String[]> games = new ArrayList<String[]>();
		if (c.moveToFirst()) {
			do {
				String[] contact = {c.getString(0),c.getString(1),c.getString(2),c.getString(3),c.getString(4),c.getString(5),c.getString(6),c.getString(7),c.getString(8)};
				games.add(contact);
			} while (c.moveToNext());
		}
		database.close();
				 
		int[] to = new int[]{R.id.game, R.id.date, R.id.timestart, R.id.timeend};
		
		//build adapter
		ArrayAdapter<String[]> adapter = new ArrayAdapter<String[]>(this, R.layout.gameitems, 10, games);
		//configure list view
		ListView list = (ListView) findViewById(R.id.gamelist);
		list.setAdapter(adapter);
		
	}

}
