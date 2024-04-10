package com.example.demo.entity;

import lombok.Data;

@Data
public class GroupMember {

	int groupId;
	int userId;

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

}