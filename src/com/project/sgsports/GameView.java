package com.project.sgsports;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class GameView extends MainActivity{
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.gameview);
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
