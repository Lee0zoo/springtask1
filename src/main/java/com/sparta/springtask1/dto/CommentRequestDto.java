package com.sparta.springtask1.dto;

import java.time.LocalDateTime;

public class CommentRequestDto {
    private Long id;
    private String comment;
    private String userId;
    private Long scheduleId;
    private LocalDateTime createAt;
}
