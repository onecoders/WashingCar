package my.project.washingcar;

import java.lang.reflect.Type;

import my.project.washingcar.utils.L;
import my.project.washingcar.utils.VersionUtil;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.PackageManager.NameNotFoundException;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;
import com.baidu.mapapi.SDKInitializer;
import com.google.gson.Gson;

public class F {

	// 版本信息，进入应用时读取
	public static int VERSION_CODE;
	public static String VERSION_NAME;

	// volley queue
	private static RequestQueue mVolleyQueue;

	// shared preferences for saving bind info
	private static SharedPreferences mPrefs;
	private static Editor mEditor;

	private static final String PREFS_NAME = "easy_recharge";
	private static Gson mGson;

	public static void init(Context context) {
		L.enableLogging();//
		initBaiduSDK(context);
		initPrefAndGson(context);
		initVersionInfo(context);
		initRequestQueue(context);
	}

	private static void initBaiduSDK(Context context) {
		SDKInitializer.initialize(context);
	}

	private static void initPrefAndGson(Context context) {
		mPrefs = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
		mEditor = mPrefs.edit();
		mGson = new Gson();
	}

	private static void initVersionInfo(Context context) {
		VERSION_CODE = getVersionCode(context);
		VERSION_NAME = getVersionName(context);
	}

	private static void initRequestQueue(Context context) {
		mVolleyQueue = Volley.newRequestQueue(context);
	}

	private static int getVersionCode(Context context) {
		try {
			return VersionUtil.getVersionCode(context);
		} catch (NameNotFoundException e) {
			e.printStackTrace();
		}
		return 1;
	}

	private static String getVersionName(Context context) {
		try {
			return VersionUtil.getVersionName(context);
		} catch (NameNotFoundException e) {
			e.printStackTrace();
		}
		return context.getString(R.string.default_version_name);
	}

	public static void putString(String key, String value) {
		mEditor.putString(key, value).commit();
	}

	public static String getString(String key, String defValue) {
		return mPrefs.getString(key, defValue);
	}

	public static void putBoolean(String key, boolean value) {
		mEditor.putBoolean(key, value).commit();
	}

	public static boolean getBoolean(String key, boolean defValue) {
		return mPrefs.getBoolean(key, defValue);
	}

	public static String toJson(Object src) {
		return mGson.toJson(src);
	}

	public static <T> T fromJson(String json, Class<T> classOfT) {
		return mGson.fromJson(json, classOfT);
	}

	public static <T> T fromJson(String json, Type typeOfT) {
		return mGson.fromJson(json, typeOfT);
	}

	public static void add(Request<?> request) {
		mVolleyQueue.add(request);
	}

}
