package com.zykj.toorder.activity;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import cn.smssdk.EventHandler;
import cn.smssdk.SMSSDK;

import com.loopj.android.http.RequestParams;
import com.zykj.toorder.BaseActivity;
import com.zykj.toorder.R;
import com.zykj.toorder.utils.StringUtil;
import com.zykj.toorder.utils.TextUtil;
import com.zykj.toorder.utils.Tools;
import com.zykj.toorder.view.MyCommonTitle;
import com.zykj.toorder.view.MyMainCommonTitle;
import com.zykj.toorder.view.MyRequestDailog;

public class UserResetPwdActivity extends BaseActivity {
	private MyMainCommonTitle myCommonTitle;
	private Button identifying_code;
	private EditText user_mobile, mobile_code, user_password, confirmpwd;
	private String mobile, password;
	private static String APPKEY = "abf87d5eac6a";
	private static String APPKEYSECRET = "4c85fbe195ff291eb8e6a79a3d6e4a40";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.ui_user_reset_pass);
		// 初始化短信验证
		SMSSDK.initSDK(this, APPKEY, APPKEYSECRET);
		EventHandler eh = new EventHandler() {
			@Override
			public void afterEvent(int event, int result, Object data) {
				Message msg = new Message();
				msg.arg1 = event;
				msg.arg2 = result;
				msg.obj = data;
				handler.sendMessage(msg);
			}
		};
		SMSSDK.registerEventHandler(eh);
		initView();
	}

	private void initView() {
		myCommonTitle = (MyMainCommonTitle) findViewById(R.id.aci_mytitle);
		myCommonTitle.setLisener(this, this, this, null);
		myCommonTitle.setTitle("密码重置");
		myCommonTitle.setEditTitle("提交");
		myCommonTitle.setBackEditTitle("返回");

		user_mobile = (EditText) findViewById(R.id.input_mobile);
		mobile_code = (EditText) findViewById(R.id.input_mobile_code);
		user_password = (EditText) findViewById(R.id.input_password);
		confirmpwd = (EditText) findViewById(R.id.input_confirm_password);
		identifying_code = (Button) findViewById(R.id.identifying_code);

		setListener(identifying_code);
	}

	@Override
	public void onClick(View view) {
		String mobile = user_mobile.getText().toString().trim();
		String code = mobile_code.getText().toString().trim();
		String password = user_password.getText().toString().trim();
		String password2 = confirmpwd.getText().toString().trim();
		switch (view.getId()) {
		case R.id.aci_edit_btn:// 提交
			if (!TextUtil.isCode(code, 4)) {
				Tools.toast(UserResetPwdActivity.this, "验证码格式不对");
				return;
			}
			if (StringUtil.isEmpty(password)) {
				Tools.toast(UserResetPwdActivity.this, "密码不能为空");
				return;
			}
			if (!TextUtil.isPasswordLengthLegal(password)) {
				Tools.toast(UserResetPwdActivity.this, "密码长度合法性校验6-20位任意字符");
				return;
			}
			if (StringUtil.isEmpty(password2)) {
				Tools.toast(UserResetPwdActivity.this, "密码不能为空");
				return;
			}
			if (!TextUtil.isPasswordLengthLegal(password2)) {
				Tools.toast(UserResetPwdActivity.this, "密码长度合法性校验6-20位任意字符");
				return;
			}
			if (!password.equals(password2)) {
				Tools.toast(UserResetPwdActivity.this, "两次输入的密码不一致,请重新输入");
				return;
			}
			// 重置密码提交代码实现........

			MyRequestDailog.showDialog(this, "");
			SMSSDK.submitVerificationCode("86", mobile, code);
			break;
		case R.id.identifying_code:// 获取手机验证码
			if (!TextUtil.isMobile(mobile)) {
				Tools.toast(UserResetPwdActivity.this, "手机号格式不正确");
				return;
			}
			/* 发送手机验证码 */
			identifying_code.setOnClickListener(null);
			new MyCount(60000, 1000).start();// 一分钟倒计时
			SMSSDK.getVerificationCode("86", mobile);
			break;
		}
	}

	Handler handler = new Handler() {
		@Override
		public void handleMessage(Message msg) {
			int event = msg.arg1;
			int result = msg.arg2;
			Object data = msg.obj;
			Log.e("event", "event+" + event);
			Log.e("result", "result+" + result);
			if (result == SMSSDK.RESULT_COMPLETE) {
				if (event == SMSSDK.EVENT_SUBMIT_VERIFICATION_CODE) {
					registerNewUser();
				} else if (event == SMSSDK.EVENT_GET_VERIFICATION_CODE) {
					Tools.toast(UserResetPwdActivity.this, "验证码已发送");
				}
			} else {
				((Throwable) data).printStackTrace();
//				 int resId =
//				 getStringRes(UserResetPwdActivity.this,"smssdk_network_error");
//				 Tools.toast(
//				 UserResetPwdActivity.this,
//				 event == SMSSDK.EVENT_GET_VERIFICATION_CODE ? "验证码频繁，请稍后再试！"
//				 : "验证码错误");
//				 if (resId > 0) {
//				 Tools.toast(UserResetPwdActivity.this, resId + "");
//				 }
			}
		}

		private void registerNewUser() {
			RequestParams params = new RequestParams();
			params.put("mob", mobile);
			params.put("password", password);
//			HttpUtils.resetPassword(new HttpErrorHandler() {
//				@Override
//				public void onRecevieSuccess(JSONObject json) {
//					MyRequestDailog.closeDialog();
//					Tools.toast(UserResetPwdActivity.this,
//							json.getString("message"));
//					// Tools.toast(UserRegisterActivity.this, "密码重置成功");
//					finish();
//				}
//
//				@Override
//				public void onRecevieFailed(String status, JSONObject json) {
//					MyRequestDailog.closeDialog();
//					Tools.toast(UserResetPwdActivity.this,
//							json.getString("message"));
//				}
//			}, params);
		}
	};

	@Override
	protected void onDestroy() {
		super.onDestroy();
		SMSSDK.unregisterAllEventHandler();
	}

	/* 定义一个倒计时的内部类 */
	class MyCount extends CountDownTimer {
		public MyCount(long millisInFuture, long countDownInterval) {
			super(millisInFuture, countDownInterval);
		}

		@Override
		public void onFinish() {
			identifying_code.setText("点击获取验证码");
			identifying_code.setOnClickListener(UserResetPwdActivity.this);
		}

		@Override
		public void onTick(long millisUntilFinished) {
			identifying_code.setText(millisUntilFinished / 1000 + "秒");
		}
	}
}
