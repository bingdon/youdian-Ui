package com.bing.youdianmanager.adapter;

import java.util.List;
import java.util.Map;

import com.bing.youdianmanager.R;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class StaffAdapter extends BaseExpandableListAdapter {

	private List<Map<String, Object>> groupList;

	private List<List<Map<String, Object>>> childList;

	private LayoutInflater inflater;

	private Context context;

	private class ChildViewHolder {
		public ImageView staff_head;
		public TextView staff_name;
	}
	
	
	private class GroupViewHolder {
		public TextView group_name;
	}

	public StaffAdapter(Context context, List<Map<String, Object>> groupList,
			List<List<Map<String, Object>>> childList) {
		inflater = LayoutInflater.from(context);
		this.context = context;
		this.groupList = groupList;
		this.childList = childList;
	}

	@Override
	public int getGroupCount() {
		// TODO Auto-generated method stub
		return groupList.size();
	}

	@Override
	public int getChildrenCount(int groupPosition) {
		// TODO Auto-generated method stub
		return childList.get(groupPosition).size();
	}

	@Override
	public Object getGroup(int groupPosition) {
		// TODO Auto-generated method stub
		return groupList.get(groupPosition);
	}

	@Override
	public Object getChild(int groupPosition, int childPosition) {
		// TODO Auto-generated method stub
		return childList.get(groupPosition).get(childPosition);
	}

	@Override
	public long getGroupId(int groupPosition) {
		// TODO Auto-generated method stub
		return groupPosition;
	}

	@Override
	public long getChildId(int groupPosition, int childPosition) {
		// TODO Auto-generated method stub
		return childPosition;
	}

	@Override
	public boolean hasStableIds() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public View getGroupView(int groupPosition, boolean isExpanded,
			View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		
		GroupViewHolder gHolder;
		if (convertView == null) {
			gHolder = new GroupViewHolder();
			convertView = inflater.inflate(R.layout.group_staff_list, null);
			gHolder.group_name = (TextView) convertView
					.findViewById(R.id.group_staff_gname_txt);
			convertView.setTag(gHolder);
		} else {
			gHolder = (GroupViewHolder) convertView.getTag();
		}

		gHolder.group_name.setText(groupList.get(groupPosition).get("group_name").toString());
		
		
		return convertView;
	}

	@Override
	public View getChildView(int groupPosition, int childPosition,
			boolean isLastChild, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		ChildViewHolder cHolder;
		if (convertView == null) {
			cHolder = new ChildViewHolder();
			convertView = inflater.inflate(R.layout.my_staff_list, null);
			cHolder.staff_name = (TextView) convertView
					.findViewById(R.id.child_list_staff_name_txt);
			convertView.setTag(cHolder);
		} else {
			cHolder = (ChildViewHolder) convertView.getTag();
		}

		cHolder.staff_name.setText(childList.get(groupPosition)
				.get(childPosition).get("staff_name").toString());

		return convertView;
	}

	@Override
	public boolean isChildSelectable(int groupPosition, int childPosition) {
		// TODO Auto-generated method stub
		return true;
	}

}
