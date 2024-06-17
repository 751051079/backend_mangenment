package com.springboot.backend.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.springboot.backend.common.R;
import com.springboot.backend.entity.Comment;
import com.springboot.backend.mapper.CommentMapper;
import com.springboot.backend.service.CommentService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CommentServiceImpl extends ServiceImpl<CommentMapper, Comment> implements CommentService {


    @Override
    @Transactional(rollbackFor = Exception.class)
    public R<Comment> saveComment(Comment comment) {
        save(comment);
        return R.success(comment,"保存成功！");
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public R<List<Comment>> getCommentsByRecipeId(Long recipeId) {
        List<Comment> comments = baseMapper.selectList(new QueryWrapper<Comment>().eq("recipe_id", recipeId));
        return R.success(comments,"查询评论成功！");
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public R<Comment> updateCommentById(Long id, Comment comment) {
        comment.setId(id);
        updateById(comment);
        return R.success(comment,"修改成功！");
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public R<String> removeCommentById(Long id) {
        removeById(id);
        return R.success("","删除成功！");
    }
}
