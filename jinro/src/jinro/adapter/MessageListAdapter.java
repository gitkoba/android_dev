package jinro.adapter;

import java.util.List;

import sample.jinro.R;
import sample.position.Position;
import sample.yaku.Message;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

public class MessageListAdapter extends ArrayAdapter<Message> {
	private LayoutInflater layoutInflater;

	public MessageListAdapter(Context context, int textViewResourceId, List<Message> objects) {

		super(context, textViewResourceId, objects);
		layoutInflater = (LayoutInflater) context
				.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

	}
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		Message item = (Message) getItem(position);

		if (null == convertView)
			convertView = layoutInflater.inflate(R.layout.message_row, null);

		TextView name = (TextView) convertView.findViewById(R.id.message_name);
		name.setText(item.getMessageSendPlayerName());

		TextView message = (TextView) convertView.findViewById(R.id.message_row_text);
		message.setText(item.getMessageText());

		return convertView;
	}

}
