package memberInfo;

public class memberInfoDto {  // 수정 시 입력 값을 바꿀 위치 - 하단 전부
	private String id;
	private String pw;
	private String name;
	private String n_name;
	private String email;
	private String regdate;
	
	public memberInfoDto() {
	}

	public memberInfoDto(String id, String pw, String name, String n_name, String email, String regdate) {  
		super();
		this.id = id;
		this.pw = pw;
		this.name = name;
		this.n_name = n_name;
		this.email = email;
		this.regdate = regdate;
	}
	
	public memberInfoDto(String id, String pw, String name, String n_name, String email) {  
		super();
		this.id = id;
		this.pw = pw;
		this.name = name;
		this.n_name = n_name;
		this.email = email;
		this.regdate = regdate;
	}
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getN_name() {
		return n_name;
	}

	public void setN_name(String n_name) {
		this.n_name = n_name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getregdate() {
		return regdate;
	}

	public void setregdate(String regdate) {
		this.regdate = regdate;
	}

	@Override
	public String toString() {
		return "memberInfoDto [id=" + id + ", pw=" + pw + ", name=" + name + ", n_name=" + n_name + ", email=" + email
				+ ", regdate=" + regdate + "]";
	}
	
	

}


