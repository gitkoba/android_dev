package jinro.activity;

import sample.jinro.R;
import sample.yaku.GameMaster;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

public class MeetingTimeActivity extends Activity implements TimerInterface{
	private TextView time;
	private Button endButton;
	private ListView aheadPollList;
	private Handler handler;
	private GameMaster gameMaster;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.meeting_activity);

		//gameMaster = (GameMaster) getIntent().getSerializableExtra("gameMaster");
		handler = new Handler();

		time = (TextView)findViewById(R.id.meeting_time);
		endButton = (Button)findViewById(R.id.meeting_end_button);
		endButton.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(MeetingTimeActivity.this, PoolTimeActivity.class);
				startActivity(intent);
				finish();
			}
		});
		endButton.setEnabled(false);

		aheadPollList = (ListView)findViewById(R.id.pool_listview);

	}

	@Override
	public void notifyEnableNext() {

		handler.post(new Runnable() {
			@Override
			public void run() {
				MeetingTimeActivity.this.endButton.setEnabled(true);;
			}
		});
	}

	@Override
	public void notifyTimerUpdata(final String time) {
		handler.post(new Runnable() {
			@Override
			public void run() {
				MeetingTimeActivity.this.time.setText(time);
			}
		});
	}
}
