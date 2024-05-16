package com.sparta.springtask1.repository;

import com.sparta.springtask1.entity.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

@Component
public interface ScheduleRepository extends JpaRepository<Schedule, Long> {
}
