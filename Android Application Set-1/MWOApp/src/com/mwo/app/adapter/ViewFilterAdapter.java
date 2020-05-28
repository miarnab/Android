package com.mwo.app.adapter;

import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONObject;

import com.mwo.app.MyApp;
import com.mwo.app.R;
import com.mwo.app.fragments.ProductServiceDescriptionFragment;
import com.mwo.app.fragments.SearchAvailablityFragment;
import com.mwo.app.fragments.ripple.MaterialRippleLayout;
import com.mwo.app.fragments.ripple.RippleView;
import com.mwo.app.objectdata.AppData;
import com.mwo.app.shoppingcart.CatalogActivity;
import com.squareup.picasso.Picasso;






import android.app.Activity;
import android.app.Dialog;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.session.MediaController;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.sax.StartElementListener;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.VideoView;
import android.widget.RatingBar.OnRatingBarChangeListener;

public class ViewFilterAdapter extends ArrayAdapter<String> {
	
	Typeface headerface;
	ArrayList<String> cIdArr = new ArrayList<String>();
	ArrayList<String> cNameArr = new ArrayList<String>();
	ArrayList<String> cDesArr = new ArrayList<String>();
	ArrayList<String> cImageArr = new ArrayList<String>();
	private  Activity context;
	private int lastPosition = -1;
	private FragmentManager fmgCommnet;
AppData gObject; 
	RatingBar ratingBar;
	
	//String name2[]={"Event Service","Home Services"};
	public ViewFilterAdapter(Activity context,ArrayList<String>idLs,ArrayList<String>nameLs,ArrayList<String>desLs,ArrayList<String>imgLs,FragmentManager fmg) {
		super(context, R.layout.mylist,idLs);
		// TODO Auto-generated constructor stub
		this.context=context;
		
		cIdArr=idLs;
		cNameArr=nameLs;
		cDesArr=desLs;
		cImageArr=imgLs;
		this.fmgCommnet=fmg;
		
		headerface = Typeface.createFromAsset(context.getAssets(), "fonts/header_font.ttf");
		gObject=(AppData)context.getApplicationContext();
		}

@Override
public View getView(final int position, View convertView, ViewGroup parent) {
	LayoutInflater inflater=context.getLayoutInflater();
	View rowView=inflater.inflate(R.layout.filterview_row, null,true);
	TextView productname=(TextView)rowView.findViewById(R.id.prodctname);
	TextView adcutry=(TextView)rowView.findViewById(R.id.adcutry);
	//TextView adv=(TextView)rowView.findViewById(R.id.adv);
	
	// Image on Click Ripple Animat
	
   
	
	// ListView Animat
	
	Animation animation = AnimationUtils.loadAnimation(getContext(), (position > lastPosition) ? R.anim.up_from_bottom : R.anim.down_from_top);
	rowView.startAnimation(animation);
    lastPosition = position;
	
	
	  ratingBar = (RatingBar)rowView.findViewById(R.id.ratingbar);
	  ratingBar.setOnRatingBarChangeListener(new OnRatingBarChangeListener() {

			@Override
			public void onRatingChanged(RatingBar ratingBar, float rating,
					boolean fromUser) {
				
			

			}
		});
      
	  ImageView img=(ImageView)rowView.findViewById(R.id.img);
	productname.setText(cNameArr.get(position));
	
	productname.setTypeface(headerface);
	
//http://104.238.93.150/~appdevelopment/testapi/image/greenvag.jpg

	try {
		Picasso.with(context)
		.load("http://104.238.93.150/~appdevelopment/testapi/image/"+cImageArr.get(position))
		.placeholder(R.drawable.ic_launcher) // optional
		.error(R.drawable.ic_launcher)         // optional
		.into(img);
	} catch (Exception e) {
	    // TODO: handle exception
	}
	
	
	img.setOnClickListener(new View.OnClickListener() {
		
		@Override
		public void onClick(View arg0) {
			// TODO Auto-generated method stub
			
			
			gObject.setFalgcheck(true);
			
		//	String msg=cIdArr.get(position);
			gObject.setCatIdSelected(cIdArr.get(position));
			gObject.setCatgeName(cNameArr.get(position));
			//gObject.setCatIdSelected(cIdArr.get(position));
			Intent catpage=new Intent(context, CatalogActivity.class);
			catpage.putExtra("id",cIdArr.get(position));
			context.startActivity(catpage);
//			Fragment f = new SearchAvailablityFragment();
//			fragmentCall(f,msg);
			
		}
	});
	return rowView;
}
public void fragmentCall(Fragment fm,String message)
{
	//Fragment frag=new FragmentClassName
	
	
	Bundle bundle = new Bundle();
	bundle.putString("id", ""+message);
	fm.setArguments(bundle);
	
	fmgCommnet.beginTransaction()
			                   .replace(R.id.frame_container, fm)
			                   .commit();
}






}
