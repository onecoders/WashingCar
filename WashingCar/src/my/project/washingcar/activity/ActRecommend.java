package my.project.washingcar.activity;

import my.project.washingcar.R;
import android.os.Bundle;
import android.view.LayoutInflater;
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
		View abView = LayoutInflater.from(this)
				.inflate(R.layout.ab_index, null);
		abView.findViewById(R.id.area).setOnClickListener(this);
		abView.findViewById(R.id.map).setOnClickListener(this);
		abView.findViewById(R.id.search).setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.area:

			break;
		case R.id.map:

			break;
		case R.id.search:

			break;
		default:
			break;
		}
	}

}
