package com.mcy.mp.fristmp.Controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.mcy.mp.fristmp.entity.User;
import com.mcy.mp.fristmp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * 根据id查询用户
     * @param id
     * @return  用户实体类
     */
    @RequestMapping("/findById")
    public User findById(Integer id){
        User user = userService.getById(id);
        return user;
    }

    /**
     * 查询全部信息
     * @return 用户集合
     */
    @RequestMapping("/findAll")
    public List<User> findAll(){
        List<User> userList = userService.list();
        return userList;
    }

    /**
     * 根据指定字段查询用户信息集合
     * @return 用户集合
     */
    @RequestMapping("findAllMap")
    public Collection<User> findAllMap(){
        //查询条件
        Map<String, Object> map = new HashMap<>();
        //kay是字段名，value是字段值
        map.put("age", 20);
        Collection<User> user = userService.listByMap(map);
        return user;
    }

    /**
     * 新增
     * @return  提示信息
     */
    @RequestMapping("/save")
    public String save(){
        User user = new User();
        user.setName("小三");
        user.setAge(18);
        user.setCourse("C++");
        user.setFraction(88);
        userService.save(user);
        return "新增一条数据成功！";
    }

    /**
     * 新增多条数据
     * @return  提示信息
     */
    @RequestMapping("/saveList")
    public String saveList(){
        User user = new User();
        user.setName("小二");
        user.setAge(23);
        user.setCourse("Java");
        user.setFraction(89);
        User user2 = new User();
        user2.setName("小二2");
        user2.setAge(24);
        user2.setCourse("Java");
        user2.setFraction(89);
        //定义list，把需要保存的对象存放到list中
        List<User> list = new ArrayList<>();
        list.add(user);
        list.add(user2);
        userService.saveBatch(list);
        return "多条数据保存成功！";
    }

    /**
     * 修改数据
     * @return  返回提示信息
     */
    @RequestMapping("/update")
    public String update(){
        //根据实体类中的id去更新，其他字段如果值为null，则不会更新该字段
        User user = new User();
        user.setId(1);
        user.setName("修改后的名称");
        userService.updateById(user);
        return "id字段值为1的数据修改成功！";
    }

    /**
     * 新增或者更新用户信息
     * @return 提示信息
     */
    @RequestMapping("/saveOrUpdate")
    public String saveOrUpdate(){
        //传入的实体类User中id为null就会新增(id自增)
        //实体类ID值存在，如果数据库存在ID就会更新，如果不存在就会新增
        User user = new User();
        user.setName("小吴");
        user.setAge(18);
        userService.saveOrUpdate(user);
        return "数据保存成功！";
    }

    /**
     * 根据id删除数据
     * @param id
     * @return  提示信息
     */
    @RequestMapping("/removeById")
    public String removeById(Integer id){
        userService.removeById(id);
        return "删除成功!";
    }

    /**
     * 根据id批量删除
     * @return  提示信息
     */
    @RequestMapping("/removeList")
    public String removeList(){
        List<Integer> userList = new ArrayList<>();
        userList.add(2);
        userList.add(3);
        userService.removeByIds(userList);
        return "数据删除成功！";
    }

    /**
     * 根据指定字段删除数据
     * @return 提示信息
     */
    @RequestMapping("/removeMap")
    public String removeMap(){
        //kay是字段名，value是字段值
        Map<String, Object> map = new HashMap<>();
        map.put("fraction", 88);
        userService.removeByMap(map);
        return "删除成功！";
    }

    /**
     * 分页查询
     * @return 当前页数据
     */
    @RequestMapping("/findAllPage")
    public IPage<User>  findAllPage(){
        //需要在Config配置类中配置分页插件
        IPage<User> page = new Page<>();
        page.setCurrent(1);     //当前页
        page.setSize(3);        //每页条数
        page = userService.page(page);

        long current = page.getCurrent(); // 当前页
        long pages = page.getPages();// 总页数
        long total = page.getTotal();// 总记录数
        long size = page.getSize();// 每页记录数

        System.out.println("当前页：" + current);
        System.out.println("总页数：" + pages);
        System.out.println("总记录数：" + total);
        System.out.println("每页记录数：" + size);

        return page;
    }

    /**
     * mybatis-plue条件构造器
     * @return  查询数据
     */
    @RequestMapping("/findByFractionGt80")
    public List<User> findByFractionGt80(){
        //定义条件构造器
        QueryWrapper<User> qw = new QueryWrapper<>();
        qw.lambda().gt(User::getFraction, 80);
        List<User> userList = userService.list(qw);
        return userList;
    }

    /**
     * 自定义SQL   查询大于该分数的学生
     * @param fraction  分数
     * @return
     */
    @RequestMapping("/selectUserFraction")
    public List<User> selectUserFraction(Integer fraction){
        List<User> userList = userService.selectUserFraction(fraction);
        return userList;
    }

}
