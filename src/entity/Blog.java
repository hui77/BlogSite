package entity;

import java.util.Date;

public class Blog {
	private String id;
	private String authodId;
	private Date date;
	private String title;
	private String content;
	private int favorNum;
	
	/** 发表文章 */
	public Blog(String authodId, Date date, String title, String content) {
		this.authodId = authodId;
		this.date = date;
		this.title = title;
		this.content = content;
	}
	/** 查询个人文章 */
	public Blog(String id, Date date, String title, String content, int favorNum) {
		this.id = id;
		this.date = date;
		this.title = title;
		this.content = content;
		this.favorNum = favorNum;
	}
	/** 查询他人文章 */
	public Blog(String id, String authodId, Date date, String title, String content, int favorNum) {
		this.id = id;
		this.authodId = authodId;
		this.date = date;
		this.title = title;
		this.content = content;
		this.favorNum = favorNum;
	}
	/** 文章链接 */
	public Blog(String id) {
		this.id = id;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getAuthodId() {
		return authodId;
	}
	public void setAuthodId(String authodId) {
		this.authodId = authodId;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int getFavorNum() {
		return favorNum;
	}
	public void setFavorNum(int favorNum) {
		this.favorNum = favorNum;
	}
}
