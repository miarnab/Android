package com.mwo.app.fragments;

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
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.LinearLayout.LayoutParams;

public class ContactUsFragment extends Fragment {
	int NUM_PAGES = 4;
	int currentPage = 0;
	Timer swipeTimer;
	ViewPager viewPager;
	FragmentManager fmg;
	MyPagerAdapter myPagerAdapter;
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View root = inflater.inflate(R.layout.contactus_fragment, null);
		
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

		int[] res = { R.drawable.greenvag, R.drawable.ic_launcher, R.drawable.greenvag,
				R.drawable.greenvag, R.drawable.ic_launcher, };
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


	 
	
}
