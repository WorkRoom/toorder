package com.zykj.toorder.activity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.zykj.toorder.BaseActivity;
import com.zykj.toorder.R;
import com.zykj.toorder.view.MyCommonTitle;
import com.zykj.toorder.view.MyMainCommonTitle;

public class ToOrderActivity extends BaseActivity {
	private MyMainCommonTitle myMainCommonTitle;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.ui_toorder);
		initView();
	}

	private void initView() {
		myMainCommonTitle=(MyMainCommonTitle) findViewById(R.id.aci_mymaintitle);
		myMainCommonTitle.setLisener(null, null, this, null);
		myMainCommonTitle.setTitle("叮当兔");
		myMainCommonTitle.setEditTitle("登陆");
	
	}
@Override
public void onClick(View view) {
	super.onClick(view);
	switch (view.getId()) {
	case R.id.aci_edit_btn:
		startActivity(new Intent(ToOrderActivity.this, UserLoginActivity.class));
		break;

	default:
		break;
	}
}
}
