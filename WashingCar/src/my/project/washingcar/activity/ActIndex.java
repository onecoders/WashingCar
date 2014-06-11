package my.project.washingcar.activity;

import my.project.washingcar.R;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;

public class ActIndex extends ActBase implements OnClickListener {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.act_index);
		init();
	}

	private void init() {
		initActionBar();
	}

	@Override
	protected View loadABCustomView() {
		View abView = LayoutInflater.from(this)
				.inflate(R.layout.ab_index, null);
		abView.findViewById(R.id.area).setOnClickListener(this);
		abView.findViewById(R.id.map).setOnClickListener(this);
		abView.findViewById(R.id.search).setOnClickListener(this);
		return abView;
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
