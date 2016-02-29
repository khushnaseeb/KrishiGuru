package com.example.krishi2;



import java.util.ArrayList;
import java.util.HashMap;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;

import android.os.Bundle;
import android.app.Activity;
import android.app.ListActivity;
import android.content.Intent;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListAdapter;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;
import android.support.v4.app.NavUtils;
public class SingleMenuItemActivity  extends ListActivity {
	
	
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.single_list_item);
        
        // getting intent data
        Intent in = getIntent();
        
        // Get JSON values from previous intent
        String name = in.getStringExtra("name");
        /* // Displaying all values on the screen
        TextView lblName = (TextView) findViewById(R.id.name_label);
        TextView lblCost = (TextView) findViewById(R.id.email_label);
        TextView lblDesc = (TextView) findViewById(R.id.mobile_label);
        
        lblName.setText(name);
        lblCost.setText(cost);
        lblDesc.setText(description);*/
        
        ArrayList<HashMap<String, String>> BankList = new ArrayList<HashMap<String, String>>();
		String response = null;
		
		ArrayList<NameValuePair> postParameters = new ArrayList<NameValuePair>();
    	postParameters.add(new BasicNameValuePair("name", name));
		try {
    		response = CustomHttpClient.executeHttpPost("http://192.168.190.197/getmsp.php", postParameters);
			//response= CustomHttpClient.executeHttpGet("http://203.199.146.117/getbankname.php");	
            response=response.toString();
            response = response.trim();
            //response= response.replaceAll("\\s+"," ");		            	    
            	    
            	    JSONArray obj=(JSONArray) new JSONTokener(response).nextValue();
            	    //String result=obj.getString("Price");
            	    //msp.setText(result);
            	    for(int i = 0; i < obj.length(); i++){
        				JSONObject c = obj.getJSONObject(i);
        				String bankname = c.getString("name");
        				String bankPolicy=c.getString("policies");
        				
        				HashMap<String, String> map = new HashMap<String, String>();
        				map.put("name", name);
        				map.put("policyname",bankPolicy);
        				BankList.add(map);
            	    }
			}
    		catch (Exception e) {
    		Log.e("Exception Occured","An Error has occured fetching data");
    		Toast.makeText(this.getBaseContext(),"Network Activity Failed. Check Connectivity",Toast.LENGTH_SHORT).show();
    	} 	
    	/**
		 * Updating parsed JSON data into ListView
		 * */
		ListAdapter adapter = new SimpleAdapter(this, BankList,
				R.layout.list_item,
				new String[] { "name" }, new int[] {
						R.id.name });

		setListAdapter(adapter);	
    }
}
