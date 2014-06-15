package my.project.washingcar.view;

import my.project.washingcar.R;
import my.project.washingcar.model.ChildArea;
import android.content.Context;
import android.util.AttributeSet;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class AreaChooseDialogContentView extends LinearLayout {

	private TextView cityName;
	private RelativeLayout switchCity;
	private NoScrollGridView childAreas;

	public AreaChooseDialogContentView(Context context) {
		this(context, null);
	}

	public AreaChooseDialogContentView(Context context, AttributeSet attrs) {
		super(context, attrs);
		inflate(context, R.layout.dialog_area_choose, this);
		init();
	}

	private void init() {
		cityName = (TextView) findViewById(R.id.area_choose_city_name);
		switchCity = (RelativeLayout) findViewById(R.id.area_choose_switch_city);
		childAreas = (NoScrollGridView) findViewById(R.id.area_choose_child_grid);
	}

	public void setCityName(String name) {
		cityName.setText(name);
	}

	public void setOnSwitchCityListener(OnClickListener l) {
		switchCity.setOnClickListener(l);
	}

	public void setChildAreaAdapter(ArrayAdapter<ChildArea> adapter) {
		childAreas.setAdapter(adapter);
	}

	public void setOnChildAreaItemClickListener(OnItemClickListener listener) {
		childAreas.setOnItemClickListener(listener);
	}

}
