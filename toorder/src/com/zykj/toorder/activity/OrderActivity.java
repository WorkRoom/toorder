package com.zykj.toorder.activity;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;

import com.zykj.toorder.R;
import com.zykj.toorder.fragment.OrderFragment;
import com.zykj.toorder.view.MyMainCommonTitle;

public class OrderActivity extends FragmentActivity  {
	private MyMainCommonTitle myCommonTitle;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.ui_order);
		initView();
	}

	private void initView() {
		myCommonTitle = (MyMainCommonTitle) findViewById(R.id.aci_my_maintitle);
		myCommonTitle.setLisener(null, null, null, null);
		myCommonTitle.setTitle("订单状态");

	}

}
