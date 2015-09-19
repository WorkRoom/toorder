package com.zykj.toorder.activity;

import android.os.Bundle;
import android.widget.TextView;

import com.zykj.toorder.BaseActivity;
import com.zykj.toorder.R;

public class TestActivity extends BaseActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		initView(R.layout.ui_test);
		
		ininView();
	}

	private void ininView() {
		String tab = getIntent().getStringExtra("tab");
		TextView test = (TextView) findViewById(R.id.test);
		test.setText(tab);
	}
}
