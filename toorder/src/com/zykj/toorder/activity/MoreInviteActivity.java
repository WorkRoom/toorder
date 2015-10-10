package com.zykj.toorder.activity;

import java.util.ArrayList;
import java.util.List;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import com.zykj.toorder.BaseActivity;
import com.zykj.toorder.R;
import com.zykj.toorder.utils.StringUtil;
import com.zykj.toorder.utils.TextUtil;
import com.zykj.toorder.utils.Tools;
import com.zykj.toorder.view.MyCommonTitle;

public class MoreInviteActivity extends BaseActivity implements	OnItemSelectedListener {
	private MyCommonTitle myCommonTitle;
	private TextView ed_submit,ed_mobile;
	private Spinner spinner;
	private List<String> list;
	private ArrayAdapter<String> adapter;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.ui_more_invitor);
		initView();
	}

	private void initView() {
		myCommonTitle=(MyCommonTitle) findViewById(R.id.aci_mytitle);
		myCommonTitle.setLisener(this, this, null);
		myCommonTitle.setTitle("邀请用户");
		myCommonTitle.setEditTitle("发送");
		myCommonTitle.setBackEditTitle("返回");
		ed_submit=(TextView) findViewById(R.id.aci_edit_btn);
		ed_mobile=(TextView) findViewById(R.id.input_mobile);
		spinner = (Spinner) findViewById(R.id.charactor_spinner);
		list = new ArrayList<String>();
		list.add("厨师");
		list.add("采购");
		adapter = new ArrayAdapter<String>(this,
				android.R.layout.simple_spinner_item, list);
		adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		spinner.setAdapter(adapter);
		spinner.setOnItemSelectedListener(this);

		ed_submit.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				
				String mobile=ed_mobile.getText().toString().trim();
				if(StringUtil.isEmpty(mobile)){
					Tools.toast(MoreInviteActivity.this,"手机号不能为空");return;
				}if(!TextUtil.isMobile(mobile)){
					Tools.toast(MoreInviteActivity.this,"手机格式不正确");return;
				}
				// 系统发送信息给待邀请的用户........
				
				
				
				
			}
		});
	}

	@Override
	public void onItemSelected(AdapterView<?> arg0, View arg1, int arg2,
			long arg3) {
		// TODO Auto-generated method stub
	}

	@Override
	public void onNothingSelected(AdapterView<?> arg0) {
		// TODO Auto-generated method stub

	}

}
