package my.project.washingcar.activity;

import java.util.ArrayList;
import java.util.List;

import my.project.washingcar.R;
import my.project.washingcar.adapter.AdaNearbyShopBrief;
import my.project.washingcar.model.ShopBrief;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ListView;

public class ActNearBy extends ActBase implements OnClickListener {

	private ListView nearbyShops;
	private List<ShopBrief> shopBrieves;

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
		abView.findViewById(R.id.nearby_category).setOnClickListener(this);
		abView.findViewById(R.id.nearby_map).setOnClickListener(this);
		abView.findViewById(R.id.nearby_search).setOnClickListener(this);
	}

	private void initViews() {
		nearbyShops = (ListView) findViewById(R.id.nearby_shops);
		shopBrieves = new ArrayList<ShopBrief>();
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
		case R.id.nearby_category:

			break;
		case R.id.nearby_map:

			break;
		case R.id.nearby_search:

			break;
		default:
			break;
		}
	}

}
