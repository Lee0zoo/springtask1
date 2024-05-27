package com.sparta.springtask1.service;

import com.sparta.springtask1.dto.CommentRequestDto;
import com.sparta.springtask1.dto.CommentResponseDto;
import com.sparta.springtask1.entity.Comment;
import com.sparta.springtask1.entity.Schedule;
import com.sparta.springtask1.repository.CommentRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CommentService {

    private final CommentRepository commentRepository;
    private final ScheduleService scheduleService;

    public List<CommentResponseDto> createComment(Long scheduleId, CommentRequestDto requestDto) {
        Schedule schedule = scheduleService.findSchedule(scheduleId);
        List<Comment> commentList = new ArrayList<>();

        Comment comment = new Comment(schedule, requestDto);
        commentList.add(comment);

        commentRepository.saveAll(commentList);

        List<CommentResponseDto> responseDtoList = new ArrayList<>();

        for(Comment i : commentList) {
            responseDtoList.add(new CommentResponseDto(i));
        }

        return responseDtoList;
    }

    @Transactional
    public Long updateComment(Long scheduleId, Long id, CommentRequestDto requestDto) {

        Comment comment = findComment(id);
        comment.update(requestDto);

        return id;
    }

    public Long deleteComment(Long scheduleId, Long id, CommentRequestDto requestDto) {

        Comment comment = findComment(id);
        commentRepository.delete(comment);

        return id;
    }

    private Comment findComment(Long id) {
        return commentRepository.findById(id).orElseThrow(() ->
                new IllegalArgumentException("해당 댓글을 찾을 수 없습니다."));
    }
}
