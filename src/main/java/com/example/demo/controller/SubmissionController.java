package com.example.demo.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.service.SubmissionService;
import com.example.demo.dto.SubmissionDisplayDTO;
@RestController
@RequestMapping("submission")
@CrossOrigin(origins = {"http://localhost:8081"})
public class SubmissionController {
	
	 /**
     * ユーザー情報 Mapper
     */
    @Autowired
    private SubmissionService submissionService;

    @GetMapping
    List<SubmissionDisplayDTO> postLogin(){   	
    	List<Map<String, Object>> submissionList = submissionService.getSubmission();
    	List<SubmissionDisplayDTO> list = new ArrayList<SubmissionDisplayDTO>();
    	for(Map<String, Object> result : submissionList) {
    		SubmissionDisplayDTO submissionForm = new SubmissionDisplayDTO();
            submissionForm.setId((int)result.get("id"));
            submissionForm.setContent((String)result.get("content"));
            submissionForm.setUserName((String)result.get("user_name"));
            submissionForm.setDeadline((Date)result.get("deadline"));
            submissionForm.setRemindDateTime((Date)result.get("remind_date_time"));
            //submissionForm.setCompleteFlag((boolean)result.get("completeFlag"));
            list.add(submissionForm);
        }
        return list;
    }
}