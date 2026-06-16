package com.chloe.homework.mapper;

import com.chloe.homework.entity.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {

    User login(String username);

    User findById(Long id);

}