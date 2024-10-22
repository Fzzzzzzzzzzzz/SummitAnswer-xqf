package com.xqf.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xqf.domain.User;
import com.xqf.service.UserService;
import com.xqf.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* @author 86199
* @description 针对表【user】的数据库操作Service实现
* @createDate 2023-03-16 14:02:35
*/
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User>
    implements UserService{

    @Autowired
    private UserMapper userMapper;

    @Override
    public PageInfo queryUserLists(Integer pageStart, Integer pageSize) {
        PageHelper.startPage(pageStart,pageSize);
        List<User> userLists = userMapper.selectList(null);
        PageInfo<User> pageInfo = new PageInfo<>(userLists);
        return pageInfo;
    }
}




