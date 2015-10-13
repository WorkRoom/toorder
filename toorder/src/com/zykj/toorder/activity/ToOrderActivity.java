package com.zykj.toorder.activity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;

import com.zykj.toorder.BaseActivity;
import com.zykj.toorder.R;
import com.zykj.toorder.view.MyCommonTitle;
import com.zykj.toorder.view.MyMainCommonTitle;

public class ToOrderActivity extends BaseActivity {
	private MyMainCommonTitle myMainCommonTitle;
	private ProgressBar mProgressBar;
	private Button cancle_update, software_update, contact_help;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.ui_toorder);
		initView();
	}

	private void initView() {
		myMainCommonTitle = (MyMainCommonTitle) findViewById(R.id.aci_mymaintitle);
		myMainCommonTitle.setLisener(null, null, this, null);
		myMainCommonTitle.setTitle("叮当兔");
		myMainCommonTitle.setEditTitle("登陆");

		mProgressBar = (ProgressBar) findViewById(R.id.progressBar1);
		mProgressBar.setMax(100);
		mProgressBar.setProgress(15);

		cancle_update = (Button) findViewById(R.id.cancle_data_synchro);
		software_update = (Button) findViewById(R.id.software_updata);
		contact_help = (Button) findViewById(R.id.contact_help);
	}

	@Override
	public void onClick(View view) {
		super.onClick(view);
		switch (view.getId()) {
		case R.id.aci_edit_btn:
			startActivity(new Intent(ToOrderActivity.this,
					UserLoginActivity.class));
			break;
		case R.id.cancle_data_synchro://取消数据同步

			break;
		case R.id.software_updata://软件升级

			break;
		case R.id.contact_help://联系帮助

			break;
		default:
			break;
		}
	}
}
