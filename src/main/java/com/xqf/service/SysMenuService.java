package com.xqf.service;

import com.xqf.domain.SysMenu;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
* @author 86199
* @description 针对表【sys_menu(菜单权限表)】的数据库操作Service
* @createDate 2023-03-15 21:57:37
*/
public interface SysMenuService extends IService<SysMenu> {

    List<SysMenu> getList();

    List<SysMenu> buildTreeList(List<SysMenu> list, int i);
}
