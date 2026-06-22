package com.chloe.homework.service;

import com.chloe.homework.dto.SubmitDTO;
import com.chloe.homework.vo.HomeworkSubmitVO;

import java.util.List;

public interface HomeworkSubmitService {
    void submit(SubmitDTO dto);
    List<HomeworkSubmitVO> list();
}