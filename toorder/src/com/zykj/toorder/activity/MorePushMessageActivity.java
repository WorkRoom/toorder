package com.zykj.toorder.activity;

import android.os.Bundle;

import com.zykj.toorder.BaseActivity;
import com.zykj.toorder.R;
import com.zykj.toorder.view.MyCommonTitle;

public class MorePushMessageActivity extends BaseActivity {
	private MyCommonTitle myCommonTitle;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.ui_more_push_message);
		
		initView();
	}
	private void initView() {
		
		myCommonTitle=(MyCommonTitle) findViewById(R.id.aci_mytitle);
		myCommonTitle.setLisener(this, null, null);
		myCommonTitle.setTitle("消息推送");
		myCommonTitle.setBackEditTitle("更多");
		
	}

}
