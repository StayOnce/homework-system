package com.chloe.homework.vo;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class HomeworkSubmitVO {

    private Long id;

    private String homeworkTitle;

    private String courseName;

    private String studentName;

    private String submitContent;

    private LocalDateTime submitTime;

    private String gradeStatus;

    private Double score;
}