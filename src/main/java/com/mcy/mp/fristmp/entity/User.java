package com.mcy.mp.fristmp.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * 学生类
 */
@Data
@TableName("user")  //#TableName中的值对应着表名
public class User {

    /**
     * 主键
     * @TableId中可以决定主键的类型，不写会采取默认值，默认值可以在application.properties配置文件中设置
     * AUTO：数据库ID自增
     * INPUT: 用户输入ID
     * ID_WORKER: 全局唯一ID，Long类型的主键
     * ID_WORKER_STR: 字符串全局唯一ID
     * UUID: 全局唯一ID，UUID类型的主键
     * NONE: 该类型为未设置主键类型
     */
    @TableId(type = IdType.AUTO)
    private Integer id;

    //姓名
    private String name;

    //年龄
    private Integer age;

    //科目
    private String course;

    //分数
    private Integer fraction;
}
