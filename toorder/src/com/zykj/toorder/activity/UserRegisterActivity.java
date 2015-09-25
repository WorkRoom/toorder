package com.zykj.toorder.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;

import com.zykj.toorder.BaseActivity;
import com.zykj.toorder.R;
import com.zykj.toorder.utils.StringUtil;
import com.zykj.toorder.utils.TextUtil;
import com.zykj.toorder.utils.Tools;
import com.zykj.toorder.view.MyCommonTitle;

public class UserRegisterActivity extends BaseActivity {
	private MyCommonTitle myCommonTitle;
	private EditText user_mobile, user_password,comp_name,user_name,user_email;
	private Button btn_login;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.ui_user_register);
		
		initView();
	}
	private void initView() {
		myCommonTitle=(MyCommonTitle) findViewById(R.id.aci_mytitle);
		myCommonTitle.setLisener(null, this, null);
		myCommonTitle.setTitle("注册");
		myCommonTitle.setEditTitle("创建");
		
		user_mobile=(EditText) findViewById(R.id.input_mobile);
		user_password=(EditText) findViewById(R.id.input_password);
		comp_name=(EditText) findViewById(R.id.input_comp);
		user_name=(EditText) findViewById(R.id.input_username);
		user_email=(EditText) findViewById(R.id.input_email);
		btn_login=(Button) findViewById(R.id.btn_login);
		
		setListener(btn_login);
	}
	@Override
	public void onClick(View view) {
		switch (view.getId()) {
		case R.id.aci_edit_btn://创建账号
			String mobile=user_mobile.getText().toString().trim();
			String password=user_password.getText().toString().trim();
			String compname=comp_name.getText().toString().trim();
			String username=user_name.getText().toString().trim();
			String email=user_email.getText().toString().trim();
			if(StringUtil.isEmpty(mobile)){
				Tools.toast(this, "手机号不能为空");return;
			}
			if(!TextUtil.isMobile(mobile)){
				Tools.toast(this, "手机号格式不正确");return;
			}
			if(StringUtil.isEmpty(password)){
				Tools.toast(this, "密码不能为空");return;
			}
			if(StringUtil.isEmpty(compname)){
				Tools.toast(this, "公司不能为空");return;
			}
			if(StringUtil.isEmpty(username)){
				Tools.toast(this, "姓名不能为空");return;
			}
			if(StringUtil.isEmpty(email)){
				Tools.toast(this, "邮箱不能为空");return;
			}
			/**
			 * 创建账号代码实现。。。。。。。。。。
			 */
			
			
			
			
			break;
		case R.id.btn_login:
			startActivity(new Intent(UserRegisterActivity.this, UserLoginActivity.class));
			break;
		default:
			break;
		}
		
	}

	
	
	
	
}
