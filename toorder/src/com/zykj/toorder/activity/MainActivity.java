package com.zykj.toorder.activity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.TabHost;

import com.zykj.toorder.BaseTabActivity;
import com.zykj.toorder.R;
import com.zykj.toorder.utils.Tools;
import com.zykj.toorder.view.MyRadioButton;

public class MainActivity extends BaseTabActivity{
	
	private TabHost m_tab;
	private Intent intent_1;
	private Intent intent_2;
	private Intent intent_3;
	private Intent intent_4;
	// 单选按钮组
	private RadioGroup m_rgroup;
	// 4个单选按钮
	private MyRadioButton m_radio_product;
	private MyRadioButton m_radio_suppliers;
	private MyRadioButton m_radio_order;
	private MyRadioButton m_radio_more;
	
	@SuppressWarnings("deprecation")
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.ui_main_tabs);
		
		m_tab = getTabHost();
		initView();
	}

	private void initView() {
		// 设置圆角边线不启用
		// final TabWidget _widget = m_tab.getTabWidget();
		// _widget.setStripEnabled(false);
		intent_1 = new Intent(this, ProductActivity.class);
		intent_2 = new Intent(this, SuppliersActivity.class);
		intent_3 = new Intent(this, OrderActivity.class);
		intent_4 = new Intent(this, MoreActivity.class);

		m_tab.addTab(buildTagSpec("test1", 0, intent_1));
		m_tab.addTab(buildTagSpec("test2", 1, intent_2));
		m_tab.addTab(buildTagSpec("test3", 2, intent_3));
		m_tab.addTab(buildTagSpec("test4", 3, intent_4));

		m_rgroup = (RadioGroup) findViewById(R.id.tab_rgroup);
		m_radio_product = (MyRadioButton) findViewById(R.id.tab_radio1);
		m_radio_product.getLayoutParams().width = Tools.M_SCREEN_WIDTH/4;
		m_radio_suppliers = (MyRadioButton) findViewById(R.id.tab_radio2);
		m_radio_suppliers.getLayoutParams().width = Tools.M_SCREEN_WIDTH/4;
		m_radio_order = (MyRadioButton) findViewById(R.id.tab_radio3);
		m_radio_order.getLayoutParams().width = Tools.M_SCREEN_WIDTH/4;
		m_radio_more = (MyRadioButton) findViewById(R.id.tab_radio4);
		m_radio_more.getLayoutParams().width = Tools.M_SCREEN_WIDTH/4;

		m_rgroup.setOnCheckedChangeListener(new OnCheckedChangeListener() {
			public void onCheckedChanged(RadioGroup group, int checkedId) {
				if (checkedId == m_radio_product.getId()) {
					m_tab.setCurrentTabByTag("test1");
				} else if (checkedId == m_radio_suppliers.getId()) {
					m_tab.setCurrentTabByTag("test2");
				} else if (checkedId == m_radio_order.getId()) {
					m_tab.setCurrentTabByTag("test3");
				} else if (checkedId == m_radio_more.getId()) {
					m_tab.setCurrentTabByTag("test4");
				}
			}
		});
		m_tab.setCurrentTab(0);
	}

	private TabHost.TabSpec buildTagSpec(String tagName, int tagLable,
			Intent content) {
		return m_tab.newTabSpec(tagName).setIndicator(tagLable + "")
				.setContent(content);
	}

	@SuppressWarnings("deprecation")
	@Override
	protected void onDestroy() {
		Tools.Log("当前tabActivity退出");
		super.onDestroy();
	}
}
