package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.User;
import com.example.demo.repository.UserMapper;

/**
 * ユーザー情報を扱うサービスクラス
 * @author　小田
 * @version　1.0.0
 */
@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;
    
    /**
     * ユーザー情報取得
     * @return 取得結果
     */
    public List<User>  selectAllUser() {
        return userMapper.selectAllUser();
    }
    
    /**
     * ユーザー情報取得(プルダウンメニュー用)
     * @return 取得結果
     */
    public List<User>  selectUserPulldown() {
        return userMapper.selectUserPulldown();
    }
    
    /**
     * ユーザ情報登録
     */
    public void  insertUser(String slackId,String userName) {
        userMapper.insertUser(slackId, userName);
    }
    
    /**
     * ユーザ情報更新
     */
    public void  updateUser(int id,String slackId,String userName) {
        userMapper.updateUser(id,slackId,userName);
    }
    
    /**
     * ユーザ情報削除
     */
    public void  deleteUser(int id) {
        userMapper.deleteUser(id);
    }
}