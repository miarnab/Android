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
	   String toSpeak1=" O Hello Sir "+write.getText().toString()+" Mitra."+" How are you? I know you you are my creator and a member of the Windows Insider Programme.You are a student of B.P. Poddar Institute of Management and Technology.You live in Basak Bagan , 4 no. D.B. Nagar,Rabindranath Tagore Road,Sodepur.Kolkata-7 0 0 1 1 0.Your mobile number is 9 6 7 4 3 8 6 8 0 7 ";
	   Toast.makeText(getApplicationContext(), toSpeak1,Toast.LENGTH_LONG).show();       
	   ttobj.speak(toSpeak1, TextToSpeech.QUEUE_FLUSH, null);
	   }
	   else if(toSpeak.equalsIgnoreCase("Tamal")){
		   String toSpeak2=" O Hello "+write.getText().toString()+" Kumar Mitra."+"How are you? I know you.You are the father of my creator";
		   Toast.makeText(getApplicationContext(), toSpeak2,Toast.LENGTH_LONG).show();       
		   ttobj.speak(toSpeak2, TextToSpeech.QUEUE_FLUSH, null);
	   }
	   else if(toSpeak.equalsIgnoreCase("Sutapa")){
		   String toSpeak3=" O Hello "+write.getText().toString()+" Mitra."+"How are you? I know you.You are the mother of my creator";
		   Toast.makeText(getApplicationContext(), toSpeak3,Toast.LENGTH_LONG).show();       
		   ttobj.speak(toSpeak3, TextToSpeech.QUEUE_FLUSH, null);
	   }
	   else if(toSpeak.equalsIgnoreCase("Sucharita")){
		   String toSpeak4=" O Hello "+write.getText().toString()+" Mitra."+"How are you? I know you.You are the sister of my creator";
		   Toast.makeText(getApplicationContext(), toSpeak4,Toast.LENGTH_LONG).show();       
		   ttobj.speak(toSpeak4, TextToSpeech.QUEUE_FLUSH, null);
	   }
	   else if(toSpeak.equalsIgnoreCase("Mithu")){
		   String toSpeak5=" O Hello "+write.getText().toString()+" Biswas."+"How are you? I know you.You are the Mitthu masshii of my creator";
		   Toast.makeText(getApplicationContext(), toSpeak5,Toast.LENGTH_LONG).show();       
		   ttobj.speak(toSpeak5, TextToSpeech.QUEUE_FLUSH, null);
	   }
	   else if(toSpeak.equalsIgnoreCase("Kriti")){
		   String toSpeak6=" O Hello "+write.getText().toString()+" Mukherjee."+"How are you? I know you.You are the maternal cousin of my creator.Your nickname is motaa dudun";
		   Toast.makeText(getApplicationContext(), toSpeak6,Toast.LENGTH_LONG).show();       
		   ttobj.speak(toSpeak6, TextToSpeech.QUEUE_FLUSH, null);
	   }
	   else if(toSpeak.equalsIgnoreCase("Sudipta")){
		   String toSpeak7=" O Hello "+write.getText().toString()+" Chakraborty."+"How are you? I know you.You are the college friend of my creator.You live in Chandannagore.Your nickname is Suipta.You love a girl named Poulomi Das of Computer Science in your college.";
		   Toast.makeText(getApplicationContext(), toSpeak7,Toast.LENGTH_LONG).show();       
		   ttobj.speak(toSpeak7, TextToSpeech.QUEUE_FLUSH, null); 
	   }
	   else if(toSpeak.equalsIgnoreCase("Sutanu")){
		   String toSpeak8=" O Hello "+write.getText().toString()+" Kha."+"How are you? I know you.You are the college friend of my creator.You live in Howrah.Your college roll no. is 1 6 2 3 1 0 6";
		   Toast.makeText(getApplicationContext(), toSpeak8,Toast.LENGTH_LONG).show();       
		   ttobj.speak(toSpeak8, TextToSpeech.QUEUE_FLUSH, null);
	   }
	   else if(toSpeak.equalsIgnoreCase("Vaibhav")){
		   String toSpeak9=" O Hello "+write.getText().toString()+" Gupta."+"How are you? I know you.You are the college friend of my creator.Your nickname is Veb.You are my creator's group member in practical classes.Your college roll no. is 1 6 2 3 1 1 3.";
		   Toast.makeText(getApplicationContext(), toSpeak9,Toast.LENGTH_LONG).show();       
		   ttobj.speak(toSpeak9, TextToSpeech.QUEUE_FLUSH, null); 
	   }
	   
   }
}
