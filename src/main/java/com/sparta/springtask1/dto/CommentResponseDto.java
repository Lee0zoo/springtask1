package com.sparta.springtask1.dto;

import com.sparta.springtask1.entity.Comment;
import lombok.Getter;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
public class CommentResponseDto {
    private String detail;
    private LocalDateTime createAt;

    public CommentResponseDto(Comment comment) {
        this.detail = comment.getDetail();
        this.createAt = LocalDateTime.now();
    }
}
