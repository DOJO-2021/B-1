// ログインユーザー識別用Beans
package model;

import java.io.Serializable;

public class LoginUser implements Serializable {
	private String id;	// ログイン時のID
	private int user_class; // ログイン時、受講者orそれ以外のチェック

	public LoginUser() {
		this(null);
	}

	public LoginUser(String id) {
		this.id = id;
	}

	public String getId() {
		return id;
	}

	public void setUserId(String id) {
		this.id = id;
	}


	public LoginUser(int user_class) {
		this.user_class = user_class;
	}

	public int getUser_class() {
		return user_class;
	}

	public void setUser_class(int user_class) {
		this.user_class = user_class;
	}
}
