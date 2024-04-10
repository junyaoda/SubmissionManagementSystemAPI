package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.service.UserService;
import com.example.demo.entity.User;

/**
 * ユーザー情報を扱うコントローラクラス
 * @author　小田
 * @version　1.0.0
 */
@RestController
@RequestMapping("user")
@CrossOrigin(origins = {"http://localhost:8081"})
public class UserController {
	
    @Autowired
    private UserService userService;
    
	 /**
     * selectUserAllメソッド
     * ユーザ情報をすべて取得するメソッド
     * @return list userのリスト
     */
    @GetMapping("/selectUserAll")
    List<User> selectUserAll(){  
    	//ユーザリストを生成
    	List<User> list = new ArrayList<User>();
    	//ユーザ情報を全て取得
    	list = userService.selectAllUser();
        return list;
    }
    
	 /**
     * selectUserPulldownメソッド
     * ユーザー情報取得(プルダウンメニュー用)を取得するメソッド
     * @return list userのリスト
     */
    @GetMapping("/selectUserPulldown")
    List<User> selectUserPulldown(){   
    	//ユーザのリストを生成
    	List<User> list = new ArrayList<User>();
    	//ユーザのリストを取得
    	list = userService.selectUserPulldown();
        return list;
    }
  
	 /**
     * insertUserメソッド
     * ユーザ情報を登録するメソッド
     * @param User ユーザ情報
     * @return HttpStatus
     */
    @PutMapping("/insertUser")
    public ResponseEntity<HttpStatus> insertUser(@RequestBody User user) {
    	// ユーザを登録
    	userService.insertUser(user.getSlackId(),user.getUserName());
        return new ResponseEntity<HttpStatus>(HttpStatus.OK);
    }
    
	 /**
     * updateUserメソッド
     * ユーザ情報を更新するメソッド
     * @param User ユーザ情報
     * @return HttpStatus
     */    
    @PostMapping("/updateUser")
    public ResponseEntity<HttpStatus> updateUser(@RequestBody User user) {
    	// ユーザ情報を更新
    	userService.updateUser(user.getId(),user.getSlackId(),user.getUserName());
        return new ResponseEntity<HttpStatus>(HttpStatus.OK);
    }
    
	 /**
     * deleteUserメソッド
     * ユーザ情報を削除するメソッド
     * @param int ユーザID
     * @return HttpStatus
     */       
    @DeleteMapping("/deleteUser")
    public ResponseEntity<HttpStatus> deleteUser(@RequestParam("id") int id) {
    	// ユーザ情報を削除
    	userService.deleteUser(id);
        return new ResponseEntity<HttpStatus>(HttpStatus.OK);
    }
}