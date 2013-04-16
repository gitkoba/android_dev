package jinro.adapter;

import java.util.List;

import sample.jinro.R;
import sample.position.Position;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class PositionSettingListAdapter extends ArrayAdapter<Position> {
	private LayoutInflater layoutInflater;

	public PositionSettingListAdapter(Context context, int textViewResourceId,
			List<Position> objects) {
		super(context, textViewResourceId, objects);
		layoutInflater = (LayoutInflater) context
				.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		Position item = (Position) getItem(position);

		if (null == convertView)
			convertView = layoutInflater.inflate(R.layout.position_list_row,
					null);

		final ViewHolder holder = new ViewHolder();

		/*
		 * holder.icon = (ImageView)
		 * convertView.findViewById(R.id.position_set_icon);
		 * holder.icon.setImageBitmap(item.getPositonIcon());
		 */

		holder.name = (TextView) convertView
				.findViewById(R.id.position_set_name);
		holder.name.setText(item.getPositionName());

		holder.numberText = (TextView) convertView
				.findViewById(R.id.position_set_number);

		holder.plusButton = (Button) convertView
				.findViewById(R.id.position_set_plus);
		holder.plusButton.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				holder.numberText.setText(String.valueOf(++holder.number));
			}
		});

		holder.minButton = (Button) convertView
				.findViewById(R.id.position_set_min);
		holder.minButton.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				if (holder.number > 0)
					holder.numberText.setText(String.valueOf(--holder.number));
			}
		});

		return convertView;
	}

	private class ViewHolder {
		ImageView icon;
		TextView name;
		TextView numberText;
		Button plusButton;
		Button minButton;
		int number = 0;

	}
}
