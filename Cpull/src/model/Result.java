package model;
import java.io.Serializable;

public class Result implements Serializable {
	private String title;		// タイトル
	private String backTo;		// 戻り先

	public Result() {
		this(null, null);
	}

	public Result(String title, String backTo) {
		this.title = title;
		this.backTo = backTo;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getBackTo() {
		return backTo;
	}

	public void setBackTo(String backTo) {
		this.backTo = backTo;
	}
}
