package com.zykj.toorder.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.zykj.toorder.BaseActivity;
import com.zykj.toorder.R;
import com.zykj.toorder.utils.StringUtil;
import com.zykj.toorder.utils.TextUtil;
import com.zykj.toorder.utils.Tools;
import com.zykj.toorder.view.MyCommonTitle;

public class UserRegisterNextActivity extends BaseActivity {
	private MyCommonTitle myCommonTitle;
	private TextView comp_name, comp_address, comp_mobile, complete_register;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.ui_user_register_next);
		initView();
	}

	private void initView() {
		myCommonTitle = (MyCommonTitle) findViewById(R.id.aci_mytitle);
		myCommonTitle.setLisener(this, null, null);
		myCommonTitle.setTitle("完善资料");
		myCommonTitle.setBackEditTitle("上一步");

		comp_name = (TextView) findViewById(R.id.comp_name);
		comp_address = (TextView) findViewById(R.id.comp_address);
		comp_mobile = (TextView) findViewById(R.id.comp_mobile);
		complete_register = (TextView) findViewById(R.id.register_btn);

		setListener(complete_register);
	}

	@Override
	public void onClick(View view) {
		super.onClick(view);
		switch (view.getId()) {
		case R.id.register_btn:
//			checkData();// 检测数据
			submitData();// 提交数据
			break;
		default:
			break;
		}
	}

	/**
	 * 检查数据的有效性
	 */
	private void checkData() {
		String compname = comp_name.getText().toString().trim();
		String compaddress = comp_address.getText().toString().trim();
		String compmobie = comp_mobile.getText().toString().trim();
		if(StringUtil.isEmpty(compname)){
			Tools.toast(UserRegisterNextActivity.this, "公司名称不能为空");
		}else if (StringUtil.isEmpty(compaddress)) {
			Tools.toast(UserRegisterNextActivity.this, "公司地址不能为空");
		}else if (!TextUtil.isMobile(compmobie)) {
			Tools.toast(UserRegisterNextActivity.this, "手机格式不正确");
		}
	}

	/**
	 * 提交注册信息
	 */
	private void submitData() {

		
		
	}

}
