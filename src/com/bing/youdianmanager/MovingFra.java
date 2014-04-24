package com.bing.youdianmanager;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.bing.youdianmanager.adapter.QuanziAdapter;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

public class MovingFra extends Fragment {

	private ListView movingListView;
	// ÊÊÅäÆ÷
	private QuanziAdapter movingAdapter;
	// Êý¾Ý
	private List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		View rootView = inflater.inflate(R.layout.fra_moving, null);
		return rootView;
	}

	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onActivityCreated(savedInstanceState);
		
		 initView();
		
	}

	
	private void initView() {
		movingListView = (ListView) getActivity().findViewById(R.id.moving_list_v);
		for (int i = 0; i < 5; i++) {
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("1", i);
			list.add(map);
		}
		movingAdapter = new QuanziAdapter(getActivity(), list);
		movingListView.setAdapter(movingAdapter);
	}
	
}
