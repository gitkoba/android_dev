package jinro.activity;

import sample.jinro.R;
import sample.yaku.Timer;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

public class NightFragmentTime extends Fragment implements TimerInterface{
	private TextView time;
	private ListView list;
	private Button next;
	private Handler handler;
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		handler = new Handler();

		View view = inflater.inflate(R.layout.night_fragment_time, container, false);
		time = (TextView)view.findViewById(R.id.night_time_view);
		list = (ListView)view.findViewById(R.id.night_time_list);
		next = (Button)view.findViewById(R.id.night_time_end_button);
		next.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v){
				Intent intent = new Intent(getActivity(), MeetingTimeActivity.class);
				startActivity(intent);
				getActivity().finish();
			}
		});
		next.setEnabled(false);

		return view;
	}

	@Override
	public void notifyEnableNext() {
		handler.post(new Runnable() {
			@Override
			public void run() {
				NightFragmentTime.this.next.setEnabled(true);
			}
		});
	}

	@Override
	public void notifyTimerUpdata(final String time) {
		handler.post(new Runnable() {
			@Override
			public void run() {
				NightFragmentTime.this.time.setText(time);
			}
		});
	}

}
