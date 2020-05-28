package com.example.helloworld3;

import java.text.SimpleDateFormat; 
import java.util.Calendar; 
import java.util.Date;  
import android.os.Bundle; 
import android.app.Activity; 
import android.text.format.DateFormat; 
import android.view.Menu; 
import android.widget.TextView;  
public class MainActivity extends Activity {  
    @Override 
    protected void onCreate(Bundle savedInstanceState) { 
        super.onCreate(savedInstanceState); 
        setContentView(R.layout.activity_main); 
         
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd"); 
        Date date = new Date(); 
     String nowDate = dateFormat.format(date); 
     TextView dateView =  (TextView)findViewById(R.id.dates);
     dateView.setText(nowDate); 
     
     SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm:ss"); 
  String nowTime = timeFormat.format(date); 
  TextView timeView =  (TextView)findViewById(R.id.times); 
  timeView.setText(nowTime); 
 }   
 @Override 
 public boolean onCreateOptionsMenu(Menu menu) { 
     // Inflate the menu; 
     getMenuInflater().inflate(R.menu.main, menu); 
     return true; 
 } 
} 

