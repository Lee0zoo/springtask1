package com.sparta.springtask1.entity;

import com.sparta.springtask1.dto.ScheduleRequestDto;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Schedule {
    private Long id;
    private String title;
    private String password;
    private String name;
    private String contents;

    public Schedule(ScheduleRequestDto requestDto) {
        this.name = requestDto.getName();
        this.contents = requestDto.getContents();
    }

    public void update(ScheduleRequestDto requestDto) {
        this.name = requestDto.getName();
        this.contents = requestDto.getContents();
    }
}