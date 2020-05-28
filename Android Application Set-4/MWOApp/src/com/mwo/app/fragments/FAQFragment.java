package com.mwo.app.fragments;

import com.mwo.app.R;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class FAQFragment extends Fragment implements OnClickListener{
	
	LinearLayout q1,lay1;
	ImageView arro;
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View root = inflater.inflate(R.layout.faq_fragment, null);
		q1=(LinearLayout)root.findViewById(R.id.q1);
		lay1=(LinearLayout)root.findViewById(R.id.lay1);
		arro=(ImageView)root.findViewById(R.id.arro);
		q1.setOnClickListener(this);
		
		return root;
	}
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
	
		if(v.getId()==R.id.q1)
		{
			lay1.setVisibility(View.VISIBLE);	
			arro.setImageResource(R.drawable.arrows_up);
		}
		
	}
}
