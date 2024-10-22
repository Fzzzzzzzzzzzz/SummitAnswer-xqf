package com.xqf.controller;


import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xqf.domain.User;
import com.xqf.domain.common.Result;
import com.xqf.service.impl.UserServiceImpl;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RequestMapping("user")
@RestController
public class SysUserController {


    @Resource
    private UserServiceImpl userService;

    @GetMapping("/userlist/{pageStart}/{pageSize}")
    public Result getUserList(@PathVariable("pageStart") Integer pageStart,@PathVariable("pageSize") Integer pageSize){


        PageInfo pageInfo = userService.queryUserLists(pageStart, pageSize);

        return Result.success(pageInfo);

    }
    @GetMapping("{id}")
    public Result test(@PathVariable("id") Integer id){
        return Result.success(id+"dddddd");
    }


}
