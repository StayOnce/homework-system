package com.chloe.homework.dto;

import lombok.Data;

@Data
public class GradeDTO {
    private Long submitId;
    private Double score;
    private String comment;
}