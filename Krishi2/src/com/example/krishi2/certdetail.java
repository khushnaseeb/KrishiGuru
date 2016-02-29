package com.example.krishi2;

import java.util.ArrayList;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONObject;
import org.json.JSONTokener;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class certdetail  extends Activity {
	TextView name_label,email_label,mobile_label;
	
	// JSON node keys
/*	private static final String TAG_NAME = "name";
	private static final String TAG_ADDRESS = "address";
	private static final String TAG_CONPERSON = "con_person";
	private static final String TAG_PHONE="phone";
	private static final String TAG_FAX="fax";
	private static final String TAG_EMAIL = "email";
*/	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.single_list_item);
        name_label=(TextView)findViewById(R.id.name_label);
        email_label=(TextView)findViewById(R.id.email_label);
        mobile_label=(TextView)findViewById(R.id.mobile_label);
        
        // getting intent data
        Intent in = getIntent();
        
        // Get JSON values from previous intent
       String vari = in.getStringExtra("TAG_VARI");
       Log.e("Current","value of vari in Single Activity is:"+vari);
       
       ArrayList<NameValuePair> postParameters = new ArrayList<NameValuePair>();
   		postParameters.add(new BasicNameValuePair("name", vari));
   	
		String response = null;
		String res;
		try {
			
			response = CustomHttpClient.executeHttpPost("http://203.199.146.117/getnewcert.php", postParameters);
			
			Log.e("Reponse","Not Null");
			Log.e("Response Value",response.toString());
			Log.e("Position","Reached point 1");	
           
			res=response.toString();
           Log.e("Position2","Reached point 2");	
          
           res = res.trim();
           Log.e("Position3","Reached point 3");	
           
           //response= response.replaceAll("\\s+","");		            	    
           Log.e("Trimmed Response",res.toString());	    
           
           JSONObject obj=(JSONObject) new JSONTokener(res).nextValue();
           Log.e("Position4","Reached point 4");	
           	  
           // JSONArray c=(JSONArray) new JSONTokener(response).nextValue();
           	    //String result=obj.getString("Price");
           	    //msp.setText(result);
           	   // JSONObject obj=c.getJSONObject(0);
       				//String name = obj.getString("name").toUpperCase();
                    String name=obj.getString("name");
       				String conperson = obj.getString("con_person");
       				Log.e("Position5","Reached point 5");	
       				String address= obj.getString("address").toUpperCase();
       				//String conperson= obj.getString("con_person").toUpperCase();
       				String phone= obj.getString("phone").toUpperCase();
       				String email= obj.getString("email").toUpperCase();
       				String fax= obj.getString("fax").toUpperCase();
       				
       			 
       			Log.e("Position6","Reached point 6");
       			TextView lblname=(TextView) findViewById(R.id.name_label);
       	       TextView lblmail = (TextView) findViewById(R.id.email_label);
       	        TextView lblphone = (TextView) findViewById(R.id.mobile_label);
       	     TextView lblconperson = (TextView) findViewById(R.id.conperson_label);
       	  TextView lblfax = (TextView) findViewById(R.id.fax_label);
 	        
       	        lblname.setText(name);
       	        lblmail.setText(email);
       	     lblphone.setText(phone);
       	     lblconperson.setText(conperson);
       	     lblfax.setText(fax);
       				//HashMap<String, String> map = new HashMap<String, String>();
       				//map.put("name", name);
       				//CertList.add(map);
           	    
			}
   		catch (Exception e) {
   		Log.e("Exception Occured","An Error has occured fetching data in Child Activity");
   	} 	
       
        // Displaying all values on the screen
      
    }
}
