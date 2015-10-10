package com.zykj.toorder.activity;

import android.os.Bundle;

import com.zykj.toorder.BaseActivity;
import com.zykj.toorder.R;
import com.zykj.toorder.view.MyMainCommonTitle;

public class SuppliersActivity extends BaseActivity {
	private MyMainCommonTitle myCommonTitle;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.ui_supplier);
		initView();
	}


	private void initView() {
		myCommonTitle=(MyMainCommonTitle) findViewById(R.id.aci_my_maintitle);
		myCommonTitle.setLisener(null, null, null, null);
		myCommonTitle.setTitle("供应商");		
	}

}
