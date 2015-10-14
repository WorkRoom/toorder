package com.zykj.toorder.activity;

import java.util.ArrayList;
import java.util.List;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;

import com.zykj.toorder.BaseActivity;
import com.zykj.toorder.R;
import com.zykj.toorder.adapter.CommonAdapter;
import com.zykj.toorder.adapter.ViewHolder;
import com.zykj.toorder.model.Supplier;
import com.zykj.toorder.utils.StringUtil;
import com.zykj.toorder.view.MyCommonTitle;
import com.zykj.toorder.view.XListView;
import com.zykj.toorder.view.XListView.IXListViewListener;

public class SuppliersInTradeActivity extends BaseActivity implements
		IXListViewListener, OnItemClickListener {
	private static int PERPAGE = 10;// //perpage默认每页显示10条信息
	private int nowpage = 1;// 当前显示的页面
	private MyCommonTitle myCommonTitle;
	private XListView mListView;
	private CommonAdapter<Supplier> suppIntradeAdapter;
	private List<Supplier> suppliers = new ArrayList<Supplier>();
	private Handler mHandler;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.ui_supplier_in_trade);
		mHandler = new Handler();
		initView();
	}

	private void initView() {

		myCommonTitle = (MyCommonTitle) findViewById(R.id.aci_mytitle);
		myCommonTitle.setLisener(this, null, null);
		myCommonTitle.setTag("交易中");
		myCommonTitle.setBackEditTitle("供应商");

		mListView = (XListView) findViewById(R.id.list_supplier_in_trade);
		mListView.setDividerHeight(0);
		mListView.setPullRefreshEnable(true);
		mListView.setPullLoadEnable(true);
		mListView.setXListViewListener(this);

		suppIntradeAdapter = new CommonAdapter<Supplier>(
				SuppliersInTradeActivity.this,
				R.layout.ui_item_suppliers_intrade, getTestData()) {

			@Override
			public void convert(ViewHolder holder, Supplier supplier) {
				holder.setText(R.id.supplier_intrade_title,
						StringUtil.toString(supplier.getName())).setText(
						R.id.supplier_intrade_content,
						StringUtil.toString(supplier.getIntro()));
			}
		};
		mListView.setAdapter(suppIntradeAdapter);
		mListView.setOnItemClickListener(SuppliersInTradeActivity.this);
		suppIntradeAdapter.notifyDataSetChanged();
	}

	/**
	 * 测试数据
	 * 
	 * @return
	 */
	private List<Supplier> getTestData() {
		Supplier supplier1 = new Supplier();
		supplier1.setName("供应商1");
		supplier1.setIntro("简介消息简介消息简介消息简介消息简介消息简介消息");
		suppliers.add(supplier1);
		Supplier supplier2 = new Supplier();
		supplier2.setName("供应商2");
		supplier2.setIntro("简介消息简介消息简介消息简介消息简介消息简介消息");
		suppliers.add(supplier2);
		Supplier supplier3 = new Supplier();
		supplier3.setName("供应商3");
		supplier3.setIntro("简介消息简介消息简介消息简介消息简介消息简介消息");
		suppliers.add(supplier3);
		return suppliers;
	}

	@Override
	public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {

	}

	@Override
	public void onRefresh() {
		mHandler.postDelayed(new Runnable() {

			@Override
			public void run() {
				nowpage = 1;
//				requestData();
				onLoad();
			}
		}, 1000);
	}

	@Override
	public void onLoadMore() {
		mHandler.postDelayed(new Runnable() {

			@Override
			public void run() {
				nowpage += 1;
//				requestData();
				onLoad();
			}
		}, 1000);
	}

	private void onLoad() {
		mListView.stopRefresh();
		mListView.stopLoadMore();
		mListView.setRefreshTime("刚刚");
	}
}
