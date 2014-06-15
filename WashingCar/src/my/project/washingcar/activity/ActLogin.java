package my.project.washingcar.activity;

import my.project.washingcar.R;
import my.project.washingcar.view.HeaderView;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class ActLogin extends ActBase implements OnClickListener {

	private EditText phoneNum, validateCode;
	private Button btnGetCode;
	private TextView clause;
	private Button btnToLogin, btnToRegister;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.act_login);
		init();
	}

	private void init() {
		initAbView();
		initView();
	}

	private void initAbView() {
		HeaderView header = (HeaderView) findViewById(R.id.header_login);
		header.setOnBackListener(this);
	}

	private void initView() {
		btnToRegister = (Button) findViewById(R.id.login_btn_toregister);
		btnToRegister.setOnClickListener(this);
		clause = (TextView) findViewById(R.id.login_clause);
		clause.getPaint().setFlags(Paint.UNDERLINE_TEXT_FLAG);
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.back:
			onBackPressed();
			break;
		case R.id.login_btn_toregister:
			switchActivity(ActRegister.class, null);
			break;
		default:
			break;
		}
	}

}
