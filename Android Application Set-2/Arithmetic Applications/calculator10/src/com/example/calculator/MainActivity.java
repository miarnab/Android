package com.example.calculator;

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
	private Button btnAdd;
	private Button btnMultiply;
	private Button btnDivide;
	private Button btnSubs;
	private Button btnSQroot;
	private Button btnSQ;
	private Button btnCUroot;
	private Button btnCU;
	private Button btnQuad;
	

 @Override  
 protected void onCreate(Bundle savedInstanceState) {           
	 super.onCreate(savedInstanceState);           
	 setContentView(R.layout.activity_main);           
	 addListenerOnButton();  
	 }  
 private void addListenerOnButton() {  
          edText1 = (EditText)findViewById(R.id.editText1);           
          edText2 = (EditText)findViewById(R.id.editText2);           
          edText3 = (EditText)findViewById(R.id.editText3);              
          btnAdd = (Button)findViewById(R.id.button1);
          btnMultiply= (Button)findViewById(R.id.button2);
          btnDivide=(Button)findViewById(R.id.button3);
          btnSubs=(Button)findViewById(R.id.button4);
          btnSQroot=(Button)findViewById(R.id.button5);
          btnSQ=(Button)findViewById(R.id.button6);
          btnCUroot=(Button)findViewById(R.id.button7);
          btnCU=(Button)findViewById(R.id.button8);
          btnQuad=(Button)findViewById(R.id.button9);
          btnAdd.setOnClickListener(new OnClickListener() {  
              @Override             
              public void onClick(View view) {                
            	  String t1 = edText1.getText().toString();                
            	  String t2 = edText2.getText().toString();                
            	  String t3 = edText3.getText().toString();                     
            	  double i1 = Double.parseDouble(t1);                
            	  double i2 = Double.parseDouble(t2);                
            	  double i3 = Double.parseDouble(t3);  
                  double add = i1+i2+i3;
                  Toast.makeText(getApplicationContext(),String.valueOf(add),Toast.LENGTH_LONG).show();             
                  }
              });
          btnMultiply.setOnClickListener(new OnClickListener(){
        	  @Override
        	  public void onClick(View view){
        		  String t1 = edText1.getText().toString();                
            	  String t2 = edText2.getText().toString();                
            	  String t3 = edText3.getText().toString();                     
            	  double i1 = Double.parseDouble(t1);                
            	  double i2 = Double.parseDouble(t2);                
            	  double i3 = Double.parseDouble(t3);
            	  double multiply=i1*i2*i3;
            	  Toast.makeText(getApplicationContext(), String.valueOf(multiply), Toast.LENGTH_LONG).show();
            	  }
          });
          btnDivide.setOnClickListener(new OnClickListener(){
        	  @Override
        	  public void onClick(View view){
        		  String t1 = edText1.getText().toString();                
            	  String t2 = edText2.getText().toString();                                     
            	  double i1 = Double.parseDouble(t1);                
            	  double i2 = Double.parseDouble(t2);                
                  double q=i1/i2;
                  double r=i1%i2;
                  String q1= "Quotient is:"+q;
                  String r1= "Remainder is:"+r;
                  Toast.makeText(getApplicationContext(), String.valueOf(q1), Toast.LENGTH_LONG).show();
                  Toast.makeText(getApplicationContext(), String.valueOf(r1), Toast.LENGTH_LONG).show();
            	  }
          });
          btnSubs.setOnClickListener(new OnClickListener(){
        	  @Override
        	  public void onClick(View view){
        		  String t1 = edText1.getText().toString();                
            	  String t2 = edText2.getText().toString();                                     
            	  double i1 = Double.parseDouble(t1);                
            	  double i2 = Double.parseDouble(t2);                
                  double s=i1-i2;
                  Toast.makeText(getApplicationContext(), String.valueOf(s), Toast.LENGTH_LONG).show();
                  }
          });
          btnSQroot.setOnClickListener(new OnClickListener(){
        	  @Override
        	  public void onClick(View view){
        		  String t1 = edText1.getText().toString();                                                     
            	  double i1 = Double.parseDouble(t1);                                
                  double sqrt=Math.sqrt(i1);
                  Toast.makeText(getApplicationContext(), String.valueOf(sqrt), Toast.LENGTH_LONG).show();
                  }
          });
          btnSQ.setOnClickListener(new OnClickListener(){
        	  @Override
        	  public void onClick(View view){
        		  String t1 = edText1.getText().toString();                                                     
            	  double i1 = Double.parseDouble(t1);                                
                  double sq=Math.pow(i1, 2);
                  Toast.makeText(getApplicationContext(), String.valueOf(sq), Toast.LENGTH_LONG).show();
                  }
          });
          btnCUroot.setOnClickListener(new OnClickListener(){
        	  @Override
        	  public void onClick(View view){
        		  String t1 = edText1.getText().toString();                                                     
            	  double i1 = Double.parseDouble(t1);                                
                  double curoot=Math.pow(i1, 0.3333);
                  Toast.makeText(getApplicationContext(), String.valueOf(curoot), Toast.LENGTH_LONG).show();
                  }
          });
          btnCU.setOnClickListener(new OnClickListener(){
        	  @Override
        	  public void onClick(View view){
        		  String t1 = edText1.getText().toString();                                                     
            	  double i1 = Double.parseDouble(t1);                               
                  double cu=Math.pow(i1, 3);
                  Toast.makeText(getApplicationContext(), String.valueOf(cu), Toast.LENGTH_LONG).show();
                  }
          });
          btnQuad.setOnClickListener(new OnClickListener() {  
              @Override             
              public void onClick(View view) {                
            	  String t1 = edText1.getText().toString();                
            	  String t2 = edText2.getText().toString();                
            	  String t3 = edText3.getText().toString();                     
            	  double i1 = Double.parseDouble(t1);                
            	  double i2 = Double.parseDouble(t2);                
            	  double i3 = Double.parseDouble(t3);  
                  double a=(i2*i2)-(4*i1*i3);
                  if(a<0.00)
                  {
                	  String s="The roots of the equation does not exist";
                  Toast.makeText(getApplicationContext(),String.valueOf(s),Toast.LENGTH_LONG).show();             
                  }
                  else{
                	  String s1="The roots of the equation exist";
                      Toast.makeText(getApplicationContext(),String.valueOf(s1),Toast.LENGTH_LONG).show();
                      double b=Math.sqrt(a);
                      double d=(-i2+b)/(2*i1);
                      double e=(-i2-b)/(2*i1);
                      if(d==e)
                      {
                    	  Toast.makeText(getApplicationContext(),String.valueOf(d),Toast.LENGTH_LONG).show(); 
                      }
                      else{
                    	  Toast.makeText(getApplicationContext(),String.valueOf(d),Toast.LENGTH_LONG).show();
                    	  Toast.makeText(getApplicationContext(),String.valueOf(e),Toast.LENGTH_LONG).show();
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
  