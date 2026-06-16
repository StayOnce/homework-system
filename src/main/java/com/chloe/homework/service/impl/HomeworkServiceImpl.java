package com.chloe.homework.service.impl;

import com.chloe.homework.entity.Homework;
import com.chloe.homework.mapper.HomeworkMapper;
import com.chloe.homework.service.HomeworkService;
import com.chloe.homework.vo.HomeworkVO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class HomeworkServiceImpl
        implements HomeworkService {

    private final HomeworkMapper homeworkMapper;

    @Override
    public void add(Homework homework) {

        homework.setPublishTime(
                LocalDateTime.now()
        );

        homework.setStatus(
                "PUBLISHED"
        );

        homeworkMapper.insert(
                homework
        );
    }

    @Override
    public List<HomeworkVO> list() {

        return homeworkMapper.getHomeworkList();

    }
}