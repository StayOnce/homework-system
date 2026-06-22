package com.chloe.homework.service.impl;

import com.chloe.homework.dto.SubmitDTO;
import com.chloe.homework.entity.Homework;
import com.chloe.homework.entity.HomeworkSubmit;
import com.chloe.homework.exception.BusinessException;
import com.chloe.homework.mapper.HomeworkMapper;
import com.chloe.homework.mapper.HomeworkSubmitMapper;
import com.chloe.homework.service.HomeworkSubmitService;
import com.chloe.homework.utils.UserContext;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import com.chloe.homework.vo.HomeworkSubmitVO;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class HomeworkSubmitServiceImpl implements HomeworkSubmitService {
    private final HomeworkMapper homeworkMapper;
    private final HomeworkSubmitMapper submitMapper;

    @Override
    public void submit(SubmitDTO dto) {
        Long studentId = UserContext.getUserId();
        Homework homework = homeworkMapper.findById(dto.getHomeworkId());

        if (homework == null) {
            throw new BusinessException("作业不存在");
        }

        if (LocalDateTime.now().isAfter(homework.getDeadline())) {
            throw new BusinessException("作业已截止提交");
        }

        HomeworkSubmit exist = submitMapper.findByHomeworkAndStudent(dto.getHomeworkId(), studentId);
        if (exist != null) {
            throw new BusinessException("不能重复提交");
        }

        HomeworkSubmit submit = new HomeworkSubmit();
        submit.setHomeworkId(dto.getHomeworkId());
        submit.setStudentId(studentId);
        submit.setSubmitContent(dto.getSubmitContent());
        submit.setSubmitTime(LocalDateTime.now());
        submit.setStatus("SUBMITTED");

        submitMapper.insert(submit);
    }

    @Override
    public List<HomeworkSubmitVO> list() {
        String role = UserContext.getRole();
        Long userId = UserContext.getUserId();

        if ("student".equals(role)) {
            return submitMapper.getSubmitListByStudentId(userId);
        } else if ("teacher".equals(role)) {
            return submitMapper.getSubmitListByTeacherId(userId);
        } else {
            return submitMapper.getSubmitList();
        }
    }
}