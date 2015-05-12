package com.project.sgsports;

import java.util.ArrayList;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MainActivity extends ActionBarActivity {

	int minZoomLevel = 5;
	private GoogleMap myMap;
	private static final LatLng SINGAPORE = new LatLng(1.35, 103.82);
	// private static final LatLng SgNEBound = new LatLng(1.468426, 104.093288);
	// private static final LatLng SgSWBound = new LatLng(1.156085, 103.577617);

	static final LatLng SPORTGAME1 = new LatLng(1.36, 103.82);
	static final LatLng SPORTGAME2 = new LatLng(1.336630, 103.849872);
	static final LatLng SPORTGAME3 = new LatLng(1.352933, 103.787559);
	static final LatLng SPORTGAME4 = new LatLng(1.375481, 103.833264);
	
	long id = 0;

	String markerTitle = "HELLO this is a fake game";
	GameDB database;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		getActionBar().setDisplayHomeAsUpEnabled(false);

		database = new GameDB(this);
		
		
		myMap = ((MapFragment) getFragmentManager().findFragmentById(R.id.map))
				.getMap();
		myMap.moveCamera(CameraUpdateFactory.newLatLngZoom(SINGAPORE, 12));

		myMap.addMarker(new MarkerOptions().position(SPORTGAME1).title(
				"Football: 1-3pm (3 players needed!)"));
		myMap.addMarker(new MarkerOptions().position(SPORTGAME2).title(
				"Volleyball: 5-7pm (2 players needed!)"));
		myMap.addMarker(new MarkerOptions().position(SPORTGAME3).title(
				"Tennis: 4-6pm (1 player needed!)"));
		myMap.addMarker(new MarkerOptions().position(SPORTGAME4).title(
				"Badminton: 9-11am (1 player needed!)"));


//		//***Loads the map with existing database values
//
//		ArrayList<String[]> games = GetGames();
//
//		for (int i = 0; i < games.size(); i++) {
//			String[] contact = games.get(i);
//
//			Double locationx = Double.parseDouble(contact[6]) + 0.01;
//			Double locationy = Double.parseDouble(contact[7]) + 0.01;
//
//			LatLng newLocation = new LatLng(locationx, locationy);
//
//			markerTitle = contact[1];
//
//			myMap.addMarker(new MarkerOptions().position(newLocation).title(
//					markerTitle));
//
//		}
		
		//***initialize some dummy content
//		database.open();
//		
//		if (id < 2) {
//			database.insertGame("Football", "091114", "1000", "1200", "Bishan Stadium",
//					"1.353879", "103.850690", "10", "20", "7");
//			database.insertGame("Basketball", "101114", "1400", "1600", "Choa Chu Kang Stadium",
//					"1.391961", "103.748627", "10", "20", "7");
//			database.insertGame("Badminton", "151114", "1000", "1200", "Serangoon Stadium",
//					"1.356454", "103.875420", "10", "20", "7");
//			database.insertGame("Tennis", "161114", "0900", "1100", "Tampines Stadium",
//					"1.353113", "103.940646", "10", "20", "7");
//			database.insertGame("Volleyball", "121114", "1400", "1600", "Bishan Stadium",
//					"1.353879", "103.850690", "10", "20", "7");
//			database.insertGame("Hockey", "131114", "1900", "2100", "Clementi Stadium",
//					"1.310398", "103.762392", "10", "20", "7");
//			Toast.makeText(this, "Dummy Content loaded.", Toast.LENGTH_LONG).show();
//			
//		}
//			id++;
//
//
//
//		database.close();
		
		

	}

	public ArrayList<String[]> GetGames() {
		// --get all contacts---
		database.open();
		Cursor c = database.getAllGames();
		ArrayList<String[]> games = new ArrayList<String[]>();
		if (c.moveToFirst()) {
			do {
				String[] contact = { c.getString(0), c.getString(1),
						c.getString(2), c.getString(3), c.getString(4),
						c.getString(5), c.getString(6), c.getString(7),
						c.getString(8), c.getString(9), c.getString(10) };
				games.add(contact);
			} while (c.moveToNext());
		}
		database.close();
		return games;
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {

		Intent myActionBarIntent;

		switch (item.getItemId()) {
		case R.id.action_add_game:
			myActionBarIntent = new Intent(this, Add.class);
			startActivity(myActionBarIntent);
			return true;
		case R.id.action_search_game:
			myActionBarIntent = new Intent(this, Search.class);
			startActivity(myActionBarIntent);
			return true;
		case R.id.action_settings:
			myActionBarIntent = new Intent(this, Login.class);
			startActivity(myActionBarIntent);
			return true;
		default:
			return super.onOptionsItemSelected(item);
		}
	}

}
