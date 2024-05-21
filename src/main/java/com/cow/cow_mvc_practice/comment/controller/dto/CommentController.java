package com.cow.cow_mvc_practice.comment.controller.dto;

import com.cow.cow_mvc_practice.comment.controller.dto.request.CommentDeleteRequest;
import com.cow.cow_mvc_practice.comment.controller.dto.request.CommentRequest;
import com.cow.cow_mvc_practice.comment.controller.dto.response.CommentResponse;
import com.cow.cow_mvc_practice.comment.controller.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/comment")
@RequiredArgsConstructor
public class CommentController {

    private final CommentService commentService;

    @PostMapping("/write")
    public CommentResponse create(@RequestBody CommentRequest commentRequest) {
        return commentService.create(commentRequest);
    }

    @DeleteMapping("/deleteIn")
    public boolean deleteComments(@RequestParam String name, @RequestParam String title, @RequestBody CommentDeleteRequest commentDeleteRequest) {
        return commentService.delete(name, title, commentDeleteRequest);
    }
}
