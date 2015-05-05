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
	 * ���Activityʵ����mActivityList�У���onCreate()�е���
	 * @param activity
	 */
	public void addActivity(Activity activity){
		mActivityList.add(activity);
	}
	/**
	 * ��������ɾ�������Activityʵ������onDestroy()�е���
	 * @param activity
	 */
	public void delActivity(Activity activity){
		mActivityList.remove(activity);
	}
	/**
	 * �˳�����ķ���
	 */
	public void exit(){
		for(Activity activity : mActivityList){
			activity.finish();
		}
		System.exit(0);
	}
}