package my.project.washingcar.view;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.Gravity;
import android.view.Window;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;

public class CategoryDialog extends Dialog {

	public CategoryDialog(Context context) {
		this(context, true, null);
	}

	protected CategoryDialog(Context context, boolean cancelable,
			OnCancelListener cancelListener) {
		super(context, cancelable, cancelListener);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		Window window = getWindow();
		// 重新设置
		WindowManager.LayoutParams params = window.getAttributes();
		window.setGravity(Gravity.LEFT | Gravity.CENTER_HORIZONTAL
				| Gravity.TOP);
		params.y = 60; // 新位置Y坐标
		params.width = LayoutParams.MATCH_PARENT;
		params.height = LayoutParams.WRAP_CONTENT;
		window.setAttributes(params);
	}

}
