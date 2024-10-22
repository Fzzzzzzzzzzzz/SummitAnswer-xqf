package com.xqf.controller;


import com.xqf.domain.SysMenu;
import com.xqf.domain.common.Result;
import com.xqf.mapper.SysMenuMapper;
import com.xqf.service.impl.SysMenuServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RequestMapping("/menu")
@RestController
public class SysMenuController {

    @Autowired
    private SysMenuServiceImpl sysMenuService;
    @Autowired
    private SysMenuMapper sysMenuMapper;

    @GetMapping("getMenuTreeBuildData")
    public Result getMenuTreeBuildData(){
        List<SysMenu> list = sysMenuService.getList();
        return Result.success(sysMenuService.buildTreeList(list,0));


    }

    /**
     *此方法使用sql只能得出二级菜单
     */
    @GetMapping("getMenuTreeBuildData2")
    public Result getMenuTreeBuildData2(){
        return Result.success(sysMenuMapper.getMenuTreeBuildData2());
    }
}
