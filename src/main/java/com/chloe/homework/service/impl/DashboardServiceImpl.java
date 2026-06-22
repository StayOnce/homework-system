package com.chloe.homework.service.impl;

import com.chloe.homework.entity.User;
import com.chloe.homework.mapper.CourseMapper;
import com.chloe.homework.mapper.HomeworkMapper;
import com.chloe.homework.mapper.HomeworkSubmitMapper;
import com.chloe.homework.mapper.UserMapper;
import com.chloe.homework.service.DashboardService;
import com.chloe.homework.utils.UserContext;
import com.chloe.homework.vo.CourseStatisticsVO;
import com.chloe.homework.vo.DashboardVO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class DashboardServiceImpl implements DashboardService {
    private final CourseMapper courseMapper;
    private final HomeworkMapper homeworkMapper;
    private final HomeworkSubmitMapper submitMapper;
    private final UserMapper userMapper;

    @Override
    public DashboardVO getDashboard() {
        DashboardVO vo = new DashboardVO();
        String role = UserContext.getRole();
        Long userId = UserContext.getUserId();

        User user = userMapper.findById(userId);
        if (user != null) {
            vo.setUserName(user.getRealName());
            vo.setUserRole(user.getRole());
        }

        if ("admin".equals(role)) {
            vo.setTotalCourses(courseMapper.getTotalCount());
            vo.setTotalHomeworks(homeworkMapper.getTotalCount());
            vo.setTotalStudents(userMapper.getStudentCount());
            vo.setTotalSubmits(submitMapper.getTotalCount());
            vo.setAverageScore(submitMapper.getAverageScore());
            vo.setCourseStatistics(courseMapper.getStatistics());
        } else if ("teacher".equals(role)) {
            vo.setTotalCourses(courseMapper.getCourseCountByTeacherId(userId));
            vo.setTotalHomeworks(homeworkMapper.getHomeworkCountByTeacherId(userId));
            vo.setTotalStudents(courseMapper.getStudentCountByTeacherId(userId));
            vo.setTotalSubmits(submitMapper.getSubmitCountByTeacherId(userId));
            vo.setAverageScore(submitMapper.getAverageScoreByTeacherId(userId));
            vo.setPendingGrades(submitMapper.getPendingGradeCountByTeacherId(userId));
            vo.setCourseStatistics(courseMapper.getStatisticsByTeacherId(userId));
        } else if ("student".equals(role)) {
            vo.setTotalCourses(courseMapper.getCourseCountByStudentId(userId));
            vo.setTotalHomeworks(homeworkMapper.getHomeworkCountByStudentId(userId));
            vo.setTotalSubmits(submitMapper.getSubmitCountByStudentId(userId));
            vo.setAverageScore(submitMapper.getAverageScoreByStudentId(userId));
            vo.setPendingSubmits(homeworkMapper.getPendingSubmitCountByStudentId(userId, LocalDateTime.now()));
        }

        return vo;
    }
}