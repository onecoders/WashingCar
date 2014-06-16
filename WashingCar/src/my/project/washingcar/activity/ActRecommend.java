package my.project.washingcar.activity;

import java.util.ArrayList;
import java.util.List;

import my.project.washingcar.R;
import my.project.washingcar.adapter.AdaChildArea;
import my.project.washingcar.adapter.AdaRecommendShopBrief;
import my.project.washingcar.model.ChildArea;
import my.project.washingcar.model.ShopBrief;
import my.project.washingcar.view.AreaChooseDialogContentView;
import my.project.washingcar.view.CategoryDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.TextView;

import com.ab.view.listener.AbOnListViewListener;
import com.ab.view.pullview.AbPullListView;

public class ActRecommend extends ActBase implements OnClickListener,
		OnItemClickListener {

	private AbPullListView recommendShops;
	private List<ShopBrief> shopBrieves;
	private int currentPage = 1;
	private int pageSize = 15;

	private TextView areaChoose;
	private Dialog areaChooseDialog;
	private String[] areaNames = { "全城", "钟楼区", "天宁区", "武进区", "新北区", "溧阳市",
			"金坛市", "戚墅堰区" };

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.act_recommend);
		init();
	}

	private void init() {
		initAbView();
		initViews();
		loadContent();
	}

	private void initAbView() {
		View abView = findViewById(R.id.header_recommend);
		abView.findViewById(R.id.recommend_back).setOnClickListener(this);
		areaChoose = (TextView) abView.findViewById(R.id.recommend_area_choose);
		areaChoose.setOnClickListener(this);
		abView.findViewById(R.id.recommend_map).setOnClickListener(this);
		abView.findViewById(R.id.recommend_search).setOnClickListener(this);
	}

	private void initViews() {
		shopBrieves = new ArrayList<ShopBrief>();
		recommendShops = (AbPullListView) findViewById(R.id.recommend_shops);
		// 打开关闭下拉刷新加载更多功能
		recommendShops.setPullRefreshEnable(true);
		recommendShops.setPullLoadEnable(true);
		// 设置进度条的样式
		recommendShops.getHeaderView().setHeaderProgressBarDrawable(
				getResources().getDrawable(R.drawable.progress_circular));
		recommendShops.getFooterView().setFooterProgressBarDrawable(
				getResources().getDrawable(R.drawable.progress_circular));
		recommendShops.setOnItemClickListener(this);

		recommendShops.setAbOnListViewListener(new AbOnListViewListener() {

			@Override
			public void onRefresh() {
				recommendShops.stopRefresh();
			}

			@Override
			public void onLoadMore() {
				recommendShops.stopLoadMore();
			}

		});
	}

	@Override
	public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
		switch (arg0.getId()) {
		case R.id.recommend_shops:
			switchActivity(ActShopDetail.class, null);
			break;
		case R.id.area_choose_child_grid:
			areaChoose.setText(areaNames[arg2]);
			areaChooseDialog.dismiss();
			break;
		default:
			break;
		}
	}

	private void loadContent() {
		for (int i = 0; i < 10; i++) {
			shopBrieves.add(new ShopBrief());
		}
		recommendShops.setAdapter(new AdaRecommendShopBrief(this, shopBrieves));
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.recommend_back:
			((ActMain) getParent()).showExitDialog();
			break;
		case R.id.recommend_area_choose:
			showAreaChooseDialog();
			break;
		case R.id.recommend_map:
			switchActivity(ActLocation.class, null);
			break;
		case R.id.recommend_search:
			switchActivity(ActSearch.class, null);
			break;
		default:
			break;
		}
	}

	private void showAreaChooseDialog() {
		areaChooseDialog = new CategoryDialog(this);
		View contentView = createAreaChooseContentView();
		areaChooseDialog.setContentView(contentView);
		areaChooseDialog.show();
	}

	private View createAreaChooseContentView() {
		AreaChooseDialogContentView contentView = new AreaChooseDialogContentView(
				this);
		List<ChildArea> childAreas = new ArrayList<ChildArea>();
		for (int i = 0; i < areaNames.length; i++) {
			childAreas.add(new ChildArea(areaNames[i]));
		}
		contentView.setChildAreaAdapter(new AdaChildArea(this, childAreas));
		contentView.setOnChildAreaItemClickListener(this);
		return contentView;
	}
}
