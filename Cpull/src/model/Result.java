package model;
import java.io.Serializable;

public class Result implements Serializable {
	private String title;		// タイトル
	private String backTo;		// 戻り先
	private String message;		// ページ遷移先

	public Result() {
		this(null, null, null);
	}

	public Result(String title, String backTo, String message) {
		this.title = title;
		this.backTo = backTo;
		this.message = message;
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

	public String getMessage() {
		return message;
	}

	public void setMessage(String Message) {
		this.message = message;
	}
}
