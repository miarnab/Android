package com.mwo.app.fragments;

import com.mwo.app.R;

import android.app.Activity;
import android.app.Fragment;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

public class AccountFragment extends Fragment {

	Spinner contry;
	String optArr1[]={"Adhar card","PIN card","Voter ID","other"};
	TextView bookingtxt,bookingheader,bookingaddresstxt,address;
	Typeface headerface;
	TextView contactdetailstxt,puposebokingtxt,othertxt;
	TextView cntactsname,cntactsn,contactsmail;
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
			View root = inflater.inflate(R.layout.account_fragment, null);

			headerface = Typeface.createFromAsset(getActivity().getAssets(), "fonts/header_font.ttf");
			// creat id ----
			cntactsname=(TextView)root.findViewById(R.id.conatctname);
			cntactsn=(TextView)root.findViewById(R.id.conatctno);
			contactsmail=(TextView)root.findViewById(R.id.conatctmail);
			cntactsname.setTypeface(headerface);
			cntactsn.setTypeface(headerface);
			contactsmail.setTypeface(headerface);
			
			//-------------------------------------
			address=(TextView)root.findViewById(R.id.address);
			bookingheader=(TextView)root.findViewById(R.id.bookingheader);
			bookingaddresstxt=(TextView)root.findViewById(R.id.bookingaddresstxt);
			bookingtxt=(TextView)root.findViewById(R.id.bookingtxt);
		
			address.setTypeface(headerface);
			bookingheader.setTypeface(headerface);
			bookingaddresstxt.setTypeface(headerface);
			bookingtxt.setTypeface(headerface);
			
			contactdetailstxt=(TextView)root.findViewById(R.id.contactdetailstxt);
			puposebokingtxt=(TextView)root.findViewById(R.id.puposebokingtxt);
			othertxt=(TextView)root.findViewById(R.id.othertxt);
			
			contactdetailstxt.setTypeface(headerface);
			puposebokingtxt.setTypeface(headerface);
			othertxt.setTypeface(headerface);
		
			
			
			contry=(Spinner)root.findViewById(R.id.idprof);
			
			ArrayAdapter aa = new ArrayAdapter(getActivity(),android.R.layout.simple_spinner_item,optArr1);  
			aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);  
	     //Setting the ArrayAdapter data on the Spinner  
			contry.setAdapter(aa);
		
	     
	     
	     return root;
	    }
	 
	
}
