package com.bing.youdianmanager;

import com.bing.youdianmanager.customview.RoundProgressBar;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;

public class DayPastFra extends Fragment implements OnClickListener {

	// 任务完成比
	private RoundProgressBar taskPro;

	private int progress = 0;
	// 目录入
	private ImageView mlrImageView;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		View rootView = inflater.inflate(R.layout.fra_day_past, null);
		return rootView;
	}

	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onActivityCreated(savedInstanceState);
		initView();
	}

	@Override
	public void onResume() {
		// TODO Auto-generated method stub
		super.onResume();

		new Thread(taskCompleRunnable).start();

	}

	private void initView() {
		taskPro = (RoundProgressBar) getActivity().findViewById(
				R.id.day_past_comple_pro);
		mlrImageView = (ImageView) getActivity().findViewById(
				R.id.day_past_mlr_img);
		mlrImageView.setOnClickListener(this);
	}

	private Runnable taskCompleRunnable = new Runnable() {

		@Override
		public void run() {
			// TODO Auto-generated method stub
			while (progress < 30) {
				progress = progress + 2;
				taskPro.setProgress(progress);
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	};

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		int id=v.getId();
		switch (id) {
		case R.id.day_past_mlr_img:
			enterMenu();
			break;

		default:
			break;
		}
	}
	
	
	private void enterMenu(){
		Intent intent=new Intent();
		intent.setClass(getActivity(), MyMenuAcitvity.class);
		startActivity(intent);
	}
	
	
}
