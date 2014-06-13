package my.project.washingcar.activity;

import java.util.ArrayList;
import java.util.List;

import my.project.washingcar.R;
import my.project.washingcar.adapter.AdaNearbyShopBrief;
import my.project.washingcar.model.ShopBrief;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;

public class ActNearBy extends ActBase implements OnClickListener,
		OnItemClickListener {

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
		shopBrieves = new ArrayList<ShopBrief>();
		nearbyShops = (ListView) findViewById(R.id.nearby_shops);
		nearbyShops.setOnItemClickListener(this);
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
