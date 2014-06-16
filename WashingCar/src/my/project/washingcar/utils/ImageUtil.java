package my.project.washingcar.utils;

import my.project.washingcar.R;
import android.content.Context;
import android.graphics.Bitmap;
import android.widget.ImageView;

import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.assist.ImageLoadingListener;

public class ImageUtil {

	private static DisplayImageOptions options;

	public static void display(Context context, String url, ImageView imageView) {
		ImageLoader.getInstance().displayImage(url, imageView,
				getDisplayImageOptions());
	}

	public static void display(String uri, ImageView imageView,
			ImageLoadingListener listener) {
		ImageLoader.getInstance().displayImage(uri, imageView,
				getDisplayImageOptions(), listener);
	}

	private static synchronized DisplayImageOptions getDisplayImageOptions() {
		if (null == options) {
			options = new DisplayImageOptions.Builder()
					.showImageOnLoading(R.drawable.ic_stub)
					.showImageForEmptyUri(R.drawable.ic_empty)
					.showImageOnFail(R.drawable.ic_error).cacheInMemory(true)
					.cacheOnDisc(true).bitmapConfig(Bitmap.Config.RGB_565)
					.build();
		}
		return options;
	}

}
