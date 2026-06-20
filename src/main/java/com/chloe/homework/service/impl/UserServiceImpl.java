package com.chloe.homework.service.impl;

import com.chloe.homework.entity.User;
import com.chloe.homework.exception.BusinessException;
import com.chloe.homework.mapper.UserMapper;
import com.chloe.homework.service.UserService;
import com.chloe.homework.utils.JwtUtil;
import com.chloe.homework.utils.UserContext;
import com.chloe.homework.vo.UserInfoVO;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl
        implements UserService {

    private final UserMapper userMapper;

    @Override
    public String login(
            String username,
            String password
    ) {

        User user =
                userMapper.login(username);

        if (user == null) {

            throw new BusinessException(
                    "用户不存在"
            );
        }

        if (!user.getPassword().equals(password)) {

            throw new BusinessException(
                    "密码错误"
            );
        }

        return JwtUtil.createToken(
                user.getId(),
                user.getUsername(),
                user.getRole()
        );
    }

    @Override
    public UserInfoVO getCurrentUser() {

        Long userId =
                UserContext.getUserId();

        User user =
                userMapper.findById(userId);

        UserInfoVO vo =
                new UserInfoVO();

        BeanUtils.copyProperties(
                user,
                vo
        );

        return vo;
    }

    @Override
    public List<User> getTeacherList() {

        return userMapper.getTeacherList();

    }
}