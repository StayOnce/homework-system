package com.chloe.homework.entity;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class HomeworkSubmit {

    private Long id;

    private Long homeworkId;

    private Long studentId;

    private String submitContent;

    private String fileUrl;

    private LocalDateTime submitTime;

    private String status;

    private String gradeStatus;

    private LocalDateTime createTime;

}