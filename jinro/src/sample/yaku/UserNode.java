package sample.yaku;

import android.graphics.Bitmap;

public class UserNode {
	private String userName;
	private Bitmap userIcon;

	public UserNode(String userName) {
		this.userName = userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserIcon(Bitmap userIcon) {
		this.userIcon = userIcon;
	}

	public Bitmap getUserIcon() {
		return userIcon;
	}
}
