package com.chloe.homework.service.impl;

import com.chloe.homework.dto.GradeDTO;
import com.chloe.homework.entity.HomeworkSubmit;
import com.chloe.homework.entity.ScoreRecord;
import com.chloe.homework.exception.BusinessException;
import com.chloe.homework.mapper.HomeworkSubmitMapper;
import com.chloe.homework.mapper.ScoreRecordMapper;
import com.chloe.homework.service.ScoreService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import com.chloe.homework.utils.UserContext;
import com.chloe.homework.vo.ScoreVO;
import java.util.List;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class ScoreServiceImpl implements ScoreService {
    private final HomeworkSubmitMapper submitMapper;
    private final ScoreRecordMapper scoreMapper;

    @Override
    public void grade(GradeDTO dto) {
        HomeworkSubmit submit = submitMapper.findById(dto.getSubmitId());
        if (submit == null) {
            throw new BusinessException("提交记录不存在");
        }

        ScoreRecord exist = scoreMapper.findBySubmitId(dto.getSubmitId());
        if (exist != null) {
            throw new BusinessException("该作业已经批改");
        }

        ScoreRecord record = new ScoreRecord();
        record.setSubmitId(dto.getSubmitId());
        record.setScore(dto.getScore());
        record.setComment(dto.getComment());
        record.setGradeTime(LocalDateTime.now());

        scoreMapper.insert(record);
        submitMapper.updateGradeStatus(dto.getSubmitId(), "GRADED");
    }

    @Override
    public List<ScoreVO> myScores() {
        return scoreMapper.getMyScores(UserContext.getUserId());
    }

    @Override
    public List<ScoreVO> getPendingGrades() {
        return scoreMapper.getPendingGrades(UserContext.getUserId());
    }
}