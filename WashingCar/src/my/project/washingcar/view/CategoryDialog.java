package my.project.washingcar.view;

import my.project.washingcar.R;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.Gravity;
import android.view.Window;
import android.view.WindowManager;

public class CategoryDialog extends Dialog {

	public CategoryDialog(Context context) {
		this(context, R.style.DialogTheme);
	}

	public CategoryDialog(Context context, int theme) {
		super(context, theme);
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		Window window = getWindow();
		// 重新设置
		WindowManager.LayoutParams params = window.getAttributes();
		window.setGravity(Gravity.LEFT | Gravity.CENTER_HORIZONTAL
				| Gravity.TOP);
		params.y = 72; // 新位置Y坐标
		window.setAttributes(params);
	}

}
