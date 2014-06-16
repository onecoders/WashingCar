package my.project.washingcar.activity;

import java.util.ArrayList;
import java.util.List;

import my.project.washingcar.R;
import my.project.washingcar.adapter.AdaNearbyShopBrief;
import my.project.washingcar.model.ShopBrief;
import my.project.washingcar.view.CategoryDialog;
import my.project.washingcar.view.NearbyChooseDialogContentView;
import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.TextView;

import com.ab.view.listener.AbOnListViewListener;
import com.ab.view.pullview.AbPullListView;

public class ActNearBy extends ActBase implements OnClickListener,
		OnItemClickListener {

	private TextView nearbyCategory;

	private AbPullListView nearbyShops;
	private List<ShopBrief> shopBrieves;
	private int currentPage = 1;
	private int pageSize = 15;

	private Dialog nearbyChooseDialog;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.act_nearby);
		init();
	}

	private void init() {
		initAbView();
		initViews();
		loadContent();
	}

	private void initAbView() {
		View abView = findViewById(R.id.header_nearby);
		abView.findViewById(R.id.nearby_back).setOnClickListener(this);
		nearbyCategory = (TextView) abView.findViewById(R.id.nearby_category);
		nearbyCategory.setOnClickListener(this);
		nearbyCategory.setText(R.string.nearby_choose_nearest);
		abView.findViewById(R.id.nearby_map).setOnClickListener(this);
		abView.findViewById(R.id.nearby_search).setOnClickListener(this);
	}

	private void initViews() {
		shopBrieves = new ArrayList<ShopBrief>();
		nearbyShops = (AbPullListView) findViewById(R.id.nearby_shops);
		// 打开关闭下拉刷新加载更多功能
		nearbyShops.setPullRefreshEnable(true);
		nearbyShops.setPullLoadEnable(true);
		// 设置进度条的样式
		nearbyShops.getHeaderView().setHeaderProgressBarDrawable(
				getResources().getDrawable(R.drawable.progress_circular));
		nearbyShops.getFooterView().setFooterProgressBarDrawable(
				getResources().getDrawable(R.drawable.progress_circular));
		nearbyShops.setOnItemClickListener(this);

		nearbyShops.setAbOnListViewListener(new AbOnListViewListener() {

			@Override
			public void onRefresh() {
				nearbyShops.stopRefresh();
			}

			@Override
			public void onLoadMore() {
				nearbyShops.stopLoadMore();
			}

		});
	}

	@Override
	public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
		switchActivity(ActShopDetail.class, null);
	}

	private void loadContent() {
		for (int i = 0; i < 10; i++) {
			shopBrieves.add(new ShopBrief());
		}
		nearbyShops.setAdapter(new AdaNearbyShopBrief(this, shopBrieves));
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.nearby_back:
			((ActMain) getParent()).showExitDialog();
			break;
		case R.id.nearby_category:
			showNearbyChooseDialog();
			break;
		case R.id.nearby_map:
			switchActivity(ActLocation.class, null);
			break;
		case R.id.nearby_search:
			switchActivity(ActSearch.class, null);
			break;
		default:
			break;
		}
	}

	private void showNearbyChooseDialog() {
		nearbyChooseDialog = new CategoryDialog(this);
		View contentView = createNearByChooseContentView();
		nearbyChooseDialog.setContentView(contentView);
		nearbyChooseDialog.show();
	}

	private View createNearByChooseContentView() {
		NearbyChooseDialogContentView contentView = new NearbyChooseDialogContentView(
				this);
		contentView.setOnNearestListener(nearbyChooseListener);
		contentView.setOnHotestListener(nearbyChooseListener);
		contentView.setOnHighestDiscountListener(nearbyChooseListener);
		return contentView;
	}

	private OnClickListener nearbyChooseListener = new OnClickListener() {

		@Override
		public void onClick(View v) {
			int resid = R.string.nearby_choose_nearest;
			switch (v.getId()) {
			case R.id.nearby_choose_nearest:
				break;
			case R.id.nearby_choose_hotest:
				resid = R.string.nearby_choose_hotest;
				break;
			case R.id.nearby_choose_highest_discount:
				resid = R.string.nearby_choose_highest_discount;
				break;
			default:
				break;
			}
			nearbyCategory.setText(resid);
			nearbyChooseDialog.dismiss();
		}
	};

}
