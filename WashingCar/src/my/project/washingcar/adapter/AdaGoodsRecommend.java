package my.project.washingcar.adapter;

import java.util.List;

import my.project.washingcar.R;
import my.project.washingcar.model.GoodsRecommend;
import my.project.washingcar.utils.ImageUtil;
import android.content.Context;
import android.graphics.Paint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class AdaGoodsRecommend extends ArrayAdapter<GoodsRecommend> {

	public AdaGoodsRecommend(Context context, List<GoodsRecommend> objects) {
		super(context, 0, objects);
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		ViewHolder holder;
		if (convertView == null) {
			convertView = LayoutInflater.from(getContext()).inflate(
					R.layout.item_goods_recommend, null);
			holder = new ViewHolder(convertView);
			convertView.setTag(holder);
		} else {
			holder = (ViewHolder) convertView.getTag();
		}
		GoodsRecommend goods = getItem(position);
		// holder.setContent(goods);
		return convertView;
	}

	private final class ViewHolder {
		ImageView image;
		TextView name;
		TextView currentPrice;
		TextView originalPrice;
		TextView distance;

		public ViewHolder(View convertView) {
			image = (ImageView) convertView.findViewById(R.id.goods_image);
			name = (TextView) convertView.findViewById(R.id.goods_name);
			currentPrice = (TextView) convertView
					.findViewById(R.id.goods_current_price);
			originalPrice = (TextView) convertView
					.findViewById(R.id.goods_original_price);
			originalPrice.getPaint().setFlags(Paint.STRIKE_THRU_TEXT_FLAG);
			distance = (TextView) convertView.findViewById(R.id.goods_distance);
		}

		public void setContent(GoodsRecommend goods) {
			ImageUtil.display(getContext(), goods.getImageUrl(), image);
			name.setText(goods.getName());
			currentPrice.setText(goods.getCurrentPrice());
			originalPrice.setText(goods.getOriginalPrice());
			distance.setText(goods.getDistance());
		}
	}

}
