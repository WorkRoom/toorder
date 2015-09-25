package com.zykj.toorder.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ToggleButton;

import com.zykj.toorder.BaseActivity;
import com.zykj.toorder.R;
import com.zykj.toorder.utils.StringUtil;
import com.zykj.toorder.utils.TextUtil;
import com.zykj.toorder.utils.Tools;
import com.zykj.toorder.view.MyCommonTitle;

public class MoreNewAddressActivity extends BaseActivity {
	private MyCommonTitle myCommonTitle;
	private ToggleButton toggleButton;
	private  EditText ed_name,ed_mobile,ed_city,ed_street;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.ui_more_new_address);
		
		initView();
	}
	private void initView() {
		myCommonTitle=(MyCommonTitle) findViewById(R.id.aci_mytitle);
		myCommonTitle.setLisener(this,this, null);
		myCommonTitle.setTitle("新增地址");
		myCommonTitle.setEditTitle("保存");
		myCommonTitle.setBackEditTitle("更多");
		
		ed_name=(EditText) findViewById(R.id.new_username);
		ed_mobile=(EditText) findViewById(R.id.new_mobile);
		ed_city=(EditText) findViewById(R.id.new_city);
		ed_street=(EditText) findViewById(R.id.new_street);
		toggleButton=(ToggleButton) findViewById(R.id.toggle_on_off);
		setListener(toggleButton);
	}
	
	@Override
	public void onClick(View view) {
		switch (view.getId()) {
		case R.id.aci_edit_btn:
			String username=ed_name.getText().toString().trim();
			String usermobile=ed_mobile.getText().toString().trim();
			String usercity=ed_city.getText().toString().trim();
			String userstreet=ed_street.getText().toString().trim();
			if(StringUtil.isEmpty(username)){
				Tools.toast(this, "姓名不能为空");return;
			}	if(StringUtil.isEmpty(usermobile)){
				Tools.toast(this, "联系电话不能为空");return;
			}	if(!TextUtil.isMobile(usermobile)){
				Tools.toast(this, "联系电话格式不正确");return;
			}	if(StringUtil.isEmpty(usercity)){
				Tools.toast(this, "省市区不能为空");return;
			}	if(StringUtil.isEmpty(userstreet)){
				Tools.toast(this, "街道不能为空");return;
			}
			break;
		case R.id.toggle_on_off:
			
			
			break;
		default:
			break;
		}
	}

}
