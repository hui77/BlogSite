package entity;

public class User {
	private String id;
	private String password;
	private String nickname;
	
	private String gender;
	private String profession;
	private String email;
	private String introduction;
	
	public User() {
	}
	/** 用户注册 */
	public User(String id, String password, String nickname) {
		this.id = id;
		this.password = password;
		this.nickname = nickname;
	}
	/** 修改密码 */
	public User(String id, String password) {
		this.id = id;
		this.password = password;
	}
	/** 修改-查询个人信息 */
	public User(String id, String nickname, String gender, String profession,
			String email, String introduction) {
		this.id = id;
		this.nickname = nickname;
		this.gender = gender;
		this.profession = profession;
		this.email = email;
		this.introduction = introduction;
	}
	
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
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getProfession() {
		return profession;
	}
	public void setProfession(String profession) {
		this.profession = profession;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getIntroduction() {
		return introduction;
	}
	public void setIntroduction(String introduction) {
		this.introduction = introduction;
	}
}
