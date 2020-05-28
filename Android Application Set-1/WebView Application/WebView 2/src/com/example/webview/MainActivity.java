package com.example.webview;

import android.os.Bundle;

 
import android.app.Activity; 
import android.view.Menu; 
import android.view.View; 
import android.view.Window;
import android.widget.ArrayAdapter;
import android.webkit.WebSettings;
import android.webkit.WebView; 
import android.webkit.WebViewClient; 
import android.widget.AutoCompleteTextView;
import android.widget.TextView; 

public class MainActivity extends Activity { 
	private AutoCompleteTextView field; 
	private WebView browser; 
	@Override 
	protected void onCreate(Bundle savedInstanceState) { 
		super.onCreate(savedInstanceState); 
		setContentView(R.layout.activity_main);
		String[] webs=getResources(). getStringArray(R.array.list_of_websites);
		ArrayAdapter adapter= new ArrayAdapter (this,android.R.layout.simple_list_item_1,webs);
		field = (AutoCompleteTextView)findViewById(R.id.urlField); 
		browser = (WebView)findViewById(R.id.webView1); 
		browser.setWebViewClient(new MyBrowser());
		field.setAdapter(adapter);
		} 
	public void open(View view){ 
		String url = field.getText().toString(); 
		browser.getSettings().setLoadsImagesAutomatically(true); 
		browser.getSettings().setJavaScriptEnabled(true); 
		browser.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY); 
		browser.loadUrl(url); 
		} 
	private class MyBrowser extends WebViewClient { 
		@Override 
		public boolean shouldOverrideUrlLoading(WebView view, String url) { 
			view.loadUrl(url); 
			return true; 
			} 
		} 
	@Override 
	public boolean onCreateOptionsMenu(Menu menu) { 
		// Inflate the menu; this adds items to the action bar if it is present. 
		getMenuInflater().inflate(R.menu.main, menu); 
		return true; 
		} 
	
	}

