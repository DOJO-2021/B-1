package model;
import java.io.Serializable;

public class Draft implements Serializable {
	private String user_id;
	private int bbs_id;
	private String draft_title;
	private String draft_details;
	private String draft_pw;
	private int draft_range;
	private int draft_category;

	//引数のあるコンストラクタ
	public Draft(String user_id, int bbs_id, String draft_title, String draft_details, String draft_pw, int draft_range,
			int draft_category) {
		super();
		this.user_id = user_id;
		this.bbs_id = bbs_id;
		this.draft_title = draft_title;
		this.draft_details = draft_details;
		this.draft_pw = draft_pw;
		this.draft_range = draft_range;
		this.draft_category = draft_category;
	}
	//引数がないコンストラクタ(デフォルトコンストラクタ)
	public Draft() {
		super();
		this.user_id = "";
		this.bbs_id = 0;
		this.draft_title = "";
		this.draft_details = "";
		this.draft_pw = "";
		this.draft_range = 0;
		this.draft_category = 0;
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
	public String getDraft_title() {
		return draft_title;
	}
	public void setDraft_title(String draft_title) {
		this.draft_title = draft_title;
	}
	public String getDraft_details() {
		return draft_details;
	}
	public void setDraft_details(String draft_details) {
		this.draft_details = draft_details;
	}
	public String getDraft_pw() {
		return draft_pw;
	}
	public void setDraft_pw(String draft_pw) {
		this.draft_pw = draft_pw;
	}
	public int getDraft_range() {
		return draft_range;
	}
	public void setDraft_range(int draft_range) {
		this.draft_range = draft_range;
	}
	public int getDraft_category() {
		return draft_category;
	}
	public void setDraft_category(int draft_category) {
		this.draft_category = draft_category;
	}
}