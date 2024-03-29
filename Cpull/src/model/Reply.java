package model;
import java.io.Serializable;

public class Reply implements Serializable {
	private int reply_id;
	private int bbs_id;
	private String user_id;
	private String user_name;
	private int reply_range;
	private String reply_contents;

	//コンストラクタ引数あり
public Reply(int reply_id,int bbs_id,String user_id, String user_name,int reply_range, String reply_contents) {
	super();
	this.reply_id = reply_id;
	this.bbs_id = bbs_id;
	this.user_id = user_id;
	this.user_name = user_name;
	this.reply_range = reply_range;
	this.reply_contents =reply_contents;
}
//コンストラクタ引数なし
public Reply() {
	super();
	this.reply_id = 0;
	this.bbs_id = 0;
	this.user_id = "";
	this.user_name = "";
	this.reply_range = 0;
	this.reply_contents ="";
}
public Reply(int int1, String string, String string2, int int2, int int3) {
	// TODO 自動生成されたコンストラクター・スタブ
}
public int getReply_id() {
	return reply_id;
}
public void setReply_id(int reply_id) {
	this.reply_id = reply_id;
}
public int getBbs_id() {
	return bbs_id;
}
public void setBbs_id(int bbs_id) {
	this.bbs_id = bbs_id;
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
public int getReply_range() {
	return reply_range;
}
public void setReply_range(int reply_range) {
	this.reply_range = reply_range;
}
public String getReply_contents() {
	return reply_contents;
}
public void setReply_contents(String reply_contents) {
	this.reply_contents = reply_contents;
}

}