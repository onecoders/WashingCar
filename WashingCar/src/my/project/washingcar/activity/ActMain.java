package my.project.washingcar.activity;

import my.project.washingcar.R;
import android.app.TabActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TabHost;
import android.widget.TabHost.TabSpec;

@SuppressWarnings("deprecation")
public class ActMain extends TabActivity {

	private TabHost tabHost;

	private static final int TAB_COUNT = 3;
	private static final Class<?>[] TAB_ACT = { ActRecommend.class,
			ActNearBy.class, ActMe.class };
	private static final int[] TAB_SPEC = { R.string.tab_spec_recommend,
			R.string.tab_spec_nearby, R.string.tab_spec_me };
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
			addTab(TAB_ACT[i], TAB_SPEC[i], TAB_TITLE[i], TAB_DRAWABLE[i]);
		}
		
		// set tab as default (zero based)
		// tabHost.setCurrentTab(0);
	}

	private void addTab(Class<?> cls, int tagId, int titleId, int iconId) {
		Intent intent = new Intent().setClass(this, cls);
		TabSpec tabSpec = tabHost
				.newTabSpec(getString(tagId))
				.setIndicator(getString(titleId),
						getResources().getDrawable(iconId)).setContent(intent);
		// add tab
		tabHost.addTab(tabSpec);
	}

}
