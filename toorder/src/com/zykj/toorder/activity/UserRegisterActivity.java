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

public class UserRegisterActivity extends BaseActivity {
	private MyMainCommonTitle myCommonTitle;
	private EditText user_mobile, user_password, comp_name, user_name,
			user_email;
	private Button btn_login;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.ui_user_register);

		initView();
	}

	private void initView() {
		myCommonTitle = (MyMainCommonTitle) findViewById(R.id.aci_mytitle);
		myCommonTitle.setLisener(null, null, this, null);
		myCommonTitle.setTitle("注册");
		myCommonTitle.setEditTitle("创建");

		user_mobile = (EditText) findViewById(R.id.input_mobile);
		user_password = (EditText) findViewById(R.id.input_password);
		comp_name = (EditText) findViewById(R.id.input_comp);
		user_name = (EditText) findViewById(R.id.input_username);
		user_email = (EditText) findViewById(R.id.input_email);
		btn_login = (Button) findViewById(R.id.btn_login);

		setListener(btn_login);
	}

	@Override
	public void onClick(View view) {
		switch (view.getId()) {
		case R.id.aci_edit_btn:// 创建账号
			
//			checkData();//检测数据有效性
			submitData();//提交数据

			/**
			 * 进一步完善注册资料
			 */
			startActivity(new Intent(UserRegisterActivity.this,
					UserRegisterNextActivity.class));
			break;
		case R.id.btn_login:
			startActivity(new Intent(UserRegisterActivity.this,
					UserLoginActivity.class));
			break;
		default:
			break;
		}

	}
/**
 * 检测输入的信息是否合理
 */
	private void checkData() {
		String mobile = user_mobile.getText().toString().trim();
		String password = user_password.getText().toString().trim();
		String compname = comp_name.getText().toString().trim();
		String username = user_name.getText().toString().trim();
		String email = user_email.getText().toString().trim();

		if (!TextUtil.isMobile(mobile)) {
			Tools.toast(this, "手机号格式不正确");
			return;
		}
		if (TextUtil.isPasswordLengthLegal(password)) {
			Tools.toast(this, "密码长度合法性校验6-20位任意字符");
			return;
		}
		if (StringUtil.isEmpty(compname)) {
			Tools.toast(this, "公司不能为空");
			return;
		}
		if (StringUtil.isEmpty(username)) {
			Tools.toast(this, "姓名不能为空");
			return;
		}
		if (!TextUtil.isEmail(email)) {
			Tools.toast(this, "邮箱格式不正确");
			return;
		}		
	}

	/**
	 * 提交注册信息
	 */
	private void submitData() {

		
		
	}

}
