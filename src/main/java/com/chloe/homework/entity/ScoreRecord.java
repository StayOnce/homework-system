package com.chloe.homework.entity;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ScoreRecord {
    private Long id;
    private Long submitId;
    private Double score;
    private String comment;
    private LocalDateTime gradeTime;
    private LocalDateTime createTime;
}