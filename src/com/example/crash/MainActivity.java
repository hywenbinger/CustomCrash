package com.example.crash;

import com.example.crash.R;

import android.os.Bundle;
import android.app.Activity;

public class MainActivity extends Activity {
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		CrashApplication.getInstance().addActivity(MainActivity.this);
		int a = 3;
		int b = 0;
		System.out.println(a/b);
	}
	
	@Override
	protected void onDestroy() {
		// TODO Auto-generated method stub
		super.onDestroy();
		CrashApplication.getInstance().delActivity(MainActivity.this);
	}
}
