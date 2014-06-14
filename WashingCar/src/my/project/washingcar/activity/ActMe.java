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
		initAbView();
	}

	private void initAbView() {
		View abView = findViewById(R.id.header_me);
		abView.findViewById(R.id.me_back).setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.me_back:
			((ActMain) getParent()).showExitDialog();
			break;

		default:
			break;
		}
	}

}
