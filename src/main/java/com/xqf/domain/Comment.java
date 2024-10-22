package com.xqf.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import lombok.Data;

/**
 * 
 * @TableName comment
 */
@TableName(value ="comment")
@Data
public class Comment implements Serializable {
    /**
     * 自增评论表Id
     */
    @TableId(type = IdType.AUTO)
    private Integer commentId;

    /**
     * 电影Id
     */
    private Integer movieId;

    /**
     * 用户Id
     */
    private Integer userId;

    /**
     * 此评论父Id
     */
    private Integer parentId;

    /**
     * 评论内容
     */
    private String comment;

    /**
     * 评论时间
     */
    private Date commentTime;

    /**
     * 点赞书
     */
    private Integer liked;


    /**
     * 是否点赞
     */
    private Integer islike;


    @TableField(exist = false)
    private List<Comment> subList ;

    public List<Comment> getSubList() {
        return subList;
    }

    public void setSubList(List<Comment> subList) {
        this.subList = subList;
    }

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}