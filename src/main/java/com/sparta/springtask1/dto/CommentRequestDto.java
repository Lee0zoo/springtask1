package com.sparta.springtask1.dto;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class CommentRequestDto {
    private String detail;
    private String userId;
    private Long scheduleId;
}
