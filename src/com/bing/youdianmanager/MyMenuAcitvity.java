package com.bing.youdianmanager;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.RelativeLayout;

public class MyMenuAcitvity extends Activity implements OnClickListener {

	private RelativeLayout myStaff;

	private RelativeLayout myshop;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.home_my_menu);

		myshop = (RelativeLayout) findViewById(R.id.my_menu_my_shop_layout);
		myStaff = (RelativeLayout) findViewById(R.id.my_menu_my_staff_layout);
		myshop.setOnClickListener(this);
		myStaff.setOnClickListener(this);

	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		int id = v.getId();
		switch (id) {
		case R.id.my_menu_my_staff_layout:
			enterMystaff();
			break;

		case R.id.my_menu_my_shop_layout:
			enterMyShop();
			break;

		default:
			break;
		}
	}

	private void enterMystaff() {
		Intent intent = new Intent();
		intent.setClass(MyMenuAcitvity.this, MyStaff.class);
		startActivity(intent);
		finish();
	}
	
	private void enterMyShop() {
		Intent intent = new Intent();
		intent.setClass(MyMenuAcitvity.this, MyShop.class);
		startActivity(intent);
		finish();
	}
	

}
