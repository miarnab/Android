package com.example.routine;

import java.util.Locale;
import java.util.Random;  

import android.app.Activity;
import android.os.Bundle; 
import android.speech.tts.TextToSpeech; 
import android.view.Menu; 
import android.view.View; 
import android.widget.EditText; 
import android.widget.Toast;

public class MainActivity extends Activity {  
   TextToSpeech ttobj;    
   private EditText write;    
   @Override    
   protected void onCreate(Bundle savedInstanceState) {       
	   super.onCreate(savedInstanceState);       
	   setContentView(R.layout.activity_main);       
	   write = (EditText)findViewById(R.id.editText1);       
	   ttobj=new TextToSpeech(getApplicationContext(),        
			   new TextToSpeech.OnInitListener() {       
		   @Override       
		   public void onInit(int status) {          
			   if(status != TextToSpeech.ERROR){              
				   ttobj.setLanguage(Locale.US);             
				   }              
			   }       
		   });    
	   }    
   @Override    
   public void onPause(){       
	   if(ttobj !=null){          
		   ttobj.stop();          
		   ttobj.shutdown();       
		   }       
	   super.onPause();    
	   }    
   @Override    
   public boolean onCreateOptionsMenu(Menu menu) {       
	   // Inflate the menu; this adds items to the action bar if it is present.       
	   getMenuInflater().inflate(R.menu.main, menu);       
	   return true;    
	   }   
   public void speakText(View view){
	   String toSpeak = write.getText().toString();
	   if(toSpeak.equalsIgnoreCase("Sunday")||toSpeak.equalsIgnoreCase("sunday")){
	   String toSpeak1=write.getText().toString()+" is a holiday.You do not have college on this day.So plan your time efficiently to get the maximum output and also complete the practicals.";
		Toast.makeText(getApplicationContext(), toSpeak1,Toast.LENGTH_LONG).show();       
	   ttobj.speak(toSpeak1, TextToSpeech.QUEUE_FLUSH, null);
	   }
	   else if(toSpeak.equalsIgnoreCase("Monday")||toSpeak.equalsIgnoreCase("monday")){
		   String toSpeak2=write.getText().toString()+" is a holiday.You do not have college on this day.So plan your time efficiently to get the maximum output and also complete the practicals.";
		   Toast.makeText(getApplicationContext(), toSpeak2,Toast.LENGTH_LONG).show();       
		   ttobj.speak(toSpeak2, TextToSpeech.QUEUE_FLUSH, null);
	   }
	   else if(toSpeak.equalsIgnoreCase("Tuesday")||toSpeak.equalsIgnoreCase("tuesday")){
		   String toSpeak3=write.getText().toString()+" is the first day of college in a week.You should have to go to college on this day since you have practicals on this day.If you want more details please enter the subject code"; 
		   Toast.makeText(getApplicationContext(), toSpeak3,Toast.LENGTH_LONG).show();       
		   ttobj.speak(toSpeak3, TextToSpeech.QUEUE_FLUSH, null);
		   {
			   if(toSpeak.equalsIgnoreCase("EC-302")||toSpeak.equalsIgnoreCase("EC302")||toSpeak.equalsIgnoreCase("EC 302")||toSpeak.equalsIgnoreCase("ec-302")||toSpeak.equalsIgnoreCase("ec302")||toSpeak.equalsIgnoreCase("ec 302")){
				   String toSpeak3_1="The subject "+write.getText().toString()+" is the first class of tuesday.This is the solid state devices theory class.Theclass is taken by Madhumita Sarkar mam.The class starts from 9:45 am.";
				   Toast.makeText(getApplicationContext(), toSpeak3_1, Toast.LENGTH_LONG).show();
				   ttobj.speak(toSpeak3_1, TextToSpeech.QUEUE_FLUSH, null);
			   }
			   else if(toSpeak.equalsIgnoreCase("EC-301")||toSpeak.equalsIgnoreCase("EC301")||toSpeak.equalsIgnoreCase("EC 301")||toSpeak.equalsIgnoreCase("ec-301")||toSpeak.equalsIgnoreCase("ec301")||toSpeak.equalsIgnoreCase("ec 301")){
				   
			   }
		   }
	   
	  