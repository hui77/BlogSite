package entity;

public class Relation {
	private int id;
	private String noticerId;
	private String noticedId;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNoticerId() {
		return noticerId;
	}
	public void setNoticerId(String noticerId) {
		this.noticerId = noticerId;
	}
	public String getNoticedId() {
		return noticedId;
	}
	public void setNoticedId(String noticedId) {
		this.noticedId = noticedId;
	}
	
}
