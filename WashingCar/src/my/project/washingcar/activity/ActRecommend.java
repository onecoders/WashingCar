package my.project.washingcar.activity;

import java.util.ArrayList;
import java.util.List;

import my.project.washingcar.R;
import my.project.washingcar.adapter.AdaRecommendShopBrief;
import my.project.washingcar.model.ShopBrief;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
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

			break;
		case R.id.recommend_map:

			break;
		case R.id.recommend_search:

			break;
		default:
			break;
		}
	}

}
