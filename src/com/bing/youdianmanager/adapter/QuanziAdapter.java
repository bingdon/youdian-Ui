package com.bing.youdianmanager.adapter;

import java.util.List;
import java.util.Map;

import com.bing.youdianmanager.R;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
/**
 * È¦×ÓÄÚÈÝÊÊÅäÆ÷
 * @author lyl
 *
 */
public class QuanziAdapter extends BaseAdapter {

	
	private List<Map<String, Object>> list;
	private LayoutInflater inflater;
	private Context context;
	private class ViewHolder{
		public ImageView userHeadImg;
	}
	
	public QuanziAdapter(Context context, List<Map<String, Object>> list){
		this.list=list;
		inflater=LayoutInflater.from(context);
		this.context=context;
	}
	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return list.size();
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return list.get(position);
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		ViewHolder holder;
		if (convertView==null) {
			holder=new ViewHolder();
			convertView=inflater.inflate(R.layout.quanzi_list, null);
			holder.userHeadImg=(ImageView)convertView.findViewById(R.id.quanzi_list_userhead_img);
			convertView.setTag(holder);
		} else {
			holder=(ViewHolder)convertView.getTag();
		}
		return convertView;
	}

}
