package jinro.activity;

import java.util.ArrayList;

import sample.jinro.R;
import sample.jinro.R.id;
import sample.jinro.R.layout;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.PagerTabStrip;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.GestureDetector;
import android.view.GestureDetector.OnGestureListener;
import android.view.MotionEvent;
import android.view.ViewGroup;
import android.view.WindowManager.LayoutParams;
import android.widget.Toast;

public class NightTimeActivity extends FragmentActivity implements OnGestureListener{
	private MyFragmentPagerAdapter adapter;
	private GestureDetector gestureDetector;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		this.getWindow().setSoftInputMode(LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
		setContentView(R.layout.night_activity);

		// ViewPager のインスタンスを取得
		ViewPager viewPager = (ViewPager) findViewById(R.id.pager);

		// FragmentPagerAdapter を継承したクラスのアダプターを作成し、ViewPager にセット
		adapter = new MyFragmentPagerAdapter(this, viewPager);

		// タブ選択時のActivityの設定
		adapter.addTab(NightFragmentTime.class, null, "time");
		adapter.addTab(NightFragmentMessage.class, null, "message");
		viewPager.setAdapter(adapter);

		// タブ境界線設定
		PagerTabStrip pagerTabStrip = (PagerTabStrip) findViewById(R.id.pager_title_strip);
		// タブの下線を有効
		pagerTabStrip.setDrawFullUnderline(true);
		// Tabのライン色の設定
		pagerTabStrip.setTabIndicatorColor(Color.BLUE);

		gestureDetector = new GestureDetector(getApplicationContext(), this);
	}

	/**
	 * PageAdapter。 タブ内の切り替え制御、表示Fragment情報管理を行う。
	 */
	private static class MyFragmentPagerAdapter extends FragmentPagerAdapter {
		private final Context mContext;
		private final ViewPager mViewPager;
		private final ArrayList<TabInfo> mTabs = new ArrayList<TabInfo>();

		/**
		 * タブ内の表示するv4.Fragment、引数、タイトルの保持を行う
		 */
		private static final class TabInfo {
			private final Class<?> clazz;
			private final Bundle args;
			private final String tabTitle;

			/**
			 * タブ内のActivity、引数を設定する。
			 *
			 * @param clazz		タブ内のv4.Fragment
			 * @param args		タブ内のv4.Fragmentに対する引数
			 * @param tabTitle	タブに表示するタイトル
			 */
			TabInfo(Class<?> clazz, Bundle args, String tabTitle) {
				this.clazz = clazz;
				this.args = args;
				this.tabTitle = tabTitle;
			}
		}

		public MyFragmentPagerAdapter(FragmentActivity activity, ViewPager pager) {
			super(activity.getSupportFragmentManager());
			mContext = activity;
			mViewPager = pager;
			mViewPager.setAdapter(this);
		}

		/**
		 * タブ内に起動するActivity、引数、タイトルを設定する
		 *
		 * @param clazz
		 *            起動するv4.Fragmentクラス
		 * @param args
		 *            v4.Fragmentに対する引数
		 * @param tabTitle
		 *            タブのタイトル
		 */
		public void addTab(Class<?> clazz, Bundle args, String tabTitle) {
			TabInfo info = new TabInfo(clazz, args, tabTitle);
			mTabs.add(info);
			notifyDataSetChanged();
		}

		/**
		 * タイトルを返す。 フレームワークからの呼び出しがされるため、任意に呼び出す必要はない。
		 */
		@Override
		public CharSequence getPageTitle(int position) {
			return mTabs.get(position).tabTitle;
		}

		/**
		 * タブの総数を返す。 フレームワークからの呼び出しがされるため、任意に呼び出す必要はない。
		 */
		@Override
		public int getCount() {
			return mTabs.size();
		}

		/**
		 * タブ内のv4.Fragmentを返す。 フレームワークからの呼び出しがされるため、任意に呼び出す必要はない。
		 */
		@Override
		public Fragment getItem(int position) {
			TabInfo info = mTabs.get(position);
			return Fragment.instantiate(mContext, info.clazz.getName(),
					info.args);
		}

		@Override
		public void finishUpdate(ViewGroup container) {
			super.finishUpdate(container);
		}
	}

	@Override
	public boolean onDown(MotionEvent arg0) {
		Log.d("onDown", "onDown");
		return false;
	}

	@Override
	public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX,
			float velocityY) {
		// TODO 自動生成されたメソッド・スタブ
		Log.d("onFling", "onFling");
		return false;
	}

	@Override
	public void onLongPress(MotionEvent e) {
		// TODO 自動生成されたメソッド・スタブ
		Log.d("onLongPress", "onLongPress");
	}

	@Override
	public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX,
			float distanceY) {
		// TODO 自動生成されたメソッド・スタブ
		Log.d("onScrool", "onScrool");
		Toast.makeText(getApplicationContext(), "scrool", 0).show();
		return false;
	}

	@Override
	public void onShowPress(MotionEvent e) {
		// TODO 自動生成されたメソッド・スタブ
		Log.d("onShowPress", "onShowPress");
	}

	@Override
	public boolean onSingleTapUp(MotionEvent e) {
		// TODO 自動生成されたメソッド・スタブ
		return false;
	}

}
