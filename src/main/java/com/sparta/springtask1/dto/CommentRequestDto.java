package com.sparta.springtask1.dto;

import lombok.Getter;
import org.antlr.v4.runtime.misc.NotNull;

import java.time.LocalDateTime;

@Getter
public class CommentRequestDto {
    private String detail;
    private String userId;
}
