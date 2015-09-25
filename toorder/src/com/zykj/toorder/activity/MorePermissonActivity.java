package com.zykj.toorder.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Switch;

import com.zykj.toorder.BaseActivity;
import com.zykj.toorder.R;
import com.zykj.toorder.view.MyCommonTitle;

public class MorePermissonActivity extends BaseActivity {
	private MyCommonTitle myCommonTitle;
	
	private LinearLayout adminLayout;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.ui_more_permission_setting);
		
		initView();
		}
	private void initView() {
		myCommonTitle=(MyCommonTitle) findViewById(R.id.aci_mytitle);
		myCommonTitle.setLisener(this, this, null);
		myCommonTitle.setTitle("权限管理");
		myCommonTitle.setEditTitle("邀请用户");
		myCommonTitle.setBackEditTitle("更多");
		
		adminLayout=(LinearLayout) findViewById(R.id.admin);
		
		setListener(adminLayout);
		
	}
	@Override
	public void onClick(View view) {
		
		switch (view.getId()) {
		case R.id.admin:
			startActivity(new Intent(MorePermissonActivity.this, MoreAdminDetailsActivity.class));
			break;

		default:
			break;
		}
	}
	

}
