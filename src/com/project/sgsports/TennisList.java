package com.project.sgsports;

import java.util.ArrayList;

import android.database.Cursor;
import android.os.Bundle;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TableRow;
import android.widget.TextView;

public class TennisList extends MainActivity {

	GameDB database;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.tennislist);

		database = new GameDB(this);

		ArrayList<String[]> games = GetTennisArray();

		for (int i = 0; i < games.size(); i++) {
			String[] contact = games.get(i);
			insertRow(Integer.parseInt(contact[0]), contact[1], contact[2],
					contact[3], contact[4], contact[5], contact[6], contact[7],
					contact[8], contact[9], contact[10]);

		}
	}

	public ArrayList<String[]> GetTennisArray() {
		// --get soccer contacts---
		database.open();
		Cursor c = database.getAllGames();
		ArrayList<String[]> games = new ArrayList<String[]>();
		if (c.moveToFirst()) {
			do {
				String[] contact = { c.getString(0), c.getString(1),
						c.getString(2), c.getString(3), c.getString(4),
						c.getString(5), c.getString(6), c.getString(7),
						c.getString(8), c.getString(9), c.getString(10) };

				if (contact[1].equals("Tennis")) {
					games.add(contact);
				}
			} while (c.moveToNext());
		}
		database.close();
		return games;
	}

	public void insertRow(long rowId, String name, String date,
			String timestart, String timeend, String location, String maplat,
			String maplng, String minplayers, String maxplayers,
			String currentplayers) {
		// ---insert a new row into the contact information table---
		ViewGroup table = (ViewGroup) findViewById(R.id.table);
		TableRow newRow = new TableRow(table.getContext());
		TextView idText = new TextView(newRow.getContext());
		TextView nameText = new TextView(newRow.getContext());
		TextView dateText = new TextView(newRow.getContext());
		TextView timestartText = new TextView(newRow.getContext());
		TextView timeendText = new TextView(newRow.getContext());
		TextView locationText = new TextView(newRow.getContext());
		TextView maplatText = new TextView(newRow.getContext());
		TextView maplngText = new TextView(newRow.getContext());
		TextView minplayersText = new TextView(newRow.getContext());
		TextView maxplayersText = new TextView(newRow.getContext());
		TextView currentplayersText = new TextView(newRow.getContext());
		newRow.setLayoutParams(new TableRow.LayoutParams(
				TableRow.LayoutParams.MATCH_PARENT,
				TableRow.LayoutParams.WRAP_CONTENT));

		idText.setText(String.valueOf(rowId));
		idText.setLayoutParams(new TableRow.LayoutParams(0,
				LinearLayout.LayoutParams.MATCH_PARENT, 0.01f));
		idText.setGravity(Gravity.CENTER);

		nameText.setText(String.valueOf(name));
		nameText.setLayoutParams(new TableRow.LayoutParams(0,
				LinearLayout.LayoutParams.MATCH_PARENT, 0.01f));
		nameText.setGravity(Gravity.CENTER);

		dateText.setText(String.valueOf(date));
		dateText.setLayoutParams(new TableRow.LayoutParams(0,
				LinearLayout.LayoutParams.MATCH_PARENT, 0.01f));
		dateText.setGravity(Gravity.CENTER);

		timestartText.setText(String.valueOf(timestart));
		timestartText.setLayoutParams(new TableRow.LayoutParams(0,
				LinearLayout.LayoutParams.MATCH_PARENT, 0.01f));
		timestartText.setGravity(Gravity.CENTER);

		timeendText.setText(String.valueOf(timeend));
		timeendText.setLayoutParams(new TableRow.LayoutParams(0,
				LinearLayout.LayoutParams.MATCH_PARENT, 0.01f));
		timeendText.setGravity(Gravity.CENTER);

		locationText.setText(String.valueOf(location));
		timestartText.setLayoutParams(new TableRow.LayoutParams(0,
				LinearLayout.LayoutParams.MATCH_PARENT, 0.01f));
		timestartText.setGravity(Gravity.CENTER);

		minplayersText.setText(String.valueOf(minplayers));
		minplayersText.setLayoutParams(new TableRow.LayoutParams(0,
				LinearLayout.LayoutParams.MATCH_PARENT, 0.01f));
		minplayersText.setGravity(Gravity.CENTER);

		maxplayersText.setText(String.valueOf(maxplayers));
		maxplayersText.setLayoutParams(new TableRow.LayoutParams(0,
				LinearLayout.LayoutParams.MATCH_PARENT, 0.01f));
		maxplayersText.setGravity(Gravity.CENTER);

		currentplayersText.setText(String.valueOf(currentplayers));
		currentplayersText.setLayoutParams(new TableRow.LayoutParams(0,
				LinearLayout.LayoutParams.MATCH_PARENT, 0.01f));
		currentplayersText.setGravity(Gravity.CENTER);

		newRow.addView(idText);
		newRow.addView(nameText);
		newRow.addView(dateText);
		newRow.addView(timestartText);
		newRow.addView(timeendText);
		newRow.addView(locationText);
		newRow.addView(maplatText);
		newRow.addView(maplngText);
		newRow.addView(minplayersText);
		newRow.addView(maxplayersText);
		newRow.addView(currentplayersText);
		table.addView(newRow);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {

		return true;

	}

}
