package com.chloe.homework.service;

import com.chloe.homework.entity.Homework;
import com.chloe.homework.vo.HomeworkVO;

import java.util.List;

public interface HomeworkService {

    void add(Homework homework);

    List<HomeworkVO> list();

}