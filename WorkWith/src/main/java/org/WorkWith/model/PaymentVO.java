package org.WorkWith.model;

public class PaymentVO {
	
	private int pno;
	
	private String title;
	
	private String content;
	
	private String status;
	
	private String id;
	
	public int getPno() {
		return pno;
	}
	public void setPno(int pno) {
		this.pno = pno;
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
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	@Override
	public String toString() {
		return "PaymentVO [pno=" + pno + ", title=" + title + ", content=" + content + ", status=" + status + ", id="
				+ id + "]";
	}
}
