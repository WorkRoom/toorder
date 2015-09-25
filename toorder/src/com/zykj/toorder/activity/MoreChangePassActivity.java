package com.zykj.toorder.activity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.TextView;

import com.zykj.toorder.BaseActivity;
import com.zykj.toorder.R;
import com.zykj.toorder.utils.StringUtil;
import com.zykj.toorder.utils.TextUtil;
import com.zykj.toorder.utils.Tools;
import com.zykj.toorder.view.MyCommonTitle;

public class MoreChangePassActivity extends BaseActivity {

	private MyCommonTitle myCommonTitle;
	private EditText old_pass,new_pass,confirm_pass;
	private TextView btn_edit;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.ui_more_change_pass);
		initView();
		}

	private void initView() {
		myCommonTitle=(MyCommonTitle) findViewById(R.id.aci_mytitle);
		myCommonTitle.setLisener(this, this, null);
		myCommonTitle.setTitle("密码修改");
		myCommonTitle.setEditTitle("保存");
		myCommonTitle.setBackEditTitle("更多");
		
		old_pass=(EditText) findViewById(R.id.old_pass);
		new_pass=(EditText) findViewById(R.id.new_pass);
		confirm_pass=(EditText) findViewById(R.id.confirm_pass);
		
		btn_edit=(TextView) findViewById(R.id.aci_edit_btn);
		
		btn_edit.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				String password1=old_pass.getText().toString().trim();
				String password2=new_pass.getText().toString().trim();
				String password3=confirm_pass.getText().toString().trim();
				if(StringUtil.isEmpty(password1)){
					Tools.toast(MoreChangePassActivity.this, "原密码不能为空");return;
					//还需要判定输入的密码和原密码是否一致
					
					
				}
				if (StringUtil.isEmpty(password2)) {
					Tools.toast(MoreChangePassActivity.this, "新密码不能为空");return;
				}if (!TextUtil.isPasswordLengthLegal(password2)) {
						Tools.toast(MoreChangePassActivity.this, "密码长度合法性校验6-20位任意字符");return;
				}
				if (StringUtil.isEmpty(password3)) {
					Tools.toast(MoreChangePassActivity.this, "确认密码不能为空");return;
				}if (!TextUtil.isPasswordLengthLegal(password3)) {
						Tools.toast(MoreChangePassActivity.this, "密码长度合法性校验6-20位任意字符");return;
				}if(password2!=password3){
							Tools.toast(MoreChangePassActivity.this, "两次输入的密码不一致,请重新输入");return;
						}
				//保存
				
				
				
				}
		});
	}

}
