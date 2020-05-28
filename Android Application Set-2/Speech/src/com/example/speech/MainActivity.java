package com.example.speech;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;


import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import android.speech.tts.TextToSpeech;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends Activity implements 
	TextToSpeech.OnInitListener,OnItemSelectedListener{
	/**Called when the activity is first created.*/
	
   private TextToSpeech tts;
   private Button buttonSpeak;
   private EditText editText;
   private Spinner speedSpinner,pitchSpinner;
   private static String speed="Normal";
   
   @Override    
   protected void onCreate(Bundle savedInstanceState) {       
	   super.onCreate(savedInstanceState);       
	   setContentView(R.layout.activity_main);       
	   tts=new TextToSpeech(this,this);
	   buttonSpeak=(Button) findViewById(R.id.button1);
	   editText = (EditText)findViewById(R.id.editText1);
	   speedSpinner=(Spinner) findViewById(R.id.spinner1);
	   
	   //load data in spinner
	   loadSpinnerdata();
	   speedSpinner.setOnItemSelectedListener(this);
	   
	   //Button click event
	   buttonSpeak.setOnClickListener(new View.OnClickListener() {
		   @Override
		public void onClick(View arg0) {
			   setSpeed();
			   speakOut();
			// TODO Auto-generated method stub
			
		}
	});
   }
		   private void loadSpinnerdata() {
	// TODO Auto-generated method stub
	
}
		@Override       
		   public void onInit(int status) {          
			   if(status == TextToSpeech.SUCCESS){
				   int result= tts.setLanguage(Locale.US);
				   if(result == TextToSpeech.LANG_MISSING_DATA || result==TextToSpeech.LANG_NOT_SUPPORTED){
					   Log.e("TTS", "This language is not supported");
				   }else{
					   buttonSpeak.setEnabled(true);
					   speakOut();
				   }
			   }else{Log.e("TTS","Initialization Failed!");}
	   }
	   @Override    
   public void onDestroy(){ 
		   //Don't forget to shutdown tts!
	   if(tts !=null){          
		   tts.stop();          
		   tts.shutdown();       
		   }       
	   super.onDestroy();    
	   }    
   @Override    
   public boolean onCreateOptionsMenu(Menu menu) {       
	   // Inflate the menu; this adds items to the action bar if it is present.       
	   getMenuInflater().inflate(R.menu.main, menu);       
	   return true;    
	   }
   private void setSpeed(){
	   if(speed.equals("Very Slow")){
		   tts.setSpeechRate(0.1f);
	   }
	   if(speed.equals("Slow")){
		   tts.setSpeechRate(0.5f);
		   }
	   if(speed.equals("Normal")){
		   tts.setSpeechRate(1.0f);
	   }
	   if(speed.equals("Fast")){
		   tts.setSpeechRate(1.5f);
	   }
	   if(speed.equals("Very Fast")){
		   tts.setSpeechRate(2.0f);
	   }
	   
	  }
   
   public void speakOut(){
	   String toSpeak = editText.getText().toString();
	   if(toSpeak.equalsIgnoreCase("Arnab")){
	   String toSpeak1="O Hello Sir "+editText.getText().toString()+" Mitra."+" How are you? You are my creator and a member of the Windows Insider Programme.You are a student of B.P. Poddar Institute of Management and Technology.You live in Basak Bagan , 4 no. D.B. Nagar,Rabindranath Tagore Road,Sodepur.Kolkata-7 0 0 1 1 0.Your mobile number is 9 6 7 4 3 8 6 8 0 7 ";
	   Toast.makeText(getApplicationContext(), toSpeak1,Toast.LENGTH_LONG).show();       
	   tts.speak(toSpeak1, TextToSpeech.QUEUE_FLUSH, null);
	   }
	   else if(toSpeak.equalsIgnoreCase("Tamal")){
		   String toSpeak2="O Hello "+editText.getText().toString()+" Kumar Mitra."+"How are you? I know you.You are the father of my creator";
		   Toast.makeText(getApplicationContext(), toSpeak2,Toast.LENGTH_LONG).show();       
		   tts.speak(toSpeak2, TextToSpeech.QUEUE_FLUSH, null);
	   }
	   else if(toSpeak.equalsIgnoreCase("Sutapa")){
		   String toSpeak3="O Hello "+editText.getText().toString()+" Mitra."+"How are you? I know you.You are the mother of my creator";
		   Toast.makeText(getApplicationContext(), toSpeak3,Toast.LENGTH_LONG).show();       
		   tts.speak(toSpeak3, TextToSpeech.QUEUE_FLUSH, null);
	   }
	   else if(toSpeak.equalsIgnoreCase("Sucharita")){
		   String toSpeak4="O Hello "+editText.getText().toString()+" Mitra."+"How are you? I know you.You are the sister of my creator";
		   Toast.makeText(getApplicationContext(), toSpeak4,Toast.LENGTH_LONG).show();       
		   tts.speak(toSpeak4, TextToSpeech.QUEUE_FLUSH, null);
	   }
	   else if(toSpeak.equalsIgnoreCase("Mithu")){
		   String toSpeak5="O Hello "+editText.getText().toString()+" Biswas."+"How are you? I know you.You are the Mitthu masshii of my creator";
		   Toast.makeText(getApplicationContext(), toSpeak5,Toast.LENGTH_LONG).show();       
		   tts.speak(toSpeak5, TextToSpeech.QUEUE_FLUSH, null);
	   }
	   else if(toSpeak.equalsIgnoreCase("Kriti")){
		   String toSpeak6="O Hello "+editText.getText().toString()+" Mukherjee."+"How are you? I know you.You are the maternal cousin of my creator.Your nickname is motaa dudun";
		   Toast.makeText(getApplicationContext(), toSpeak6,Toast.LENGTH_LONG).show();       
		   tts.speak(toSpeak6, TextToSpeech.QUEUE_FLUSH, null);
	   }
	   else if(toSpeak.equalsIgnoreCase("Sudipta")){
		   String toSpeak7="O Hello "+editText.getText().toString()+" Chakrabarty."+"How are you? I know you.You are the college friend of my creator.You live in Chandannagore.Your nickname is Suipta.You love a girl named Poulami Das of Computer Science in your college.";
		   Toast.makeText(getApplicationContext(), toSpeak7,Toast.LENGTH_LONG).show();       
		   tts.speak(toSpeak7, TextToSpeech.QUEUE_FLUSH, null); 
	   }
	   else if(toSpeak.equalsIgnoreCase("Sutanu")){
		   String toSpeak8="O Hello "+editText.getText().toString()+" Kha."+"How are you? I know you.You are the college friend of my creator.You live in Howrah.Your college roll no. is 1 6 2 3 1 0 6";
		   Toast.makeText(getApplicationContext(), toSpeak8,Toast.LENGTH_LONG).show();       
		   tts.speak(toSpeak8, TextToSpeech.QUEUE_FLUSH, null);
	   }
	   else if(toSpeak.equalsIgnoreCase("Vaibhav")){
		   String toSpeak9="O Hello "+editText.getText().toString()+" Gupta."+"How are you? I know you.You are the college friend of my creator.Your nickname is Veb.You are my creator's group member in practical classes.Your college roll no. is 1 6 2 3 1 1 3.";
		   Toast.makeText(getApplicationContext(), toSpeak9,Toast.LENGTH_LONG).show();       
		   tts.speak(toSpeak9, TextToSpeech.QUEUE_FLUSH, null); 
	   }
	   //Questions that can be asked
	   else if(toSpeak.equalsIgnoreCase("Who are you?")||(toSpeak.equalsIgnoreCase("Who are you"))){
		   String toSpeak1_1="O Hello,I am an android application named Search created by Arnab Mitra, built on eclipse IDE and my support extends from android 4.0 (API 14) to android 4.4 (API 19)";
		   Toast.makeText(getApplicationContext(), toSpeak1_1,Toast.LENGTH_LONG).show();       
		   tts.speak(toSpeak1_1, TextToSpeech.QUEUE_FLUSH, null);
	   }
	   else if(toSpeak.equalsIgnoreCase("What is android?")||toSpeak.equalsIgnoreCase("What do you mean by android?")){
		   String toSpeak1_2="O Hello,Android is an advanced operating system developed upon the Linux kernel , marketed and owned by Google.Android runs on mobiles , tablets , TVs , wearables and cars .Andy Rubin is the father and creator of the Android operating system.";
		   Toast.makeText(getApplicationContext(), toSpeak1_2,Toast.LENGTH_LONG).show();       
		   tts.speak(toSpeak1_2, TextToSpeech.QUEUE_FLUSH, null);
	   }
	   else if(toSpeak.equalsIgnoreCase("What can you do for me?")||toSpeak.equalsIgnoreCase("What can you do for me")){
		   String toSpeak1_3="I can do many things for you I can tell your info if you write your name in the text field also if you write an element I can provide the details of the element";
		   Toast.makeText(getApplicationContext(), toSpeak1_3,Toast.LENGTH_LONG).show();       
		   tts.speak(toSpeak1_3, TextToSpeech.QUEUE_FLUSH, null);
	   }
	   else if(toSpeak.equalsIgnoreCase("Who am I?")||toSpeak.equalsIgnoreCase("Who am I")||(toSpeak.equalsIgnoreCase("Who am i?"))||(toSpeak.equalsIgnoreCase("Who am i"))||(toSpeak.equalsIgnoreCase("who am i?"))||(toSpeak.equalsIgnoreCase("who am i"))){
		   String toSpeak1_4="I may or may not know you if you please enter your name in the text field then I can tell about you";
		   Toast.makeText(getApplicationContext(), toSpeak1_4,Toast.LENGTH_LONG).show();       
		   tts.speak(toSpeak1_4, TextToSpeech.QUEUE_FLUSH, null);
	   }
	   //Elements of Periodic Table
	   else if(toSpeak.equalsIgnoreCase("Hydrogen")||toSpeak.equalsIgnoreCase("What do you know about hydrogen?")){
		   String toSpeak2_1=editText.getText().toString()+" is a Group-1 Period-1 element having atomic number-1 and mass number-1 and has a valency of +1 and has three isotopes named Protium, Deuterium and Tritium.";
		   Toast.makeText(getApplicationContext(), toSpeak2_1,Toast.LENGTH_LONG).show();       
		   tts.speak(toSpeak2_1, TextToSpeech.QUEUE_FLUSH, null);
	   }
	   else if(toSpeak.equalsIgnoreCase("Lithium")||toSpeak.equalsIgnoreCase("What do you know about Lithium?")){
		   String toSpeak2_2=editText.getText().toString()+" is a Group-1 Period-2 element having atomic number-3 and mass number-5 and has a valency of +1";
		   Toast.makeText(getApplicationContext(), toSpeak2_2,Toast.LENGTH_LONG).show();       
		   tts.speak(toSpeak2_2, TextToSpeech.QUEUE_FLUSH, null);
	   }
	   else if(toSpeak.equalsIgnoreCase("Helium")){
		   String toSpeak2_3="This information is not available right now, stay tuned for more.";
		   Toast.makeText(getApplicationContext(), toSpeak2_3,Toast.LENGTH_LONG).show();       
		   tts.speak(toSpeak2_3, TextToSpeech.QUEUE_FLUSH, null);
	   }
	   else if(toSpeak.equalsIgnoreCase("Beryllium")){
		   String toSpeak2_4=" This information is not available right now, stay tuned for more";
		   Toast.makeText(getApplicationContext(), toSpeak2_4,Toast.LENGTH_LONG).show();       
		   tts.speak(toSpeak2_4, TextToSpeech.QUEUE_FLUSH, null);
	   }
	   else{
		   String toSpeak16="O Hello you must be one of the acquaintances or friends of Arnab Mitra.Sorry your name "+editText.getText().toString()+" is not listed for any voice outputs or this information you want is not available in the database right now.";
		   Toast.makeText(getApplicationContext(), toSpeak16,Toast.LENGTH_LONG).show();       
		   tts.speak(toSpeak16, TextToSpeech.QUEUE_FLUSH, null);
	   }
   }
	   @SuppressWarnings("unused")
	private void loadSpinnerData(){
		   //Data for speed Spinner
		   List<String> lables=new ArrayList<String>();
		   lables.add("Very Slow");
		   lables.add("Slow");
		   lables.add("Normal");
		   lables.add("Fast");
		   lables.add("Very Fast");
		   
		   //Creating adapter for spinner
		   ArrayAdapter<String> dataAdapter=new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,lables);
		   
		   //Dropdown layout style_list view with radio button
		   dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		   
		   //attaching data adapter to spinner
		   speedSpinner.setAdapter(dataAdapter);
	   }
	   @Override
	   public void onItemSelected(AdapterView<?> parent,View view,int position,long id){
		  //On selecting a spinner item
		   speed=parent.getItemAtPosition(position).toString();
		   Toast.makeText(parent.getContext(), "You Selected:"+speed, Toast.LENGTH_LONG).show();
	   }
	   @Override
	   public void onNothingSelected(AdapterView<?> arg0){
	   }
	   
	   public Spinner getPitchSpinner() {
			return pitchSpinner;
		}


		public void setPitchSpinner(Spinner pitchSpinner) {
			this.pitchSpinner = pitchSpinner;
		}

   }
	   
 


