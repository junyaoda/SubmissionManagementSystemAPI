package com.example.demo.repository;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.example.demo.dto.GroupMemberDTO;
import com.example.demo.dto.GroupMemberNameDTO;

@Mapper
public interface GroupMapper {

	/**
	 * グループ情報取得
	 */
	@Select("SELECT gm.group_id ,u.id as user_id,u.user_name FROM SubmissionManagementSystem.group_member gm "
			+ "left join SubmissionManagementSystem.user u on u.id = gm.user_id " + "order by gm.group_id;")
	List<GroupMemberNameDTO> selectAllGroupMemberName();

	/**
	 * グループのIDと名前の取得
	 */
	@Select("SELECT gm.group_id,gn.group_name "
			+ "FROM SubmissionManagementSystem.group_member gm "
			+ "left join SubmissionManagementSystem.group_name gn on gn.id = gm.group_id "
			+ "left join SubmissionManagementSystem.user u on u.id = gm.user_id "
			+ "group by gm.group_id order by gm.group_id;")
	List<GroupMemberDTO> selectGroupList();

	/**
	 * 直前に登録したグループID取得
	 */
	@Select("SELECT id FROM SubmissionManagementSystem.Group_Name " 
			+ "order by id desc limit 1;")
	int getLastInsertGroupId();

	/**
	 * グループ名登録
	 */
	@Insert("INSERT INTO SubmissionManagementSystem.group_name (group_name) " 
			+ "VALUES ( #{groupName} ) ;")
	void insertGroupName(String groupName);

	/**
	 * グループメンバー登録
	 */
	@Insert("INSERT INTO SubmissionManagementSystem.group_member (group_id,user_id) " 
			+ "VALUES ( #{groupId} , #{userId} ) ;")
	void insertGroupMember(int groupId, int userId);

	/**
	 * グループ名更新
	 */
	@Update("UPDATE group_name " 
			+ "SET group_name = #{groupName} " 
			+ "WHERE id=#{id};")
	void updateGroupName(int id, String groupName);

	/**
	 * グループ名削除
	 */
	@Delete("DELETE FROM group_name WHERE id = #{id};")
	void deleteGroupName(int id);

	/**
	 * グループメンバー削除
	 */
	@Delete("DELETE FROM group_member WHERE group_id = #{id};")
	void deleteGroupMember(int id);
}
