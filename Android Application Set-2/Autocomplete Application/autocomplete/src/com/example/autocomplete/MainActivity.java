package com.example.autocomplete;

import android.os.Bundle; 
import android.app.Activity; 
import android.view.Menu; 
import android.widget.ArrayAdapter; 
import android.widget.ListView;

public class MainActivity extends Activity {  
   // Array of strings...     
	String[] countryArray = {"India", "Pakistan", "USA", "UK"};  
   @Override    
   protected void onCreate(Bundle savedInstanceState) {       
	   super.onCreate(savedInstanceState);       
	   setContentView(R.layout.activity_main);              
	   ArrayAdapter adapter = new ArrayAdapter<String>(this,R.layout.activity_listview, countryArray);              
	   ListView listView = (ListView) findViewById(R.id.country_list);       
	   listView.setAdapter(adapter);    
	   } 
   }