package com.zykj.toorder.activity;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.loopj.android.http.RequestParams;
import com.zykj.toorder.BaseActivity;
import com.zykj.toorder.R;
import com.zykj.toorder.http.HttpUtils;
import com.zykj.toorder.utils.StringUtil;
import com.zykj.toorder.utils.TextUtil;
import com.zykj.toorder.utils.Tools;
import com.zykj.toorder.view.MyCommonTitle;

public class SuppliersAddSupplierActivity extends BaseActivity {
	private MyCommonTitle myCommonTitle;
	private EditText supp_mobile, supp_name, supp_contacts;
	private Button add_guester;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.ui_supplier_add_supplier);
		initView();

	}

	private void initView() {
		myCommonTitle = (MyCommonTitle) findViewById(R.id.aci_mytitle);
		myCommonTitle.setLisener(this, null, null);
		myCommonTitle.setTitle("供应商详情");
		myCommonTitle.setBackEditTitle("供应商");
		supp_mobile = (EditText) findViewById(R.id.new_supplier_mobile);
		supp_name = (EditText) findViewById(R.id.new_supplier_name);
		supp_contacts = (EditText) findViewById(R.id.new_supplier_contacts);

		add_guester = (Button) findViewById(R.id.btn_add_guest);
		add_guester.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				String mobile = supp_mobile.getText().toString().trim();
				String name = supp_name.getText().toString().trim();
				String contacts = supp_contacts.getText().toString().trim();
				if (!TextUtil.isMobile(mobile)) {
					Tools.toast(SuppliersAddSupplierActivity.this,"手机格式不正确，请重新输入");
				} else if (StringUtil.isEmpty(name)) {
					Tools.toast(SuppliersAddSupplierActivity.this,"供应商名称不能为空");
				} else if (StringUtil.isEmpty(contacts)) {
					Tools.toast(SuppliersAddSupplierActivity.this,"联系人不能为空");
				}
				RequestParams params =new RequestParams();
				params.put("", mobile);
				params.put("", name);
				params.put("", contacts);
				//添加供应商。。。。。。。参照接口
//				HttpUtils.
			}
		});
	}

}
