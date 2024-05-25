package com.sparta.springtask1.dto;

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
}
