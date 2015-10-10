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

public class OrderActivity extends FragmentActivity implements
		OnPageChangeListener {
	private MyMainCommonTitle myCommonTitle;
	 private ViewPager order_viewpager;
	private OrderFragment[] fragments;
	private FragmentPagerAdapter mPagerAdapter;
	private RadioGroup tab_order;
	private RadioButton order_tab1, order_tab2, order_tab3, order_tab4,order_tab5;
	private OrderFragment orderFragment1, orderFragment2, orderFragment3,
			orderFragment4, orderFragment5;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.ui_order);
		initView();
		requestData();
	}

	private void initView() {
		myCommonTitle = (MyMainCommonTitle) findViewById(R.id.aci_my_maintitle);
		myCommonTitle.setLisener(null, null, null, null);
		myCommonTitle.setTitle("订单状态");
		tab_order = (RadioGroup) findViewById(R.id.tab_order);

		orderFragment1 = OrderFragment.getInstance(0);// 待审核
		orderFragment2 = OrderFragment.getInstance(1);// 待确认
		orderFragment3 = OrderFragment.getInstance(2);// 待发货
		orderFragment4 = OrderFragment.getInstance(3);// 待收货
		orderFragment5 = OrderFragment.getInstance(4);// 已完成

//		fragments = new OrderFragment[]{orderFragment1,orderFragment2,orderFragment3,orderFragment4,orderFragment5};
//    	mPagerAdapter = new FragmentPagerAdapter(OrderActivity.this.getSupportFragmentManager()) {
//			@Override
//			public int getCount() { return fragments.length; }
//			@Override
//			public Fragment getItem(int position) { return fragments[position]; }
//		};
//		order_viewpager.setAdapter(mPagerAdapter);
//		order_viewpager.setOnPageChangeListener(this);
		
		tab_order.setOnCheckedChangeListener(new OnCheckedChangeListener() {
			public void onCheckedChanged(RadioGroup group, int checkedId) {
				if (checkedId == R.id.order_tab1) {
					getSupportFragmentManager().beginTransaction()
							.show(orderFragment1).hide(orderFragment2)
							.hide(orderFragment3).hide(orderFragment4)
							.hide(orderFragment5).commit();
				} else if (checkedId == R.id.order_tab2) {
					getSupportFragmentManager().beginTransaction()
							.show(orderFragment2).hide(orderFragment1)
							.hide(orderFragment3).hide(orderFragment4)
							.hide(orderFragment5).commit();
				} else if (checkedId == R.id.order_tab3) {
					getSupportFragmentManager().beginTransaction()
							.show(orderFragment3).hide(orderFragment1)
							.hide(orderFragment2).hide(orderFragment4)
							.hide(orderFragment5).commit();
				} else if (checkedId == R.id.order_tab4) {
					getSupportFragmentManager().beginTransaction()
							.show(orderFragment4).hide(orderFragment1)
							.hide(orderFragment2).hide(orderFragment3)
							.hide(orderFragment5).commit();
				} else if (checkedId == R.id.order_tab5) {
					getSupportFragmentManager().beginTransaction()
							.show(orderFragment5).hide(orderFragment1)
							.hide(orderFragment2).hide(orderFragment3)
							.hide(orderFragment4).commit();
				}
			}
		});
	}

	/**
	 * 加载数据
	 */
	private void requestData() {
		getSupportFragmentManager().beginTransaction()
				.add(R.id.order_framelayout, orderFragment1)
				.add(R.id.order_framelayout, orderFragment2)
				.add(R.id.order_framelayout, orderFragment3)
				.add(R.id.order_framelayout, orderFragment4)
				.add(R.id.order_framelayout, orderFragment5)
				.show(orderFragment1).hide(orderFragment2).hide(orderFragment3)
				.hide(orderFragment4).hide(orderFragment5).commit();
	}

	@Override
	public void onPageScrollStateChanged(int arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onPageScrolled(int arg0, float arg1, int arg2) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onPageSelected(int position) {
		switch (position) {
		case 0:
			order_tab1.setChecked(true);
			break;
		case 1:
			order_tab2.setChecked(true);
			break;
		case 2:
			order_tab3.setChecked(true);
			break;
		case 3:
			order_tab4.setChecked(true);
			break;
		case 4:
			order_tab5.setChecked(true);
			break;
		default:
			break;
		}
	}
}
