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

public class NightAttackListAdapter extends ArrayAdapter<Player> {

	private LayoutInflater layoutInflater;

	public NightAttackListAdapter(Context context, int resource,
			int textViewResourceId, List<Player> objects) {

		super(context, resource, textViewResourceId, objects);
		layoutInflater = (LayoutInflater) context
				.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		Player item = (Player) getItem(position);
		
		if(convertView == null){
			convertView = layoutInflater.inflate(R.layout.night_attack_row, null);
		}
		
		//ImageView icon = (ImageView)convertView.findViewById(R.id.night_icon);
		//icon.setImageBitmap(item.getUserIcon());
		
		TextView name = (TextView)convertView.findViewById(R.id.night_player_name);
		name.setText(item.getUserName());
		
		Button button = (Button)convertView.findViewById(R.id.night_attack_button);
		button.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO 自動生成されたメソッド・スタブ
				
			}
		});
		
		return convertView;
	}
}
