package my.project.washingcar.activity;

import my.project.washingcar.R;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;

public class ActMe extends ActBase implements OnClickListener {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.act_me);
		init();
	}

	private void init() {

	}

	@Override
	public void onClick(View v) {

	}

}
