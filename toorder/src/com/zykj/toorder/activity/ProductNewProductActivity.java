package com.zykj.toorder.activity;

import android.os.Bundle;
import com.zykj.toorder.BaseActivity;
import com.zykj.toorder.R;
import com.zykj.toorder.view.MyCommonTitle;

public class ProductNewProductActivity extends BaseActivity {
	private MyCommonTitle myCommonTitle;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.ui_product_add_details);
		initView();
	}

	private void initView() {
		myCommonTitle = (MyCommonTitle) findViewById(R.id.aci_mytitle);
		myCommonTitle.setTitle("产品详情");
		myCommonTitle.setBackEditTitle("产品");

	}
}
