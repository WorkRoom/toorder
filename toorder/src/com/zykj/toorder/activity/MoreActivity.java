package com.zykj.toorder.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import com.zykj.toorder.BaseActivity;
import com.zykj.toorder.R;
import com.zykj.toorder.view.MyCommonTitle;
import com.zykj.toorder.view.MyMainCommonTitle;

public class MoreActivity extends BaseActivity {
	private MyMainCommonTitle myCommonTitle;
	private LinearLayout user_setting, change_pass, manage_address, permission_setting,
			push_message;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.ui_more);

		initView();

	}

	private void initView() {
		myCommonTitle=(MyMainCommonTitle) findViewById(R.id.aci_my_maintitle);
		myCommonTitle.setLisener(null, null, null, null);
		myCommonTitle.setTitle("更多");
		user_setting = (LinearLayout) findViewById(R.id.app_user_setting);
		change_pass = (LinearLayout) findViewById(R.id.app_change_pass);
		manage_address = (LinearLayout) findViewById(R.id.app_manage_address);
		permission_setting = (LinearLayout) findViewById(R.id.app_permission_setting);
		push_message = (LinearLayout) findViewById(R.id.app_push_message);

		setListener(user_setting, change_pass, manage_address,
				permission_setting, push_message);
	}

	@Override
	public void onClick(View view) {

		switch (view.getId()) {
		case R.id.app_user_setting:
			startActivity(new Intent(MoreActivity.this, MoreUserSettingActivity.class));
			break;
		case R.id.app_change_pass:
			startActivity(new Intent(MoreActivity.this, MoreChangePassActivity.class));
			break;
		case R.id.app_manage_address:
			startActivity(new Intent(MoreActivity.this, MoreManageAddressActivity.class));
			break;
		case R.id.app_permission_setting:
			startActivity(new Intent(MoreActivity.this, MorePermissonActivity.class));
			break;
		case R.id.app_push_message:
			startActivity(new Intent(MoreActivity.this, MorePushMessageActivity.class));
			break;

		default:
			break;
		}
	}

}
