package com.bing.youdianmanager;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.bing.youdianmanager.adapter.StaffAdapter;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.ExpandableListView;
import android.widget.ImageView;
import android.widget.RelativeLayout;

/**
 * 我的员工
 * 
 * @author lyl
 * 
 */
public class MyStaff extends Activity implements OnClickListener {
	// 员工列表
	private ExpandableListView expandableListView;

	private StaffAdapter staffAdapter;

	private List<Map<String, Object>> groupList = new ArrayList<Map<String, Object>>();

	private List<List<Map<String, Object>>> childList = new ArrayList<List<Map<String, Object>>>();

	private ImageView add_staff;

	private RelativeLayout searchLayout;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_my_staff);
		initView();
	}

	private void initView() {

		add_staff = (ImageView) findViewById(R.id.my_staff_add);
		searchLayout = (RelativeLayout) findViewById(R.id.search_layout);
		add_staff.setOnClickListener(this);
		searchLayout.setOnClickListener(this);

		expandableListView = (ExpandableListView) findViewById(R.id.my_staff_expand_list_);

		for (int i = 0; i < 10; i++) {
			Map<String, Object> groupMap = new HashMap<String, Object>();
			groupMap.put("group_name", "第" + i + "组");
			List<Map<String, Object>> children = new ArrayList<Map<String, Object>>();
			for (int j = 0; j < 10; j++) {
				Map<String, Object> childMap = new HashMap<String, Object>();
				childMap.put("staff_name", "BING");
				children.add(childMap);
			}
			childList.add(children);
			groupList.add(groupMap);
		}

		staffAdapter = new StaffAdapter(this, groupList, childList);
		expandableListView.setAdapter(staffAdapter);

	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		int id = v.getId();
		switch (id) {
		case R.id.my_staff_add:
			enterContacts();
			break;

		case R.id.search_layout:
			onSearchRequested();
			break;

		default:
			break;
		}

	}

	@Override
	public boolean onSearchRequested() {
		// TODO Auto-generated method stub

		Bundle appSearchData = new Bundle();
		appSearchData.putString("demo_key", "text");

		startSearch(null, false, appSearchData, false);

		return true;
	}

	private void enterContacts() {
		Intent intent = new Intent();
		intent.setClass(MyStaff.this, MyConatcts.class);
		startActivity(intent);
	}

}
