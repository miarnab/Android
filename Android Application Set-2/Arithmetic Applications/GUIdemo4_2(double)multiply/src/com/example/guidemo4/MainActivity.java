package com.example.guidemo4;  


import android.os.Bundle; 
import android.app.Activity; 
import android.view.Menu; 
import android.view.View; 
import android.view.View.OnClickListener; 
import android.widget.Button; 
import android.widget.EditText; 
import android.widget.Toast;  


public class MainActivity extends Activity {    
	private EditText edText1,edText2,edText3;  
	private Button btnProduct;  

 @Override  
 protected void onCreate(Bundle savedInstanceState) {           
	 super.onCreate(savedInstanceState);           
	 setContentView(R.layout.activity_main);           
	 addListenerOnButton();  
	 }  
 private void addListenerOnButton() {  
          edText1 = (EditText)findViewById(R.id.edittext);           
          edText2 = (EditText)findViewById(R.id.edittext2);           
          edText3 = (EditText)findViewById(R.id.edittext3);              
          btnProduct = (Button)findViewById(R.id.button1);
          btnProduct.setOnClickListener(new OnClickListener() {  
              @Override             
              public void onClick(View view) {                
            	  String t1 = edText1.getText().toString();                
            	  String t2 = edText2.getText().toString();                
            	  String t3 = edText3.getText().toString();                     
            	  double i1 = Double.parseDouble(t1);                
            	  double i2 = Double.parseDouble(t2);                
            	  double i3 = Double.parseDouble(t3);  
                 double product = i1*i2*i3;               
                 Toast.makeText(getApplicationContext(),String.valueOf(product),Toast.LENGTH_LONG).show();             
                 }      
              });  
          }  
   @Override  
   public boolean onCreateOptionsMenu(Menu menu) {         
	   /* Inflate the menu; this adds items to the action bar if it is present */         
	   getMenuInflater().inflate(R.menu.main, menu);         
	   return true;  
	   } 
   } 
  