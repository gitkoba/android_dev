package sample.yaku;


public class Option {
	private static int meetingTime = 5;
	private static int poolTime;
	private static int nightTime;
	private static boolean firstAttack;
	private static boolean firstDivine;
	private static boolean reducePosition;

	public static void optionReflection(int mTime, int pTime, int nTime, boolean attack, boolean divine, boolean reduce){
		//TODO option
		meetingTime = mTime;
		poolTime = pTime;
		nightTime = nTime;
		firstAttack = attack;
		firstDivine = divine;
		reducePosition = reduce;
	}

	public int getMeetingTime(){
		return meetingTime;
	}
	public int getPoolTime(){
		return poolTime;
	}
	public int getNightTime(){
		return nightTime;
	}
	public boolean isFirstAttack(){
		return firstAttack;
	}
	public boolean isFirstDivine(){
		return firstDivine;
	}
	public boolean isReducePosition(){
		return reducePosition;
	}
}