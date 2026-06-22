package com.chloe.homework.mapper;

import com.chloe.homework.entity.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {
    User login(String username);
    User findById(Long id);
    List<User> getTeacherList();
    Integer getStudentCount();
    List<User> getStudentList();
    List<User> getUserList();
    int insert(User user);
    int update(User user);
    int deleteById(Long id);
}