package com.zykj.toorder.activity;

import android.os.Bundle;

import com.zykj.toorder.BaseActivity;
import com.zykj.toorder.R;
import com.zykj.toorder.view.MyCommonTitle;

public class SupplierMessageActivity extends BaseActivity {
	MyCommonTitle myCommonTitle;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.ui_supplier_message);
		initView();
	}

	private void initView() {
		myCommonTitle=(MyCommonTitle) findViewById(R.id.aci_mytitle);
		myCommonTitle.setTitle("通知消息");
		myCommonTitle.setBackEditTitle("供应商");
		
	}

}
