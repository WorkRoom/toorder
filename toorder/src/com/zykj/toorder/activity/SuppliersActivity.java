package com.zykj.toorder.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.zykj.toorder.BaseActivity;
import com.zykj.toorder.R;
import com.zykj.toorder.view.MyMainCommonTitle;

public class SuppliersActivity extends BaseActivity {
	private MyMainCommonTitle myCommonTitle;
	private ImageView img_addSupplier;
	private LinearLayout ly_supplier_sys_recomm, ly_supplier_in_trade,
			ly_supplier_unresponse, ly_supplier_unconnection,
			ly_supplier_receive_request, ly_supplier_refuse_rquest;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.ui_supplier);
		initView();
	}

	private void initView() {
		myCommonTitle = (MyMainCommonTitle) findViewById(R.id.aci_my_maintitle);
		myCommonTitle.setLisener(null, null,this,  null);
		myCommonTitle.setTitle("供应商");
		myCommonTitle.setEditTitle("下单");

		img_addSupplier = (ImageView) findViewById(R.id.img_add_supplier);
		ly_supplier_sys_recomm = (LinearLayout) findViewById(R.id.supplier_sys_recommend);
		ly_supplier_in_trade = (LinearLayout) findViewById(R.id.supplier_in_trade);
		ly_supplier_unresponse = (LinearLayout) findViewById(R.id.supplier_unresponse);
		ly_supplier_unconnection = (LinearLayout) findViewById(R.id.supplier_unconnection);
		ly_supplier_receive_request = (LinearLayout) findViewById(R.id.supplier_receive_request);
		ly_supplier_refuse_rquest = (LinearLayout) findViewById(R.id.supplier_refuse_rquest);

		setListener(img_addSupplier, ly_supplier_sys_recomm,
				ly_supplier_in_trade, ly_supplier_unresponse,
				ly_supplier_unconnection, ly_supplier_receive_request,
				ly_supplier_refuse_rquest);
	}

	@Override
	public void onClick(View view) {
		super.onClick(view);
		switch (view.getId()) {
		case R.id.img_add_supplier:// 添加供应商
			startActivity(new Intent(SuppliersActivity.this,
					SuppliersAddSupplierActivity.class));
			break;
		case R.id.supplier_sys_recommend:// 系统推荐供应商
			startActivity(new Intent(SuppliersActivity.this,
					SupplierSystemRecommandActivity.class));
			break;
		case R.id.supplier_in_trade:// 交易中的供应商

			break;
		case R.id.supplier_unresponse:// 未响应连接的供应商

			break;
		case R.id.supplier_unconnection:// 已断开连接的供应商

			break;
		case R.id.supplier_receive_request:// 收到的连接请求

			break;
		case R.id.supplier_refuse_rquest:// 被拒绝的连接请求

			break;
		default:
			break;
		}
	}
}
