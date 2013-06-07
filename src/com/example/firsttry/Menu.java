package com.example.firsttry;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class Menu extends ListActivity{

	String classes[] = { "Main", "TextPlay", "Email", "Camera", "Data", 
			"GFX", "GFXSurface", "SoundStuff", "Slider", "Tabs", "SimpleBrowser",
			"Flipper", "SharedPrefs", "InternalData", "ExternalData", "SQLiteExample"};
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		
		//full screen
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
		setListAdapter(new ArrayAdapter<String>(Menu.this, android.R.layout.simple_list_item_1, classes));
	}
	
	@Override
	protected void onListItemClick(ListView l, View v, int position, long id) {
		// TODO Auto-generated method stub
		super.onListItemClick(l, v, position, id);
		String cheese = classes[position];
		try{
		Class ourClass = Class.forName("com.example.firsttry." + cheese);
		Intent ourIntent = new Intent(Menu.this, ourClass);
		startActivity(ourIntent);
		}catch(ClassNotFoundException e){
			e.printStackTrace();
		}		
	}

	
	@Override
	public boolean onCreateOptionsMenu(android.view.Menu menu) {
		// TODO Auto-generated method stub
	    super.onCreateOptionsMenu(menu);
		MenuInflater blowUp = getMenuInflater();
		blowUp.inflate(R.menu.cool_menu, menu);
		return true;
	}

	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		//  TODO Auto-generated method stub
		switch(item.getItemId()){
		case R.id.aboutUS:
			Intent i = new Intent("com.example.firsttry.ABOUT");
			startActivity(i);
			break;
		case R.id.preferences:
			Intent p = new Intent("com.example.firsttry.PREFS");
			startActivity(p);
			break;	
        case R.id.exit:
			finish();
			break;	
		}
		return false;
	}

	
	
}
