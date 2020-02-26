package com.mcy.mp.fristmp.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.mcy.mp.fristmp.entity.User;

import java.util.List;

/**
 * 用户信息DAO
 */
public interface UserMapper extends BaseMapper<User> {
    /**
     * 查询大于该分数的学生
     * @param fraction 分数
     * @return 查询结构
     */
    List<User> selectUserFraction(Integer fraction);
}
