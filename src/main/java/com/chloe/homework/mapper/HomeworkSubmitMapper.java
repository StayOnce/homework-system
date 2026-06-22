package com.chloe.homework.mapper;

import com.chloe.homework.entity.HomeworkSubmit;
import com.chloe.homework.vo.HomeworkSubmitVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface HomeworkSubmitMapper {
    HomeworkSubmit findByHomeworkAndStudent(
            @Param("homeworkId") Long homeworkId,
            @Param("studentId") Long studentId
    );
    int insert(HomeworkSubmit submit);
    HomeworkSubmit findById(Long id);
    int updateGradeStatus(@Param("id") Long id, @Param("gradeStatus") String gradeStatus);
    int countByHomeworkId(Long homeworkId);
    List<HomeworkSubmitVO> getSubmitList();
    List<HomeworkSubmitVO> getSubmitListByStudentId(@Param("studentId") Long studentId);
    List<HomeworkSubmitVO> getSubmitListByTeacherId(@Param("teacherId") Long teacherId);
    Integer getTotalCount();
    Integer getSubmitCountByTeacherId(@Param("teacherId") Long teacherId);
    Integer getSubmitCountByStudentId(@Param("studentId") Long studentId);
    Double getAverageScore();
    Double getAverageScoreByTeacherId(@Param("teacherId") Long teacherId);
    Double getAverageScoreByStudentId(@Param("studentId") Long studentId);
    Integer getPendingGradeCountByTeacherId(@Param("teacherId") Long teacherId);
}