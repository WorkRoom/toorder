package com.zykj.toorder.view;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.zykj.toorder.R;

public class MyMainCommonTitle extends RelativeLayout {

	private ImageView titleBack;
	private TextView titleEdit, backEdit;
	private ImageView sharedBtn;

	public MyMainCommonTitle(Context context, AttributeSet attrs) {
		super(context, attrs);
		LayoutInflater.from(context).inflate(R.layout.ui_mymaincommontitle, this);
		titleBack = (ImageView) findViewById(R.id.aci_back_btn);// 后退
		backEdit = (TextView) findViewById(R.id.aci_backedit_btn);// 后退后面文字
		titleEdit = (TextView) findViewById(R.id.aci_edit_btn);// 编辑
		sharedBtn = (ImageView) findViewById(R.id.aci_shared_btn);// 分享
		
		titleBack.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				((Activity) getContext()).finish();
			}
		});
	}

	public void setLisener(OnClickListener backListener,
			OnClickListener backEditListener, OnClickListener editListener,
			OnClickListener sharedListener) {
		if (editListener != null) {
			titleEdit.setVisibility(View.VISIBLE);
			titleEdit.setOnClickListener(editListener);
		}
		if (sharedListener != null) {
			sharedBtn.setVisibility(View.VISIBLE);
			sharedBtn.setOnClickListener(sharedListener);
		}
		if (backEditListener != null) {
			backEdit.setVisibility(View.VISIBLE);
			backEdit.setOnClickListener(sharedListener);
		}
		if (backListener != null) {
			titleBack.setVisibility(View.VISIBLE);
			titleBack.setOnClickListener(sharedListener);
		}
	}

	public void setTitle(String title) {
		TextView titleText = (TextView) findViewById(R.id.aci_title_tv);
		titleText.setText(title);
	}

	public void setBackEditTitle(String title) {
		backEdit.setText(title);
	}

	public void setEditTitle(String title) {
		titleEdit.setText(title);
	}

	public void setSubTitle(String subtitle) {
		TextView subtitleText = (TextView) findViewById(R.id.aci_subtitle_tv);
		subtitleText.setVisibility(View.VISIBLE);
		subtitleText.setText(subtitle);
	}

	public void setBackBtnVisible(boolean flag) {
		if (flag) {
			titleBack.setVisibility(View.VISIBLE);
		} else {
			titleBack.setVisibility(View.INVISIBLE);
		}
	}
}
