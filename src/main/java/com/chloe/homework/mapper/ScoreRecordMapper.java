package com.chloe.homework.mapper;

import com.chloe.homework.entity.ScoreRecord;
import com.chloe.homework.vo.ScoreVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ScoreRecordMapper {

    int insert(ScoreRecord scoreRecord);

    ScoreRecord findBySubmitId(Long submitId);

    List<ScoreVO> getMyScores(Long studentId);

}