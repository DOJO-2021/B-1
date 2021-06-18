package model;
import java.io.Serializable;


public class User implements Serializable {
	private String user_id;
	private String user_name;
	private String user_pw;
	private String user_k_name;
	private String user_company;
	private int user_class;
	private String user_prefecture;
	private String user_hobby;
	private String user_skill;
	private String user_birth;
	private String user_remarks;
	private int user_range;
	private String user_image;

	//引数があるコンストラクタ
	public User(
			String user_id,
			String user_name,
			String user_pw,
			String user_k_name,
			String user_company,
			int user_class,
			String user_prefecture,
			String user_hobby,
			String user_skill,
			String user_birth,
			String user_remarks,
			int user_range,
			String user_image) {
		super();
		this.user_id = user_id;
		this.user_name = user_name;
		this.user_pw = user_pw;
		this.user_k_name = user_k_name;
		this.user_company = user_company;
		this.user_class = user_class;
		this.user_prefecture = user_prefecture;
		this.user_hobby = user_hobby;
		this.user_skill = user_skill;
		this.user_birth = user_birth;
		this.user_remarks = user_remarks;
		this.user_range = user_range;
		this.user_image = user_image;
	}

	// 引数が1つのコンストラクタ
	public User(String user_id) {
		super();
		this.user_id = user_id;
	}

	//引数がないコンストラクタ（デフォルトコンストラクタ）
	public User() {
		super();
		this.user_id = "";
		this.user_name = "";
		this.user_pw = "";
		this.user_k_name = "";
		this.user_company = "";
		this.user_class = 0;
		this.user_prefecture = "";
		this.user_hobby = "";
		this.user_skill = "";
		this.user_birth = "";
		this.user_remarks = "";
		this.user_range = 0;
		this.user_image = "";
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	public String getUser_pw() {
		return user_pw;
	}

	public void setUser_pw(String user_pw) {
		this.user_pw = user_pw;
	}

	public String getUser_k_name() {
		return user_k_name;
	}

	public void setUser_k_name(String user_k_name) {
		this.user_k_name = user_k_name;
	}

	public String getUser_company() {
		return user_company;
	}

	public void setUser_company(String user_company) {
		this.user_company = user_company;
	}

	public int getUser_class() {
		return user_class;
	}

	public void setUser_class(int user_class) {
		this.user_class = user_class;
	}

	public String getUser_prefecture() {
		return user_prefecture;
	}

	public void setUser_prefecture(String user_prefecture) {
		this.user_prefecture = user_prefecture;
	}

	public String getUser_hobby() {
		return user_hobby;
	}

	public void setUser_hobby(String user_hobby) {
		this.user_hobby = user_hobby;
	}

	public String getUser_skill() {
		return user_skill;
	}

	public void setUser_skill(String user_skill) {
		this.user_skill = user_skill;
	}

	public String getUser_birth() {
		return user_birth;
	}

	public void setUser_birth(String user_birth) {
		this.user_birth = user_birth;
	}

	public String getUser_remarks() {
		return user_remarks;
	}

	public void setUser_remarks(String user_remarks) {
		this.user_remarks = user_remarks;
	}

	public int getUser_range() {
		return user_range;
	}

	public void setUser_range(int user_range) {
		this.user_range = user_range;
	}

	public String getUser_image() {
		return user_image;
	}

	public void setUser_image(String user_image) {
		this.user_image = user_image;
	}
}
