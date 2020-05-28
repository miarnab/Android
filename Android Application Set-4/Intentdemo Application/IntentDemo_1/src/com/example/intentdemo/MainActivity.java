package com.example.intentdemo;

import android.net.Uri;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //First intent to use ACTION_VIEW action with correct data
        Button startBrowser_a=(Button)findViewById(R.id.start_browser_a);
        startBrowser_a.setOnClickListener(new View.OnClickListener(){
        	public void onClick(View view){
            Intent i=new Intent(android.content.Intent.ACTION_VIEW,Uri.parse("http://www.example.com"));
        	startActivity(i);	
            }
        });
        //Second intent to use LAUNCH action with correct data
        Button startBrowser_b=(Button)findViewById(R.id.start_browser_b);
        startBrowser_b.setOnClickListener(new View.OnClickListener(){
        	public void onClick(View view){
        		Intent i=new Intent("com.example.intentdemo.LAUNCH",Uri.parse("http://www.example.com"));
        		startActivity(i);
        	}
        });
        //Third intent to use LAUNCH action with incorrect data
        Button startBrowser_c=(Button)findViewById(R.id.start_browser_c);
        startBrowser_c.setOnClickListener(new View.OnClickListener(){
        	private Intent i;

			public void onClick(View view){
        		setI(new Intent("com.example.intentdemo.LAUNCH",Uri.parse("https://www.example.com")));
        	}

			@SuppressWarnings("unused")
			public Intent getI() {
				return i;
			}

			public void setI(Intent i) {
				this.i = i;
			}
        });
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
    	//bar if it is present
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
}
