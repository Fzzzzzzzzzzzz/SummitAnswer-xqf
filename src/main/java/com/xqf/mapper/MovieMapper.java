package com.xqf.mapper;

import com.xqf.domain.Movie;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
* @author 86199
* @description 针对表【movie】的数据库操作Mapper
* @createDate 2023-03-16 14:02:35
* @Entity com.xqf.domain.Movie
*/
@Mapper
public interface MovieMapper extends BaseMapper<Movie> {

}




