package com.bing.youdianmanager;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.bing.youdianmanager.adapter.ContactsAdapter;

import android.app.Activity;
import android.content.ContentResolver;
import android.database.Cursor;
import android.os.Bundle;
import android.provider.ContactsContract.CommonDataKinds.Phone;
import android.provider.ContactsContract.Contacts.Photo;
import android.text.TextUtils;
import android.util.Log;
import android.view.Window;
import android.widget.ListView;

public class MyConatcts extends Activity {

	private ListView contactListView;
	private List<Map<String, Object>> phonenumList = new ArrayList<Map<String, Object>>();
	private ContactsAdapter contactsAdapter;

	private final String[] PHONES_PROJECTION = new String[] {
			Phone.DISPLAY_NAME, Phone.NUMBER, Photo.PHOTO_ID, Phone.CONTACT_ID };

	/** 联系人显示名称 **/
	private static final int PHONES_DISPLAY_NAME_INDEX = 0;

	/** 电话号码 **/
	private static final int PHONES_NUMBER_INDEX = 1;

	/** 头像ID **/
	private static final int PHONES_PHOTO_ID_INDEX = 2;

	/** 联系人的ID **/
	private static final int PHONES_CONTACT_ID_INDEX = 3;
	
	private static final String TAG="MyConatcts";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_phone_contacts);
		initView();
	}

	private void initView() {
		contactListView = (ListView) findViewById(R.id.p_c_list_v);
		contactsAdapter = new ContactsAdapter(this, phonenumList);
		contactListView.setAdapter(contactsAdapter);
		getContacts();
	}

	private void getContacts() {
		ContentResolver resolver = getContentResolver();
		Cursor phoneCursor = resolver.query(Phone.CONTENT_URI,
				PHONES_PROJECTION, null, null, null);
		if (phoneCursor != null) {
			while (phoneCursor.moveToNext()) {
				// 得到手机号码
				String phoneNumber = phoneCursor.getString(PHONES_NUMBER_INDEX);
				
				if (TextUtils.isEmpty(phoneNumber))
					continue;
				// 得到联系人名称
				String contactName = phoneCursor
						.getString(PHONES_DISPLAY_NAME_INDEX);
				Map<String, Object> map = new HashMap<String, Object>();
				map.put("contact_name", contactName);
				map.put("phonenum", phoneNumber);
				phonenumList.add(map);

			}

			phoneCursor.close();

			contactsAdapter.notifyDataSetChanged();

		}
	}

}
