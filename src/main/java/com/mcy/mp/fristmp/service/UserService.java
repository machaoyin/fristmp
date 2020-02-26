package com.mcy.mp.fristmp.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.mcy.mp.fristmp.entity.User;

import java.util.List;

/**
 * 用户业务接口
 */
public interface UserService extends IService<User> {
    /**
     * 查询大于该分数的学生
     * @param fraction 分数
     * @return 查询结构
     */
    List<User> selectUserFraction(Integer fraction);
}
