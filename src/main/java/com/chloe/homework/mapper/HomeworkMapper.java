package com.chloe.homework.mapper;

import com.chloe.homework.entity.Homework;
import com.chloe.homework.vo.HomeworkVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface HomeworkMapper {
    int insert(Homework homework);
    List<HomeworkVO> getHomeworkList();
    List<HomeworkVO> getHomeworkListByTeacherId(@Param("teacherId") Long teacherId);
    List<HomeworkVO> getHomeworkListByCourseIds(@Param("courseIds") List<Long> courseIds);
    Homework findById(Long id);
    int update(Homework homework);
    int deleteById(Long id);
    Integer getTotalCount();
    Integer getHomeworkCountByTeacherId(@Param("teacherId") Long teacherId);
    Integer getHomeworkCountByStudentId(@Param("studentId") Long studentId);
    Integer getPendingSubmitCountByStudentId(@Param("studentId") Long studentId, @Param("now") java.time.LocalDateTime now);
}