package com.zykj.toorder.activity;

import java.util.ArrayList;
import java.util.List;

import android.R.anim;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.zykj.toorder.BaseActivity;
import com.zykj.toorder.R;

public class MoreInviteActivity extends BaseActivity implements OnItemSelectedListener{

	private Spinner spinner;
	private List<String>  list;
	private ArrayAdapter<String> adapter;
@Override
protected void onCreate(Bundle savedInstanceState) {
	super.onCreate(savedInstanceState);
	setContentView(R.layout.ui_more_invitor);
	initView();
}

private void initView() {
	spinner=(Spinner) findViewById(R.id.charactor_spinner);	
	list=new ArrayList<String>();
	list.add("角色选择");
	list.add("厨师");
	list.add("采购");
	adapter=new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item, list);
	adapter.setDropDownViewResource(android.R.layout.simple_spinner_item);
	spinner.setAdapter(adapter);
	spinner.setOnItemSelectedListener(this);
	
}
@Override
public void onItemSelected(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
	// TODO Auto-generated method stub
}
@Override
public void onNothingSelected(AdapterView<?> arg0) {
	// TODO Auto-generated method stub
	
}

}
