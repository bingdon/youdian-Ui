package com.bing.youdianmanager;

import android.support.v7.app.ActionBarActivity;
import android.support.v4.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageButton;
import android.widget.TextView;

public class MainActivity extends ActionBarActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		getSupportActionBar().hide();
		setContentView(R.layout.activity_main);

		if (savedInstanceState == null) {
			getSupportFragmentManager().beginTransaction()
					.add(R.id.container, new PlaceholderFragment()).commit();
		}

		// mActionBar=getSupportActionBar();
		// int flags = ActionBar.DISPLAY_HOME_AS_UP;
		// int change = mActionBar.getDisplayOptions() ^ flags;
		// // mActionBar.setDisplayOptions(change, flags);
		// mActionBar.setDisplayHomeAsUpEnabled(true);
	}

	/**
	 * A placeholder fragment containing a simple view.
	 */
	public static class PlaceholderFragment extends Fragment implements
			OnClickListener {

		private ImageButton loginButton;;
		// 注册按钮
		private TextView regisTxt;

		public PlaceholderFragment() {
		}

		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container,
				Bundle savedInstanceState) {
			View rootView = inflater.inflate(R.layout.fragment_main, container,
					false);
			return rootView;
		}

		@Override
		public void onActivityCreated(Bundle savedInstanceState) {
			// TODO Auto-generated method stub
			super.onActivityCreated(savedInstanceState);
			loginButton = (ImageButton) getActivity().findViewById(
					R.id.login_btn);
			regisTxt = (TextView) getActivity().findViewById(R.id.regist_txt);
			loginButton.setOnClickListener(this);
			regisTxt.setOnClickListener(this);
		}

		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			int id = v.getId();
			switch (id) {
			
			case R.id.login_btn:
				enterHome();
				break;
			
			case R.id.regist_txt:
				enterRegist();
				break;

			default:
				break;
			}
		}

		/**
		 * 进入注册
		 */
		public void enterRegist() {
			Intent intent = new Intent();
			intent.setClass(getActivity(), ResgisterActivity.class);
			startActivity(intent);
		}
		
		
		/**
		 * 进入主界面
		 */
		public void enterHome() {
			Intent intent = new Intent();
			intent.setClass(getActivity(), HomeActivity.class);
			startActivity(intent);
		}

	}

}
