package my.project.washingcar.adapter;

import java.util.List;

import my.project.washingcar.R;
import my.project.washingcar.model.ShopBrief;
import my.project.washingcar.utils.ImageUtil;
import android.content.Context;
import android.graphics.Paint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class AdaRecommendShopBrief extends ArrayAdapter<ShopBrief> {

	public AdaRecommendShopBrief(Context context, List<ShopBrief> objects) {
		super(context, 0, objects);
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		ViewHolder holder;
		if (convertView == null) {
			convertView = LayoutInflater.from(getContext()).inflate(
					R.layout.item_recommend_shop_brief, null);
			holder = new ViewHolder(convertView);
			convertView.setTag(holder);
		} else {
			holder = (ViewHolder) convertView.getTag();
		}
		ShopBrief shopBrief = getItem(position);
		// holder.setContent(shopBrief);
		return convertView;
	}

	private final class ViewHolder {
		ImageView image;
		TextView name;
		TextView flag;
		TextView synopsis;
		TextView currentPrice;
		TextView originalPrice;
		TextView soldCount;

		public ViewHolder(View convertView) {
			image = (ImageView) convertView.findViewById(R.id.image);
			name = (TextView) convertView.findViewById(R.id.name);
			flag = (TextView) convertView.findViewById(R.id.flag);
			synopsis = (TextView) convertView.findViewById(R.id.synopsis);
			currentPrice = (TextView) convertView
					.findViewById(R.id.current_price);
			originalPrice = (TextView) convertView
					.findViewById(R.id.original_price);
			originalPrice.getPaint().setFlags(Paint.STRIKE_THRU_TEXT_FLAG);
			soldCount = (TextView) convertView.findViewById(R.id.sold_count);
		}

		public void setContent(ShopBrief shopBrief) {
			ImageUtil.display(getContext(), shopBrief.getImage(), this.image);
			name.setText(shopBrief.getName());
			int briefFlag = shopBrief.getFlag();
			flag.setVisibility(briefFlag == 0 ? View.INVISIBLE : View.VISIBLE);
			flag.setBackgroundResource(briefFlag != 0 && briefFlag == 1 ? R.drawable.home_isuperscript_red
					: R.drawable.home_isuperscript_blue);
			synopsis.setText(shopBrief.getSynopsis());
			currentPrice.setText(shopBrief.getCurrentPrice());
			originalPrice.setText(shopBrief.getOriginalPrice());
			soldCount.setText(shopBrief.getSoldCount());
		}

	}

}
