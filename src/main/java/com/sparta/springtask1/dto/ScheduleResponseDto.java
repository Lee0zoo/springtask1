package com.sparta.springtask1.dto;

import com.sparta.springtask1.entity.Schedule;
import lombok.Getter;

@Getter
public class ScheduleResponseDto {
    private Long id;
    private String name;
    private String title;
    private String contents;

    public ScheduleResponseDto(Schedule schedule) {
        this.id = schedule.getId();
        this.name = schedule.getName();
        this.title = schedule.getTitle();
        this.contents = schedule.getContents();
    }

    public ScheduleResponseDto(Long id, String name, String contents, String title) {
        this.id = id;
        this.name = name;
        this.contents = contents;
        this.title = title;
    }
}
