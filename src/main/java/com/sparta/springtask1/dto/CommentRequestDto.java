package com.sparta.springtask1.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;

@Getter
public class CommentRequestDto {
    @NotBlank(message = "내용을 입력해 주세요.")
    private String detail;
    @NotBlank(message = "일정의 ID를 입력해 주세요.")
    private String userId;
}
