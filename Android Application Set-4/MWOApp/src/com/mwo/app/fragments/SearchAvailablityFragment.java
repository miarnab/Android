package com.mwo.app.fragments;

import java.util.ArrayList;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONArray;
import org.json.JSONObject;

import com.mwo.app.R;
import com.mwo.app.CustomHttpClient;
import com.mwo.app.HomeActivity;
import com.mwo.app.LoginActivity;
import com.mwo.app.adapter.SearchAvailablityAdapter;
import com.mwo.app.adapter.ViewFilterAdapter;
import com.mwo.app.objectdata.AppData;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

public class SearchAvailablityFragment extends Fragment {

String CatId;
	ArrayList<String>subId=new ArrayList<String>();
	ArrayList<String>subName=new ArrayList<String>();
	ArrayList<String>cId=new ArrayList<String>();
	ArrayList<String>subPrice=new ArrayList<String>();
	ArrayList<String>subAvailable=new ArrayList<String>();
	
	FragmentManager fmg;
	ListView searchAvailablity;
	AppData gObject;
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View root = inflater.inflate(R.layout.search_availablity_fragment, null);
		gObject=(AppData)getActivity().getApplicationContext();
		
		searchAvailablity=(ListView)root.findViewById(R.id.searchLs);
		CatId= getArguments().getString("id");  
		new ListSearchAsyc(CatId).execute();
	        return root;
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
			pd=AppData.ProgressStatus(getActivity());
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

			fmg = getFragmentManager();

			SearchAvailablityAdapter adapter1 = new SearchAvailablityAdapter(getActivity(),
					subId, subName, cId,subPrice,subAvailable, fmg);
			searchAvailablity.setAdapter(adapter1);
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
	}
}
