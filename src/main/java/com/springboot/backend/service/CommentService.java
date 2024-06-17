package com.springboot.backend.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.springboot.backend.common.R;
import com.springboot.backend.entity.Comment;

import java.util.List;

public interface CommentService extends IService<Comment> {
    public R<Comment> saveComment(Comment comment);

    public R<List<Comment>> getCommentsByRecipeId(Long recipeId);

    public R<Comment> updateCommentById(Long id,Comment comment);

    public R<String> removeCommentById(Long id);
}
