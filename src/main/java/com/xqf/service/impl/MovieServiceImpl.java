package com.xqf.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xqf.domain.Movie;
import com.xqf.service.MovieService;
import com.xqf.mapper.MovieMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
* @author 86199
* @description 针对表【movie】的数据库操作Service实现
* @createDate 2023-03-16 14:02:35
*/
@Service
public class MovieServiceImpl extends ServiceImpl<MovieMapper, Movie>
    implements MovieService{
    @Autowired
    private MovieMapper mapper;
}




