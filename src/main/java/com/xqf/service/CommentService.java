package com.xqf.service;

import com.xqf.domain.Comment;
import com.baomidou.mybatisplus.extension.service.IService;
import com.xqf.domain.common.Result;

import java.util.List;

/**
* @author 86199
* @description 针对表【comment】的数据库操作Service
* @createDate 2023-03-16 14:02:35
*/
public interface CommentService extends IService<Comment> {

    List<Comment> getCommentByMovieId(Integer movieId);

    Result likeComment(Integer commentId);
}
