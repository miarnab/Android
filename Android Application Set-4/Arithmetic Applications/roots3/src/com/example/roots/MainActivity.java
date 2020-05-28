package com.example.roots;

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
            	  double a = Double.parseDouble(t1);                
            	  double b = Double.parseDouble(t2);                
            	  double c = Double.parseDouble(t3);  
                  double d=0.00,p=0.00,q=0.00,e=0.00;
                  d=(b*b)-(4*a*c);
                  if(d<0.00)
                  {
                	String m="The roots of the equation are imaginery";
                	Toast.makeText(getApplicationContext(),String.valueOf(m),Toast.LENGTH_LONG).show();
                  }
                  else
                  {
                	  String n="The roots of the equation are real";
                	  Toast.makeText(getApplicationContext(), String.valueOf(n),Toast.LENGTH_LONG).show();
                	  e=Math.sqrt(d);
                	  p=(-b+e)/(2*a);
                	  q=(-b-e)/(2*a);
                	  if(p==q)
                	  {
                		  Toast.makeText(getApplicationContext(), String.valueOf(p),Toast.LENGTH_LONG).show(); 
                	  }
                	  else
                	  {
                	  Toast.makeText(getApplicationContext(),String.valueOf(p),Toast.LENGTH_LONG).show();
                	  Toast.makeText(getApplicationContext(), String.valueOf(q),Toast.LENGTH_LONG).show();
                	  }
                  }
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
