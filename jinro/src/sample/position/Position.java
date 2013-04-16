package sample.position;

import java.util.List;

import sample.yaku.Player;

import android.graphics.Bitmap;

public class Position{
	protected static List<Position> positonList;
	private int positionNo;
	private int positionStatus;
	private int fortuneStatus;
	protected Bitmap positionIcon;
	protected String positionName;
	protected String positonExplanation;
	public static final int _TeamCitizen = 100;
	public static final int _TeamWerewolf = 101;
	public static final int _TeamThird = 102;

	public static final int _citizen = 0;
	public static final int _fortuneTeller = 1;
	public static final int _psychic = 2;
	public static final int _hunter = 3;
	public static final int _share = 4;
	public static final int _sekine = 5;
	public static final int _monsterCat = 6;
	public static final int _werewolf = 10;
	public static final int _madman = 11;
	public static final int _fox = 20;
	public static final int _littleFox = 21;

	public void setPositionStatus(int no, int pStatus, int fStatus) {
		positionNo = no;
		positionStatus = pStatus;
		fortuneStatus = fStatus;
	}

	public void nightAttack(Player player) {

	}

	public int getPositionNo(){
		return positionNo;
	}

	public int getPositionStatus(){
		return positionStatus;
	}

	public String getPositionName() {
		return positionName;
	}

	public String getPositionExplanation() {
		return positonExplanation;
	}

	public Bitmap getPositonIcon() {
		return positionIcon;
	}

	public int getFortuneStatus(){
		return fortuneStatus;
	}

}