package com.example.krishi2;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.support.v4.app.NavUtils;

public class Finance extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_finance);
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_finance, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case android.R.id.home:
			// This ID represents the Home or Up button. In the case of this
			// activity, the Up button is shown. Use NavUtils to allow users
			// to navigate up one level in the application structure. For
			// more details, see the Navigation pattern on Android Design:
			//
			// http://developer.android.com/design/patterns/navigation.html#up-vs-back
			//
			NavUtils.navigateUpFromSameTask(this);
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
	public void dbBank(View v)
	 {
	   Intent myIntent = new Intent(this, DBBank.class);
	   startActivity(myIntent);
	 }
	public void dbMsp(View v)
	 {
	   Intent myIntent = new Intent(this, DBMsp.class);
	   startActivity(myIntent);
	 }
	public void dbRetail(View v)
	 {
	   Intent myIntent = new Intent(this, DBRetail.class);
	   startActivity(myIntent);
	 }
	public void dbNgo(View v)
	 {
	   Intent myIntent = new Intent(this, DBNgo.class);
	   startActivity(myIntent);
	 }
	public void dbGov(View v)
	 {
	   Intent myIntent = new Intent(this, DBGov.class);
	   startActivity(myIntent);
	 }

}
