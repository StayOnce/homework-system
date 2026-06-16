package com.chloe.homework.mapper;

import com.chloe.homework.entity.Homework;
import com.chloe.homework.vo.HomeworkVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface HomeworkMapper {

    int insert(Homework homework);

    List<HomeworkVO> getHomeworkList();

    Homework findById(Long id);

}