package sample.yaku;

import sample.position.Position;
import android.graphics.Bitmap;

public class Player {
	private boolean status;
	private Position position;
	private int score;
	private UserNode userNode;
	private static GameMaster master;

	public void poll(Player polledPlayer) {
		Pollstation.playerPoll(polledPlayer, this);
	}

	public void positionSet(Position position) {
		this.position = position;
	}

	public void death() {
		status = false;
	}

	public boolean isDeath() {
		return status;
	}

	public void addScore(int score) {
		this.score += score;
	}

	public void messageSend(String message) {
		master.linkMessage(message, this);
	}

	public void messageReceive(String message) {

	}

	public int getScore() {
		return score;
	}

	public int whatPosition() {
		return position.getPositionNo();
	}

	public String getUserName() {
		return userNode.getUserName();
	}

	public Bitmap getUserIcon() {
		return userNode.getUserIcon();
	}
}
