package com.example.krishi2;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}
	
	public void openAbout(View v)
	 {
	   Intent myIntent = new Intent(this, About.class);
	   startActivity(myIntent);
	 }
	
	public void PlaySound(View v)
	 {
			MediaPlayer mp=MediaPlayer.create(this,R.raw.welcome_screen);
			mp.start();
		
	 }
	public void openWeather(View v)
	 {
	   Intent myIntent = new Intent(this, Weather.class);
	   startActivity(myIntent);
	 }
	public void openFinance(View v)
	 {
	   Intent myIntent = new Intent(this, Finance.class);
	   startActivity(myIntent);
	 }
	public void openJansabha(View v)
	 {
		startActivity(new Intent(Intent.ACTION_VIEW, 
				Uri.parse("http://203.199.146.117/KisaanJanSabha/")));	
	 }
	public void openUtility(View v)
	 {
	   Intent myIntent = new Intent(this, Utility.class);
	   startActivity(myIntent);
	 }
	public void openTech(View v)
	 {
	   Intent myIntent = new Intent(this, AndroidRssReader.class);
	   startActivity(myIntent);
	 }
	public void openOrganic(View v)
	 {
	   Intent myIntent = new Intent(this, Organic.class);
	   startActivity(myIntent);
	 }
	public void openCall(View v)
	 {
		String url = "tel:18001801551";
	    Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse(url));
		startActivity(intent);
	 }
}
