package com.example.autocomplete;

import android.os.Bundle;

 
import android.app.Activity; 
import android.view.Menu; 
import android.widget.ArrayAdapter; 
import android.widget.AutoCompleteTextView; 
import android.widget.MultiAutoCompleteTextView; 

public class MainActivity extends Activity { 
	
	private AutoCompleteTextView actv;
	private MultiAutoCompleteTextView mactv; 
	@Override 
	protected void onCreate(Bundle savedInstanceState) { 
		super.onCreate(savedInstanceState); 
		setContentView(R.layout.activity_main); 
		String[] countries = getResources(). getStringArray(R.array.list_of_countries); 
		ArrayAdapter adapter = new ArrayAdapter (this,android.R.layout.simple_list_item_1,countries); 
		actv = (AutoCompleteTextView) findViewById(R.id.autoCompleteTextView1); 
		mactv = (MultiAutoCompleteTextView) findViewById (R.id.multiAutoCompleteTextView1); 
		actv.setAdapter(adapter); 
		mactv.setAdapter(adapter); 
		mactv.setTokenizer(new MultiAutoCompleteTextView.CommaTokenizer()); 
		} 
	@Override 
	public boolean onCreateOptionsMenu(Menu menu) { 
		// Inflate the menu; this adds items to the action bar if it is present. 
		getMenuInflater().inflate(R.menu.main, menu); 
		return true; 
		} 
	
	}

