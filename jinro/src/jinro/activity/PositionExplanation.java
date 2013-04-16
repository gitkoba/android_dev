package jinro.activity;

import sample.jinro.R;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class PositionExplanation extends Activity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.position_explanation);

		Intent intent = getIntent();

		TextView nameView = (TextView) findViewById(R.id.position_ex_name);
		nameView.setText(intent.getStringExtra("name"));

		TextView explanationView = (TextView) findViewById(R.id.position_ex_explanation);
		explanationView.setText(intent.getStringExtra("explanation"));

		Button btn = (Button) findViewById(R.id.position_ex_button);
		btn.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				finish();
			}
		});
	}
}
