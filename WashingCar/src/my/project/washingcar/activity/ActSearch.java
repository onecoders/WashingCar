package my.project.washingcar.activity;

import java.util.ArrayList;
import java.util.List;

import my.project.washingcar.R;
import my.project.washingcar.adapter.AdaChildArea;
import my.project.washingcar.model.ChildArea;
import my.project.washingcar.view.HeaderView;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.TextView;

public class ActSearch extends ActBase implements OnClickListener, TextWatcher {

	private EditText keyWords;
	private TextView cancel;
	private GridView areaCategory;
	private ListView resultShops;

	private String[] areaNames = { "全城", "钟楼区", "天宁区", "武进区", "新北区", "溧阳市",
			"金坛市", "戚墅堰区" };

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.act_search);
		init();
	}

	private void init() {
		initAbView();
		initView();
	}

	private void initAbView() {
		HeaderView header = (HeaderView) findViewById(R.id.header_search);
		header.setOnBackListener(this);
	}

	private void initView() {
		keyWords = (EditText) findViewById(R.id.search_key_words);
		cancel = (TextView) findViewById(R.id.search_cancel);
		areaCategory = (GridView) findViewById(R.id.search_category_area);
		resultShops = (ListView) findViewById(R.id.search_result_shops);
		keyWords.addTextChangedListener(this);
		cancel.setOnClickListener(this);
		// simulation
		List<ChildArea> childAreas = new ArrayList<ChildArea>();
		for (int i = 0; i < areaNames.length; i++) {
			childAreas.add(new ChildArea(areaNames[i]));
		}
		areaCategory.setAdapter(new AdaChildArea(this, childAreas));
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.back:
			onBackPressed();
			break;
		case R.id.search_cancel:
			keyWords.setText("");
			break;
		default:
			break;
		}
	}

	@Override
	public void beforeTextChanged(CharSequence s, int start, int count,
			int after) {

	}

	@Override
	public void onTextChanged(CharSequence s, int start, int before, int count) {
		cancel.setVisibility(isEmpty(keyWords.getText().toString()) ? View.GONE
				: View.VISIBLE);
	}

	@Override
	public void afterTextChanged(Editable s) {
		// do search here
	}

}
