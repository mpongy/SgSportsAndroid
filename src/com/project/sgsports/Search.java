package com.project.sgsports;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class Search extends Activity {


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.search);

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {

		return true;

	}
	public void viewAll(View view) {
		Intent newIntent;
		newIntent = new Intent(this, AllList.class);
		startActivity(newIntent);
	}
	public void viewFootball(View view) {
		Intent newIntent;
		newIntent = new Intent(this, FootballList.class);
		startActivity(newIntent);
	}
	public void viewBasketball(View view) {
		Intent newIntent;
		newIntent = new Intent(this, BasketballList.class);
		startActivity(newIntent);
	}
	public void viewBadminton(View view) {
		Intent newIntent;
		newIntent = new Intent(this, BadmintonList.class);
		startActivity(newIntent);
	}
	public void viewTennis(View view) {
		Intent newIntent;
		newIntent = new Intent(this, TennisList.class);
		startActivity(newIntent);
	}
	public void viewVolleyball(View view) {
		Intent newIntent;
		newIntent = new Intent(this, VolleyballList.class);
		startActivity(newIntent);
	}
	public void viewHockey(View view) {
		Intent newIntent;
		newIntent = new Intent(this, HockeyList.class);
		startActivity(newIntent);
	}
	
}
