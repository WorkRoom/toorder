package com.zykj.toorder.activity;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import com.zykj.toorder.R;
import com.zykj.toorder.fragment.OrderFragment;
import com.zykj.toorder.view.MyCommonTitle;

public class OrderActivity extends FragmentActivity {
	private MyCommonTitle myCommonTitle;
	private RadioGroup tab_order;
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
		myCommonTitle = (MyCommonTitle) findViewById(R.id.aci_mytitle);
		myCommonTitle.setTitle("订单状态");
		tab_order = (RadioGroup) findViewById(R.id.tab_order);

		orderFragment1 = OrderFragment.getInstance(1);// 待审核
		orderFragment2 = OrderFragment.getInstance(2);// 待确认
		orderFragment3 = OrderFragment.getInstance(3);// 待发货
		orderFragment4 = OrderFragment.getInstance(4);// 待收货
		orderFragment5 = OrderFragment.getInstance(5);// 已完成

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
				} else if (checkedId == R.id.order_tab1) {
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
}
