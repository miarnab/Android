package com.mwo.app;


import java.util.ArrayList;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONArray;
import org.json.JSONObject;

import com.mwo.app.R;
import com.mwo.app.objectdata.AppData;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.EditText;
import android.widget.TextView;

public class LoginActivity extends Activity {

	TextView signbtn,loginbtn;
	TextView tt;
	Typeface headingtxt;
	EditText userName,pass;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.loginactivity);
		signbtn=(TextView)findViewById(R.id.signbtn);
		userName=(EditText)findViewById(R.id.username);
		pass=(EditText)findViewById(R.id.pass);
		
		
		signbtn.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent sig=new Intent(LoginActivity.this, SignUpActivity.class);
				startActivity(sig);
			}
		});
		
	loginbtn=(TextView)findViewById(R.id.loginbtn);
		loginbtn.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				new LoginAsyc().execute();
			}
		});
		
		
		userName.setHintTextColor(getResources().getColor(R.color.white));
		pass.setHintTextColor(getResources().getColor(R.color.white));
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
	class LoginAsync extends AsyncTask<String, String, String>
	{
@Override
protected void onPreExecute() {
	// TODO Auto-generated method stub
	super.onPreExecute();
}

		@Override
		protected String doInBackground(String... params) {
			// TODO Auto-generated method stub
			return null;
		}
		@Override
				protected void onPostExecute(String result) {
					// TODO Auto-generated method stub
					super.onPostExecute(result);
				}
	}
	
	
	class LoginAsyc extends AsyncTask<String, String, String>
	{

		String respo;
		ProgressDialog pd;
		@Override
		protected void onPreExecute() {
			// TODO Auto-generated method stub
			super.onPreExecute();
			pd=AppData.ProgressStatus(LoginActivity.this);
		}
		@Override
		protected String doInBackground(String... params) {
			// TODO Auto-generated method stub
			try{
			String urlLogin=AppData.loginUrl;
			
			
			ArrayList<NameValuePair> param = new ArrayList<NameValuePair>();
			param.add(new BasicNameValuePair("email", userName.getText().toString()));
			
			param.add(new BasicNameValuePair("password", pass.getText().toString()));
		
			
			
		//	String paramiters=""+userName.getText().toString()+"/"+pass.getText().toString()+"";
			respo=CustomHttpClient.executeHttpPost(urlLogin, param);
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			return respo;
		}
		@Override
		protected void onPostExecute(String result) {
			// TODO Auto-generated method stub
			super.onPostExecute(result);
			/*try{
			pd.dismiss();
			JSONObject jObject=new JSONObject(result);
			String status=jObject.getString("success");
			if(status.equals("1"))
			{
				
				
				Intent sig=new Intent(LoginActivity.this, HomeActivity.class);
				startActivity(sig);
				finish();
				
			}
			else
			{
				MyApp.gToast(LoginActivity.this, "Wrong credentials");
			}
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}*/
			
			
			try{
				JSONArray jObj=new JSONArray(result);
				int len=jObj.length();
				
				//String res=jObj.getString("");
				if(len==1)
				{
				
					
					
					Intent i = new Intent(LoginActivity.this, HomeActivity.class);
			        startActivity(i);
			        finish();
				}
				
				
			}catch(Exception e)
			{
				e.printStackTrace();
			}
		}
	}
}
