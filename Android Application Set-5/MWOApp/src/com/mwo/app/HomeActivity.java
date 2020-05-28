package com.mwo.app;

import java.util.ArrayList;
import java.util.Arrays;

import com.mwo.app.R;
import com.mwo.app.adapter.CustomListAdapter;
import com.mwo.app.fragments.AboutUsFragment;
import com.mwo.app.fragments.AccountFragment;
import com.mwo.app.fragments.ContactUsFragment;
import com.mwo.app.fragments.FAQFragment;
import com.mwo.app.fragments.HomeFragment;
import com.mwo.app.fragments.MyBookingFragment;
import com.mwo.app.fragments.MyOfferFragment;
import com.mwo.app.fragments.ProfileFragment;
import com.mwo.app.fragments.CatgoryFragment;
import com.mwo.app.objectdata.AppData;
import com.mwo.app.shoppingcart.CatalogActivity;



import android.app.Activity;
import android.app.Fragment;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.PopupMenu;
import android.widget.TextView;

public class HomeActivity extends Activity implements OnClickListener {

	
	private ArrayList<String> menuList;
	private ImageView menuclick;
	private String[] menu;
	private Integer[] menuIcons;
	private DrawerLayout dLayout;
	private ImageView useronclick, sendsms;
	private ListView dList;
	private ImageView menuopt,homeimg;
	private LinearLayout viewTab,homeTab,guidTab,arouindMeTab,accountTab;
	private TextView hometxt,guidtxt,arondmetxt,accnttxt,viewtxt;
	private int pos;
	Typeface headingtxt;
	AppData gObject;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_main);
		gObject=(AppData)getApplicationContext();
		headingtxt = Typeface.createFromAsset(HomeActivity.this.getAssets(), "fonts/header_font.ttf");
		// bottom menu textView id Regiter here
		
		hometxt = (TextView) findViewById(R.id.hometxt);
		guidtxt = (TextView) findViewById(R.id.guidtxt);
		arondmetxt = (TextView) findViewById(R.id.aroundmetxt);
		accnttxt = (TextView) findViewById(R.id.accounttxt);
		viewtxt = (TextView) findViewById(R.id.viewtxt);
		
		hometxt.setTypeface(headingtxt);
		guidtxt.setTypeface(headingtxt);
		arondmetxt.setTypeface(headingtxt);
		accnttxt.setTypeface(headingtxt);
		viewtxt.setTypeface(headingtxt);
		
		
		// foter tab regiter here
		
		viewTab=(LinearLayout)findViewById(R.id.viewTab);
		homeTab=(LinearLayout)findViewById(R.id.homeTab);
		guidTab=(LinearLayout)findViewById(R.id.guidTab);
		arouindMeTab=(LinearLayout)findViewById(R.id.aroundMeTab);
		accountTab=(LinearLayout)findViewById(R.id.accountTab);
		
		viewTab.setOnClickListener(this);
		homeTab.setOnClickListener(this);
		guidTab.setOnClickListener(this);
		arouindMeTab.setOnClickListener(this);
		accountTab.setOnClickListener(this);
		
		//***************************************
		menuopt=(ImageView)findViewById(R.id.menuopt);
		homeimg=(ImageView)findViewById(R.id.homeimg);
		menuopt.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				
				 PopupMenu popup = new PopupMenu(HomeActivity.this, menuopt);  
		           
		            popup.getMenuInflater().inflate(R.menu.catopt, popup.getMenu());  
		         
		            popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {  
		             public boolean onMenuItemClick(MenuItem item) {  
		              //Toast.makeText(MainActivity.this,"You Clicked : " + ,Toast.LENGTH_SHORT).show();
		            	 
		            	 if(item.getTitle().equals("Signup"))
		            	 {
		            		
		            	 }
		            	 else if(item.getTitle().equals("LogOut"))
		            	 {
		            		 Intent i1 = new Intent(HomeActivity.this, LoginActivity.class);  
		 					i1.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
		 					i1.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP); // <= USE THIS
		 					startActivity(i1);
		            	 }
		            	
		            	 
		            	 
		              return true;  
		             }  
		            });  
		  
		            popup.show();
			
			
			
			}
		});






		
		@Override
		public void onClick(View arg0) {
			// TODO Auto-generated method stub
			 dLayout.openDrawer(Gravity.LEFT);
		}
		});

   lor(R.color.foter_menu_bg));
		}
		else if(v.getId()==R.id.homeTab)
		{
			
			 Fragment f=new ViewFragment();
			   fragmentCall(f);
			
			homeTab.setBackgroundColor(getResources().getColor(R.color.footer_tab_celected));
			viewTab.setBackgroundColor(getResources().getColor(R.color.foter_menu_bg));
			guidTab.setBackgroundColor(getResources().getColor(R.color.foter_menu_bg));
			arouindMeTab.setBackgroundColor(getResources().getColor(R.color.foter_menu_bg));
			accountTab.setBackgroundColor(getResources().getColor(R.color.foter_menu_bg));
		}
		else if(v.getId()==R.id.guidTab)
		{
			viewTab.setBackgroundColor(getResources().getColor(R.color.foter_menu_bg));
			homeTab.setBackgroundColor(getResources().getColor(R.color.foter_menu_bg));
			guidTab.setBackgroundColor(getResources().getColor(R.color.footer_tab_celected));
			arouindMeTab.setBackgroundColor(getResources().getColor(R.color.foter_menu_bg));
			accountTab.setBackgroundColor(getResources().getColor(R.color.foter_menu_bg));
		}
		else if(v.getId()==R.id.aroundMeTab)
		{
		
//			Fragment f=new AroundFragment();
//			fragmentCall(f);
//			viewTab.setBackgroundColor(getResources().getColor(R.color.foter_menu_bg));
//			homeTab.setBackgroundColor(getResources().getColor(R.color.foter_menu_bg));
//			guidTab.setBackgroundColor(getResources().getColor(R.color.foter_menu_bg));
//			arouindMeTab.setBackgroundColor(getResources().getColor(R.color.footer_tab_celected));
//			accountTab.setBackgroundColor(getResources().getColor(R.color.foter_menu_bg));
		}
		else if(v.getId()==R.id.accountTab)
		{
			Fragment f=new AccountFragment();
			fragmentCall(f);
			viewTab.setBackgroundColor(getResources().getColor(R.color.foter_menu_bg));
			homeTab.setBackgroundColor(getResources().getColor(R.color.foter_menu_bg));
			guidTab.setBackgroundColor(getResources().getColor(R.color.foter_menu_bg));
			arouindMeTab.setBackgroundColor(getResources().getColor(R.color.foter_menu_bg));
			accountTab.setBackgroundColor(getResources().getColor(R.color.footer_tab_celected));
		}
	*/}
}
