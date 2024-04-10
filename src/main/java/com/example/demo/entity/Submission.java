package com.example.demo.entity;

import java.sql.Date;

import lombok.Data;

@Data
public class Submission {
    int id;
    int userId;
    String content;
    String url;
    String comment;
    Date deadline;
    Date remaindDateTime;
    boolean completeFlag;
}