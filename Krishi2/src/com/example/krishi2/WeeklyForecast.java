package com.example.krishi2;

import android.net.Uri;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Spinner;
import android.support.v4.app.NavUtils;

public class WeeklyForecast extends Activity {
	private Spinner spinner1;
	private Button btnSubmit;
	private String vari;
	private int pos;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_weekly_forecast);
		addListenerOnButton();
	}
	
	public void addListenerOnButton() {

		spinner1 = (Spinner) findViewById(R.id.spinner1);
		//spinner2 = (Spinner) findViewById(R.id.spinner2);
		
		btnSubmit = (Button) findViewById(R.id.btnSubmit);

		btnSubmit.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {

				pos=spinner1.getSelectedItemPosition();
				switch(pos)
				{
				case 0: vari="http://www.imdagrimet.gov.in/sites/default/files/rainfall_map/APsearf_S_V.jpg";
				break;
				case 1:vari="http://www.imdagrimet.gov.in/sites/default/files/rainfall_map/Arunsearf_SD..jpg";
				break;
				case 2:vari="http://www.imdagrimet.gov.in/sites/default/files/rainfall_map/Asmsearf-SD.jpg";
		        break;
				case 3:vari="http://www.imdagrimet.gov.in/sites/default/files/rainfall_map/Bihsearf_S_V.jpg";
		        break;
				case 4:vari="http://www.imdagrimet.gov.in/sites/default/files/rainfall_map/Chasearf-SD.jpg";
				break;
				case 5:vari="http://www.imdagrimet.gov.in/sites/default/files/rainfall_map/NDsearf-SD_0.jpg";
				break;
				case 6:vari="http://www.imdagrimet.gov.in/sites/default/files/rainfall_map/Gujsearf-SD.jpg";
				break;
				case 7:vari="http://www.imdagrimet.gov.in/sites/default/files/rainfall_map/Harsearf-SD_0.jpg";
				break;
				case 8:vari="http://www.imdagrimet.gov.in/sites/default/files/rainfall_map/himsearf-SD_0.jpg";
				break;
				case 9:vari="http://www.imdagrimet.gov.in/sites/default/files/rainfall_map/JKsearf_S_V.jpg";
				break;
				case 10:vari="http://www.imdagrimet.gov.in/sites/default/files/rainfall_map/Jhasearf_S_V.jpg";
				break;
				case 11:vari="http://www.imdagrimet.gov.in/sites/default/files/rainfall_map/Karsearf_S_V.jpg";
				break;
				case 12:vari="http://www.imdagrimet.gov.in/sites/default/files/rainfall_map/Kersearf_S_V.jpg";
				break;
				case 13:vari="http://www.imdagrimet.gov.in/sites/default/files/rainfall_map/mpsearf_SV_0.jpg";
				break;
				case 14:vari="http://www.imdagrimet.gov.in/sites/default/files/rainfall_map/Mahsea_13.2.13_S_V.jpg";
				break;
				case 15:vari="http://www.imdagrimet.gov.in/sites/default/files/rainfall_map/Manipursearf-SD.jpg";
				break;
				case 16:vari="http://www.imdagrimet.gov.in/sites/default/files/rainfall_map/Meghalayasearf-SD.jpg";
				break;
				case 17:vari="http://www.imdagrimet.gov.in/sites/default/files/rainfall_map/Mizoramsearf_SD..jpg";
				break;
				case 18:vari="http://www.imdagrimet.gov.in/sites/default/files/rainfall_map/Nagalandsearf-SD_0.jpg";
				break;
				case 19:vari="http://www.imdagrimet.gov.in/sites/default/files/rainfall_map/Orisearf-SD.jpg";
				break;
				case 20:vari="http://www.imdagrimet.gov.in/sites/default/files/rainfall_map/Punsearf-SD_0.jpg";
				break;
				case 21:vari="http://www.imdagrimet.gov.in/sites/default/files/rainfall_map/Rajsearf-SD_0.jpg";
				break;
				case 22:vari="http://www.imdagrimet.gov.in/sites/default/files/rainfall_map/Sikkimsearf-SD_0.jpg";
				break;
				case 23:vari="http://www.imdagrimet.gov.in/sites/default/files/rainfall_map/TNsearf_S_V.jpg";
				break;
				case 24:vari="http://www.imdagrimet.gov.in/sites/default/files/rainfall_map/Tripurasearf%20-SD.jpg";
				break;
				case 25:vari="http://www.imdagrimet.gov.in/sites/default/files/rainfall_map/Uttsearf_S_V_0.jpg";
				break;
				case 26:vari="http://www.imdagrimet.gov.in/sites/default/files/rainfall_map/upsearf._0.jpg";
				break;
				case 27:vari="http://www.imdagrimet.gov.in/sites/default/files/rainfall_map/Wbsearf-SD_0.jpg";
				break;
				}
				Intent viewIntent = new Intent("android.intent.action.VIEW", Uri.parse(vari));
				startActivity(viewIntent);
			}

		});

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_weekly_forecast, menu);
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

}
