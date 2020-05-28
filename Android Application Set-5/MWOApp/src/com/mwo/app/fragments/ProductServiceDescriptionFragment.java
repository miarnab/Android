package com.mwo.app.fragments;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

import com.mwo.app.R;


import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.graphics.Typeface;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.LinearLayout.LayoutParams;

public class ProductServiceDescriptionFragment extends Fragment implements OnClickListener {
	
	String optArr[]={"1","2","3","4","5"};
	String optArr1[]={"1","2","3","4"};
	//ViewPager Instatnce;
	Spinner contry,catg;
			int NUM_PAGES = 4;
			int currentPage = 0;
			Timer swipeTimer;
			ViewPager viewPager;
			FragmentManager fmg;
			MyPagerAdapter myPagerAdapter;
	Button bookingbtn;
	Typeface headerface,cntenttext;
	TextView labletxt,labletxt1,labletxt2,labletxt3,labletxt8;
	RadioButton labletxt4,labletxt5,labletxt6;
	CheckBox checkterms;
	 String CatId;
			//------------------------------------
	
			TextView raund1,raund2,raund3,raund4;
			
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View root = inflater.inflate(R.layout.product_services_des, null);
		
		
		cntenttext = Typeface.createFromAsset(getActivity().getAssets(), "fonts/content_text.ttf");
		headerface = Typeface.createFromAsset(getActivity().getAssets(), "fonts/header_font.ttf");
		labletxt=(TextView)root.findViewById(R.id.labletxt);
		labletxt1=(TextView)root.findViewById(R.id.labletxt1);
		labletxt2=(TextView)root.findViewById(R.id.labletxt2);
		labletxt3=(TextView)root.findViewById(R.id.labletxt3);
		labletxt8=(TextView)root.findViewById(R.id.labletxt8);
		labletxt4=(RadioButton)root.findViewById(R.id.labletxt4);
		labletxt5=(RadioButton)root.findViewById(R.id.labletxt5);
		
		labletxt6=(RadioButton)root.findViewById(R.id.labletxt6);
		checkterms=(CheckBox)root.findViewById(R.id.checkterms);
		
		labletxt.setTypeface(cntenttext);
		labletxt1.setTypeface(cntenttext);
		labletxt2.setTypeface(cntenttext);
		labletxt3.setTypeface(cntenttext);
		labletxt4.setTypeface(cntenttext);
		labletxt5.setTypeface(cntenttext);
		labletxt6.setTypeface(cntenttext);
		labletxt8.setTypeface(cntenttext);
		checkterms.setTypeface(headerface);
		
		
		
