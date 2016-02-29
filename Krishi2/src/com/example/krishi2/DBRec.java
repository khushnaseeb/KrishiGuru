package com.example.krishi2;

import java.util.ArrayList;
import java.util.HashMap;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.AdapterView.OnItemClickListener;

public class DBRec extends ListActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_list);
		// Show the Up button in the action bar.
		//getActionBar().setDisplayHomeAsUpEnabled(true);
		ArrayList<HashMap<String, String>> RecList = new ArrayList<HashMap<String, String>>();
		String response = null;
		try {
    		//response = CustomHttpClient.executeHttpPost("http://192.168.190.197/getmsp.php", postParameters);
			response= CustomHttpClient.executeHttpGet("http://203.199.146.117/getrec.php");	
            response=response.toString();
            response = response.trim();
            response= response.replaceAll("\\s+","");		            	    
            	    
            	    JSONArray obj=(JSONArray) new JSONTokener(response).nextValue();
            	    //String result=obj.getString("Price");
            	    //msp.setText(result);
            	    for(int i = 0; i < obj.length(); i++){
        				JSONObject c = obj.getJSONObject(i);
        				String name = c.getString("name").toUpperCase();
        				
        				HashMap<String, String> map = new HashMap<String, String>();
        				map.put("name", name);
        				RecList.add(map);
            	    }
			}
    		catch (Exception e) {
    		Log.e("Exception Occured","An Error has occured fetching data");
    	} 	
    	/**
		 * Updating parsed JSON data into ListView
		 * */
		 final ListAdapter adapter = new SimpleAdapter(this, RecList,
				R.layout.list_item,
				new String[] { "name" }, new int[] {
						R.id.name });

		setListAdapter(adapter);
		ListView lv = getListView();

		// Launching new screen on Selecting Single ListItem
		lv.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				
				
				String vari= adapter.getItem(position).toString();
				//vari=vari.substring(5);
				vari=vari.substring(6, vari.length()-1);
				
				// getting values from selected ListItem
				//String name = ((TextView) view.findViewById(R.id.name)).getText().toString();
			//	String cost = ((TextView) view.findViewById(R.id.email)).getText().toString();
				//String description = ((TextView) view.findViewById(R.id.mobile)).getText().toString();
				
				// Starting new intent
				Intent in = new Intent(getApplicationContext(), Prodetail.class);
				in.putExtra("TAG_VARI",vari);
				Log.e("Current","Current value is:"+vari.toString());
				//in.putExtra(TAG_EMAIL, cost);
				//in.putExtra(TAG_PHONE_MOBILE, description);
				startActivity(in);
				

			}
		});
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

}
