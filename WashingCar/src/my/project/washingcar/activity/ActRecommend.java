package my.project.washingcar.activity;

import java.util.ArrayList;
import java.util.List;

import my.project.washingcar.R;
import my.project.washingcar.adapter.AdaShopBrief;
import my.project.washingcar.model.ShopBrief;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ListView;

public class ActRecommend extends ActBase implements OnClickListener {

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
	}

	private void initAbView() {
		View abView = findViewById(R.id.header_recommend);
		abView.findViewById(R.id.recommend_area).setOnClickListener(this);
		abView.findViewById(R.id.recommend_map).setOnClickListener(this);
		abView.findViewById(R.id.recommend_search).setOnClickListener(this);
	}

	private void initViews() {
		recommendShops = (ListView) findViewById(R.id.recommend_shops);
		shopBrieves = new ArrayList<ShopBrief>();
	}

	@Override
	protected void onResume() {
		super.onResume();
		loadContent();
	}

	private void loadContent() {
		for (int i = 0; i < 10; i++) {
			shopBrieves.add(new ShopBrief());
		}
		recommendShops.setAdapter(new AdaShopBrief(this, shopBrieves));
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
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
