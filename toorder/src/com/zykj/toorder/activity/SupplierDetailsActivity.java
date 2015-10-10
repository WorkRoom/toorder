package com.zykj.toorder.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.zykj.toorder.BaseActivity;
import com.zykj.toorder.R;
import com.zykj.toorder.view.MyCommonTitle;

public class SupplierDetailsActivity extends BaseActivity {
	private MyCommonTitle myCommonTitle;
	private LinearLayout deliveryType;// 配送方式
	private LinearLayout payType;// 付款方式
	private LinearLayout tradeInfo;// 交易信息
	private LinearLayout selectConnect;// 选择关联物料
	private LinearLayout shopDetails;// 店铺详情
	private TextView supplierMobile, supplierName, supplierContacts,
			supplierEmail, supplierBussiness, suppierBankOpen,
			SupplierBankAccount, supplierBankContacts, supplierAddressCity,
			supplierAddressStreet;
	private Button btn_cancleConnection, btn_addConnection, btn_delete;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.ui_supplier_details);
		initView();
	}

	private void initView() {
		myCommonTitle = (MyCommonTitle) findViewById(R.id.aci_mytitle);
		myCommonTitle.setTitle("详情");
		myCommonTitle.setBackEditTitle("供应商");

		deliveryType = (LinearLayout) findViewById(R.id.ly_delivery_type);//配送方式
		payType = (LinearLayout) findViewById(R.id.ly_pay_type);//付款方式
		tradeInfo = (LinearLayout) findViewById(R.id.ly_trade_info);//交易信息
		selectConnect = (LinearLayout) findViewById(R.id.ly_select_conn_materiel);//选择关联物料
		shopDetails = (LinearLayout) findViewById(R.id.ly_shop_details);//店铺详情

		btn_cancleConnection = (Button) findViewById(R.id.supplier_connection_cancle);// 取消关联
		btn_addConnection = (Button) findViewById(R.id.supplier_connection_add);// 关联供应商
		btn_delete = (Button) findViewById(R.id.supplier_delete);// 删除

		setListener(btn_cancleConnection, btn_addConnection, btn_delete);
	}

	@Override
	public void onClick(View view) {
		super.onClick(view);
		switch (view.getId()) {
		case R.id.ly_shop_details:// 店铺详情

			break;
		case R.id.ly_select_conn_materiel:// 选择关联物料

			break;
		case R.id.ly_trade_info:// 交易信息

			break;
		case R.id.ly_pay_type:// 付款方式

			break;
		case R.id.ly_delivery_type:// 配送方式

			break;
		case R.id.supplier_connection_cancle:// 取消关联

			break;
		case R.id.supplier_connection_add:// 关联供应商

			break;
		case R.id.supplier_delete:// 删除

			break;
		default:
			break;
		}
	}
}
