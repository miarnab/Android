package com.example.intentsharetwitter;

import java.io.File; 
import java.io.FileOutputStream; 
import com.example.intentshare.R; 
import android.app.Activity; 
import android.content.DialogInterface; 
import android.content.DialogInterface.OnClickListener; 
import android.content.Intent; 
import android.net.Uri; 
import android.os.Bundle; 
import android.os.Environment; 
import android.view.Menu; 
import android.view.View; 
import android.widget.ImageView;
import android.widget.Toast; 

public class MainActivity extends Activity { 
	private ImageView img; 
	@Override 
	protected void onCreate(Bundle savedInstanceState) { 
		super.onCreate(savedInstanceState); 
		setContentView(R.layout.activity_main); 
		img = (ImageView) findViewById(R.id.imageView1); 
		} 
	@Override 
	public boolean onCreateOptionsMenu(Menu menu) { 
		// Inflate the menu; this adds items to the action bar if it is present. 
		getMenuInflater().inflate(R.menu.main, menu); 
		return true; 
		} 
	public void open(View view){ 
		Intent shareIntent = new Intent(); 
		shareIntent.setAction(Intent.ACTION_SEND); 
		shareIntent.setType("text/plain"); 
		shareIntent.putExtra(Intent.EXTRA_TEXT, "Hello, from tutorialspoint"); 
		startActivity(Intent.createChooser(shareIntent, "Share your thoughts")); 
		} 
	
	}

