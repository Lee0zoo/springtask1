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

    // 댓글 생성
    public List<CommentResponseDto> createComment(Long scheduleId, CommentRequestDto requestDto) {
        // 해당 일정이 있는지 확인
        Schedule schedule = scheduleService.findSchedule(scheduleId);
        // 댓글을 담을 List 생성
        List<Comment> commentList = new ArrayList<>();

        // 댓글 저장
        Comment comment = new Comment(schedule, requestDto);

        commentList.add(comment);

        commentRepository.saveAll(commentList);

        // 사용자에게 보여지는 댓글 목록 List 생성
        List<CommentResponseDto> responseDtoList = new ArrayList<>();

        for(Comment i : commentList) {
            responseDtoList.add(new CommentResponseDto(i));
        }

        // 사용자에게 보여지는 댓글 목록 List 반환
        return responseDtoList;
    }

    @Transactional
    public Long updateComment(Long scheduleId, Long id, CommentRequestDto requestDto) {

        // 해당 댓글이 있는지 확인
        Comment comment = findComment(id);

        // 해당 댓글의 아이디가 수정자가 입력한 아이디와 같은지 확인
        checkId(requestDto.getUserId(), comment.getUser_id());

        // 댓글 수정
        comment.update(requestDto);

        return id;
    }

    public Long deleteComment(Long scheduleId, Long id, CommentRequestDto requestDto) {

        // 해당 댓글이 있는지 확인
        Comment comment = findComment(id);

        // 해당 댓글의 아이디가 삭제하려는 사람이 입력한 아이디와 같은지 확인
        checkId(requestDto.getUserId(), comment.getUser_id());

        // 댓글 삭제
        commentRepository.delete(comment);

        return id;
    }

    private Comment findComment(Long id) {
        return commentRepository.findById(id).orElseThrow(() ->
                new IllegalArgumentException("해당 댓글을 찾을 수 없습니다."));
    }

    private void checkId(String id, String new_id) {
        if(!id.equals(new_id)) {
            throw new IllegalArgumentException("사용자의 아이디가 일치하지 않습니다.");
        }
    }
}
