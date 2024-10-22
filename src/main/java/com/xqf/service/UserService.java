package com.xqf.service;

import com.github.pagehelper.PageInfo;
import com.xqf.domain.User;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
* @author 86199
* @description 针对表【user】的数据库操作Service
* @createDate 2023-03-16 14:02:35
*/
public interface UserService extends IService<User> {
        PageInfo queryUserLists(Integer pageStart, Integer pageSize);
}
