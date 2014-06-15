package my.project.washingcar.activity;

import my.project.washingcar.R;
import android.os.Bundle;
import android.os.Handler;

public class ActStart extends ActBase {

	private static final long DELAY_MILLIS = 3 * 1000;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.act_start);
		init();
	}

	private void init() {
		delayAndSwitch2Main();
	}

	private void delayAndSwitch2Main() {
		new Handler().postDelayed(new Runnable() {

			@Override
			public void run() {
				switch2Main();
			}
		}, DELAY_MILLIS);
	}

	private void switch2Main() {
		switchActivityAndFinish(ActMain.class, null);
	}

	@Override
	public void onBackPressed() {

	}

}
