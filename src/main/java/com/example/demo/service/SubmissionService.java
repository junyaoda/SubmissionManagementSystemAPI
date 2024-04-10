package com.example.demo.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repository.SubmissionMapper;

/**
 * ユーザー情報 Service
 */
@Service
public class SubmissionService {
	 /**
     * ユーザー情報 Mapper
     */
    @Autowired
    private SubmissionMapper submissionMapper;
    /**
     * ユーザー情報検索
　　　* @param userSearchRequest リクエストデータ
     * @return 検索結果
     */
//    public User search(UserSearchRequest userSearchRequest) {
//        return userMapper.search(userSearchRequest);
//    }
    public List<Map<String, Object>>  getSubmission() {
        return submissionMapper.getSubmission();
    }
    
}