package com.mwo.app.adapter;
 






import com.mwo.app.R;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
 
public class CustomListAdapter extends ArrayAdapter<String> {
 
Typeface headerface;
private View rowView;
private final Activity context;
private final String[] itemname;
private final Integer[] imgid;
public CustomListAdapter(Activity context, String[] itemname, Integer[] imgid) {
super(context, R.layout.mylist, itemname);
// TODO Auto-generated constructor stub
this.context=context;
this.itemname=itemname;
this.imgid=imgid;
headerface = Typeface.createFromAsset(context.getAssets(), "fonts/header_font.ttf");
}

public View getView(int position,View view,ViewGroup parent) {
	
	try{
LayoutInflater inflater=context.getLayoutInflater();
rowView=inflater.inflate(R.layout.mylist, null,true);
TextView txtTitle = (TextView) rowView.findViewById(R.id.Itemname);
txtTitle.setTypeface(headerface);
ImageView imageView = (ImageView) rowView.findViewById(R.id.icon);

txtTitle.setText(itemname[position]);
imageView.setImageResource(imgid[position]);
	}catch(Exception e){
		//crashreposrMail("getView Custome Adapter block"+e);
	}
return rowView;
};

public void crashreposrMail(String str){
	   
	   
	   Intent i = new Intent(Intent.ACTION_SEND);
	   i.setType("message/rfc822");
	   i.putExtra(Intent.EXTRA_EMAIL  , new String[]{"nirbhayiise@gmail.com"});
	   i.putExtra(Intent.EXTRA_SUBJECT, "ArpitAlbumCrashReport");
	   i.putExtra(Intent.EXTRA_TEXT   , str);
	   try {
	       context.startActivity(Intent.createChooser(i, "Send mail..."));
	   } catch (android.content.ActivityNotFoundException ex) {
	       Toast.makeText(context, "not send Crash Report.", Toast.LENGTH_SHORT).show();
	   }
	   
	   
}
}