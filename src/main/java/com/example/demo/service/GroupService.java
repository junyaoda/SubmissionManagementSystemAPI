package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.GroupMemberDTO;
import com.example.demo.dto.GroupMemberNameDTO;
import com.example.demo.repository.GroupMapper;

/**
 * グループ情報を扱うサービスクラス
 * @author　小田
 * @version　1.0.0
 */
@Service
public class GroupService {

    @Autowired
    private GroupMapper groupMapper;
    
    /**
     * グループ情報取得
     * @return 取得結果
     */
    public List<GroupMemberNameDTO>  selectAllGroupMemberName() {
        return groupMapper.selectAllGroupMemberName();
    }
    /**
     * グループのIDと名前の取得
     * @return 取得結果
     */
    public List<GroupMemberDTO>  selectGroupList() {
        return groupMapper.selectGroupList();
    }
    /**
     * 直前に登録したグループID取得
     * @return 取得結果
     */
    public int  getLastInsertGroupId() {
        return groupMapper.getLastInsertGroupId();
    }
    
    /**
     * グループ名登録
     */
    public void insertGroupName(String groupName) {
    	groupMapper.insertGroupName(groupName);
    }
    
    /**
     * グループメンバー登録
     */
    public void  insertGroupMember(int groupId,int userId) {
        groupMapper.insertGroupMember(groupId,userId);
    }
    
    /**
     * グループ名更新
     */
    public void  updateGroupName(int id,String groupName) {
        groupMapper.updateGroupName(id,groupName);
    }
    
    /**
     * グループ名削除
     */
    public void  deleteGroupName(int id) {
        groupMapper.deleteGroupName(id);
    }
    
    /**
     * グループメンバー削除
     */
    public void  deleteGroupMember(int id) {
        groupMapper.deleteGroupMember(id);
    }
}