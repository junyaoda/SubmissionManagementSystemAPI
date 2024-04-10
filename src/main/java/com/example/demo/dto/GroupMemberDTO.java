package com.example.demo.dto;

import java.io.Serializable;
import java.util.List;

import com.example.demo.entity.User;

import lombok.Data;

/**
 * 
 * グループ画面 表示用DTO
 */
@Data
public class GroupMemberDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	int groupId;
	String groupName;
	List<User> user;

	public int getGroupId() {
		return groupId;
	}

	public void setGroupId(int groupId) {
		this.groupId = groupId;
	}

	public String getGroupName() {
		return groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

	public List<User> getUser() {
		return user;
	}

	public void setUser(List<User> user) {
		this.user = user;
	}

}