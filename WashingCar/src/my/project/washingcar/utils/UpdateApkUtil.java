package my.project.washingcar.utils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

import android.content.Context;
import android.os.Environment;

public class UpdateApkUtil {

	public interface OnUpdateProgressListener {
		public void updateProgress(int progress);
	}

	private OnUpdateProgressListener listener;

	private String savePath;

	public UpdateApkUtil(OnUpdateProgressListener listener) {
		this.listener = listener;
	}

	public boolean downloadFile(String url, String savePath) {
		if (!hasSDCard()) {
			return false;
		}
		this.savePath = savePath;
		HttpClient client = new DefaultHttpClient();
		HttpGet get = new HttpGet(url);
		HttpResponse response;
		try {
			response = client.execute(get);
			HttpEntity entity = response.getEntity();
			long length = entity.getContentLength();
			InputStream is = entity.getContent();
			FileOutputStream fileOutputStream = null;
			if (is != null) {
				File file = new File(Environment.getExternalStorageDirectory(),
						savePath);
				if (!file.exists()) {
					file.createNewFile();
				}
				fileOutputStream = new FileOutputStream(file);
				byte[] buf = new byte[1024];
				int ch = -1;
				long progress = 0;
				while ((ch = is.read(buf)) != -1) {
					fileOutputStream.write(buf, 0, ch);
					progress += ch;
					if (listener != null) {
						listener.updateProgress((int) (progress * 100 / length));
					}
				}
			}
			fileOutputStream.flush();
			if (fileOutputStream != null) {
				fileOutputStream.close();
			}
			return true;
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		client.getConnectionManager().shutdown();
		return false;
	}

	private static boolean hasSDCard() {
		return Environment.MEDIA_MOUNTED.equals(Environment
				.getExternalStorageState());
	}

	public void installApk(Context context) {
		File apkFile = new File(Environment.getExternalStorageDirectory(),
				savePath);
		if (apkFile.exists()) {
			ApkUtil.installApk(context, apkFile);
		}
	}

}
