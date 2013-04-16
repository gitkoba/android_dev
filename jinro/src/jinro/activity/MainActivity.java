package jinro.activity;

import sample.jinro.R;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity implements OnClickListener {
	private static final int MENU_SELECT_CLEAR = 0;
	private Button startButton;
	private Button inButton;
	private Button optionButton;
	private Button endButton;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		startButton = (Button) findViewById(R.id.main_village_start_button);
		startButton.setOnClickListener(this);

		inButton = (Button) findViewById(R.id.main_village_in_button);
		inButton.setOnClickListener(this);

		optionButton = (Button) findViewById(R.id.main_option_button);
		optionButton.setOnClickListener(this);

		endButton = (Button) findViewById(R.id.main_end_button);
		endButton.setOnClickListener(this);

		splashLaunched();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		// getMenuInflater().inflate(R.menu.main, menu);
		menu.add(0, MENU_SELECT_CLEAR, 0, "Clear").setIcon(
				android.R.drawable.ic_menu_close_clear_cancel);
		return true;
	}

	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case MENU_SELECT_CLEAR:
			SharedPreferences pref = getSharedPreferences("lancherd", MODE_PRIVATE);
			Editor edit = pref.edit();
			edit.putBoolean("Launched", false);
			edit.commit();
			return true;
		}
		return false;
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

	@Override
	public void onClick(View v) {
		if (v == startButton) {
			Intent intent = new Intent(MainActivity.this,
					PositionSettingActivity.class);
			startActivity(intent);
			finish();
		} else if (v == inButton) {
			Intent intent = new Intent(MainActivity.this,
					PositionSettingActivity.class);
			startActivity(intent);
			finish();
		} else if (v == optionButton) {
			Intent intent = new Intent(MainActivity.this, OptionActivity.class);
			startActivity(intent);
		} else if (v == endButton) {
			moveTaskToBack(true);
		}
	}

	private void splashLaunched() {
		SharedPreferences pref = getSharedPreferences("lancherd", MODE_PRIVATE);
		Editor editor = pref.edit();

		if (pref.getBoolean("Launched", false) == false) {
			// 初回起動時の処理
			alertSplashLaunched();
			// プリファレンスの書き変え
			editor.putBoolean("Launched", true);
			editor.commit();
		}
	}

	private void alertSplashLaunched() {
		AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
		alertDialogBuilder.setTitle("ユーザー設定");
		// アラートダイアログのメッセージを設定します
		alertDialogBuilder.setMessage("本アプリではユーザー名を設定する必要があります\n設定画面に遷移します。");

		// アラートダイアログの肯定ボタンがクリックされた時に呼び出されるコールバックリスナーを登録します
		alertDialogBuilder.setPositiveButton("OK",
				new DialogInterface.OnClickListener() {
					@Override
					public void onClick(DialogInterface dialog, int which) {
						Intent intent = new Intent(MainActivity.this,
								OptionActivity.class);
						startActivity(intent);
					}
				});
		alertDialogBuilder.setCancelable(false);
		AlertDialog alertDialog = alertDialogBuilder.create();
		alertDialog.show();
	}

}
