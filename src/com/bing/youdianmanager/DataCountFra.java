package com.bing.youdianmanager;

import java.util.ArrayList;
import java.util.List;







import com.bing.youdianmanager.adapter.DataCountPager;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class DataCountFra extends Fragment implements OnItemClickListener {

	private ViewPager dcPager;
	private List<View> pagerViews=new ArrayList<View>();
	private Spinner spinner;
	private ArrayAdapter<String> adapter;  
	 private static final String[] m={"阿玛尼","阿玛尼","阿玛尼","阿玛尼","其他"};  
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		View rootView=inflater.inflate(R.layout.fra_data_count, null);
		return rootView;
	}
	
	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onActivityCreated(savedInstanceState);
		initView();
	}

	
	private void initView(){
		dcPager=(ViewPager)getActivity().findViewById(R.id.data_view_pager);
		LayoutInflater inflater=getActivity().getLayoutInflater();
		
		View view0=inflater.inflate(R.layout.pager_data_count, null);
		View view1=inflater.inflate(R.layout.pager_data_count, null);
		View view2=inflater.inflate(R.layout.pager_data_count, null);
		pagerViews.add(view0);
		pagerViews.add(view1);
		pagerViews.add(view2);
		
		dcPager.setAdapter(new DataCountPager(pagerViews));
		dcPager.setCurrentItem(0);
		spinner=(Spinner)getActivity().findViewById(R.id.data_count_spinner);
		adapter = new ArrayAdapter<String>(getActivity(),android.R.layout.simple_spinner_item,m);
		 //设置下拉列表的风格  
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
      //将adapter 添加到spinner中  
        spinner.setAdapter(adapter);
        
        spinner.setVisibility(View.VISIBLE);  
        
//        spinner.setOnItemClickListener(this);
	}

	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position,
			long id) {
		// TODO Auto-generated method stub
		
	}
	
}
