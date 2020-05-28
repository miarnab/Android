package com.mwo.app.shoppingcart;

import java.util.List;

import com.mwo.app.R;
import com.squareup.picasso.Picasso;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class ProductAdapter extends BaseAdapter {

	private List<Product> mProductList;
	private LayoutInflater mInflater;
	private boolean mShowQuantity;
	Context c;

	public ProductAdapter(List<Product> list, LayoutInflater inflater, boolean showQuantity,Context ct) {
		mProductList = list;
		mInflater = inflater;
		mShowQuantity = showQuantity;
		c=ct;
	}

	@Override
	public int getCount() {
		return mProductList.size();
	}

	@Override
	public Object getItem(int position) {
		return mProductList.get(position);
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		final ViewItem item;

		if (convertView == null) {
			convertView = mInflater.inflate(R.layout.list_row, null);
			
			Animation animation = AnimationUtils.loadAnimation(c, (position > position) ? R.anim.up_from_bottom : R.anim.down_from_top);
			convertView.startAnimation(animation);
			
			item = new ViewItem();

			item.productImageView = (ImageView) convertView
					.findViewById(R.id.ImageViewItem);

			item.productTitle = (TextView) convertView
					.findViewById(R.id.TextViewItem);

			item.productQuantity = (TextView) convertView
					.findViewById(R.id.textViewQuantity);

			convertView.setTag(item);
		} else {
			item = (ViewItem) convertView.getTag();
		}

		Product curProduct = mProductList.get(position);

		item.productImageView.setImageDrawable(curProduct.productImage);
		item.productTitle.setText(curProduct.title);
		
		

		// Show the quantity in the cart or not
		if (mShowQuantity) {
			item.productQuantity.setText("Quantity: "
					+ ShoppingCartHelper.getProductQuantity(curProduct));
		} else {
			// Hid the view
			item.productQuantity.setVisibility(View.GONE);
		}

		return convertView;
	}

	private class ViewItem {
		ImageView productImageView;
		TextView productTitle;
		TextView productQuantity;
	}

}
