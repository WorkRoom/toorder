package com.zykj.toorder.adapter;

import java.util.List;

import com.zykj.toorder.R;
import com.zykj.toorder.model.Product;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView.FindListener;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class ShoppingCartAdapter extends BaseAdapter {
	LayoutInflater mLayoutInflater;
	List<Product> datalist;
	Context mContext;

	public ShoppingCartAdapter(LayoutInflater mLayoutInflater,
			List<Product> datalist, Context mContext) {
		super();
		this.mLayoutInflater = mLayoutInflater;
		this.datalist = datalist;
		this.mContext = mContext;
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return datalist.size();
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return datalist.get(position);
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		ViewHolder holder;
		if(convertView==null){
			holder=new ViewHolder();
			convertView=mLayoutInflater.inflate(R.layout.ui_item_shopping_cart, null);
			//holder.pro_imgsrc=convertView.findViewById(R.id.product_shopcart_img);
		}

		return convertView;
	}

	public final class ViewHolder {
		public ImageView pro_imgsrc;
		public TextView pro_name;
		public TextView pro_specification;
		public TextView pro_delete;
		public EditText pro_count;

	}
}
