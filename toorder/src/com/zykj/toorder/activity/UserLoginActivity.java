package com.zykj.toorder.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.zykj.toorder.BaseActivity;
import com.zykj.toorder.R;
import com.zykj.toorder.utils.StringUtil;
import com.zykj.toorder.utils.TextUtil;
import com.zykj.toorder.utils.Tools;
import com.zykj.toorder.view.MyMainCommonTitle;

public class UserLoginActivity extends BaseActivity {
	private MyMainCommonTitle myCommonTitle;
	private EditText user_mobile, user_password;
	private Button btn_createaccount, btn_resetpwd;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.ui_user_login);

		initView();
	}

	private void initView() {
		myCommonTitle = (MyMainCommonTitle) findViewById(R.id.aci_mytitle);
		myCommonTitle.setLisener(null,null, this, null);
		myCommonTitle.setTitle("登录");
		myCommonTitle.setEditTitle("登录");

		user_mobile = (EditText) findViewById(R.id.input_mobile);
		user_password = (EditText) findViewById(R.id.input_password);
		btn_createaccount = (Button) findViewById(R.id.create_account);
		btn_resetpwd = (Button) findViewById(R.id.reset_password);

		setListener(btn_createaccount, btn_resetpwd);
	}

	@Override
	public void onClick(View view) {
		switch (view.getId()) {
		case R.id.aci_edit_btn://登陆
			String mobile = user_mobile.getText().toString().trim();
			String password = user_password.getText().toString().trim();
		
//			if(!TextUtil.isMobile(mobile)){
//				Tools.toast(this, "手机号格式不正确");return;
//			}
//			if(StringUtil.isEmpty(password)){
//				Tools.toast(this, "密码不能为空");return;
//			}
			//登陆代码实现........
			
			
			
		
			startActivity(new Intent(UserLoginActivity.this,
					UserLoginingActivity.class));
			
			break;
		case R.id.create_account://创建账号
			startActivity(new Intent(UserLoginActivity.this,
					UserRegisterActivity.class));
			break;
		case R.id.reset_password://重置密码
			startActivity(new Intent(UserLoginActivity.this,
					UserResetPwdActivity.class));
			break;
		default:
			break;
		}

	}
}
