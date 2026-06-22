package com.chloe.homework.service.impl;

import com.chloe.homework.entity.Homework;
import com.chloe.homework.entity.HomeworkSubmit;
import com.chloe.homework.exception.BusinessException;
import com.chloe.homework.mapper.CourseMapper;
import com.chloe.homework.mapper.HomeworkMapper;
import com.chloe.homework.mapper.HomeworkSubmitMapper;
import com.chloe.homework.service.HomeworkService;
import com.chloe.homework.utils.UserContext;
import com.chloe.homework.vo.HomeworkVO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class HomeworkServiceImpl implements HomeworkService {
    private final HomeworkMapper homeworkMapper;
    private final HomeworkSubmitMapper homeworkSubmitMapper;
    private final CourseMapper courseMapper;

    @Override
    public void add(Homework homework) {
        String role = UserContext.getRole();
        if (!"teacher".equals(role)) {
            throw new BusinessException("只有教师可以发布作业");
        }
        homework.setTeacherId(UserContext.getUserId());
        homework.setPublishTime(LocalDateTime.now());
        homeworkMapper.insert(homework);
    }

    @Override
    public List<HomeworkVO> list() {
        String role = UserContext.getRole();
        Long userId = UserContext.getUserId();
        List<HomeworkVO> list;

        if ("teacher".equals(role)) {
            list = homeworkMapper.getHomeworkListByTeacherId(userId);
        } else if ("student".equals(role)) {
            List<Long> courseIds = courseMapper.getCourseIdsByStudentId(userId);
            list = (courseIds == null || courseIds.isEmpty()) ? new ArrayList<>() : homeworkMapper.getHomeworkListByCourseIds(courseIds);
        } else {
            list = homeworkMapper.getHomeworkList();
        }

        LocalDateTime now = LocalDateTime.now();
        for (HomeworkVO vo : list) {
            Boolean submitted = false;
            if ("student".equals(role)) {
                HomeworkSubmit submit = homeworkSubmitMapper.findByHomeworkAndStudent(vo.getId(), userId);
                submitted = submit != null;
            }
            vo.setSubmitted(submitted);

            if (vo.getDeadline() == null) {
                vo.setStatus("未设置截止时间");
            } else if (submitted) {
                vo.setStatus("已完成");
            } else if (now.isBefore(vo.getDeadline())) {
                vo.setStatus("进行中");
            } else {
                vo.setStatus("已截止");
            }
        }

        return list;
    }

    @Override
    public void update(Homework homework) {
        homeworkMapper.update(homework);
    }

    @Override
    public void delete(Long id) {
        Integer count = homeworkSubmitMapper.countByHomeworkId(id);
        if (count != null && count > 0) {
            throw new BusinessException("该作业已有学生提交记录，无法删除");
        }
        homeworkMapper.deleteById(id);
    }
}