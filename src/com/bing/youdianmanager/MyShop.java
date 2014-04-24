package com.bing.youdianmanager;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.bing.youdianmanager.adapter.ShopListAdapter;

import android.app.Activity;
import android.os.Bundle;
import android.view.Window;
import android.widget.ListView;

public class MyShop extends Activity {

	private List<Map<String, Object>> shopList = new ArrayList<Map<String, Object>>();
	private ShopListAdapter shopListAdapter;
	private ListView shopListView;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_my_shop);
		initView();
	}

	private void initView() {
		shopListView = (ListView) findViewById(R.id.my_shop_list_v);
		for (int i = 0; i < 10; i++) {
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("shop_name", "Wing");
			shopList.add(map);
		}

		shopListAdapter = new ShopListAdapter(this, shopList);
		shopListView.setAdapter(shopListAdapter);

	}

}
