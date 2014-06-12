package my.project.washingcar.activity;

import my.project.washingcar.R;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;

public class ActNearBy extends ActBase implements OnClickListener {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.act_nearby);
		init();
	}

	private void init() {
		initAbView();
	}

	private void initAbView() {
		View abView = findViewById(R.id.header_nearby);
		abView.findViewById(R.id.nearby_category).setOnClickListener(this);
		abView.findViewById(R.id.nearby_map).setOnClickListener(this);
		abView.findViewById(R.id.nearby_search).setOnClickListener(this);
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
