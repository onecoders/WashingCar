package my.project.washingcar.activity;

import my.project.washingcar.R;
import android.os.Bundle;
import android.view.View;

public class ActRecommend extends ActBase {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.act_recommend);
		init();
	}

	private void init() {
		initActionBar();
	}

	@Override
	protected View loadABCustomView() {
		return null;
	}

}
