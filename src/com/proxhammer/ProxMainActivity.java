/*
 * OUR PRAYER to the JAVA Gods of MAYA who love offerings of chocolate and code 
 * 
 * We, after a few weeks of cleaning and learning new code, would like the JAVA gods to overlook
 * our code, keep logcat at bay and teach us the patience of writing good code. We also would like
 * to have more patience for error checking and debugging and logging as all awesome apps are made
 * with spirit and ingenuity. Forgive us for copying and laziness. May our code receive blessings 
 * in abundance. MANIFEST!( means Amen in this context)
 */
package com.proxhammer;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.kl.kitlocate.*;
import com.kl.kitlocate.class_interface.KLGeofence;
import com.kl.kitlocate.interfaces.KLApplication;
import com.kl.kitlocate.interfaces.KLLocation;
import com.kl.kitlocate.interfaces.KitLocate;

public class ProxMainActivity extends Activity {

	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_prox_main);	
		//lady and gents here we
		//are initiating the third-party API KitLocate
		KitLocate.initKitLocate(this, "3cf2c639-e40d-4756-90dd-74748357df9c");
		
		/**
		 * Here we are adding our geofence manually
		 * @params addGeofence(Context, latitude, longitue, radius, geotype*, String message)
		 * 
		 * manje we are doing this manually to make sure everything works before we get into push notifications
		 */
		KLLocation.addGeofence(this, -29.917333f, 30.975862000000006f, 500, KLGeofence.Type.IN, "EDGARS");
		//here we register to our responseHandler class which is 
		//a built in class that comes with 
		//Kitlocate
		KLLocation.registerGeofencing(this, GeofenceResponseHandler.class);
		
		
	}
/*
 * (non-Javadoc)
 * @see android.app.Activity#onStart()
 * 
 * this starts KitLocate when our activity starts
 */
	@Override
	protected void onStart() {
		// TODO Auto-generated method stub
		super.onStart();
		KLApplication.onActivityStart(this);
	}

	@Override
	protected void onStop() {
		// TODO Auto-generated method stub
		super.onStop();
		KLApplication.onActivityStop(this);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.prox_main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
