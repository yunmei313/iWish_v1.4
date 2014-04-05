package com.loop;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Add extends Activity {
	
	private static final String TAG = "loop.add";
	static final String BUNDLE_NAME = "name";
	static final String BUNDLE_NOTE = "note";
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.add);
		Button submitBtn, backBtn; 
		submitBtn = ((Button) findViewById(R.id.button_AddButton_Submit));
		backBtn = ((Button) findViewById(R.id.button_AddButton_WishList));
		
		if(submitBtn != null || backBtn == null){
			submitBtn.setOnClickListener(submitBtnListener);
			backBtn.setOnClickListener(wishListBtnListener);
		}else{
			Log.e(TAG, "btn is null!");
		}
	}
	
	private OnClickListener submitBtnListener = new OnClickListener() {
		
		@Override
		public void onClick(View v) {
			EditText wishName = (EditText) findViewById(R.id.editText_Add_Wish);
			EditText wishPrice = (EditText) findViewById(R.id.editText_Add_Price);			
			WishData newData;
			
			if(wishName == null || wishPrice == null){
				Log.e(TAG, "EditText is null!");
				return;
			}
			
			if (isStringEmpty(wishName.getText().toString()) || (isStringEmpty(wishPrice.getText().toString()))) {
				Toast.makeText(getApplicationContext(), R.string.add_prompt_input_somthing, Toast.LENGTH_LONG).show();
			} else {
				newData = new WishData();
				newData.setWishName(wishName.getText().toString());
				newData.setWishNote(wishPrice.getText().toString());
				Intent intent = new Intent();
				Bundle bundle = new Bundle();
				bundle.putString(BUNDLE_NAME, newData.getWishName());
				bundle.putString(BUNDLE_NOTE, newData.getWishNote());
				intent.putExtras(bundle);
				setResult(Activity.RESULT_OK, intent);
				finish();
			}
			
		}
		
		public boolean isStringEmpty(String str){
			if(str != null && !str.equals("")){
				return false;
			}
			return true;
		}
	};
	
	private OnClickListener wishListBtnListener = new OnClickListener() {
		
		@Override
		public void onClick(View v) {
			finish();
		}
	};
}
