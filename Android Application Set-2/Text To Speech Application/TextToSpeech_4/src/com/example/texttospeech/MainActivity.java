package com.example.texttospeech;

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
				   ttobj.setLanguage(Locale.ENGLISH);             
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
	   if(toSpeak.equalsIgnoreCase("Arnab")){
	   String toSpeak1=" O Hello Sir "+write.getText().toString()+" Mitra."+" How are you today ?I know you you are my creator and you will become the senior vice president of products and services";
	   Toast.makeText(getApplicationContext(), toSpeak1,Toast.LENGTH_LONG).show();       
	   ttobj.speak(toSpeak1, TextToSpeech.QUEUE_FLUSH, null);
	   }
	   else if(toSpeak.equalsIgnoreCase("Tamal")){
		   String toSpeak2=" O Hello "+write.getText().toString()+" Kumar Mitra."+"How are you today?I know you.You are the father of my creator";
		   Toast.makeText(getApplicationContext(), toSpeak2,Toast.LENGTH_LONG).show();       
		   ttobj.speak(toSpeak2, TextToSpeech.QUEUE_FLUSH, null);
	   }
	   else if(toSpeak.equalsIgnoreCase("Sutapa")){
		   String toSpeak3=" O Hello "+write.getText().toString()+" Mitra."+"How are you today?I know you.You are the mother of my creator";
		   Toast.makeText(getApplicationContext(), toSpeak3,Toast.LENGTH_LONG).show();       
		   ttobj.speak(toSpeak3, TextToSpeech.QUEUE_FLUSH, null);
	   }
	   else if(toSpeak.equalsIgnoreCase("Sucharita")){
		   String toSpeak4=" O Hello "+write.getText().toString()+" Mitra."+"How are you today?I know you.You are the sister of my creator";
		   Toast.makeText(getApplicationContext(), toSpeak4,Toast.LENGTH_LONG).show();       
		   ttobj.speak(toSpeak4, TextToSpeech.QUEUE_FLUSH, null);
	   }
	   else if(toSpeak.equalsIgnoreCase("Mithu")){
		   String toSpeak5=" O Hello "+write.getText().toString()+" Biswas."+"How are you today?I know you.You are the Mithu mashhii of my creator";
		   Toast.makeText(getApplicationContext(), toSpeak5,Toast.LENGTH_LONG).show();       
		   ttobj.speak(toSpeak5, TextToSpeech.QUEUE_FLUSH, null);
	   }
	   else if(toSpeak.equalsIgnoreCase("Kriti")){
		   String toSpeak6=" O Hello "+write.getText().toString()+" Mukherjee."+"How are you today?I know you.You are the maternal younger sister of my creator.Your nickname is motaa dudun";
		   Toast.makeText(getApplicationContext(), toSpeak6,Toast.LENGTH_LONG).show();       
		   ttobj.speak(toSpeak6, TextToSpeech.QUEUE_FLUSH, null);
	   } 
   }
}
