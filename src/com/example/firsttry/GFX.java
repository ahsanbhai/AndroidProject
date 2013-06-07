package com.example.firsttry;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.PowerManager;
import android.os.PowerManager.WakeLock;

public class GFX extends Activity {

	MyOwnWork ourView;
	WakeLock wL;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		
		//wake-lock
		PowerManager pM = (PowerManager)getSystemService(Context.POWER_SERVICE);
		wL = pM.newWakeLock(PowerManager.FULL_WAKE_LOCK, "whatever");
		wL.acquire();
		
		super.onCreate(savedInstanceState);
		ourView = new MyOwnWork(this);
		setContentView(ourView);
	}

	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		wL.release();
	}

}
