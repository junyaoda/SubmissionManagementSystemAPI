package com.example.demo.repository;


import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface SubmissionMapper {
	@Select("SELECT s.id,s.content,u.user_name,s.deadline,s.remind_date_time,s.complete_flag "
			+ "FROM submission s "
			+ "left join User u "
			+ "on s.id = u.id;")
	List<Map<String, Object>>  getSubmission();
}

