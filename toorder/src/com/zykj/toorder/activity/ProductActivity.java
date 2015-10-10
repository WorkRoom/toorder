package com.zykj.toorder.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.zykj.toorder.BaseActivity;
import com.zykj.toorder.R;
import com.zykj.toorder.view.MyCommonTitle;
import com.zykj.toorder.view.MyMainCommonTitle;

public class ProductActivity extends BaseActivity {
	private MyMainCommonTitle myCommonTitle;
	private Button btn_addpro;
	private ImageView img_share;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.ui_product);
		initView();
	}
	private void initView() {
		myCommonTitle=(MyMainCommonTitle) findViewById(R.id.aci_my_maintitle);
		myCommonTitle.setLisener(null, null, null, this);
		myCommonTitle.setTitle("产品");
		img_share=(ImageView) findViewById(R.id.aci_shared_btn);
		img_share.setImageResource(R.drawable.purcherse_icon);
		
		btn_addpro=(Button) findViewById(R.id.btn_add_product);
	
		setListener(btn_addpro);
	}
@Override
public void onClick(View view) {
	super.onClick(view);
	switch (view.getId()) {
	case R.id.btn_add_product:
		startActivity(new Intent(ProductActivity.this, ProductNewSortActivity.class));
		break;
	case R.id.aci_shared_btn:
		startActivity(new Intent(ProductActivity.this, ProductShoppingCartActivity.class));
		break;
	default:
		break;
	}
}
}
