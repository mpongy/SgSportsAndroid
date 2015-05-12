package com.project.sgsports;

import java.util.ArrayList;
import java.util.Calendar;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

public class Add extends MainActivity implements OnItemSelectedListener,
		DatePickerDialog.OnDateSetListener {

	private Spinner spinnerGame;
	private Spinner spinnerLocation;
	public String gameType;
	public String location;
	GameDB database;
	Calendar myCalendar = Calendar.getInstance();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.add);

		// ***SPINNER FOR GAME TYPE
		spinnerGame = (Spinner) findViewById(R.id.spinner_GameType);
		// Create an ArrayAdapter using the string array and a default spinner
		// layout
		ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
				this, R.array.game_array, android.R.layout.simple_spinner_item);
		// Specify the layout to use when the list of choices appears
		adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		// Apply the adapter to the spinner
		spinnerGame.setAdapter(adapter);
		spinnerGame.setOnItemSelectedListener(this);

		// ***SPINNER FOR GAME LOCATION
		spinnerLocation = (Spinner) findViewById(R.id.spinner_Location);
		// Create an ArrayAdapter using the string array and a default spinner
		// layout
		ArrayAdapter<CharSequence> locationadapter = ArrayAdapter
				.createFromResource(this, R.array.location_array,
						android.R.layout.simple_spinner_item);
		// Specify the layout to use when the list of choices appears
		locationadapter
				.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		// Apply the adapter to the spinner
		spinnerLocation.setAdapter(locationadapter);
		spinnerLocation.setOnItemSelectedListener(this);

		database = new GameDB(this);

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {

		return true;

	}

	// *SPINNER*//
	public void onItemSelected(AdapterView<?> parent, View view, int pos,
			long id) {

		Spinner spinner = (Spinner) parent;
		if (spinner.getId() == R.id.spinner_GameType) {
			gameType = spinnerGame.getSelectedItem().toString();
		} else if (spinner.getId() == R.id.spinner_Location) {
			location = spinnerLocation.getSelectedItem().toString();
		}
	}

	public void onNothingSelected(AdapterView<?> parent) {
		// Another interface callback
	}

	// *TIME PICKER*//
	public void showTimePickerDialog(View v) {
		DialogFragment newFragment = new TimePickerFragment();
		newFragment.show(getSupportFragmentManager(), "timePicker");
	}

	public void onTimeSet(TimePicker view, int hourOfDay, int minute) {

		// STILL DOESNT WORK
	}

	// *DATE PICKER*//
	public void showDatePickerDialog(View v) {
		DialogFragment newFragment = new DatePickerFragment();
		newFragment.show(getSupportFragmentManager(), "datePicker");
	}

	public void onDateSet(DatePicker view, int year, int month, int day) {
		// Do something with the time chosen by the user
		// STILL DOESNT WORK
	}




	// *DATABASE*//

	public void AddGameToDatabase(View view) {

		String game = gameType;
		String date = "091114";
		String timestart = "1000";
		String timeend = "1200";
		String mapLat = "4";
		String mapLng = "5";
		String minplayers = "2";
		String maxplayers = "10";
		String currentplayers = "5";
		long id;

		EditText editDate = (EditText) findViewById(R.id.inputDate);
		EditText editTimeStart = (EditText) findViewById(R.id.inputTimeStart);
		EditText editTimeEnd = (EditText) findViewById(R.id.inputTimeEnd);
		EditText editMinPlayers = (EditText) findViewById(R.id.inputMinPlayers);
		EditText editMaxPlayers = (EditText) findViewById(R.id.inputMaxPlayers);
		EditText editCurrentPlayers = (EditText) findViewById(R.id.inputCurrentPlayers);

		date = editDate.getText().toString();
		timestart = editTimeStart.getText().toString();
		timeend = editTimeEnd.getText().toString();
		minplayers = editMinPlayers.getText().toString();
		maxplayers = editMaxPlayers.getText().toString();
		currentplayers = editCurrentPlayers.getText().toString();

		if (location.equals("Bishan Stadium")) {
			Double lat = 1.353879;
			Double lng = 103.850690;
			mapLat = String.valueOf(lat);
			mapLng = String.valueOf(lng);
		} else if (location.equals("Choa Chu Kang Stadium")) {
			Double lat = 1.391961;
			Double lng = 103.748627;
			mapLat = String.valueOf(lat);
			mapLng = String.valueOf(lng);
		} else if (location.equals("Clementi Stadium")) {
			Double lat = 1.310398;
			Double lng = 103.762392;
			mapLat = String.valueOf(lat);
			mapLng = String.valueOf(lng);
		} else if (location.equals("National Stadium")) {
			Double lat = 1.304000;
			Double lng = 103.874116;
			mapLat = String.valueOf(lat);
			mapLng = String.valueOf(lng);
		} else if (location.equals("Serangoon Stadium")) {
			Double lat = 1.356454;
			Double lng = 103.875420;
			mapLat = String.valueOf(lat);
			mapLng = String.valueOf(lng);
		} else if (location.equals("Tampines Stadium")) {
			Double lat = 1.353113;
			Double lng = 103.940646;
			mapLat = String.valueOf(lat);
			mapLng = String.valueOf(lng);
		} else if (location.equals("Yio Chu Kang Stadium")) {
			Double lat = 1.382550;
			Double lng = 103.846765;
			mapLat = String.valueOf(lat);
			mapLng = String.valueOf(lng);
		} else if (location.equals("Yishun Stadium")) {
			Double lat = 1.412853;
			Double lng = 103.832043;
			mapLat = String.valueOf(lat);
			mapLng = String.valueOf(lng);
		}
		database.open();
		id = database.insertGame(game, date, timestart, timeend, location,
				mapLat, mapLng, minplayers, maxplayers, currentplayers);

		if (id > 0) {
			Toast.makeText(this, "Add successful.", Toast.LENGTH_LONG).show();
		}
		database.close();
	}

}
