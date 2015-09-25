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
import com.zykj.toorder.view.MyCommonTitle;

public class UserResetPwdActivity extends BaseActivity {
	private MyCommonTitle myCommonTitle;
	private Button btn_code;
	private EditText user_mobile,user_code,user_password,confirmpwd;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.ui_user_reset_pass);
		
		initView();
	}
	private void initView() {
		myCommonTitle=(MyCommonTitle) findViewById(R.id.aci_mytitle);
		myCommonTitle.setLisener(this, this, null);
		myCommonTitle.setTitle("密码重置");
		myCommonTitle.setEditTitle("提交");
		myCommonTitle.setBackEditTitle("返回");
		
		user_mobile=(EditText) findViewById(R.id.input_mobile);
		user_code=(EditText) findViewById(R.id.input_mobile_code);
		user_password=(EditText) findViewById(R.id.input_password);
		confirmpwd=(EditText) findViewById(R.id.input_confirm_password);
		btn_code=(Button) findViewById(R.id.identifying_code);

	setListener(btn_code);
	}
@Override
public void onClick(View view) {
	switch (view.getId()) {
	case R.id.aci_edit_btn://提交
		String mobile = user_mobile.getText().toString().trim();
		String code = user_code.getText().toString().trim();
		String password1 = user_password.getText().toString().trim();
		String password2 = confirmpwd.getText().toString().trim();
		if(StringUtil.isEmpty(mobile)){
			Tools.toast(this, "手机号不能为空");return;
		}
		if(!TextUtil.isMobile(mobile)){
			Tools.toast(this, "手机号格式不正确");return;
		}
		if(StringUtil.isEmpty(code)){
			Tools.toast(this, "验证码不能为空");return;
		}
		if(StringUtil.isEmpty(password1)){
			Tools.toast(this, "密码不能为空");return;
		}
		if (!TextUtil.isPasswordLengthLegal(password2)) {
			Tools.toast(this, "密码长度合法性校验6-20位任意字符");return;
	    }
		if (StringUtil.isEmpty(password2)) {
			Tools.toast(this, "确认密码不能为空");return;
		}
		if (!TextUtil.isPasswordLengthLegal(password2)) {
				Tools.toast(this, "密码长度合法性校验6-20位任意字符");return;
		}
		if(password1!=password2){
					Tools.toast(this, "两次输入的密码不一致,请重新输入");return;
				}
		//重置密码提交代码实现........
		
		
		
	

		
		break;
	case R.id.identifying_code://获取手机验证码
		
		
		
		break;
	default:
		break;
	}
	
}
}
