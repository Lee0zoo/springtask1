package com.sparta.springtask1.dto;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class CommentRequestDto {
    private Long id;
    private String comment;
    private String userId;
    private Long scheduleId;
    private LocalDateTime createAt;
}
