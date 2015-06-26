package com.proxhammer;

import java.util.ArrayList;

import android.content.Context;

import com.kl.kitlocate.class_interface.KLGeofence;
import com.kl.kitlocate.class_interface.KLLocalNotification;
import com.kl.kitlocate.utilities.interfaces.IKLGeofenceResponse;

public class GeofenceResponseHandler implements IKLGeofenceResponse{

	
	/*
	 * (non-Javadoc)
	 * @see com.kl.kitlocate.utilities.interfaces.IKLGeofenceResponse#geofenceIn(android.content.Context, java.util.ArrayList)
	 * 
	 * We are only going to need the geofenceIn
	 * 
	 * you can edit the Params and the lat, long values in our main activity
	 * 
	 */
	@Override
	public void geofenceIn(Context arg0, ArrayList<KLGeofence> arg1) {
		// TODO Auto-generated method stub
		new KLLocalNotification(arg0,"Half price sale at Edgars. Ends Today", R.drawable.ic_launcher).setContentTitle("Edgars shoe sale!").send();
	}

	@Override
	public void geofenceInArm(Context arg0, ArrayList<KLGeofence> arg1) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void geofenceOut(Context arg0, ArrayList<KLGeofence> arg1) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void geofenceOutArm(Context arg0, ArrayList<KLGeofence> arg1) {
		// TODO Auto-generated method stub
		
	}

}
