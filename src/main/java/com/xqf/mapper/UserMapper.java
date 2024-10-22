package com.xqf.mapper;

import com.xqf.domain.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
* @author 86199
* @description 针对表【user】的数据库操作Mapper
* @createDate 2023-03-16 14:02:35
* @Entity com.xqf.domain.User
*/
@Mapper
public interface UserMapper extends BaseMapper<User> {

    List<Map<String,Object>> getUsers(@Param("userName") String userName);
     List<User> getMonth2List(@Param("month2")String month2);
}




