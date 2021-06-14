package model;
import java.io.Serializable;

public class BBS implements Serializable {
	private String user_id;
	private int bbs_id;
	private String bbs_title;
	private String bbs_details;
	private String bbs_pw;
	private int bbs_range;
	private int bbs_category;

	//引数のあるコンストラクタ
	public BBS(String user_id, int bbs_id, String bbs_title, String bbs_details, String bbs_pw, int bbs_range, int bbs_category) {
		super();
		this.user_id = user_id;
		this.bbs_id = bbs_id;
		this.bbs_title = bbs_title;
		this.bbs_details = bbs_details;
		this.bbs_pw = bbs_pw;
		this.bbs_range = bbs_range;
		this.bbs_category = bbs_category;
	}

	//引数がないコンストラクタ(デフォルトコンストラクタ)
	public BBS() {
		super();
		this.user_id = "";
		this.bbs_id = 0;
		this.bbs_title = "";
		this.bbs_details = "";
		this.bbs_pw = "";
		this.bbs_range = 0;
		this.bbs_category = 0;
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public int getBbs_id() {
		return bbs_id;
	}

	public void setBbs_id(int bbs_id) {
		this.bbs_id = bbs_id;
	}

	public String getBbs_title() {
		return bbs_title;
	}

	public void setBbs_title(String bbs_title) {
		this.bbs_title = bbs_title;
	}

	public String getBbs_details() {
		return bbs_details;
	}

	public void setBbs_details(String bbs_details) {
		this.bbs_details = bbs_details;
	}

	public String getBbs_pw() {
		return bbs_pw;
	}

	public void setBbs_pw(String bbs_pw) {
		this.bbs_pw = bbs_pw;
	}

	public int getBbs_range() {
		return bbs_range;
	}

	public void setBbs_range(int bbs_range) {
		this.bbs_range = bbs_range;
	}

	public int getBbs_category() {
		return bbs_category;
	}

	public void setBbs_category(int bbs_category) {
		this.bbs_category = bbs_category;
	}

}