package com.xqf.controller;


import com.xqf.domain.Comment;
import com.xqf.domain.common.Result;
import com.xqf.mapper.CommentMapper;
import com.xqf.service.impl.CommentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RequestMapping("/comment")
@RestController

public class SysCommentController {

    @Autowired
    private CommentServiceImpl commentService;

    @Autowired
    private CommentMapper commentMapper;

    /**
     *分页获取某个电影的评论（二级评论）
     */
    @GetMapping("getCommentTree")
    public Result getCommentTree(@RequestParam("movieId") Integer movieId){
        List<Comment> commentByMovieId = commentService.getCommentByMovieId(movieId);
        return Result.success(commentByMovieId);
    }
    /**
     * 尝试使用sql写二级评论
     *
     *
     * 测试结果：只能得到评论 评论了的电影的（parent=0）的子评论，无法得到子评论的子评论
     */
    @GetMapping("getCommentTree2")
    public Result getCommentTree2(@RequestParam("movieId") Integer movieId){
        return Result.success(commentMapper.getCommentTree2(movieId));
    }

    /**
     *
     * @description: 给某个电影的评论点赞
     * @return:
     * @author: xqf
     * @time: 2023/3/16 19:15
     *
     */
    @PostMapping("/like/{commentId}")
    public Result likeComment(@PathVariable("commentId") Integer commentId){
        return commentService.likeComment(commentId);
    }

    @PutMapping("/test")
    public Result likeComment(@RequestParam("ids") Integer arr[]){
        return Result.success(arr);
    }

}
