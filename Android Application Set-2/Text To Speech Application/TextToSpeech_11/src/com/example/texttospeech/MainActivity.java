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
	   if(toSpeak.equalsIgnoreCase("Arnab")){
	   String toSpeak1="O Hello Sir "+write.getText().toString()+" Mitra."+" How are you? You are my creator and a member of the Windows Insider Programme.You are a student of B.P. Poddar Institute of Management and Technology.You live in Basak Bagan , 4 no. D.B. Nagar,Rabindranath Tagore Road,Sodepur.Kolkata-7 0 0 1 1 0.Your mobile number is 9 6 7 4 3 8 6 8 0 7 ";
	   Toast.makeText(getApplicationContext(), toSpeak1,Toast.LENGTH_LONG).show();       
	   ttobj.speak(toSpeak1, TextToSpeech.QUEUE_FLUSH, null);
	   }
	   else if(toSpeak.equalsIgnoreCase("Tamal")){
		   String toSpeak2="O Hello "+write.getText().toString()+" Kumar Mitra."+"How are you? I know you.You are the father of my creator";
		   Toast.makeText(getApplicationContext(), toSpeak2,Toast.LENGTH_LONG).show();       
		   ttobj.speak(toSpeak2, TextToSpeech.QUEUE_FLUSH, null);
	   }
	   else if(toSpeak.equalsIgnoreCase("Sutapa")){
		   String toSpeak3="O Hello "+write.getText().toString()+" Mitra."+"How are you? I know you.You are the mother of my creator";
		   Toast.makeText(getApplicationContext(), toSpeak3,Toast.LENGTH_LONG).show();       
		   ttobj.speak(toSpeak3, TextToSpeech.QUEUE_FLUSH, null);
	   }
	   else if(toSpeak.equalsIgnoreCase("Sucharita")){
		   String toSpeak4="O Hello "+write.getText().toString()+" Mitra."+"How are you? I know you.You are the sister of my creator";
		   Toast.makeText(getApplicationContext(), toSpeak4,Toast.LENGTH_LONG).show();       
		   ttobj.speak(toSpeak4, TextToSpeech.QUEUE_FLUSH, null);
	   }
	   else if(toSpeak.equalsIgnoreCase("Mithu")){
		   String toSpeak5="O Hello "+write.getText().toString()+" Biswas."+"How are you? I know you.You are the Mitthu masshii of my creator";
		   Toast.makeText(getApplicationContext(), toSpeak5,Toast.LENGTH_LONG).show();       
		   ttobj.speak(toSpeak5, TextToSpeech.QUEUE_FLUSH, null);
	   }
	   else if(toSpeak.equalsIgnoreCase("Kriti")){
		   String toSpeak6="O Hello "+write.getText().toString()+" Mukherjee."+"How are you? I know you.You are the maternal cousin of my creator.Your nickname is motaa dudun";
		   Toast.makeText(getApplicationContext(), toSpeak6,Toast.LENGTH_LONG).show();       
		   ttobj.speak(toSpeak6, TextToSpeech.QUEUE_FLUSH, null);
	   }
	   else if(toSpeak.equalsIgnoreCase("Sudipta")){
		   String toSpeak7="O Hello "+write.getText().toString()+" Chakrabarty."+"How are you? I know you.You are the college friend of my creator.You live in Chandannagore.Your nickname is Suipta.You love a girl named Poulami Das of Computer Science in your college.";
		   Toast.makeText(getApplicationContext(), toSpeak7,Toast.LENGTH_LONG).show();       
		   ttobj.speak(toSpeak7, TextToSpeech.QUEUE_FLUSH, null); 
	   }
	   else if(toSpeak.equalsIgnoreCase("Sutanu")){
		   String toSpeak8="O Hello "+write.getText().toString()+" Kha."+"How are you? I know you.You are the college friend of my creator.You live in Howrah.Your college roll no. is 1 6 2 3 1 0 6";
		   Toast.makeText(getApplicationContext(), toSpeak8,Toast.LENGTH_LONG).show();       
		   ttobj.speak(toSpeak8, TextToSpeech.QUEUE_FLUSH, null);
	   }
	   else if(toSpeak.equalsIgnoreCase("Vaibhav")){
		   String toSpeak9="O Hello "+write.getText().toString()+" Gupta."+"How are you? I know you.You are the college friend of my creator.Your nickname is Veb.You are my creator's group member in practical classes.Your college roll no. is 1 6 2 3 1 1 3.";
		   Toast.makeText(getApplicationContext(), toSpeak9,Toast.LENGTH_LONG).show();       
		   ttobj.speak(toSpeak9, TextToSpeech.QUEUE_FLUSH, null); 
	   }
	   //Questions that can be asked
	   else if(toSpeak.equalsIgnoreCase("Who are you?")||(toSpeak.equalsIgnoreCase("Who are you"))){
		   String toSpeak1_1="O Hello,I am an android application named Search created by Arnab Mitra, built on eclipse IDE and my support extends from android 4.0 (API 14) to android 4.4 (API 19)";
		   Toast.makeText(getApplicationContext(), toSpeak1_1,Toast.LENGTH_LONG).show();       
		   ttobj.speak(toSpeak1_1, TextToSpeech.QUEUE_FLUSH, null);
	   }
	   else if(toSpeak.equalsIgnoreCase("What is android?")||toSpeak.equalsIgnoreCase("What do you mean by android?")){
		   String toSpeak1_2="O Hello,Android is an advanced operating system developed upon the Linux kernel , marketed and owned by Google.Android runs on mobiles , tablets , TVs , wearables and cars .Andy Rubin is the father and creator of the Android operating system.";
		   Toast.makeText(getApplicationContext(), toSpeak1_2,Toast.LENGTH_LONG).show();       
		   ttobj.speak(toSpeak1_2, TextToSpeech.QUEUE_FLUSH, null);
	   }
	   else if(toSpeak.equalsIgnoreCase("What can you do for me?")||toSpeak.equalsIgnoreCase("What can you do for me")){
		   String toSpeak1_3="I can do many things for you I can tell your info if you write your name in the text field also if you write an element I can provide the details of the element";
		   Toast.makeText(getApplicationContext(), toSpeak1_3,Toast.LENGTH_LONG).show();       
		   ttobj.speak(toSpeak1_3, TextToSpeech.QUEUE_FLUSH, null);
	   }
	   else if(toSpeak.equalsIgnoreCase("Who am I?")||toSpeak.equalsIgnoreCase("Who am I")||(toSpeak.equalsIgnoreCase("Who am i?"))||(toSpeak.equalsIgnoreCase("Who am i"))||(toSpeak.equalsIgnoreCase("who am i?"))||(toSpeak.equalsIgnoreCase("who am i"))){
		   String toSpeak1_4="I may or may not know you if you please enter your name in the text field then I can tell about you";
		   Toast.makeText(getApplicationContext(), toSpeak1_4,Toast.LENGTH_LONG).show();       
		   ttobj.speak(toSpeak1_4, TextToSpeech.QUEUE_FLUSH, null);
	   }
	   //Elements of Periodic Table
	   else if(toSpeak.equalsIgnoreCase("Hydrogen")||toSpeak.equalsIgnoreCase("What do you know about hydrogen?")){
		   String toSpeak2_1=write.getText().toString()+" is a Group-1 Period-1 element having atomic number-1 and mass number-1 and has a valency of +1 and has three isotopes named Protium, Deuterium and Tritium.";
		   Toast.makeText(getApplicationContext(), toSpeak2_1,Toast.LENGTH_LONG).show();       
		   ttobj.speak(toSpeak2_1, TextToSpeech.QUEUE_FLUSH, null);
	   }
	   else if(toSpeak.equalsIgnoreCase("Lithium")||toSpeak.equalsIgnoreCase("What do you know about Lithium?")){
		   String toSpeak2_2=write.getText().toString()+" is a Group-1 Period-2 element having atomic number-3 and mass number-5 and has a valency of +1";
		   Toast.makeText(getApplicationContext(), toSpeak2_2,Toast.LENGTH_LONG).show();       
		   ttobj.speak(toSpeak2_2, TextToSpeech.QUEUE_FLUSH, null);
	   }
	   else if(toSpeak.equalsIgnoreCase("Helium")){
		   String toSpeak2_3="This information is not available right now, stay tuned for more.";
		   Toast.makeText(getApplicationContext(), toSpeak2_3,Toast.LENGTH_LONG).show();       
		   ttobj.speak(toSpeak2_3, TextToSpeech.QUEUE_FLUSH, null);
	   }
	   else if(toSpeak.equalsIgnoreCase("Beryllium")){
		   String toSpeak2_4=" This information is not available right now, stay tuned for more";
		   Toast.makeText(getApplicationContext(), toSpeak2_4,Toast.LENGTH_LONG).show();       
		   ttobj.speak(toSpeak2_4, TextToSpeech.QUEUE_FLUSH, null);
	   }
	   else{
		   String toSpeak16="O Hello you must be one of the acquaintances or friends of Arnab Mitra.Sorry your name "+write.getText().toString()+" is not listed for any voice outputs or this information you want is not available in the database right now.";
		   Toast.makeText(getApplicationContext(), toSpeak16,Toast.LENGTH_LONG).show();       
		   ttobj.speak(toSpeak16, TextToSpeech.QUEUE_FLUSH, null);
	   }
   }
}
