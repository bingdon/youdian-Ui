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
import android.widget.TextView;

public class ShopListAdapter extends BaseAdapter {

	private List<Map<String, Object>> list;
	private LayoutInflater inflater;
	private Context context;
	
	public ShopListAdapter(Context context,List<Map<String, Object>> list){
		this.context=context;
		inflater=LayoutInflater.from(context);
		this.list=list;
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
			convertView=inflater.inflate(R.layout.my_shop_list, null);
			holder.shop_Address=(TextView)convertView.findViewById(R.id.shop_list_shop_address_txt);
			holder.shop_Captain=(TextView)convertView.findViewById(R.id.shop_list_shop_captain_name_txt);
			holder.shop_Diatance=(TextView)convertView.findViewById(R.id.shop_list_shop_location_txt);
			holder.shop_Img=(ImageView)convertView.findViewById(R.id.shop_list_shop_img);
			holder.shop_Name=(TextView)convertView.findViewById(R.id.shop_list_shop_name);
			holder.shop_Phone_Num=(TextView)convertView.findViewById(R.id.shop_list_shop_phone_num_txt);
			holder.shop_Renqi=(TextView)convertView.findViewById(R.id.shop_list_renqi_txt);
			convertView.setTag(holder);
		} else {
			holder=(ViewHolder)convertView.getTag();
		}
		
		return convertView;
	}

	private class ViewHolder{
		public ImageView shop_Img;
		public TextView shop_Name;
		public TextView shop_Address;
		public TextView shop_Captain;
		public TextView shop_Renqi;
		public TextView shop_Phone_Num;
		public TextView shop_Diatance;
	}
	
	
}
