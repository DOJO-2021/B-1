// ログインユーザー識別用Beans
package model;

import java.io.Serializable;

public class LoginUser implements Serializable {
	private String id;	// ログイン時のID
	private int user_class; // ログイン時、受講者orそれ以外のチェック
	private String user_name; //ログインしてるユーザーの名前

	public LoginUser() {
		super();
		this.id = null;
		this.user_class = 5;
		this.user_name = null;
	}

	public LoginUser(String id , int user_class , String user_name) {
		this.id = id;
		this.user_class = user_class;
		this.user_name = user_name;
	}

	public String getId() {
		return id;
	}

	public void setUserId(String id) {
		this.id = id;
	}

	public int getUser_class() {
		return user_class;
	}

	public void setUser_class(int user_class) {
		this.user_class = user_class;
	}

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
}
