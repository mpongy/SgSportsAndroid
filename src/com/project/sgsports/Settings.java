package com.project.sgsports;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

//*** WE TRIED TO IMPLEMENT A SETTINGS PAGE BUT HAVE NOT ENOUGH TIME :( ***

public class Settings extends Activity{
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.settings);
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


