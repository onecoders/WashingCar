package my.project.washingcar.view;

import my.project.washingcar.R;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class HeaderView extends RelativeLayout {

	private View back;
	private TextView title;

	public HeaderView(Context context) {
		this(context, null);
	}

	public HeaderView(Context context, AttributeSet attrs) {
		this(context, attrs, 0);
	}

	public HeaderView(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		inflate(context, R.layout.ab_normal, this);
		init();
	}

	private void init() {
		back = findViewById(R.id.back);
		title = (TextView) findViewById(R.id.title);
	}

	public void setOnBackListener(OnClickListener l) {
		back.setOnClickListener(l);
	}

	public void setTitle(int resid) {
		title.setText(resid);
	}

}
