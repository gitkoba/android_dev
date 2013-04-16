package jinro.activity;

import sample.jinro.R;
import sample.yaku.GameMaster;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class PositionDecisionActivity extends Activity {
	private GameMaster gameMaster;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.position_decision);

		gameMaster = (GameMaster) getIntent().getSerializableExtra("gameMaster");

		TextView positionName = (TextView) findViewById(R.id.position_dec_name);
		TextView positionExplnation = (TextView) findViewById(R.id.position_dec_explanation);
		ImageView positionIcon = (ImageView) findViewById(R.id.position_dec__icon);

		Button btn = (Button) findViewById(R.id.position_dec_button);
		btn.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(PositionDecisionActivity.this, NightTimeActivity.class);
				startActivity(intent);
				finish();
			}
		});
	}

	@Override
	public boolean dispatchKeyEvent(KeyEvent event) {
		if (event.getAction() == KeyEvent.ACTION_DOWN) {
			switch (event.getKeyCode()) {
			case KeyEvent.KEYCODE_BACK:
				return true;
			}
		}
		return super.dispatchKeyEvent(event);
	}
}
