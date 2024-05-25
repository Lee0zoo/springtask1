package com.sparta.springtask1.service;

import com.sparta.springtask1.dto.CommentRequestDto;
import com.sparta.springtask1.dto.CommentResponseDto;
import com.sparta.springtask1.repository.CommentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CommentService {

    private final CommentRepository commentRepository;

    public CommentResponseDto createComment(CommentRequestDto requestDto) {
        return null;
    }
}
