package my.project.washingcar.activity;

import my.project.washingcar.R;
import android.app.AlertDialog;
import android.app.TabActivity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Window;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.TabHost;
import android.widget.TabHost.TabSpec;

@SuppressWarnings("deprecation")
public class ActMain extends TabActivity {

	private TabHost tabHost;

	private static final int TAB_COUNT = 3;
	private static final Class<?>[] TAB_ACT = { ActRecommend.class,
			ActNearBy.class, ActMe.class };
	private static final int[] TAB_TITLE = { R.string.tab_title_recommend,
			R.string.tab_title_nearby, R.string.tab_title_me };
	private static final int[] TAB_DRAWABLE = { R.drawable.icon_recommend,
			R.drawable.icon_nearby, R.drawable.icon_me };

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.act_main);
		init();
	}

	private void init() {
		tabHost = getTabHost();
		for (int i = 0; i < TAB_COUNT; i++) {
			addTab(TAB_ACT[i], TAB_TITLE[i], TAB_TITLE[i], TAB_DRAWABLE[i]);
		}

		RadioGroup radioGroup = (RadioGroup) findViewById(R.id.main_tab_group);
		radioGroup.setOnCheckedChangeListener(new OnCheckedChangeListener() {

			@Override
			public void onCheckedChanged(RadioGroup group, int checkedId) {
				int index = 0;
				switch (checkedId) {
				case R.id.main_tab_recommend:
					break;
				case R.id.main_tab_nearby:
					index = 1;
					break;
				case R.id.main_tab_me:
					index = 2;
					break;
				default:
					break;
				}
				tabHost.setCurrentTab(index);
			}
		});
	}

	private void addTab(Class<?> cls, int tagId, int titleId, int iconId) {
		Intent intent = new Intent().setClass(this, cls);
		TabSpec tabSpec = tabHost.newTabSpec(getString(tagId))
				.setIndicator(getString(titleId)).setContent(intent);
		tabHost.addTab(tabSpec);
	}

	@Override
	public boolean dispatchKeyEvent(KeyEvent event) {
		if (event.getKeyCode() == KeyEvent.KEYCODE_BACK) {
			if (event.getAction() == KeyEvent.ACTION_DOWN
					&& event.getRepeatCount() == 0) {
				showExitDialog();
			}
			return true;
		}
		return super.dispatchKeyEvent(event);
	}

	private void showExitDialog() {
		AlertDialog.Builder builder = new AlertDialog.Builder(this);
		builder.setMessage(R.string.exit_hint);
		builder.setPositiveButton(R.string.exit, new OnClickListener() {

			@Override
			public void onClick(DialogInterface dialog, int which) {
				exit();
			}

		});
		builder.setNegativeButton(R.string.cancel, null);
		AlertDialog dialog = builder.create();
		dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
		dialog.show();
	}

	private void exit() {
		finish();
		System.exit(0);
	}

}
