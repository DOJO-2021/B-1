//BC.javaを入れる
package model;
import java.io.Serializable;

public class User implements Serializable {
	private int businesscard_id;
	private String company_name;
	private String department_name;
	private String full_name;
	private String zipcode;
	private String address;
	private String tel;
	private String fax;
	private String email;
	private String remarks;

	//引数があるコンストラクタ
	public User(int businesscard_id, String company_name, String department_name, String full_name, String zipcode,
			String address, String tel, String fax, String email, String remarks) {
		super();
		this.businesscard_id = businesscard_id;
		this.company_name = company_name;
		this.department_name = department_name;
		this.full_name = full_name;
		this.zipcode = zipcode;
		this.address = address;
		this.tel = tel;
		this.fax = fax;
		this.email = email;
		this.remarks = remarks;
	}

	//引数がないコンストラクタ（デフォルトコンストラクタ）
	public User() {
		super();
		this.businesscard_id = 0;
		this.company_name = "";
		this.department_name = "";
		this.full_name = "";
		this.zipcode = "";
		this.address = "";
		this.tel = "";
		this.fax = "";
		this.email = "";
		this.remarks = "";
	}

	public int getBusinesscard_id() {
		return businesscard_id;
	}

	public void setBusinesscard_id(int businesscard_id) {
		this.businesscard_id = businesscard_id;
	}

	public String getCompany_name() {
		return company_name;
	}

	public void setCompany_name(String company_name) {
		this.company_name = company_name;
	}

	public String getDepartment_name() {
		return department_name;
	}

	public void setDepartment_name(String department_name) {
		this.department_name = department_name;
	}

	public String getFull_name() {
		return full_name;
	}

	public void setFull_name(String full_name) {
		this.full_name = full_name;
	}

	public String getZipcode() {
		return zipcode;
	}

	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getFax() {
		return fax;
	}

	public void setFax(String fax) {
		this.fax = fax;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
}
