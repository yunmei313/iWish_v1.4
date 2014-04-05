package com.loop;

import java.util.ArrayList;
import java.util.List;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ListView;

public class MainViewActivity extends Activity {

	private static final int REQUEST_ADD_WISH = 11;
	
	private ListView lv ;
	private Button btn;
	private MyAdapter adapter = null;
	private List<WishData> wishList;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main_view);
		setTitle(getResources().getString(R.string.app_name));
		initView();
	}

	private void initView() {
		wishList = new ArrayList<WishData>();
		lv = (ListView) findViewById(R.id.listView_Main);
		btn	= (Button) findViewById(R.id.button_MainButton_AddWish);
		initWithFakeData();
		adapter = new MyAdapter(this, wishList);
		lv.setAdapter(adapter);
		btn.setOnClickListener(addBtnListener);
	}
	
	private void initWithFakeData(){
		FakeDatas fakeDatas = new FakeDatas();
		WishData data = new WishData();
		int i, dataCount = fakeDatas.getDataCount();
		for (i = 0; i < dataCount; i++) {
			data = new WishData();
			data.setWishName(fakeDatas.getTitle()[i]);
			data.setWishNote(fakeDatas.getSubTitle()[i]);
			wishList.add(data);
		}
	}
	private OnClickListener addBtnListener = new OnClickListener() {
		
		@Override
		public void onClick(View v) {
			Intent intent = new Intent();
			intent.setClass( MainViewActivity.this, Add.class );
            startActivityForResult(intent, REQUEST_ADD_WISH);
		}
	};
	
	private void refresh() {
		adapter.notifyDataSetChanged();
	}
	
	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		super.onActivityResult(requestCode, resultCode, data);
		if (requestCode == REQUEST_ADD_WISH && resultCode == Activity.RESULT_OK) {
			WishData newData = new WishData();
			newData.setWishName(data.getExtras().get(Add.BUNDLE_NAME).toString());
			newData.setWishNote(data.getExtras().get(Add.BUNDLE_NOTE).toString());
			wishList.add(newData);
			refresh();
		}
	}

}
