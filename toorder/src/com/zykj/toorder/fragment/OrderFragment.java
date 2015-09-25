package com.zykj.toorder.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class OrderFragment extends Fragment {

	public static OrderFragment getInstance(int type) {
		OrderFragment orderFragment = new OrderFragment();
		Bundle bundle = new Bundle();
		bundle.putInt("type", type);
		orderFragment.setArguments(bundle);
		return null;
	}
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		
		
		
		return super.onCreateView(inflater, container, savedInstanceState);
	}
}
