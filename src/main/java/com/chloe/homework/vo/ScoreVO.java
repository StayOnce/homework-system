package com.chloe.homework.vo;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ScoreVO {
    private Long submitId;
    private String homeworkTitle;
    private String courseName;
    private String studentName;
    private String submitContent;
    private Double score;
    private String comment;
    private LocalDateTime gradeTime;
    private String gradeStatus;
}