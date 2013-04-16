package jinro.activity;

import sample.jinro.R;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

public class PoolTimeActivity extends Activity implements TimerInterface{
	private TextView time;
	private TextView wait;
	private Button nextButton;
	private ListView list;
	private Handler handler;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.pooltime_activity);

		handler = new Handler();

		time = (TextView)findViewById(R.id.poll_time);
		wait = (TextView)findViewById(R.id.pool_wait_text);
		nextButton = (Button)findViewById(R.id.poll_end_button);
		nextButton.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(PoolTimeActivity.this, PunishmentActivity.class);
				startActivity(intent);
				finish();
			}
		});
		list = (ListView)findViewById(R.id.pool_listview);

		nextButton.setEnabled(false);
	}

	@Override
	public void notifyEnableNext(){
		handler.post(new Runnable() {
			@Override
			public void run() {
				PoolTimeActivity.this.nextButton.setEnabled(true);;
			}
		});
	}

	@Override
	public void notifyTimerUpdata(final String time) {
		handler.post(new Runnable() {
			@Override
			public void run() {
				PoolTimeActivity.this.time.setText(time);
			}
		});
	}
}
