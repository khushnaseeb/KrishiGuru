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

public class Ngodetail  extends Activity {
	TextView name_label,address_label,web_label,phone_label,mobile_label,email_label;
	
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.db_ngo);
        name_label=(TextView)findViewById(R.id.name_label);
       address_label=(TextView)findViewById(R.id.address_label);
        web_label=(TextView)findViewById(R.id.web_label);
        phone_label=(TextView)findViewById(R.id.phno_label);
        mobile_label=(TextView)findViewById(R.id.mobile_label);
        email_label=(TextView)findViewById(R.id.email_label);
        
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
			
			response = CustomHttpClient.executeHttpPost("http://203.199.146.117/getnewngo.php", postParameters);
			
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
       				String address= obj.getString("address");
       				String web= obj.getString("web");
       				String phone= obj.getString("phone");
       				String mobile= obj.getString("mobile");
       				String email= obj.getString("email");
       				
       				//String phone= obj.getString("phone").toUpperCase();
       				//String email= obj.getString("email").toUpperCase();
       				//String web= obj.getString("web");
       				
       			 
       			Log.e("Position6","Reached point 6");
       			TextView lblname=(TextView) findViewById(R.id.name_label);
       	       TextView lbladdress = (TextView) findViewById(R.id.address_label);
       	        TextView lblweb = (TextView) findViewById(R.id.web_label);
       	     TextView lblphone = (TextView) findViewById(R.id.phno_label);
       	  TextView lblmobile = (TextView) findViewById(R.id.mobile_label);
       	TextView lblemail = (TextView) findViewById(R.id.email_label);
       	     
 	        
       	        lblname.setText(name);
       	        Log.e("label web","set web");
       	        lbladdress.setText(address);
       	        lblweb.setText(web);
       	        Log.e("label pol","set policy");
       	        lblphone.setText(phone);
       	        lblmobile.setText(mobile);
       	        lblemail.setText(email);
       	    
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
