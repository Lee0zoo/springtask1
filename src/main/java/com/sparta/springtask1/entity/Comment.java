package com.sparta.springtask1.entity;

import com.sparta.springtask1.dto.CommentRequestDto;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "comment")
@NoArgsConstructor
public class Comment extends Timestamped {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "detail", nullable = false)
    private String detail;

    @Column(name = "userId", nullable = false)
    private String userId;

    @ManyToOne
    @JoinColumn(name = "scheduleId")
    private Schedule schedule;

    public Comment(Schedule schedule, CommentRequestDto requestDto) {
        this.detail = requestDto.getDetail();
        this.userId = requestDto.getUserId();
        this.schedule = schedule;
    }

    public void update(CommentRequestDto requestDto) {
        this.detail = requestDto.getDetail();
    }
}
