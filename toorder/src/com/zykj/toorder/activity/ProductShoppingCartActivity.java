package com.zykj.toorder.activity;

import java.util.ArrayList;
import java.util.List;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.zykj.toorder.BaseActivity;
import com.zykj.toorder.R;
import com.zykj.toorder.adapter.CommonAdapter;
import com.zykj.toorder.adapter.ViewHolder;
import com.zykj.toorder.model.Product;
import com.zykj.toorder.view.MyCommonTitle;
import com.zykj.toorder.view.XListView;
import com.zykj.toorder.view.XListView.IXListViewListener;

public class ProductShoppingCartActivity extends BaseActivity implements IXListViewListener{
	private MyCommonTitle myCommonTitle;
	private Handler mHandler;
	private int nowpage=0;
	private int perpage=2;
	private List<Product> products=new ArrayList<Product>();
	private XListView shopcart_list;
	private CommonAdapter<Product> adapter;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.ui_product_shopping_cart);
		mHandler=new Handler();
		initView();
	}

	private void initView() {
		myCommonTitle = (MyCommonTitle) findViewById(R.id.aci_mytitle);
		myCommonTitle.setTitle("购物车");
		myCommonTitle.setBackEditTitle("首页");
		
		shopcart_list=(XListView) findViewById(R.id.xlistview_shop_cart);
		
		shopcart_list.setPullRefreshEnable(true);
		shopcart_list.setPullLoadEnable(true);
		shopcart_list.setXListViewListener(this);
		
		adapter=new CommonAdapter<Product>(this, R.layout.ui_item_shopping_cart, products) {

			@Override
			public void convert(ViewHolder holder, Product product) {
				holder.setText(R.id.product_shopcart_title, product.getPro_name())
				      .setImageUrl(R.id.product_shopcart_img, product.getPro_imgsrc())
				      .setText(R.id.product_shopcart_unit, product.getPro_unit());
				final TextView pro_delete=holder.getView(R.id.product_shopcart_delete);
				
				pro_delete.setOnClickListener(new OnClickListener() {
					
					@Override
					public void onClick(View v) {
						// TODO Auto-generated method stub
						
					}
				});
				
			}
		};
		shopcart_list.setAdapter(adapter);

	}

	private void requestData() {

		
		
		
		
		
		
	}
	@Override
	public void onRefresh() {
		mHandler.postDelayed(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				nowpage=1;
				requestData();
				onLoad();
			}
		}, 1000);
		
	}

	@Override
	public void onLoadMore() {
		mHandler.postDelayed(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				nowpage+=1;
				requestData();
				onLoad();
			}

		
		}, 1000);
	}
	private void onLoad() {
		shopcart_list.stopRefresh();
		shopcart_list.stopLoadMore();
		shopcart_list.setRefreshTime("刚刚");
	}
}
