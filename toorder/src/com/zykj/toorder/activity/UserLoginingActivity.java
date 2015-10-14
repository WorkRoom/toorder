package com.zykj.toorder.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.zykj.toorder.BaseActivity;
import com.zykj.toorder.R;
import com.zykj.toorder.view.MyCommonTitle;

public class UserLoginingActivity extends BaseActivity {
	private MyCommonTitle myCommonTitle;
	private Handler mHandler;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

	setContentView(R.layout.ui_user_logining);
	 mHandler=new Handler();
	
	myCommonTitle=(MyCommonTitle) findViewById(R.id.aci_mytitle);
	myCommonTitle.setLisener(null, this, null);
	myCommonTitle.setTitle("登录");
	myCommonTitle.setEditTitle("登录");
	
	mHandler.postDelayed(new Runnable() {
		
		@Override
		public void run() {
			startActivity(new Intent(UserLoginingActivity.this, MainActivity.class));
		}
	}, 1000);
	
	}
}
