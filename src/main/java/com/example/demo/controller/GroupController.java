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
import com.example.demo.service.GroupService;
import com.example.demo.dto.GroupMemberDTO;
import com.example.demo.dto.GroupMemberNameDTO;
import com.example.demo.entity.User;

/**
 * グループ情報を扱うコントローラクラス
 * 
 * @author 小田
 * @version 1.0.0
 */
@RestController
@RequestMapping("group")
@CrossOrigin(origins = { "http://localhost:8081" })
public class GroupController {

	@Autowired
	private GroupService groupService;

	/**
	 * selectGroupAllメソッド グループ情報をすべて取得するメソッド
	 * 
	 * @return list GroupMemberDTOのリスト
	 */
	@GetMapping("/selectGroupAll")
	List<GroupMemberDTO> selectGroupAll() {
		// グループメンバー名リストを生成
		List<GroupMemberNameDTO> groupMemberNameList = new ArrayList<GroupMemberNameDTO>();
		// グループメンバー名の情報を全て取得
		groupMemberNameList = groupService.selectAllGroupMemberName();

		// グループメンバーリストを生成
		List<GroupMemberDTO> groupMemberList = groupService.selectGroupList();

		// グループメンバーリストの要素指定用
		int count = 0;
		// グループの数だけループ
		for (GroupMemberDTO groupMember : groupMemberList) {
			// １グループに所属するメンバーのリストを生成
			List<User> menberList = new ArrayList<User>();
			// グループに所属するメンバーの数だけループ
			for (GroupMemberNameDTO groupMemberName : groupMemberNameList) {
				// 同じグループIDのメンバーのユーザIDとユーザ名をメンバーリストに格納
				if (groupMember.getGroupId() == groupMemberName.getGroupId()) {
					User user = new User();
					user.setId(groupMemberName.getUserId());
					user.setUserName(groupMemberName.getUserName());
					menberList.add(user);
				}
			}
			// グループメンバーリストにメンバーリストを格納
			groupMemberList.get(count).setUser(menberList);
			// グループメンバーリストの要素の１つずらす
			count++;
		}
		return groupMemberList;
	}

	/**
	 * insertGroupメソッド グループ情報を登録するメソッド
	 * 
	 * @param GroupMemberDTO グループ名とメンバーの情報
	 * @return HttpStatus
	 */
	@PutMapping("/insertGroup")
	public ResponseEntity<HttpStatus> insertGroup(@RequestBody GroupMemberDTO groupInfo) {
		// グループを登録
		groupService.insertGroupName(groupInfo.getGroupName());
		// 登録したグループのIDを取得
		int groupId = groupService.getLastInsertGroupId();
		// メンバーの数だけ登録
		for (User userlist : groupInfo.getUser()) {
			// グループを登録
			groupService.insertGroupMember(groupId, userlist.getId());
		}
		return new ResponseEntity<HttpStatus>(HttpStatus.OK);
	}

	/**
	 * updateGroupメソッド グループ情報を更新するメソッド
	 * 
	 * @param GroupMemberDTO グループ名とメンバーの情報
	 * @return HttpStatus
	 */
	@PostMapping("/updateGroup")
	public ResponseEntity<HttpStatus> updateGroup(@RequestBody GroupMemberDTO group) {
		// グループ名を更新
		groupService.updateGroupName(group.getGroupId(), group.getGroupName());
		// グループメンバー情報を一度削除
		groupService.deleteGroupMember(group.getGroupId());
		// グループメンバーの数だけループ
		for (User list : group.getUser()) {
			// グループメンバーを登録
			groupService.insertGroupMember(group.getGroupId(), list.getId());
		}
		return new ResponseEntity<HttpStatus>(HttpStatus.OK);
	}

	/**
	 * deleteGroupメソッド グループ情報を削除するメソッド
	 * 
	 * @param int グループID
	 * @return HttpStatus
	 */
	@DeleteMapping("/deleteGroup")
	public ResponseEntity<HttpStatus> deleteGroup(@RequestParam("id") int id) {
		// グループメンバーを削除
		groupService.deleteGroupMember(id);
		// グループを削除
		groupService.deleteGroupName(id);
		return new ResponseEntity<HttpStatus>(HttpStatus.OK);
	}
}