		// TextView Ovel shape selecte room 
		bookingbtn=(Button)root.findViewById(R.id.bookingbtn);
		bookingbtn.setTypeface(headerface);
		raund1=(TextView)root.findViewById(R.id.raund11);
		raund2=(TextView)root.findViewById(R.id.raund21);
		raund3=(TextView)root.findViewById(R.id.raund31);
		raund4=(TextView)root.findViewById(R.id.raund41);
		raund1.setOnClickListener(this);
		raund2.setOnClickListener(this);
		raund3.setOnClickListener(this);
		raund4.setOnClickListener(this);
		bookingbtn.setOnClickListener(this);
		
		
		contry=(Spinner)root.findViewById(R.id.person);
		catg=(Spinner)root.findViewById(R.id.roomselect);
		ArrayAdapter aa = new ArrayAdapter(getActivity(),android.R.layout.simple_spinner_item,optArr);  
        aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);  
        //Setting the ArrayAdapter data on the Spinner  
        contry.setAdapter(aa);
        ArrayAdapter aa1 = new ArrayAdapter(getActivity(),android.R.layout.simple_spinner_item,optArr1);  
        aa1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item); 
        catg.setAdapter(aa1);
        //Setting the ArrayAdapter data on the Spinner  
		
		// Viewpager impl;imentation here
		
				viewPager = (ViewPager) root.findViewById(R.id.myviewpager_product_details);
				myPagerAdapter = new MyPagerAdapter();
				viewPager.setAdapter(myPagerAdapter);
			
				final Handler handler = new Handler();

				final Runnable Update = new Runnable() {
					public void run() {
						if (currentPage == NUM_PAGES - 1) {
							currentPage = 0;
						}
						viewPager.setCurrentItem(currentPage++, true);
						
					}
				};

				swipeTimer = new Timer();
				swipeTimer.schedule(new TimerTask() {

					@Override
					public void run() {
						handler.post(Update);
					}
				}, 1000, 2000);

				viewPager.setOnPageChangeListener(new OnPageChangeListener() {

					@Override
					public void onPageSelected(int arg0) {
						// TODO Auto-generated method stub

					}

					@Override
					public void onPageScrolled(int arg0, float arg1, int arg2) {
						// TODO Auto-generated method stub

					}

					@Override
					public void onPageScrollStateChanged(int arg0) {
						// TODO Auto-generated method stub

					}
				});
		
		return root;
	}
	
	
	
	
	/*
	 * ViewPager Adapter
	 */
	private class MyPagerAdapter extends PagerAdapter {

		int NumberOfPages = 5;

		int[] res = { R.drawable.htl, R.drawable.hotel1, R.drawable.hotel2,
				R.drawable.htl, R.drawable.hotel1, };
		int[] backgroundcolor = { 0xFF101010, 0xFF202020, 0xFF303030,
				0xFF404040, 0xFF505050 };

		@Override
		public int getCount() {
			return NumberOfPages;
		}

		@Override
		public boolean isViewFromObject(View view, Object object) {
			return view == object;
		}

		@Override
		public Object instantiateItem(ViewGroup container, int position) {

			ImageView imageView = new ImageView(getActivity());
			imageView.setScaleType(ImageView.ScaleType.FIT_XY);
			imageView.setImageResource(res[position]);
			LayoutParams imageParams = new LayoutParams(
					LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT);
			imageView.setLayoutParams(imageParams);

			LinearLayout layout = new LinearLayout(getActivity());
			layout.setOrientation(LinearLayout.VERTICAL);
			LayoutParams layoutParams = new LayoutParams(
					LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT);
			layout.setBackgroundColor(backgroundcolor[position]);
			layout.setLayoutParams(layoutParams);

			layout.addView(imageView);

			container.addView(layout);
			return layout;
		}

		@Override
		public void destroyItem(ViewGroup container, int position, Object object) {
			container.removeView((LinearLayout) object);

		}

	}




	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub

		if(v.getId()==R.id.raund11)
		{
			
			raund1.setBackgroundResource(R.drawable.room_select_rand_color);
			raund2.setBackgroundResource(R.drawable.defaul_room_color);
			raund3.setBackgroundResource(R.drawable.defaul_room_color);
			raund4.setBackgroundResource(R.drawable.defaul_room_color);
			
		}
		else if(v.getId()==R.id.raund21)
		{
			
			raund1.setBackgroundResource(R.drawable.defaul_room_color);
			raund2.setBackgroundResource(R.drawable.room_select_rand_color);
			raund3.setBackgroundResource(R.drawable.defaul_room_color);
			raund4.setBackgroundResource(R.drawable.defaul_room_color);
			
			
		}
		else if(v.getId()==R.id.raund31)
		{
			raund1.setBackgroundResource(R.drawable.defaul_room_color);
			raund2.setBackgroundResource(R.drawable.defaul_room_color);
			raund3.setBackgroundResource(R.drawable.room_select_rand_color);
			raund4.setBackgroundResource(R.drawable.defaul_room_color);
			
			
		}
		else if(v.getId()==R.id.raund41)
		{
			raund1.setBackgroundResource(R.drawable.defaul_room_color);
			raund2.setBackgroundResource(R.drawable.defaul_room_color);
			raund3.setBackgroundResource(R.drawable.defaul_room_color);
			raund4.setBackgroundResource(R.drawable.room_select_rand_color);
			
			
		}
		else if(v.getId()==R.id.bookingbtn)
		{
			Fragment f=new SendFragment();
			fragmentCall(f);
			
			
		}
	}
	public void fragmentCall(Fragment fm)
	{
		//Fragment frag=new FragmentClassName
				 getFragmentManager().beginTransaction()
				                   .replace(R.id.frame_container, fm)
				                   .commit();
	}
}
