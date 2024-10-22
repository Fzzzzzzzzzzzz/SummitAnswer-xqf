package com.xqf.mapper;

import com.xqf.domain.Comment;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
* @author 86199
* @description 针对表【comment】的数据库操作Mapper
* @createDate 2023-03-16 14:02:35
* @Entity com.xqf.domain.Comment
*/
@Mapper
public interface CommentMapper extends BaseMapper<Comment> {
    //点赞数+1
    int likedCountUp(Integer commentId);
    int likedCountDown(Integer commentId);

//    List<Comment> test();


    List<Comment> getCommentTree2(Integer movieId);
}




