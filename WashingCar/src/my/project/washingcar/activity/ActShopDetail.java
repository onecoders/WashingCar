package my.project.washingcar.activity;

import my.project.washingcar.R;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;

public class ActShopDetail extends ActBase implements OnClickListener {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.act_shop_detail);
		init();
	}

	private void init() {
		initAbView();
	}

	private void initAbView() {
		View abView = findViewById(R.id.header_detail);
		abView.findViewById(R.id.detail_back).setOnClickListener(this);
		abView.findViewById(R.id.detail_star).setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.detail_back:
			onBackPressed();
			break;
		case R.id.detail_star:

			break;
		default:
			break;
		}
	}

}
