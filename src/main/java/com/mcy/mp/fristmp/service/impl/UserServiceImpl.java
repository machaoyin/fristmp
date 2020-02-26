package com.mcy.mp.fristmp.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mcy.mp.fristmp.entity.User;
import com.mcy.mp.fristmp.mapper.UserMapper;
import com.mcy.mp.fristmp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 用户业务实现
 */
@Service
@Transactional  //事务
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public List<User> selectUserFraction(Integer fraction) {
        return userMapper.selectUserFraction(fraction);
    }
}
