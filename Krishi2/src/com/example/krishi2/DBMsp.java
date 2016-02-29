package com.example.krishi2;


import java.util.ArrayList;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import org.json.*;

public class DBMsp extends Activity {
    EditText Crop;
	TextView msp,error;
    Button ok;
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.db_msp);
        Crop=(EditText)findViewById(R.id.et_un);
        msp=(TextView)findViewById(R.id.et_pw);
        ok=(Button)findViewById(R.id.btn_login);
        error=(TextView)findViewById(R.id.tv_error);

        ok.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub

            	ArrayList<NameValuePair> postParameters = new ArrayList<NameValuePair>();
            	postParameters.add(new BasicNameValuePair("produce", Crop.getText().toString()));
            	
            	String response = null;
    			String res;
            	
            	try {
            		response = CustomHttpClient.executeHttpPost("http://203.199.146.117/getmsp.php", postParameters);
						
		            	    res=response.toString();
		            	    res = res.trim();
		            	    //res= res.replaceAll("\\s+","");		
		            	    Log.e("Trimmed Response",res.toString());
		            	    
		            	    JSONObject obj=(JSONObject) new JSONTokener(res).nextValue();
		            	    String result=obj.getString("Price");
		            	    msp.setText(result);
					}
            		catch (Exception e) {
            		error.setText(e.toString());
            	}
            }
        });
    }
   
}


