/**
 * 
 */
package com.zykj.toorder.activity;

import android.os.Bundle;

import com.zykj.toorder.BaseActivity;
import com.zykj.toorder.R;
import com.zykj.toorder.view.MyCommonTitle;


public class MoreAdminDetailsActivity extends BaseActivity {
	private MyCommonTitle myCommonTitle;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.ui_more_admin_details);
		
		initView();
	}
	private void initView() {
		myCommonTitle=(MyCommonTitle) findViewById(R.id.aci_mytitle);
		myCommonTitle.setLisener(this, null, null);
		myCommonTitle.setTitle("管理员详情");
		myCommonTitle.setBackEditTitle("返回");
	}

}
