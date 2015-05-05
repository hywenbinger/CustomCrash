package com.example.crash;

import java.util.LinkedList;
import java.util.List;

import android.app.Activity;
import android.app.Application;

public class CrashApplication extends Application {
	
	private List<Activity> mActivityList = new LinkedList<Activity>();
	
	private static CrashApplication crashApplication;

	public static CrashApplication getInstance() {
		return crashApplication;
	}
	@Override
	public void onCreate() {
		super.onCreate();
		crashApplication = this;
		CustomCrashHandler mCustomCrashHandler = CustomCrashHandler.getInstance();
		mCustomCrashHandler.setCustomCrashHanler(getApplicationContext());
	}
	/**
	 * 添加Activity实例到mActivityList中，在onCreate()中调用
	 * @param activity
	 */
	public void addActivity(Activity activity){
		mActivityList.add(activity);
	}
	/**
	 * 从容器中删除多余的Activity实例，在onDestroy()中调用
	 * @param activity
	 */
	public void delActivity(Activity activity){
		mActivityList.remove(activity);
	}
	/**
	 * 退出程序的方法
	 */
	public void exit(){
		for(Activity activity : mActivityList){
			activity.finish();
		}
		System.exit(0);
	}
}