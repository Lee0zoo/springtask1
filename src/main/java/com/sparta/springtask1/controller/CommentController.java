package com.sparta.springtask1.controller;

import com.sparta.springtask1.dto.CommentRequestDto;
import com.sparta.springtask1.dto.CommentResponseDto;
import com.sparta.springtask1.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/comments")
public class CommentController {

    private final CommentService commentService;

    @PostMapping("/{scheduleId}")
    public List<CommentResponseDto> createComment(@PathVariable Long scheduleId, @RequestBody CommentRequestDto requestDto) {
        return commentService.createComment(scheduleId, requestDto);
    }

    @PutMapping("/{scheduleId}/{id}")
    public Long updateComment(@PathVariable Long scheduleId, @PathVariable Long id, @RequestBody CommentRequestDto requestDto) {
        return commentService.updateComment(scheduleId, id, requestDto);
    }

    @DeleteMapping("/{scheduleId}/{id}")
    public Long deleteComment(@PathVariable Long scheduleId, @PathVariable Long id, @RequestBody CommentRequestDto requestDto) {
        return commentService.deleteComment(scheduleId, id, requestDto);
    }
}
