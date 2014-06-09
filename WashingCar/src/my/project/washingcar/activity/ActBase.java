package my.project.washingcar.activity;

import java.lang.reflect.Type;

import my.project.washingcar.F;
import my.project.washingcar.R;
import my.project.washingcar.utils.MToast;
import my.project.washingcar.utils.NetworkUtil;
import my.project.washingcar.view.NewAlertDialog;
import my.project.washingcar.view.NewAlertDialog.OnDialogBtnClickListener;
import my.project.washingcar.view.ProgressHUD;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Gravity;
import android.view.View;

import com.actionbarsherlock.app.ActionBar;
import com.actionbarsherlock.app.SherlockActivity;

/**
 * Base Activity
 * 
 * @author roy
 * @email onecoders@gmail.com
 */

public abstract class ActBase extends SherlockActivity implements
		OnCancelListener {

	private ProgressHUD mProgressHUD;

	private boolean currentConnected;

	private BroadcastReceiver receiver = new BroadcastReceiver() {

		@Override
		public void onReceive(Context context, Intent intent) {
			boolean conneced = isNetworkConnected();
			if (currentConnected && !conneced) {
				onNetworkInterupt();
			} else if (!currentConnected && conneced) {
				onNetworkConnect();
			}
			currentConnected = conneced;
		}

	};

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		init();
	}

	private void init() {
		currentConnected = isNetworkConnected();
		registerReceiver();
	}

	protected void initActionBar() {
		ActionBar actionBar = getSupportActionBar();
		// Get custom view
		View customerView = loadABCustomView();
		// Now set custom view
		initActionBarAndSetCustomView(actionBar, customerView);
	}

	protected abstract View loadABCustomView();

	private static void initActionBarAndSetCustomView(ActionBar actionBar,
			View customerView) {
		// set LayoutParams
		ActionBar.LayoutParams params = new ActionBar.LayoutParams(
				ActionBar.LayoutParams.MATCH_PARENT,
				ActionBar.LayoutParams.MATCH_PARENT, Gravity.CENTER);
		// Set display to custom next
		actionBar.setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
		// Do any other config to the action bar
		actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_STANDARD);
		actionBar.setDisplayShowHomeEnabled(false);
		actionBar.setDisplayHomeAsUpEnabled(false);
		actionBar.setDisplayShowTitleEnabled(false);
		// Now set custom view
		actionBar.setCustomView(customerView, params);
	}

	protected void showDialog(int titleId, int msgId, int leftBtnText,
			int rightBtnText, OnDialogBtnClickListener listener) {
		showDialog(titleId, getString(msgId), leftBtnText, false, rightBtnText,
				listener);
	}

	protected void showDialog(int titleId, String msg, int leftBtnText,
			boolean hideRightBtn, int rightBtnText,
			OnDialogBtnClickListener listener) {
		NewAlertDialog dialog = new NewAlertDialog(this);
		dialog.setTitle(titleId);
		dialog.setMessage(msg);
		dialog.setLeftBtnText(leftBtnText);
		dialog.setDialogBtnClickListener(listener);
		if (hideRightBtn) {
			dialog.hideRightBtn();
		} else {
			dialog.setRightBtnText(rightBtnText);
		}
		dialog.show();
	}

	protected void showProgressHUD() {
		showProgressHUD(R.string.hint_when_loading);
	}

	protected void showProgressHUD(int resid) {
		mProgressHUD = ProgressHUD.show(this, getString(resid), true, false,
				this);
	}

	protected void setMessage(String message) {
		mProgressHUD.setMessage(message);
	}

	protected void updateMessage(int progress) {
		setMessage(getString(R.string.downloading) + progress + "%");
	}

	@Override
	public void onCancel(DialogInterface dialog) {
		dismissProgressHUD();
	}

	protected void dismissProgressHUD() {
		mProgressHUD.dismiss();
	}

	protected void showToast(int resId) {
		MToast.showText(this, resId);
	}

	protected void showToast(String msg) {
		MToast.showText(this, msg);
	}

	protected void switchActivity(Class<?> cls, Bundle extras) {
		Intent intent = new Intent(this, cls);
		if (extras != null) {
			intent.putExtras(extras);
		}
		startActivity(intent);
	}

	protected void switchActivityAndFinish(Class<?> cls, Bundle extras) {
		switchActivity(cls, extras);
		finish();
	}

	protected void switchActivityForResult(Class<?> cls, int requestCode,
			Bundle extras) {
		Intent intent = new Intent(this, cls);
		if (extras != null) {
			intent.putExtras(extras);
		}
		startActivityForResult(intent, requestCode);
	}

	protected void switchActivityReorder2Front(Class<?> cls) {
		Intent intent = new Intent(this, cls);
		intent.addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
		startActivity(intent);
	}

	protected boolean isEmpty(String str) {
		return TextUtils.isEmpty(str);
	}

	// 网络连接时调用
	protected void onNetworkConnect() {
		showToast(R.string.network_connect);
	}

	// 网络断开时调用
	protected void onNetworkInterupt() {
		showToast(R.string.network_interupt);
	}

	protected boolean isNetworkConnected() {
		return NetworkUtil.isNetworkConnected(this);
	}

	protected String toJson(Object src) {
		return F.toJson(src);
	}

	public static <T> T fromJson(String json, Class<T> classOfT) {
		return F.fromJson(json, classOfT);
	}

	public static <T> T fromJson(String json, Type typeOfT) {
		return F.fromJson(json, typeOfT);
	}

	@Override
	protected void onDestroy() {
		unregisterReceiver();
		super.onDestroy();
	}

	private void registerReceiver() {
		IntentFilter filter = new IntentFilter();
		filter.addAction(ConnectivityManager.CONNECTIVITY_ACTION);
		if (null != receiver) {
			registerReceiver(receiver, filter);
		}
	}

	private void unregisterReceiver() {
		if (null != receiver) {
			unregisterReceiver(receiver);
		}
	}

}
