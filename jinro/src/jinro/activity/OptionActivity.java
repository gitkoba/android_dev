package jinro.activity;

import java.io.InputStream;

import sample.jinro.R;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.WindowManager.LayoutParams;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.ToggleButton;

public class OptionActivity extends Activity {
	private static final int REQUEST_GALLERY = 0;
	private ImageView userIcon;
	private EditText userName;
	private Spinner spinnerMeeting;
	private Spinner spinnerNight;
	private Spinner spinnerPoll;
	private ToggleButton toggleAttack;
	private ToggleButton toggleDivine;
	private ToggleButton toggleReduce;
	private String iconPath = null;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		this.getWindow().setSoftInputMode(
				LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
		setContentView(R.layout.option_activity);

		linkView();

		Button btn = (Button) findViewById(R.id.option_save_button);
		btn.setOnClickListener(new View.OnClickListener() {
			AlertDialog alertDialog = null;
			@Override
			public void onClick(View v) {
				if (userName.length() > 0 && userName.length() <=10)
					finish();
				else
					alertUserNameNull();
			}

			private void alertUserNameNull() {


				AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(OptionActivity.this);
				alertDialogBuilder.setTitle("ユーザー名設定エラー");
				// アラートダイアログのメッセージを設定します
				alertDialogBuilder.setMessage("ユーザー名は1文字以上、10文字以下に設定してください。");
				// アラートダイアログの肯定ボタンがクリックされた時に呼び出されるコールバックリスナーを登録します
				alertDialogBuilder.setPositiveButton("OK",
						new DialogInterface.OnClickListener() {
							@Override
							public void onClick(DialogInterface dialog, int which) {
								alertDialog.dismiss();
							}
						});
				alertDialogBuilder.setCancelable(false);
				alertDialog = alertDialogBuilder.create();
				alertDialog.show();

			}
		});
	}

	@Override
	protected void onDestroy() {
		super.onDestroy();

		SharedPreferences pref = getSharedPreferences("option", MODE_PRIVATE);
		Editor e = pref.edit();
		e.putString("userIcon", iconPath);
		e.putString("userName", userName.getText().toString());
		e.putInt("meetingTime", spinnerMeeting.getSelectedItemPosition());
		e.putInt("nightTime", spinnerNight.getSelectedItemPosition());
		e.putInt("pollTime", spinnerPoll.getSelectedItemPosition());
		e.putBoolean("firstAttack", toggleAttack.isChecked());
		e.putBoolean("firstDivine", toggleDivine.isChecked());
		e.putBoolean("reducePosition", toggleReduce.isChecked());

		e.commit();
	}

	private void linkView() {
		SharedPreferences pref = getSharedPreferences("option", MODE_PRIVATE);

		userIcon = (ImageView) findViewById(R.id.option_user_icon);
		userName = (EditText) findViewById(R.id.option_user_name);
		spinnerMeeting = (Spinner) findViewById(R.id.spinner_meeting);
		spinnerNight = (Spinner) findViewById(R.id.spinner_Night);
		spinnerPoll = (Spinner) findViewById(R.id.spinner_poll);
		toggleAttack = (ToggleButton) findViewById(R.id.toggle_first_attack);
		toggleDivine = (ToggleButton) findViewById(R.id.toggle_first_devine);
		toggleReduce = (ToggleButton) findViewById(R.id.toggle_reduce_position);

		userIcon.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent intent = new Intent();
				intent.setType("image/*");
				intent.setAction(Intent.ACTION_GET_CONTENT);
				startActivityForResult(intent, REQUEST_GALLERY);
			}
		});
		iconPath = pref.getString("userIcon", null);
		if (iconPath != null) {
			try {
				InputStream in = getContentResolver().openInputStream(
						Uri.parse(iconPath));
				Bitmap img = BitmapFactory.decodeStream(in);
				in.close();
				// 選択した画像を表示
				userIcon.setImageBitmap(img);
			} catch (Exception e) {
			}
		}
		userName.setText(pref.getString("userName", "UN KNWON"));
		spinnerMeeting.setSelection(pref.getInt("meetingTime", 0));
		spinnerNight.setSelection(pref.getInt("nightTime", 0));
		spinnerPoll.setSelection(pref.getInt("pollTime", 0));
		toggleAttack.setChecked(pref.getBoolean("firstAttack", false));
		toggleDivine.setChecked(pref.getBoolean("firstDivine", true));
		toggleReduce.setChecked(pref.getBoolean("reducePosition", false));

	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		// TODO Auto-generated method stub
		if (requestCode == REQUEST_GALLERY && resultCode == RESULT_OK) {
			try {
				iconPath = data.getData().toString();
				InputStream in = getContentResolver().openInputStream(
						data.getData());
				Bitmap img = BitmapFactory.decodeStream(in);
				in.close();
				// 選択した画像を表示
				userIcon.setImageBitmap(img);
			} catch (Exception e) {
			}
		}
	}
}
