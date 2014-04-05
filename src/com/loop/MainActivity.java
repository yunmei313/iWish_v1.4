package com.loop;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Window;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_main);
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				try {
                    Thread.sleep(3000);
                    startActivity(new Intent(MainActivity.this, MainViewActivity.class));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
			}
		}).start();
		
	}

}
