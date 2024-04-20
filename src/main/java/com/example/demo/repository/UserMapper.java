package com.example.demo.repository;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.example.demo.entity.User;

@Mapper
public interface UserMapper {

	/**
	 * ユーザー情報取得
	 */
	@Select("SELECT * FROM user;")
	List<User> selectAllUser();

	/**
	 * ユーザー情報取得(プルダウンメニュー用)
	 */
	@Select("SELECT * FROM user;")
	List<User> selectUserPulldown();

	/**
	 * ユーザ情報登録
	 */
	@Insert("INSERT INTO user (slack_id, user_name) " 
			+ "	VALUES 	( #{slackId}, #{userName}) ;")
	void insertUser(String slackId, String userName);

	/**
	 * ユーザ情報更新
	 */
	@Update("UPDATE user " 
			+ "SET slack_id = #{slackId}, user_name = #{userName} " 
			+ "WHERE id=#{id};")
	void updateUser(int id, String slackId, String userName);

	/**
	 * ユーザ情報削除
	 */
	@Delete("DELETE FROM user WHERE id = #{id};")
	void deleteUser(int id);
}
