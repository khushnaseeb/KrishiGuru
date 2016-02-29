package com.example.krishi2;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.support.v4.app.NavUtils;

public class Utility extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_utility);
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_utility, menu);
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
	public void openApproved(View v)
	 {
	   Intent myIntent = new Intent(this, ApprovedPest.class);
	   startActivity(myIntent);
	 }
	public void openBanned(View v)
	 {
	   Intent myIntent = new Intent(this, Banned.class);
	   startActivity(myIntent);
	 }
	public void openMix(View v)
	 {
	   Intent myIntent = new Intent(this, Mix.class);
	   startActivity(myIntent);
	 }
	public void dbRec(View v)
	 {
	   Intent myIntent = new Intent(this, DBRec.class);
	   startActivity(myIntent);
	 }
	public void PlaySound(View v)
	 {
			MediaPlayer mp=MediaPlayer.create(this,R.raw.util1);
			mp.start();
		
	 }

}
