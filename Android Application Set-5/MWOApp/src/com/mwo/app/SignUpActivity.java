package com.mwo.app;


import java.util.ArrayList;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONObject;
import com.mwo.app.objectdata.AppData;
import com.mwo.app.HomeActivity;
import com.mwo.app.SignUpActivity;
import com.mwo.app.R;
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

public class SignUpActivity extends Activity {

	TextView tt;
	TextView regNow;
	Typeface headingtxt;
	EditText name,addrss,mob,mail,pass;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.signupactivity);
		name=(EditText)findViewById(R.id.name);
		addrss=(EditText)findViewById(R.id.address);
		mob=(EditText)findViewById(R.id.mob);
		mail=(EditText)findViewById(R.id.mail);
		pass=(EditText)findViewById(R.id.pass);
		regNow=(TextView)findViewById(R.id.regNow);
		regNow.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				new SignUpAsyc().execute();
			}
		});
		
	}

	
	

	class SignUpAsyc extends AsyncTask<String, String, String>
	{

		String respo;
		ProgressDialog pd;
		@Override
		protected void onPreExecute() {
			// TODO Auto-generated method stub
			super.onPreExecute();
			pd=AppData.ProgressStatus(SignUpActivity.this);
		}
		@Override
		protected String doInBackground(String... params) {
			// TODO Auto-generated method stub
			try{
			String signup=AppData.signUpUrl;
			
			ArrayList<NameValuePair> param = new ArrayList<NameValuePair>();
			param.add(new BasicNameValuePair("name", name.getText().toString()));
			
			param.add(new BasicNameValuePair("address", addrss.getText().toString()));
			param.add(new BasicNameValuePair("mobile", mob.getText().toString()));
			param.add(new BasicNameValuePair("email", mail.getText().toString()));
			param.add(new BasicNameValuePair("password", pass.getText().toString()));
		
			
			
			
			respo=CustomHttpClient.executeHttpPost(signup, param);
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
			try{
			pd.dismiss();
			JSONObject jObject=new JSONObject(result);
			String status=jObject.getString("response");
			if(status.equals("1"))
			{
				
				Intent sig=new Intent(SignUpActivity.this, LoginActivity.class);
				startActivity(sig);
				finish();
				AppData.gToast(SignUpActivity.this, "Successfully SignUp!");
			}
			else
			{
				String msg=jObject.getString("success");
				AppData.gToast(SignUpActivity.this, ""+msg);
			}
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
	}
	

}
