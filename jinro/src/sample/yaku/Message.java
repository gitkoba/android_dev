package sample.yaku;

import android.graphics.Bitmap;

public class Message {
	private Player player;
	private String message;

	public Message(Player player, String message){
		this.player = player;
		this.message = message;
	}

	public Bitmap getMessageSendPlayerIcon(){
		return player.getUserIcon();
	}
	public String getMessageSendPlayerName(){
		return player.getUserName();
	}
	public String getMessageText(){
		return message;
	}
}
