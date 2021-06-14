package model;
import java.io.Serializable;
import java.sql.Timestamp;

public class Inquiry implements Serializable {
	private String user_id;
	private int inquiry_id;
	private String subject;
	private String message;
	private Timestamp ts;

	//引数があるコンストラクタ
	public Inquiry(
			 String user_id,
			 int inquiry_id,
			 String subject,
			 String message,
			 Timestamp ts) {
	super();
	this.user_id = user_id;
	this.inquiry_id = inquiry_id;
	this.subject = subject;
	this.message = message;
	this.ts = ts;
	}

	//引数がないコンストラクタ
	public Inquiry() {
		super();
		this.user_id = null;
		this.inquiry_id = 0;
		this.subject = "";
		this.message = "";
		this.ts = null;

	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public int getInquiry_id() {
		return inquiry_id;
	}

	public void setInquiry_id(int inquiry_id) {
		this.inquiry_id = inquiry_id;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Timestamp getTs() {
		return ts;
	}

	public void setTs(Timestamp ts) {
		this.ts = ts;
	}

}
