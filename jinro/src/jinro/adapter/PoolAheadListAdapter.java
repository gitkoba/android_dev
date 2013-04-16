package jinro.adapter;

import java.util.List;
import java.util.Map;

import org.w3c.dom.Text;

import sample.jinro.R;
import sample.yaku.Player;
import sample.yaku.Pollstation;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class PoolAheadListAdapter extends ArrayAdapter<Player> {

	private LayoutInflater layoutInflater;

	public PoolAheadListAdapter(Context context, int resource,
			int textViewResourceId, List<Player> objects) {

		super(context, resource, textViewResourceId, objects);
		layoutInflater = (LayoutInflater) context
				.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		Player item1 = (Player)getItem(position);

		if(convertView == null)
			convertView = layoutInflater.inflate(R.layout.poll_ahead_list, null);

		ImageView icon1 = (ImageView)convertView.findViewById(R.id.poll_player_icon);
		icon1.setImageBitmap(item1.getUserIcon());
		TextView name1 = (TextView)convertView.findViewById(R.id.poll_player_name);
		name1.setText(item1.getUserName());

		Player item2 = Pollstation.selectedPollPlayer(item1);
		ImageView icon2 = (ImageView)convertView.findViewById(R.id.polled_player_icon);
		icon2.setImageBitmap(item2.getUserIcon());
		TextView name2 = (TextView)convertView.findViewById(R.id.polled_player_name);
		name2.setText(item2.getUserName());

		return convertView;
	}
}
