package com.zykj.toorder.activity;

import java.util.ArrayList;
import java.util.List;

import android.app.DownloadManager.Request;
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

public class SuppliersSystemRecommandActivity extends BaseActivity implements IXListViewListener,OnItemClickListener{
	private static int PERPAGE=10;////perpage默认每页显示10条信息
	private int nowpage=1;//当前显示的页面
	private MyCommonTitle myCommonTitle;
	private XListView mListView;
	private Supplier supplier;
	private List<Supplier> suppliers=new ArrayList<Supplier>();
	private CommonAdapter<Supplier> supplierAdapter;
	private Handler mHandler;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.ui_supplier_sys_recommand);
		initView();
	}

	private void initView() {
		mHandler=new Handler();
		myCommonTitle=(MyCommonTitle) findViewById(R.id.aci_mytitle);
		myCommonTitle.setLisener(this, null, null);
		myCommonTitle.setTitle("系统推荐");
		myCommonTitle.setBackEditTitle("供应商");
		mListView=(XListView) findViewById(R.id.list_supplier_sys_recommand);
		mListView.setDividerHeight(0);
		
		mListView.setPullLoadEnable(true);
		mListView.setPullRefreshEnable(true);
		mListView.setXListViewListener(this);
		
		supplierAdapter=new CommonAdapter<Supplier>(SuppliersSystemRecommandActivity.this,R.layout.ui_item_sys_recommand,getTestData()) {

			@Override
			public void convert(ViewHolder holder, Supplier supplier) {
				holder.setText(R.id.supplier_name, StringUtil.toString(supplier.getName()))
				.setText(R.id.supplier_contacts, StringUtil.toString(supplier.getContacts()))
					.setText(R.id.supplier_mobile, StringUtil.toString(supplier.getMobile()));	
			}
		};
		mListView.setAdapter(supplierAdapter);
		mListView.setOnItemClickListener(this);
		supplierAdapter.notifyDataSetChanged();
	}
/**
 * 测试数据
 * @return
 */
	private List<Supplier> getTestData() {
		Supplier supplier1=new Supplier();
		supplier1.setName("供应商1");
		supplier1.setMobile("13611322885");
		supplier1.setContacts("刘先生");
		suppliers.add(supplier1);
		Supplier supplier2=new Supplier();
		supplier2.setName("供应商2");
		supplier2.setMobile("13711278945");
		supplier2.setContacts("崔先生");
		suppliers.add(supplier2);
		Supplier supplier3=new Supplier();
		supplier3.setName("供应商3");
		supplier3.setMobile("13900012345");
		supplier3.setContacts("王先生");
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
				nowpage=1;
				//RequestData();
				onLoad();
			}
		}, 1000);
	}

	@Override
	public void onLoadMore() {
		mHandler.postDelayed(new Runnable() {
			
			@Override
			public void run() {
				nowpage+=1;
				//RequestData();
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
