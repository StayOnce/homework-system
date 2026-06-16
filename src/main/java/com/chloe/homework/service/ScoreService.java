package com.chloe.homework.service;

import com.chloe.homework.dto.GradeDTO;
import com.chloe.homework.vo.ScoreVO;

import java.util.List;

public interface ScoreService {

    void grade(GradeDTO dto);

    List<ScoreVO> myScores();

}