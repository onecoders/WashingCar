package my.project.washingcar.activity;

import my.project.washingcar.R;
import my.project.washingcar.view.HeaderView;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.meg7.widget.CustomShapeImageView;

public class ActMe extends ActBase implements OnClickListener {

	private CustomShapeImageView avatar;
	private TextView userName;
	private RelativeLayout readyPay, alreadyPay, notUsed, myCollection,
			switchAccount, aboutApp;
	private Button btnLogin;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.act_me);
		init();
	}

	private void init() {
		initAbView();
		initView();
	}

	private void initAbView() {
		HeaderView header = (HeaderView) findViewById(R.id.header_me);
		header.setTitle(R.string.header_title_me);
		header.setOnBackListener(this);
	}

	private void initView() {
		btnLogin = (Button) findViewById(R.id.me_btn_login);
		btnLogin.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.back:
			((ActMain) getParent()).showExitDialog();
			break;
		case R.id.me_btn_login:
			switchActivity(ActLogin.class, null);
			break;
		default:
			break;
		}
	}

}
