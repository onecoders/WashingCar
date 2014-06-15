package my.project.washingcar.activity;

import java.util.ArrayList;
import java.util.List;

import my.project.washingcar.R;
import my.project.washingcar.adapter.AdaChildArea;
import my.project.washingcar.adapter.AdaRecommendShopBrief;
import my.project.washingcar.model.ChildArea;
import my.project.washingcar.model.ShopBrief;
import my.project.washingcar.view.AreaDialogContentView;
import android.app.Dialog;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;

public class ActRecommend extends ActBase implements OnClickListener,
		OnItemClickListener {

	private ListView recommendShops;
	private List<ShopBrief> shopBrieves;

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
		abView.findViewById(R.id.recommend_area).setOnClickListener(this);
		abView.findViewById(R.id.recommend_map).setOnClickListener(this);
		abView.findViewById(R.id.recommend_search).setOnClickListener(this);
	}

	private void initViews() {
		shopBrieves = new ArrayList<ShopBrief>();
		recommendShops = (ListView) findViewById(R.id.recommend_shops);
		recommendShops.setOnItemClickListener(this);
	}

	@Override
	public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
		switchActivity(ActShopDetail.class, null);
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
		case R.id.recommend_area:
			showAreaChooseDialog();
			break;
		case R.id.recommend_map:
			switchActivity(ActLocation.class, null);
			break;
		case R.id.recommend_search:

			break;
		default:
			break;
		}
	}

	private void showAreaChooseDialog() {
		Dialog dialog = new Dialog(this);
		dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
		AreaDialogContentView contentView = new AreaDialogContentView(this);
		List<ChildArea> childAreas = new ArrayList<ChildArea>();
		String[] areaNames = { "全城", "钟楼区", "天宁区", "武进区", "新北区", "溧阳市", "金坛市",
				"戚墅堰区" };
		for (int i = 0; i < areaNames.length; i++) {
			childAreas.add(new ChildArea(areaNames[i]));
		}
		contentView.setChildAreaAdapter(new AdaChildArea(this, childAreas));
		dialog.setContentView(contentView);
		Window window = dialog.getWindow();
		// 重新设置
		WindowManager.LayoutParams lp = window.getAttributes();
		window.setGravity(Gravity.LEFT | Gravity.TOP);
		lp.y = 60; // 新位置Y坐标
		window.setAttributes(lp);
		dialog.show();
	}
}
