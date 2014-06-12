package my.project.washingcar.activity;

import my.project.washingcar.R;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;

public class ActRecommend extends ActBase implements OnClickListener {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.act_recommend);
		init();
	}

	private void init() {
		initAbView();
	}

	private void initAbView() {
		View abView = findViewById(R.id.header_recommend);
		abView.findViewById(R.id.recommend_area).setOnClickListener(this);
		abView.findViewById(R.id.recommend_map).setOnClickListener(this);
		abView.findViewById(R.id.recommend_search).setOnClickListener(this);
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
