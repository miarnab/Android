package com.example.auto;

import android.os.Bundle; 
import android.app.Activity; 
import android.view.Menu;
import android.widget.ArrayAdapter; 
import android.widget.AutoCompleteTextView;
 


public class MainActivity extends Activity {      
	AutoCompleteTextView autocompletetextview;  
   String arr[]= { "Vaibhav Gupta", "Arnab Mitra", "Sudip Poray","Titas Mukherjee","Utsanita Kundu","Subhajeet Roy","Sudipta Chakraborty","Ria Jesmin","Rishab Paul","Ritesh","Ritam Ghosh","Sambaran Maity","Saroj Srivastava","Satya Raj","Sayan Chowdhury","Sayan Roy","Sayantan Chowdhury","Sayantan Sarkar","Shaswata Adhikary","Shibangi Gupta","Shubho Sarkar","Subhasayan Das","Sandipan Ghosh","Sandipan Mitra","Sristi Jaiswal","Sourav Roy","Saurav Kumar Bose","Saurav Bharadwaj","Souvik Sarkar","Shouvik Roy","Sudip Kundu","Supriyo Kumar Patra","Suraj ","Sutanu Kha","Swastik Paul","Syed Asif Javed","Tanmoy Bhattacharya","Tirthadeep Ghosh","Ujjwal Pandey","Solanki Das","Agniva ","Anyatama Ghosh","Kinjal Mitra","Priyotosh Kumar Singh","Zohhak Pameez","Sourav Singha","Sourav Pal","Subhadeep Dutta","Subhajeet Mondal","Anindya Sankar Das","Vivek Kumar" };  
   @Override    
   protected void onCreate(Bundle savedInstanceState) {       
	   super.onCreate(savedInstanceState);       
	   setContentView(R.layout.activity_main);  
	   autocompletetextview = (AutoCompleteTextView)                    
	   findViewById(R.id.autoCompleteTextView1);  
      ArrayAdapter adapter = new ArrayAdapter(this,android.R.layout.select_dialog_item, arr);  
      autocompletetextview.setThreshold(1);       
      autocompletetextview.setAdapter(adapter);     
      } 
   @Override    
   public boolean onCreateOptionsMenu(Menu menu) {       
	   /* Inflate the menu; this adds items to the action bar if it is present */       
	   getMenuInflater().inflate(R.menu.main, menu);       
	   return true; 
   }
}

