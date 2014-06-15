package my.project.washingcar.adapter;

import java.util.List;

import my.project.washingcar.R;
import my.project.washingcar.model.ChildArea;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

public class AdaChildArea extends ArrayAdapter<ChildArea> {

	public AdaChildArea(Context context, List<ChildArea> objects) {
		super(context, 0, objects);
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		ViewHolder holder;
		if (convertView == null) {
			convertView = LayoutInflater.from(getContext()).inflate(
					R.layout.item_child_area, null);
			holder = new ViewHolder(convertView);
			convertView.setTag(holder);
		} else {
			holder = (ViewHolder) convertView.getTag();
		}
		ChildArea area = getItem(position);
		holder.setContent(area);
		return convertView;
	}

	private final class ViewHolder {
		TextView areaView;

		public ViewHolder(View convertView) {
			areaView = (TextView) convertView.findViewById(R.id.city_name);
		}

		public void setContent(ChildArea area) {
			areaView.setText(area.getName());
		}
	}

}
