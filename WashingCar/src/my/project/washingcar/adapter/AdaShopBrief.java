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

public class AdaShopBrief extends ArrayAdapter<ShopBrief> {

	public AdaShopBrief(Context context, List<ShopBrief> objects) {
		super(context, 0, objects);
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		ViewHolder holder;
		if (convertView == null) {
			convertView = LayoutInflater.from(getContext()).inflate(
					R.layout.item_brief, null);
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
		TextView synopsis;
		TextView currentPrice;
		TextView originalPrice;
		TextView soldCount;

		public ViewHolder(View convertView) {
			image = (ImageView) convertView.findViewById(R.id.image);
			name = (TextView) convertView.findViewById(R.id.name);
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
			this.name.setText(shopBrief.getName());
			this.synopsis.setText(shopBrief.getSynopsis());
			this.currentPrice.setText(shopBrief.getCurrentPrice());
			this.originalPrice.setText(shopBrief.getOriginalPrice());
			this.soldCount.setText(shopBrief.getSoldCount());
		}

	}

}
