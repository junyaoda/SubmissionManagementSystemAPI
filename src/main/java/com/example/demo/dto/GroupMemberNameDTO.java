package com.example.demo.dto;

import java.io.Serializable;

import lombok.Data;

/**
 * 
 * グループメンバー名 取得用DTO
 */
@Data
public class GroupMemberNameDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	int groupId;
	int userId;
	String userName;

	public int getGroupId() {
		return groupId;
	}

	public void setGroupId(int groupId) {
		this.groupId = groupId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

}