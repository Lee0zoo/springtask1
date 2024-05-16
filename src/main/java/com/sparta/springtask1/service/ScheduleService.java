package com.sparta.springtask1.service;

import com.sparta.springtask1.dto.ScheduleRequestDto;
import com.sparta.springtask1.dto.ScheduleResponseDto;
import com.sparta.springtask1.entity.Schedule;
import com.sparta.springtask1.repository.ScheduleRepository;
import jakarta.transaction.Transactional;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ScheduleService {

    private final ScheduleRepository scheduleRepository;

    public ScheduleService(ScheduleRepository scheduleRepository) {
        this.scheduleRepository = scheduleRepository;
    }

    public ScheduleResponseDto createSchedule(ScheduleRequestDto requestDto) {
        // RequestDto -> Entity
        Schedule schedule = new Schedule(requestDto);

        // DB 저장
        Schedule saveSchedule = scheduleRepository.save(schedule);

        // Entity -> ResponseDto
        ScheduleResponseDto scheduleResponseDto = new ScheduleResponseDto(schedule);

        return scheduleResponseDto;
    }

    public List<ScheduleResponseDto> getAllSchedules() {
        // DB 조회
        return scheduleRepository.findAllByOrderByModifiedAtDesc().stream().map(ScheduleResponseDto::new).toList();
    }

    public ScheduleResponseDto getSchedule(Long id) {
        // 해당 스케줄이 DB에 존재하는지 확인
        Schedule schedule = findSchedule(id);

        // Schedule 조회
        return new ScheduleResponseDto(schedule);
    }

    @Transactional
    public Long updateSchedule(Long id, ScheduleRequestDto requestDto) {
        // 해당 스케줄이 DB에 존재하는지 확인
        Schedule schedule = findSchedule(id);

        // 비밀번호 일치여부 확인
        if(schedule.getPassword().equals(requestDto.getPassword())) {
            // memo 내용 수정
            schedule.update(requestDto);
            return id;
        } else {
            throw new IllegalArgumentException("잘못된 비밀번호입니다.");
        }
    }

    public Long deleteSchedule(Long id, ScheduleRequestDto requestDto) {
        // 해당 스케줄이 DB에 존재하는지 확인
        Schedule schedule = findSchedule(id);

        // 비밀번호 일치여부 확인
        if(schedule.getPassword().equals(requestDto.getPassword())) {
            // memo 삭제
            scheduleRepository.delete(schedule);
            return id;
        } else {
            throw new IllegalArgumentException("잘못된 비밀번호입니다.");
        }
    }

    private Schedule findSchedule(Long id) {
        return scheduleRepository.findById(id).orElseThrow(() ->
                new IllegalArgumentException("Schedule not found"));
    }
}
