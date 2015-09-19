package com.zykj.toorder.activity;

import java.util.Timer;
import java.util.TimerTask;

import android.content.Intent;
import android.os.Bundle;

import com.zykj.toorder.BaseActivity;
import com.zykj.toorder.BaseApp;
import com.zykj.toorder.utils.Tools;

import com.zykj.toorder.R;

public class Welcome extends BaseActivity {
	
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		//在使用SDK各组件之前初始化context信息，传入ApplicationContext
        //注意该方法要再setContentView方法之前实现
		initView(R.layout.ui_welcome);

		Timer timer = new Timer();
		TimerTask task = new TimerTask() {
			public void run() {
				String is_intro = getSharedPreferenceValue(BaseApp.IS_INTRO);
				boolean should_intro = false;
				int version = Tools.getAppVersion(Welcome.this);
				String save_version = getSharedPreferenceValue(BaseApp.VERSION);
				int save_version_int = save_version.equals("") ? -1 : Integer
						.parseInt(save_version);

				if (is_intro.length() > 0 && version == save_version_int) {// 已经进行过指引,且版本号符合
					should_intro = false;
				} else {
					should_intro = false;//true
				}

				if (should_intro) {
//					Intent intent = new Intent(Welcome.this, IntroActivity.class);
//					startActivity(intent);
				} else {
					Intent intent = new Intent(Welcome.this, MainActivity.class);
					startActivity(intent);
				}
				finish();

			}
		};
		timer.schedule(task, 2000);
	}
}
