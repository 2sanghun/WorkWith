package org.WorkWith.model;

public class MemberVO {
	private String id;
	
	private String department;
	
	private String position;
	
	private String emplno;
	
	private String password;
		
	private String addr;
	
	private String phone;
	
	private String email;
	
	private String name;
	
	private String startdate;
	
	private String enddate;
	
	private String birth;
	
	private int quit;
	
	private int cnt;


	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}


	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBirth() {
		return birth;
	}

	public void setBirth(String birth) {
		this.birth = birth;
	}
	
	public int getCnt() {
		return cnt;
	}

	public void setCnt(int cnt) {
		this.cnt = cnt;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public String getStartdate() {
		return startdate;
	}

	public void setStartdate(String startdate) {
		this.startdate = startdate;
	}

	public String getEmplno() {
		return emplno;
	}

	public void setEmplno(String emplno) {
		this.emplno = emplno;
	}

	public int getQuit() {
		return quit;
	}

	public void setQuit(int quit) {
		this.quit = quit;
	}

	public String getEnddate() {
		return enddate;
	}

	public void setEnddate(String enddate) {
		this.enddate = enddate;
	}

	@Override
	public String toString() {
		return "MemberVO [id=" + id + ", department=" + department + ", position=" + position + ", emplno=" + emplno
				+ ", password=" + password + ", addr=" + addr + ", phone=" + phone + ", email=" + email + ", name="
				+ name + ", startdate=" + startdate + ", enddate=" + enddate + ", birth=" + birth + ", quit=" + quit
				+ ", cnt=" + cnt + "]";
	}
	
	
}
