package jinro.adapter;

import java.util.List;

import sample.jinro.R;
import sample.yaku.Player;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;

public class PoolListAdapter extends ArrayAdapter<Player> {

	private LayoutInflater layoutInflater;

	public PoolListAdapter(Context context, int resource,
			int textViewResourceId, List<Player> objects) {
		super(context, resource, textViewResourceId, objects);
		layoutInflater = (LayoutInflater) context
				.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		Player item = (Player) getItem(position);

		if (convertView == null)
			convertView = layoutInflater.inflate(R.layout.pool_list_row, null);

		TextView name = (TextView)convertView.findViewById(R.id.poll_name);
		name.setText(item.getUserName());

		//ImageView icon = (ImageView)convertView.findViewById(R.id.poll_icon);
		//icon.setImageBitmap(item.getUserIcon());

		Button button = (Button)convertView.findViewById(R.id.poll_button);
		button.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				//TODO pollaction
			}
		});

		return convertView;
	}

}
