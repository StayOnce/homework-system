package com.chloe.homework.mapper;

import com.chloe.homework.entity.HomeworkSubmit;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface HomeworkSubmitMapper {

    HomeworkSubmit findByHomeworkAndStudent(
            @Param("homeworkId") Long homeworkId,
            @Param("studentId") Long studentId
    );

    int insert(HomeworkSubmit submit);

    HomeworkSubmit findById(Long id);

    int updateGradeStatus(
            @Param("id") Long id,
            @Param("gradeStatus") String gradeStatus
    );

    int countByHomeworkId(Long homeworkId);
}