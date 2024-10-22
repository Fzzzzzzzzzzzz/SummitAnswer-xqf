package com.xqf.mapper;

import com.xqf.domain.SysMenu;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
* @author 86199
* @description 针对表【sys_menu(菜单权限表)】的数据库操作Mapper
* @createDate 2023-03-15 21:57:37
* @Entity com.xqf.domain.SysMenu
*/
@Mapper
public interface SysMenuMapper extends BaseMapper<SysMenu> {

    List<SysMenu> getMenuTreeBuildData2();
}




