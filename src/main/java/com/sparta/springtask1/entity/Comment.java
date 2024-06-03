package com.sparta.springtask1.entity;

import com.sparta.springtask1.dto.CommentRequestDto;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@Table(name = "comment")
@NoArgsConstructor
public class Comment extends Timestamped {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "detail", nullable = false)
    private String detail;

    @Column(name = "user_id", nullable = false)
    private String user_id;

    @ManyToOne
    @JoinColumn(name = "schedule_id")
    private Schedule schedule;

    public Comment(Schedule schedule, CommentRequestDto requestDto) {
        this.detail = requestDto.getDetail();
        this.user_id = requestDto.getUserId();
        this.schedule = schedule;
    }

    public void update(CommentRequestDto requestDto) {
        this.detail = requestDto.getDetail();
    }
}
