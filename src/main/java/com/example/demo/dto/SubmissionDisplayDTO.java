package com.example.demo.dto;
import java.io.Serializable;
import java.util.Date;

import lombok.Data;
/**
 * 
 * 提出物一覧　表示用データ
 */
@Data
public class SubmissionDisplayDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    int id;
    String content;
    String userName;
    Date deadline;
    Date remindDateTime;
    boolean completeFlag;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public Date getDeadline() {
		return deadline;
	}
	public void setDeadline(Date date) {
		this.deadline = date;
	}
	public Date getRemindDateTime() {
		return remindDateTime;
	}
	public void setRemindDateTime(Date remindDateTime) {
		this.remindDateTime = remindDateTime;
	}
	public boolean isCompleteFlag() {
		return completeFlag;
	}
	public void setCompleteFlag(boolean completeFlag) {
		this.completeFlag = completeFlag;
	}
    
}