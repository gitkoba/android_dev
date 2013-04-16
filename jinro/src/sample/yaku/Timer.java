package sample.yaku;

import jinro.activity.TimerInterface;

public class Timer{
	private TimerHandler handler;
	private TimerInterface tInterface;
	private Option option;
	public static final int _NightTimer = 0;
	public static final int _PoolTimer = 1;
	public static final int _MeetingTimer = 2;

	public Timer(Option option){
		this.option = option;
	}

	public void timerStart(TimerInterface tInterface, int timerType) {
		this.tInterface = tInterface;

		int time = 0;
		switch (timerType) {
		case _NightTimer:
			time = option.getNightTime();
			break;
		case _PoolTimer:
			time = option.getPoolTime();
			break;
		case _MeetingTimer:
			time = option.getMeetingTime();
			break;
		}
		handler = new TimerHandler(time);
	}

	public void timerClear() {
		handler.clear();
	}

	private class TimerHandler implements Runnable {
		private int time;
		private Thread thread;
		private String coron = ":";

		private TimerHandler(int time) {
			this.time = time;
			thread = new Thread(this);
			thread.start();
		}

		public void clear() {
			time = 0;
		}

		@Override
		public void run() {
			tInterface.notifyTimerUpdata(toStringTime());
			while (time > 0) {
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				time--;
				tInterface.notifyTimerUpdata(toStringTime());
			}
			tInterface.notifyEnableNext();
		}

		private String toStringTime() {
			int m = time / 60;
			int s = time % 60;
			StringBuffer sb = new StringBuffer();
			if (m < 10)
				sb.append(0);
			sb.append(m);
			sb.append(coron);
			if(s < 10)
				sb.append(0);
			sb.append(s);

			return sb.toString();
		}

	}
}
