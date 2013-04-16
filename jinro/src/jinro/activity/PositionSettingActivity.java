package jinro.activity;

import java.util.ArrayList;
import java.util.List;

import jinro.adapter.PositionSettingListAdapter;
import sample.jinro.R;
import sample.position.Position;
import sample.position.PositionCitizen;
import sample.position.PositionFortuneTeller;
import sample.position.PositionHunter;
import sample.position.PositionLittleFox;
import sample.position.PositionMadman;
import sample.position.PositionMonsterCat;
import sample.position.PositionPsychic;
import sample.position.PositionSekine;
import sample.position.PositionFox;
import sample.position.PositionShare;
import sample.position.PositionWerewolf;
import sample.yaku.GameMaster;
import sample.yaku.Player;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

public class PositionSettingActivity extends Activity {
	private ListView positionList;
	private GameMaster gameMaster;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.position_setting);

		gameMaster = new GameMaster();

		PositionSettingListAdapter adapter = new PositionSettingListAdapter(
				this, R.layout.position_list_row, setPosition());

		positionList = (ListView) findViewById(R.id.position_set_list);
		positionList.setAdapter(adapter);

		positionList.setOnItemClickListener(new OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> adapter, View view,
					int position, long id) {
				ListView listView = (ListView) adapter;
				Position item = (Position) listView
						.getItemAtPosition(position);

				Intent intent = new Intent(PositionSettingActivity.this,
						PositionExplanation.class);
				intent.putExtra("name", item.getPositionName());
				intent.putExtra("explanation", item.getPositionExplanation());
				startActivity(intent);
			}
		});

		Button btn = (Button) findViewById(R.id.position_set_button);
		btn.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(PositionSettingActivity.this,
						PositionDecisionActivity.class);
				startActivity(intent);
				finish();
			}
		});

	}

	private List<Position> setPosition() {
		List<Position> list = new ArrayList<Position>();

		list.add(new PositionCitizen());
		list.add(new PositionWerewolf());
		list.add(new PositionFortuneTeller());
		list.add(new PositionPsychic());
		list.add(new PositionHunter());
		list.add(new PositionShare());
		list.add(new PositionMadman());
		list.add(new PositionFox());
		list.add(new PositionLittleFox());
		list.add(new PositionMonsterCat());
		list.add(new PositionSekine());

		return list;
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
