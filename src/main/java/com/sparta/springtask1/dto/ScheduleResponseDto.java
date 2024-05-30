package com.sparta.springtask1.dto;

import com.sparta.springtask1.entity.Comment;
import com.sparta.springtask1.entity.Schedule;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Getter
public class ScheduleResponseDto {
    private Long id;
    private String name;
    private String title;
    private String contents;
    private List<CommentResponseDto> commentList;
    private LocalDateTime createAt;
    private LocalDateTime modifiedAt;

    public ScheduleResponseDto(Schedule schedule) {
        this.id = schedule.getId();
        this.name = schedule.getName();
        this.title = schedule.getTitle();
        this.contents = schedule.getContents();
        this.commentList = schedule.getCommentList().stream().map(CommentResponseDto::new).collect(Collectors.toList());
        this.createAt = schedule.getCreatedAt();
        this.modifiedAt = schedule.getModifiedAt();
    }
}
