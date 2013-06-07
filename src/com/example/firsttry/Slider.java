package com.example.firsttry;

import android.app.Activity;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.SlidingDrawer;
import android.widget.SlidingDrawer.OnDrawerOpenListener;

public class Slider extends Activity implements OnClickListener, OnDrawerOpenListener, OnCheckedChangeListener {

	SlidingDrawer sd;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.sliding);
		Button handle1 = (Button) findViewById(R.id.bSliding1);
		Button handle2 = (Button) findViewById(R.id.bSliding2);
		Button handle3 = (Button) findViewById(R.id.bSliding3);
		Button handle4 = (Button) findViewById(R.id.bSliding4);
		CheckBox checkbox = (CheckBox) findViewById(R.id.cbSLidable);
		checkbox.setOnCheckedChangeListener(this);
		sd = (SlidingDrawer) findViewById(R.id.slidingD);
		sd.setOnDrawerOpenListener(this);
		handle1.setOnClickListener(this);
		handle2.setOnClickListener(this);
		handle3.setOnClickListener(this);
		handle4.setOnClickListener(this);
		
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch(v.getId()){
		case R.id.bSliding1:
			sd.open();
			break;
		case R.id.bSliding2:
			
			break;
		case R.id.bSliding3:
			sd.toggle();
			break;
		case R.id.bSliding4:
			sd.close();
			break;
		}
	}

	public void onCheckedChanged(CompoundButton arg0, boolean arg1) {
		// TODO Auto-generated method stub
		if(arg0.isChecked()){
			sd.lock();
		}else{
			sd.unlock();
		}
	}

	@Override
	public void onDrawerOpened() {
		// TODO Auto-generated method stub
		MediaPlayer mp = MediaPlayer.create(this, R.raw.explosion);
		mp.start();
	}

	
}
