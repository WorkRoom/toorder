package com.zykj.toorder.activity;

import android.os.Bundle;

import com.zykj.toorder.BaseActivity;
import com.zykj.toorder.R;
import com.zykj.toorder.view.MyCommonTitle;

public class UserRegisterNextActivity extends BaseActivity {
	private MyCommonTitle myCommonTitle;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.ui_user_register_next);
		initView();
	}
	private void initView() {
		myCommonTitle=(MyCommonTitle) findViewById(R.id.aci_mytitle);
		myCommonTitle.setTitle("完善资料");
		myCommonTitle.setBackEditTitle("上一步");
	}

}
