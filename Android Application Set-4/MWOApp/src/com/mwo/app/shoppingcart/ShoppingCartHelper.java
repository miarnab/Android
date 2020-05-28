package com.mwo.app.shoppingcart;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Vector;

import com.mwo.app.R;
import com.mwo.app.objectdata.AppData;


import android.content.Context;
import android.content.res.Resources;

public class ShoppingCartHelper {
	
	static Context contxt;
	public static final String PRODUCT_INDEX = "PRODUCT_INDEX";
	static AppData gObject;
	
	private static Map<Product, ShoppingCartEntry> cartMap = new HashMap<Product, ShoppingCartEntry>();

	
	public static List<Product> getCatalog(Resources res,Context c){
		  List<Product> catalog = null;
		if(catalog == null) {
			contxt=c;
			
			
			catalog = new Vector<Product>();
			 ArrayList<String>nlist=new ArrayList<String>();
			 ArrayList<String>price=new ArrayList<String>();
			 gObject=(AppData)contxt.getApplicationContext();
			nlist=gObject.getCatNameList();
			price=gObject.getRsCatList();
			
			for(int i=0;i<nlist.size();i++)
			{
				catalog.add(new Product(""+nlist.get(i), res
						.getDrawable(R.drawable.greenvag),
						"coming soon !!", Double.parseDouble(price.get(i))));
			}
			
			/*catalog.add(new Product("Dead or Alive", res
					.getDrawable(R.drawable.deadoralive),
					"Dead or Alive by Tom Clancy with Grant Blackwood", 29.99));
			catalog.add(new Product("Switch", res
					.getDrawable(R.drawable.switchbook),
					"Switch by Chip Heath and Dan Heath", 24.99));
			catalog.add(new Product("Watchmen", res
					.getDrawable(R.drawable.watchmen),
					"Watchmen by Alan Moore and Dave Gibbons", 14.99));
			catalog.add(new Product("NP mobile", res
					.getDrawable(R.drawable.mb),
					"This is Mobile of HTC Company in which have same good functionality like vide call 4G supported Availble in market  ", 5000));
			catalog.add(new Product("T-Shirts", res
					.getDrawable(R.drawable.ts),
					"Rebook brand T-shirts availble at market ", 500));
			catalog.add(new Product("Spaiker jeans", res
					.getDrawable(R.drawable.jns),
					"Spaiker brand Jeans availble at market ", 600));
			
			catalog.add(new Product("WINGS OF FIRE Book", res
					.getDrawable(R.drawable.apj),
					"WINGS OF FIRE Book written by Respected Dr.APJ Abadul kalam (Misil man) ", 100));*/
		}
		
		return catalog;
	}
	
	public static void setQuantity(Product product, int quantity) {
		// Get the current cart entry
		ShoppingCartEntry curEntry = cartMap.get(product);
		
		// If the quantity is zero or less, remove the products
		if(quantity <= 0) {
			if(curEntry != null)
				removeProduct(product);
			return;
		}
		
		// If a current cart entry doesn't exist, create one
		if(curEntry == null) {
			curEntry = new ShoppingCartEntry(product, quantity);
			cartMap.put(product, curEntry);
			return;
		}
		
		// Update the quantity
		curEntry.setQuantity(quantity);
	}
	
	public static int getProductQuantity(Product product) {
		// Get the current cart entry
		ShoppingCartEntry curEntry = cartMap.get(product);
		
		if(curEntry != null)
			return curEntry.getQuantity();
		
		return 0;
	}
	
	public static void removeProduct(Product product) {
		cartMap.remove(product);
	}
	
	public static List<Product> getCartList() {
		List<Product> cartList = new Vector<Product>(cartMap.keySet().size());
		for(Product p : cartMap.keySet()) {
			cartList.add(p);
		}
		
		return cartList;
	}
	

}
