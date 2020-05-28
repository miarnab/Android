package com.mwo.app.shoppingcart;

import java.util.ArrayList;
import java.util.List;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONArray;
import org.json.JSONObject;

import com.mwo.app.CustomHttpClient;
import com.mwo.app.LoginActivity;
import com.mwo.app.R;
import com.mwo.app.SplashActivity;
import com.mwo.app.adapter.SearchAvailablityAdapter;
import com.mwo.app.objectdata.AppData;


import android.app.Activity;
import android.app.FragmentManager;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.TextView;

public class CatalogActivity extends Activity {

	TextView catName;
	String CatId;
	ArrayList<String>subId=new ArrayList<String>();
	ArrayList<String>subName=new ArrayList<String>();
	ArrayList<String>cId=new ArrayList<String>();
	ArrayList<String>subPrice=new ArrayList<String>();
	ArrayList<String>subAvailable=new ArrayList<String>();
	
	FragmentManager fmg;
	ListView searchAvailablity;
	AppData gObject;
	
	String value ;
	
	///////////////////////////////////////////
	private List<Product> mProductList;
	ListView listViewCatalog;
TextView cartno;
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.catalog);
		
		listViewCatalog= (ListView) findViewById(R.id.ListViewCatalog);
		gObject=(AppData)getApplicationContext();
		Bundle extras = getIntent().getExtras();
		if (extras != null) {
			value= extras.getString("id");
		}
		cartno=(TextView)findViewById(R.id.cartno);
		String idcat=gObject.getCatIdSelected();
		catName=(TextView)findViewById(R.id.TextView01);
		catName.setText(gObject.getCatgeName());
		
		new ListSearchAsyc(value).execute();
		
		
new Handler().postDelayed(new Runnable() {
            
            // Using handler with postDelayed called runnable run method
  
            @Override
            public void run() {
            	// Obtain a reference to the product catalog
        		mProductList = ShoppingCartHelper.getCatalog(getResources(),CatalogActivity.this);
        		
        		// Create the list
        		
        		listViewCatalog.setAdapter(new ProductAdapter(mProductList, getLayoutInflater(), false,CatalogActivity.this));
            }
        }, 1*1000);
		
		
		
		listViewCatalog.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view, int position,
					long id) {
				
				gObject.setFalgcheck(false);
				Intent productDetailsIntent = new Intent(getBaseContext(),ProductDetailsActivity.class);
				productDetailsIntent.putExtra(ShoppingCartHelper.PRODUCT_INDEX, position);
				startActivity(productDetailsIntent);
			}
		});
		
//		Button viewShoppingCart = (Button) findViewById(R.id.ButtonViewCart);
//		viewShoppingCart.setOnClickListener(new OnClickListener() {
//			
//			@Override
//			public void onClick(View v) {
//				Intent viewShoppingCartIntent = new Intent(getBaseContext(), ShoppingCartActivity.class);
//				startActivity(viewShoppingCartIntent);
//			}
//		});
//		
		ImageView viewShoppingCart = (ImageView) findViewById(R.id.ButtonViewCart1);
		viewShoppingCart.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent viewShoppingCartIntent = new Intent(getBaseContext(), ShoppingCartActivity.class);
				startActivity(viewShoppingCartIntent);
			}
		});
		
		    	//cartno.setText(""+ob.getCounterNo());
		  
	}
	
	
	
	class ListSearchAsyc extends AsyncTask<String, String, String>
	{

		String respo;
		ProgressDialog pd;
		String cIdstr;
		ListSearchAsyc(String catId)
		{
			cIdstr=catId;
		}
		@Override
		protected void onPreExecute() {
			// TODO Auto-generated method stub
			super.onPreExecute();
			pd=AppData.ProgressStatus(CatalogActivity.this);
		}
		@Override
		protected String doInBackground(String... params) {
			// TODO Auto-generated method stub
			try{
			String urlLogin=AppData.subCatUrl;
			ArrayList<NameValuePair> param = new ArrayList<NameValuePair>();
			param.add(new BasicNameValuePair("id", cIdstr));
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
			try{
			pd.dismiss();
			JSONArray jArr=new JSONArray(result);
			for(int index=0;index<jArr.length();index++)
			{
				JSONObject ArrJsonObject=jArr.getJSONObject(index);
				subId.add(ArrJsonObject.getString("subId"));
				subName.add(ArrJsonObject.getString("subName"));
				cId.add(ArrJsonObject.getString("cId"));
				subPrice.add(ArrJsonObject.getString("subPrice"));
				subAvailable.add(ArrJsonObject.getString("subAvailable"));
				
			}

			gObject.setCatNameList(subName);
			gObject.setRsCatList(subPrice);
		//	gObject.setCatNameList(subName);
			
			
			
			
			/*fmg = getFragmentManager();

			SearchAvailablityAdapter adapter1 = new SearchAvailablityAdapter(CatalogActivity.this,
					subId, subName, cId,subPrice,subAvailable, fmg);
			searchAvailablity.setAdapter(adapter1);*/
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
	}
	
	
	@Override
	public void onPause() {
	    super.onPause();  // Always call the superclass method first
	    new ListSearchAsyc(value).execute();
		
		
	    new Handler().postDelayed(new Runnable() {
	                
	                // Using handler with postDelayed called runnable run method
	      
	                @Override
	                public void run() {
	                	// Obtain a reference to the product catalog
	            		mProductList = ShoppingCartHelper.getCatalog(getResources(),CatalogActivity.this);
	            		
	            		// Create the list
	            		
	            		listViewCatalog.setAdapter(new ProductAdapter(mProductList, getLayoutInflater(), false,CatalogActivity.this));
	                }
	            }, 1*1000);
	  
	}
}