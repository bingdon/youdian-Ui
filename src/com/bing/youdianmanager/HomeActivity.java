package com.bing.youdianmanager;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Toast;

public class HomeActivity extends FragmentActivity implements OnClickListener {

	private FragmentManager manager;
	// 日流量
	private RelativeLayout day_past_Layout;
	// 动态
	private RelativeLayout moving_Layout;
	// 数据
	private RelativeLayout data_Layout;
	// 圈子
	private RelativeLayout quanzi_Layout;
	// 更多
	private RelativeLayout more_Layout;
	// 日流量
	private ImageView day_past_Img;
	// 动态
	private ImageView moving_Img;
	// 数据
	private ImageView data_Img;
	// 圈子
	private ImageView quanzi_Img;
	// 更多
	private ImageView more_Img;
	// 日流水
	private DayPastFra dayPastFra;
	// 动态
	private MovingFra movingFra;
	// 更多
	private MoreFra moreFra;
	// 圈子
	private QuanziFra quanziFra;
	// 数据
	private DataCountFra dataCountFra;

	private static final int _ID_DAY_PAST = 0;
	private static final int _ID_MOVING = 1;
	private static final int _ID_DATA = 2;
	private static final int _ID_QUANZI = 3;
	private static final int _ID_MORE = 4;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_home);
		manager = getSupportFragmentManager();
		initView();
		setTab(_ID_DAY_PAST);
	}

	private void initView() {

		day_past_Layout = (RelativeLayout) findViewById(R.id.home_day_past_layout);
		moving_Layout = (RelativeLayout) findViewById(R.id.home_moving_layout);
		data_Layout = (RelativeLayout) findViewById(R.id.home_data_layout);
		quanzi_Layout = (RelativeLayout) findViewById(R.id.home_quanzi_layout);
		more_Layout = (RelativeLayout) findViewById(R.id.home_more_layout);

		day_past_Img = (ImageView) findViewById(R.id.home_day_past_img);
		moving_Img = (ImageView) findViewById(R.id.home_moving_img);
		data_Img = (ImageView) findViewById(R.id.home_data_img);
		quanzi_Img = (ImageView) findViewById(R.id.home_quanzi_img);
		more_Img = (ImageView) findViewById(R.id.home_more_img);

		day_past_Layout.setOnClickListener(this);
		moving_Layout.setOnClickListener(this);
		data_Layout.setOnClickListener(this);
		quanzi_Layout.setOnClickListener(this);
		more_Layout.setOnClickListener(this);
	}

	/**
	 * 显示
	 * 
	 * @param id
	 */
	private void setTab(int id) {

		FragmentTransaction transaction = manager.beginTransaction();
		hidefra(transaction);
		switch (id) {
		case _ID_DAY_PAST:
			if (dayPastFra == null) {
				dayPastFra = new DayPastFra();
				transaction.add(R.id.home_frame, dayPastFra);

			} else {
				transaction.show(dayPastFra);
			}
			day_past_Img.setImageResource(R.drawable.day_past_press);
			moving_Img.setImageResource(R.drawable.more_img);
			data_Img.setImageResource(R.drawable.date_img);
			quanzi_Img.setImageResource(R.drawable.quanzi_img);
			more_Img.setImageResource(R.drawable.more_img);

			break;

		case _ID_MOVING:

			if (movingFra == null) {
				movingFra = new MovingFra();
				transaction.add(R.id.home_frame, movingFra);

			} else {
				transaction.show(movingFra);
			}

			day_past_Img.setImageResource(R.drawable.day_past);
			moving_Img.setImageResource(R.drawable.more_img_press);
			data_Img.setImageResource(R.drawable.date_img);
			quanzi_Img.setImageResource(R.drawable.quanzi_img);
			more_Img.setImageResource(R.drawable.more_img);

			break;

		case _ID_DATA:

			if (dataCountFra == null) {
				dataCountFra = new DataCountFra();
				transaction.add(R.id.home_frame, dataCountFra);

			} else {
				transaction.show(dataCountFra);
			}

			day_past_Img.setImageResource(R.drawable.day_past);
			moving_Img.setImageResource(R.drawable.more_img);
			data_Img.setImageResource(R.drawable.date_img_press);
			quanzi_Img.setImageResource(R.drawable.quanzi_img);
			more_Img.setImageResource(R.drawable.more_img);

			break;

		case _ID_QUANZI:

			if (quanziFra == null) {
				quanziFra = new QuanziFra();
				transaction.add(R.id.home_frame, quanziFra);

			} else {
				transaction.show(quanziFra);
			}

			day_past_Img.setImageResource(R.drawable.day_past);
			moving_Img.setImageResource(R.drawable.more_img);
			data_Img.setImageResource(R.drawable.date_img);
			quanzi_Img.setImageResource(R.drawable.quanzi_img_press);
			more_Img.setImageResource(R.drawable.more_img);

			break;

		case _ID_MORE:

			if (moreFra == null) {
				moreFra = new MoreFra();
				transaction.add(R.id.home_frame, moreFra);

			} else {
				transaction.show(moreFra);
			}

			day_past_Img.setImageResource(R.drawable.day_past);
			moving_Img.setImageResource(R.drawable.more_img);
			data_Img.setImageResource(R.drawable.date_img);
			quanzi_Img.setImageResource(R.drawable.quanzi_img);
			more_Img.setImageResource(R.drawable.more_img_press);

			break;

		default:
			break;
		}

		transaction.commit();

	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		int id = v.getId();
		switch (id) {
		case R.id.home_day_past_layout:
			setTab(_ID_DAY_PAST);
			break;

		case R.id.home_moving_layout:
			setTab(_ID_MOVING);
			break;

		case R.id.home_data_layout:
			setTab(_ID_DATA);
			break;

		case R.id.home_quanzi_layout:
			setTab(_ID_QUANZI);
			break;

		case R.id.home_more_layout:
			setTab(_ID_MORE);
			break;

		default:
			break;
		}
	}

	private void hidefra(FragmentTransaction transaction) {
		if (dayPastFra != null) {
			transaction.hide(dayPastFra);
		}

		if (movingFra != null) {
			transaction.hide(movingFra);
		}
		if (moreFra != null) {
			transaction.hide(moreFra);
		}

		if (quanziFra != null) {
			transaction.hide(quanziFra);
		}

		if (dataCountFra != null) {
			transaction.hide(dataCountFra);
		}

	}

}
