package my.project.washingcar.view;

import my.project.washingcar.R;
import android.app.Dialog;
import android.content.Context;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;

public class NewAlertDialog extends Dialog implements OnClickListener {

	public interface OnDialogBtnClickListener {

		public void onLeftBtnClick();

		public void onRightBtnClick();

	}

	private Context mContext;

	private Button leftBtn;
	private Button rightBtn;
	private TextView mTitle;
	private TextView mMessage;
	private View v;

	private OnDialogBtnClickListener listener;

	public NewAlertDialog(Context context) {
		super(context);
		mContext = context;
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.new_alert_dialog);
		v = getWindow().getDecorView();
		v.setBackgroundResource(android.R.color.transparent);
		mTitle = (TextView) findViewById(R.id.dialogTitle);
		mMessage = (TextView) findViewById(R.id.dialogMessage);
		leftBtn = (Button) findViewById(R.id.left_btn);
		leftBtn.setOnClickListener(this);
		rightBtn = (Button) findViewById(R.id.right_btn);
		rightBtn.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		if (listener == null) {
			dismiss();
			return;
		}
		switch (v.getId()) {
		case R.id.left_btn:
			listener.onLeftBtnClick();
			break;
		case R.id.right_btn:
			listener.onRightBtnClick();
			break;
		default:
			break;
		}
		dismiss();
	}

	@Override
	public void setTitle(CharSequence title) {
		super.setTitle(title);
		mTitle.setText(title);
	}

	@Override
	public void setTitle(int titleId) {
		super.setTitle(titleId);
		mTitle.setText(titleId);
	}

	public void setMessage(CharSequence message) {
		mMessage.setText(message);
		mMessage.setMovementMethod(ScrollingMovementMethod.getInstance());
	}

	public void setMessage(int messageId) {
		mMessage.setText(mContext.getResources().getString(messageId));
		mMessage.setMovementMethod(ScrollingMovementMethod.getInstance());
	}

	public void setLeftBtnText(int resid) {
		leftBtn.setText(resid);
	}

	public void setRightBtnText(int resid) {
		rightBtn.setText(resid);
	}

	public void hideRightBtn() {
		rightBtn.setVisibility(View.GONE);
	}

	public void setDialogBtnClickListener(OnDialogBtnClickListener listener) {
		this.listener = listener;
	}

}
