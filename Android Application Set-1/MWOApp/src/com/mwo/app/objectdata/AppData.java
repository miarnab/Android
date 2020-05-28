package com.mwo.app.objectdata;

import java.util.ArrayList;

import android.app.Application;
import android.app.ProgressDialog;
import android.content.Context;
import android.view.Window;
import android.widget.Toast;

public class AppData extends Application{
	
	public static String serverBaseUrl="http://104.238.93.150/~appdevelopment/testapi/";
	public static String loginUrl=serverBaseUrl+"login_user.php";
	public static String signUpUrl=serverBaseUrl+"register_user.php";
	public static String catUrl=serverBaseUrl+"getCat.php";
	public static String subCatUrl=serverBaseUrl+"getSubcat.php";
	
	
	//User Info gettter setter
	
	private String firstName;
	private String lastName;
	private String email;
	private String userName;
	private String password;
	private String profileImage;
	private String bookinHour;
	
//***************************************
	String catIdSelected;
	String catgeName;
	//**********************booking******************
	
	String hotelId,roomId,amount,bookfrom,bookto;
			
	//*****************************************
	//ArraryLisy Category all
	
	ArrayList<String>catNameList=new ArrayList<String>();
	ArrayList<String>imagCatList=new ArrayList<String>();
	ArrayList<String>rsCatList=new ArrayList<String>();
	
	boolean falgcheck=false;
	
	
	public boolean isFalgcheck() {
		return falgcheck;
	}

	public void setFalgcheck(boolean falgcheck) {
		this.falgcheck = falgcheck;
	}

	public String getCatgeName() {
		return catgeName;
	}

	public void setCatgeName(String catgeName) {
		this.catgeName = catgeName;
	}

	public ArrayList<String> getCatNameList() {
		return catNameList;
	}

	public void setCatNameList(ArrayList<String> catNameList) {
		this.catNameList = catNameList;
	}

	public ArrayList<String> getImagCatList() {
		return imagCatList;
	}

	public void setImagCatList(ArrayList<String> imagCatList) {
		this.imagCatList = imagCatList;
	}

	public ArrayList<String> getRsCatList() {
		return rsCatList;
	}

	public void setRsCatList(ArrayList<String> rsCatList) {
		this.rsCatList = rsCatList;
	}

	public String getHotelId() {
		return hotelId;
	}

	public String getCatIdSelected() {
		return catIdSelected;
	}

	public void setCatIdSelected(String catIdSelected) {
		this.catIdSelected = catIdSelected;
	}

	public String getBookinHour() {
		return bookinHour;
	}

	public void setBookinHour(String bookinHour) {
		this.bookinHour = bookinHour;
	}

	public void setHotelId(String hotelId) {
		this.hotelId = hotelId;
	}

	public String getRoomId() {
		return roomId;
	}

	public void setRoomId(String roomId) {
		this.roomId = roomId;
	}

	public String getAmount() {
		return amount;
	}

	public void setAmount(String amount) {
		this.amount = amount;
	}

	public String getBookfrom() {
		return bookfrom;
	}

	public void setBookfrom(String bookfrom) {
		this.bookfrom = bookfrom;
	}

	public String getBookto() {
		return bookto;
	}

	public void setBookto(String bookto) {
		this.bookto = bookto;
	}

	private String uId;

	public String getuId() {
		return uId;
	}

	public void setuId(String uId) {
		this.uId = uId;
	}
	
	
	
	
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getProfileImage() {
		return profileImage;
	}

	public void setProfileImage(String profileImage) {
		this.profileImage = profileImage;
	}

	public static ProgressDialog ProgressStatus(Context context)
	{
		ProgressDialog statusPro=new ProgressDialog(context);
		statusPro.requestWindowFeature(Window.FEATURE_NO_TITLE);
		statusPro.setMessage("Please wait...");
		statusPro.show();
		return statusPro;
	}
	
	public static void gToast(Context c,String msg)
	{
		Toast.makeText(c, ""+msg, Toast.LENGTH_LONG).show();
	}

	
	
	
int counterNo=0;
	
	String numberOfcounter;

	public String getNumberOfcounter() {
		return numberOfcounter;
	}

	public void setNumberOfcounter(String numberOfcounter) {
		this.numberOfcounter = numberOfcounter;
	}

	public int getCounterNo() {
		return counterNo;
	}

	public void setCounterNo(int counterNo) {
		this.counterNo = counterNo+1;
	}
}
