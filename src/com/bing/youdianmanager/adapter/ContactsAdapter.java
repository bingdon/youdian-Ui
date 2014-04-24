package com.bing.youdianmanager.adapter;

import java.util.List;
import java.util.Map;

import com.bing.youdianmanager.R;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
/**
 * 联系人内容适配 
 * @author lyl
 *
 */
public class ContactsAdapter extends BaseAdapter {

	private List<Map<String, Object>> list;
	private LayoutInflater inflater;
	
	public ContactsAdapter(Context context,List<Map<String, Object>> list){
		this.list=list;
		inflater=LayoutInflater.from(context);
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
			convertView=inflater.inflate(R.layout.p_c_list, null);
			holder.contact_name=(TextView)convertView.findViewById(R.id.p_c_name_txt);
			convertView.setTag(holder);
		} else {
			holder=(ViewHolder)convertView.getTag();
		}
		
		holder.contact_name.setText(list.get(position).get("contact_name").toString());
		
		return convertView;
	}

	private class ViewHolder{
		public TextView contact_name;
	}
	
}
