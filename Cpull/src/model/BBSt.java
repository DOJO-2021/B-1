package model;
import java.io.Serializable;

public class BBSt implements Serializable {
	private String bbs_title;

	//引数のあるコンストラクタ
	public BBSt(String bbs_title) {
		super();
		this.bbs_title = bbs_title;
	}

	//引数がないコンストラクタ(デフォルトコンストラクタ)
	public BBSt() {
		super();
		this.bbs_title = "";
	}

	public String getBbs_title() {
		return bbs_title;
	}

	public void setBbs_title(String bbs_title) {
		this.bbs_title = bbs_title;
	}
}