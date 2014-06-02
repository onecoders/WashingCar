package my.project.washingcar.activity;

import my.project.washingcar.R;
import android.os.Bundle;

public class ActMain extends ActBase {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.act_main);
		init();
	}

	private void init() {
		initActionBar();
	}

	@Override
	protected void initAbContent() {
		setAbTitle(R.string.app_name);
	}

}
