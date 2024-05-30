package com.sparta.springtask1.dto;

import com.sparta.springtask1.entity.Comment;
import lombok.Getter;

import java.util.List;

@Getter
public class ScheduleRequestDto {
    private String name;
    private String title;
    private String password;
    private String contents;
}
