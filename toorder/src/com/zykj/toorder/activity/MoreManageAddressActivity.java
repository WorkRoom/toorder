package com.zykj.toorder.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

import com.zykj.toorder.BaseActivity;
import com.zykj.toorder.R;
import com.zykj.toorder.view.MyCommonTitle;

public class MoreManageAddressActivity extends BaseActivity {
	private MyCommonTitle myCommonTitle;
	private Button btn_add_newaddress;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.ui_more_manage_address);
		initView();
	}
	
	 private void initView() {
		 myCommonTitle=(MyCommonTitle)findViewById(R.id.aci_mytitle);
		 myCommonTitle.setLisener(this,null,null);
			myCommonTitle.setTitle("管理地址");
			myCommonTitle.setBackEditTitle("更多");	 
			
			btn_add_newaddress=(Button) findViewById(R.id.btn_add_new_address);
			
			btn_add_newaddress.setOnClickListener(new OnClickListener() {
				
				@Override
				public void onClick(View v) {
					startActivity(new Intent(MoreManageAddressActivity.this, MoreNewAddressActivity.class));
				}
			});
	}


}
