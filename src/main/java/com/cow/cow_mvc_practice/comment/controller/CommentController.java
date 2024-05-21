package com.cow.cow_mvc_practice.comment.controller;

import com.cow.cow_mvc_practice.comment.controller.dto.request.CommentRequest;
import com.cow.cow_mvc_practice.comment.controller.dto.request.UpdateCommentRequest;
import com.cow.cow_mvc_practice.comment.entity.Comment;
import com.cow.cow_mvc_practice.comment.service.CommentService;
import com.cow.cow_mvc_practice.member.entity.Member;
import lombok.RequiredArgsConstructor;
import org.hibernate.annotations.Comments;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.security.cert.Extension;
import java.util.List;

@RequiredArgsConstructor
@RestController
public class CommentController {

    private final CommentService commentService;

    @PostMapping("/api/comments")
    public ResponseEntity<Comment> Comment(@RequestBody CommentRequest request, Member member) {
        Comment savedComment = commentService.save(request, member.getId());

        return ResponseEntity.status(HttpStatus.CREATED)
                    .body(savedComment);
    }

    @GetMapping("/api/comments/{commentId}")
    public void findComment(@PathVariable long commentId) {
        Comment comment = commentService.findComment(commentId);
    }

    @PutMapping("/api/comments/{commentId}")
    public ResponseEntity<Comment> updateComment(@PathVariable long id, @RequestBody UpdateCommentRequest request) {
        Comment updatedComment = commentService.update(id, request);

        return ResponseEntity.ok()
                .body(updatedComment);
    }
}
