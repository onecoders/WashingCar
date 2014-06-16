package my.project.washingcar.activity;

import java.lang.reflect.Type;

import my.project.washingcar.F;
import my.project.washingcar.R;
import my.project.washingcar.utils.MToast;
import my.project.washingcar.utils.NetworkUtil;
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

import com.ab.activity.AbActivity;

/**
 * Base Activity
 * 
 * @author roy
 * @email onecoders@gmail.com
 */

public abstract class ActBase extends AbActivity implements OnCancelListener {

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
		initNetWorkReceiver();
	}

	private void initNetWorkReceiver() {
		currentConnected = isNetworkConnected();
		registerReceiver();
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

	public void showToast(int resId) {
		MToast.showText(this, resId);
	}

	public void showToast(String msg) {
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
