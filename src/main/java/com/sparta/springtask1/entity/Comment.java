package com.sparta.springtask1.entity;

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

    @Column(nullable = false)
    private String comment;

    @Column(nullable = false)
    private String userId;

    @Column(nullable = false)
    private Long ScheduleId;

    @ManyToOne
    @JoinColumn(name = "scheduleId")
    private Schedule schedule;

}
