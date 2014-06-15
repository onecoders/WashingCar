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

public class ActRegister extends ActBase implements OnClickListener {

	private EditText userName, phoneNum, validateCode;
	private Button btnGetCode;
	private TextView clause;
	private Button btnCommit;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.act_register);
		init();
	}

	private void init() {
		initAbView();
		initView();
	}

	private void initAbView() {
		HeaderView header = (HeaderView) findViewById(R.id.header_register);
		header.setTitle(R.string.header_title_register);
		header.setOnBackListener(this);
	}

	private void initView() {
		clause = (TextView) findViewById(R.id.register_clause);
		clause.getPaint().setFlags(Paint.UNDERLINE_TEXT_FLAG);
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.back:
			onBackPressed();
			break;
		default:
			break;
		}
	}

}
