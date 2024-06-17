package com.springboot.backend.controller;

import com.springboot.backend.entity.Comment;
import com.springboot.backend.service.CommentService;
import com.springboot.backend.common.R;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/comments")
public class CommentController {

    @Autowired
    private CommentService commentService;

    // 添加评论到菜谱
    @PostMapping
    public R<Comment> createComment(@RequestBody Comment comment) {

        return commentService.saveComment(comment);
    }

    // 获取菜谱的所有评论
    @GetMapping("/recipe/{recipeId}")
    public R<List<Comment>> getCommentsByRecipeId(@PathVariable Long recipeId) {
        return commentService.getCommentsByRecipeId(recipeId);
    }

    // 更新评论信息
    @PutMapping("/{id}")
    public R<Comment> updateComment(@PathVariable Long id, @RequestBody Comment comment) {
        return commentService.updateCommentById(id,comment);
    }

    // 删除评论
    @DeleteMapping("/{id}")
    public R<String> deleteComment(@PathVariable Long id) {
        return commentService.removeCommentById(id);
    }
}
