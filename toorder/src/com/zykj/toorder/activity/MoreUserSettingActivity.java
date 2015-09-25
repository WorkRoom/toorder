package com.zykj.toorder.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.zykj.toorder.BaseActivity;
import com.zykj.toorder.BaseApp;
import com.zykj.toorder.R;
import com.zykj.toorder.utils.CommonUtils;
import com.zykj.toorder.utils.StringUtil;
import com.zykj.toorder.utils.TextUtil;
import com.zykj.toorder.utils.Tools;
import com.zykj.toorder.view.MyCommonTitle;

public class MoreUserSettingActivity extends BaseActivity {
	private MyCommonTitle myCommonTitle;
	private Button btn_logout;
	private ImageView img_log;
	private EditText tv_comp_name, tv_comp_contacts, tv_comp_mobile,
			tv_comp_tel;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.ui_more_user_setting);

		initView();
	}

	private void initView() {
		myCommonTitle = (MyCommonTitle) findViewById(R.id.aci_mytitle);
		myCommonTitle.setLisener(this, this, null);
		myCommonTitle.setTitle("个人设置");
		myCommonTitle.setEditTitle("保存");
		myCommonTitle.setBackEditTitle("更多");

		img_log = (ImageView) findViewById(R.id.comp_logo);
		tv_comp_name = (EditText) findViewById(R.id.comp_name);
		tv_comp_contacts = (EditText) findViewById(R.id.comp_contacts);
		tv_comp_mobile = (EditText) findViewById(R.id.comp_mobile);
		tv_comp_tel = (EditText) findViewById(R.id.comp_tel);
		btn_logout = (Button) findViewById(R.id.login_out);
		setListener(img_log, btn_logout);
	}

	@Override
	public void onClick(View view) {
		switch (view.getId()) {
		case R.id.comp_logo:// 公司logo

			break;

		case R.id.login_out:// 退出登录
			BaseApp.getModel().clear();
			requestData();
			
			/**
			 * 暂时的跳转，登陆界面在其他UI的位置
			 */
			startActivity(new Intent(MoreUserSettingActivity.this, UserLoginActivity.class));

			break;
		case R.id.aci_edit_btn:// 保存信息
			String comp_name=tv_comp_name.getText().toString().trim();
			String comp_contacts=tv_comp_contacts.getText().toString().trim();
			String comp_tel=tv_comp_tel.getText().toString().trim();
			if(StringUtil.isEmpty(comp_name)){
				Tools.toast(MoreUserSettingActivity.this, "公司名称不能为空");return;
			}
			if(StringUtil.isEmpty(comp_contacts)){
				Tools.toast(MoreUserSettingActivity.this, "联系人不能为空");return;
			}
			if(StringUtil.isEmpty(comp_tel)){
				Tools.toast(MoreUserSettingActivity.this, "固定电话不能为空");return;
			}    if(TextUtil.isPhone(comp_tel)){
				Tools.toast(MoreUserSettingActivity.this, "固定电话格式不正确");return;
			}
			//保存信息
			
			
			
			break;
		}
	}

	private void requestData() {
		if (CommonUtils.CheckLogin()) {
			img_log.setVisibility(View.VISIBLE);
			tv_comp_name.setVisibility(View.VISIBLE);
			tv_comp_contacts.setVisibility(View.VISIBLE);
			tv_comp_tel.setVisibility(View.VISIBLE);
		} else {
			img_log.setVisibility(View.GONE);
			tv_comp_name.setVisibility(View.GONE);
			tv_comp_contacts.setVisibility(View.GONE);
			tv_comp_tel.setVisibility(View.GONE);

		}
	}
}
