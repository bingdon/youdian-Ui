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

/**
 * 圈子界面
 * 
 * @author lyl
 * 
 */
public class QuanziFra extends Fragment {

	// 适配器
	private QuanziAdapter quanziAdapter;
	// 数据
	private List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
	// 显示list
	private ListView qzListView;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		View rootView = inflater.inflate(R.layout.fra_quanzi, null);
		return rootView;
	}

	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onActivityCreated(savedInstanceState);

		initView();
	}

	private void initView() {
		qzListView = (ListView) getActivity().findViewById(R.id.quanzi_list_v);
		for (int i = 0; i < 5; i++) {
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("1", i);
			list.add(map);
		}
		quanziAdapter = new QuanziAdapter(getActivity(), list);
		qzListView.setAdapter(quanziAdapter);
	}

}
