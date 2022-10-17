package org.WorkWith.model;

import java.util.ArrayList;

import org.WorkWith.model.AttachFileVO;

public class BoardVO {
	private int bno;
	
	private String title;
	
	private String content;
		
	private String regdate;
	
	private int cnt;
	
	private String department;

	private String position;
	
	private String category;
	
	private String id;

	private String filePath;
	
	private int cnthno;
	
	private int cntrno; 
	
	// AttachFileVO(파일 업로드 관련 model)
	private ArrayList<AttachFileVO> attach;

	public int getBno() {
		return bno;
	}

	public void setBno(int bno) {
		this.bno = bno;
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

	public String getRegdate() {
		return regdate;
	}

	public void setRegdate(String regdate) {
		this.regdate = regdate;
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

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

	public int getCnthno() {
		return cnthno;
	}

	public void setCnthno(int cnthno) {
		this.cnthno = cnthno;
	}

	public int getCntrno() {
		return cntrno;
	}

	public void setCntrno(int cntrno) {
		this.cntrno = cntrno;
	}

	public ArrayList<AttachFileVO> getAttach() {
		return attach;
	}

	public void setAttach(ArrayList<AttachFileVO> attach) {
		this.attach = attach;
	}

	@Override
	public String toString() {
		return "BoardVO [bno=" + bno + ", title=" + title + ", content=" + content + ", regdate=" + regdate + ", cnt="
				+ cnt + ", department=" + department + ", position=" + position + ", category=" + category + ", id="
				+ id + ", filePath=" + filePath + ", cnthno=" + cnthno + ", cntrno=" + cntrno + ", attach=" + attach
				+ "]";
	}
	
	
}
