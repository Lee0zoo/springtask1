package com.sparta.springtask1.dto;

import com.sparta.springtask1.entity.Comment;
import lombok.Getter;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
public class CommentResponseDto {
    private Long id;
    private String comment;
    private String userId;
    private Long scheduleId;
    private LocalDateTime createAt;

    public CommentResponseDto(Comment comment) {
        this.id = comment.getId();
        this.comment = comment.getComment();
        this.userId = comment.getUserId();
        this.scheduleId = comment.getScheduleId();
        this.createAt = LocalDateTime.now();
    }
}
