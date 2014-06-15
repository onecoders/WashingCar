package my.project.washingcar.view;

import my.project.washingcar.R;
import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

public class NearbyChooseDialogContentView extends LinearLayout {

	private RelativeLayout nearest, hotest, highestDiscount;

	public NearbyChooseDialogContentView(Context context) {
		this(context, null);
	}

	public NearbyChooseDialogContentView(Context context, AttributeSet attrs) {
		super(context, attrs);
		inflate(context, R.layout.dialog_nearby_choose, this);
		init();
	}

	private void init() {
		nearest = (RelativeLayout) findViewById(R.id.nearby_choose_nearest);
		hotest = (RelativeLayout) findViewById(R.id.nearby_choose_hotest);
		highestDiscount = (RelativeLayout) findViewById(R.id.nearby_choose_highest_discount);
	}

	public void setOnNearestListener(OnClickListener l) {
		nearest.setOnClickListener(l);
	}

	public void setOnHotestListener(OnClickListener l) {
		hotest.setOnClickListener(l);
	}

	public void setOnHighestDiscountListener(OnClickListener l) {
		highestDiscount.setOnClickListener(l);
	}

}
