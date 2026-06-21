package com.chloe.homework.service.impl;

import com.chloe.homework.entity.Homework;
import com.chloe.homework.mapper.HomeworkMapper;
import com.chloe.homework.mapper.HomeworkSubmitMapper;
import com.chloe.homework.service.HomeworkService;
import com.chloe.homework.utils.UserContext;
import com.chloe.homework.vo.HomeworkVO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import com.chloe.homework.exception.BusinessException;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class HomeworkServiceImpl
        implements HomeworkService {

    private final HomeworkMapper homeworkMapper;
    private final HomeworkSubmitMapper homeworkSubmitMapper;

    @Override
    public void add(Homework homework) {

        homework.setTeacherId(
                UserContext.getUserId()
        );

        homework.setPublishTime(
                LocalDateTime.now()
        );

        if (homework.getStatus() == null) {

            homework.setStatus(
                    "进行中"
            );

        }

        homeworkMapper.insert(
                homework
        );

    }

    @Override
    public List<HomeworkVO> list() {

        return homeworkMapper.getHomeworkList();

    }

    @Override
    public void update(Homework homework) {

        homeworkMapper.update(
                homework
        );

    }

    @Override
    public void delete(Long id) {

        Integer count =
                homeworkSubmitMapper
                        .countByHomeworkId(id);

        if(count > 0){

            throw new BusinessException(
                    "该作业已有学生提交记录，无法删除"
            );

        }

        homeworkMapper.deleteById(id);

    }

}