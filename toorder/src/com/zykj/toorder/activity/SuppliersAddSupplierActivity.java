package com.zykj.toorder.activity;

import android.os.Bundle;

import com.zykj.toorder.BaseActivity;
import com.zykj.toorder.R;
import com.zykj.toorder.view.MyCommonTitle;

public class SuppliersAddSupplierActivity extends BaseActivity {
	private MyCommonTitle myCommonTitle;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.ui_supplier_add_supplier);
		initView();
		
	}
	private void initView() {
		myCommonTitle=(MyCommonTitle) findViewById(R.id.aci_mytitle);	
		myCommonTitle.setTitle("供应商详情");	
		myCommonTitle.setBackEditTitle("供应商");
		
		}

}
