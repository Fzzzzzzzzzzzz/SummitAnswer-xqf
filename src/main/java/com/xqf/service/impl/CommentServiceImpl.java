package com.xqf.service.impl;

import cn.hutool.core.util.BooleanUtil;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xqf.domain.Comment;
import com.xqf.domain.common.Result;
import com.xqf.service.CommentService;
import com.xqf.mapper.CommentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

/**
* @author 86199
* @description 针对表【comment】的数据库操作Service实现
* @createDate 2023-03-16 14:02:35
*/
@Service
public class CommentServiceImpl extends ServiceImpl<CommentMapper, Comment>
    implements CommentService{

    @Autowired
    private CommentMapper commentMapper;

    @Resource
    private StringRedisTemplate stringRedisTemplate;


    /**
     *点赞某个评论
     */
    @Override
    public Result likeComment(Integer commentId) {
        //1、获取登录用户
        //TODO
        Integer userId = 2002;//假设已经获取到了
        //2、判断某个用户是否已经点过赞
        String key ="comment:liked:"+commentId;
        Boolean member = stringRedisTemplate.opsForSet().isMember(key, userId.toString());

        if(BooleanUtil.isFalse(member)){
            //3、如果未点赞，可以点赞
            //3.1数据库点赞
            int i = commentMapper.likedCountUp(commentId);
            //3.2保存用户到Redis的set集合
            if(i!=0){
                stringRedisTemplate.opsForSet().add(key,userId.toString());
                return Result.fail("点赞成功");
            }
            else{
                return Result.fail("redis失败");
            }
        }else{

            //4.如果已经点赞，取消点赞

            //4.1数据库-1
            int i = commentMapper.likedCountUp(commentId);
            //4.2把用户从Redis set中移除
            stringRedisTemplate.opsForSet().remove(key,userId.toString());
            return Result.success("取消点赞成功！");
        }


    }



    @Override
    public List<Comment> getCommentByMovieId(Integer movieId) {
        List<Comment> commentAll = commentMapper.selectList(null);
        List<Comment> collect0 = commentAll.stream().filter(comment -> comment.getParentId() == 0).collect(Collectors.toList());
        List<Comment> collectRemain = commentAll.stream().filter(comment -> comment.getParentId() != 0).collect(Collectors.toList());

        for (Comment comment0:collect0) {
            List<Comment> commentList1 = new ArrayList<>();
            recursionFn(commentAll,comment0,commentList1);
            comment0.setSubList(commentList1);
        }
        return collect0;
    }




    /**
     * 递归列表
     *
     * @param list 分类表
     * @param t 子节点
     */
    private void recursionFn(List<Comment> list, Comment t,List<Comment> list2)
    {
        // 得到子节点列表
        List<Comment> childList = getChildList(list, t);
        //这里直接就添加进二级评论数组区
        list2.addAll(childList);
        for (Comment tChild : childList)
        {
            if (hasChild(list, tChild))
            {
                recursionFn(list, tChild,list2);
            }
        }
    }

    /**
     * 得到子节点列表
     */
    private List<Comment> getChildList(List<Comment> list, Comment t)
    {
        List<Comment> tlist = new ArrayList<Comment>();
        Iterator<Comment> it = list.iterator();
        while (it.hasNext())
        {
            Comment n = (Comment) it.next();
            if (n.getParentId().longValue() == t.getCommentId().longValue())
            {
                tlist.add(n);
            }
        }
        return tlist;
    }

    /**
     * 判断是否有子节点
     */
    private boolean hasChild(List<Comment> list, Comment t)
    {
        return getChildList(list, t).size() > 0;
    }

}




