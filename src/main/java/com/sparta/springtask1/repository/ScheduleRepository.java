package com.sparta.springtask1.repository;

import com.sparta.springtask1.dto.ScheduleRequestDto;
import com.sparta.springtask1.dto.ScheduleResponseDto;
import com.sparta.springtask1.entity.Schedule;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class ScheduleRepository {
    private final JdbcTemplate jdbcTemplate;

    public ScheduleRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public Schedule save(Schedule schedule) {
        KeyHolder keyHolder = new GeneratedKeyHolder(); // 기본 키를 반환받기 위한 객체

        String sql = "INSERT INTO memo (username, contents, title, password) VALUES (?, ?, ?, ?)";
        jdbcTemplate.update( con -> {
                    PreparedStatement preparedStatement = con.prepareStatement(sql,
                            Statement.RETURN_GENERATED_KEYS);

                    preparedStatement.setString(1, schedule.getName());
                    preparedStatement.setString(2, schedule.getContents());
                    preparedStatement.setString(3, schedule.getTitle());
                    preparedStatement.setString(4, schedule.getPassword());
                    return preparedStatement;
                },
                keyHolder);

        // DB Insert 후 받아온 기본키 확인
        Long id = keyHolder.getKey().longValue();
        schedule.setId(id);

        return schedule;
    }

    public List<ScheduleResponseDto> findAll() {
        String sql = "SELECT * FROM memo";

        return jdbcTemplate.query(sql, new RowMapper<ScheduleResponseDto>() {
            @Override
            public ScheduleResponseDto mapRow(ResultSet rs, int rowNum) throws SQLException {
                // SQL 의 결과로 받아온 Memo 데이터들을 MemoResponseDto 타입으로 변환해줄 메서드
                Long id = rs.getLong("id");
                String name = rs.getString("name");
                String contents = rs.getString("contents");
                String title = rs.getString("title");
                return new ScheduleResponseDto(id, name, contents, title);
            }
        });
    }

    public void update(Long id, ScheduleRequestDto requestDto) {
        String sql = "UPDATE memo SET name = ?, title = ?, contents = ? WHERE id = ?";
        jdbcTemplate.update(sql, requestDto.getName(), requestDto.getTitle(), requestDto.getContents(), id);
    }

    public void delete(Long id) {
        String sql = "DELETE FROM memo WHERE id = ?";
        jdbcTemplate.update(sql, id);
    }

    public Schedule findById(Long id) {
        // DB 조회
        String sql = "SELECT * FROM memo WHERE id = ?";

        return jdbcTemplate.query(sql, resultSet -> {
            if(resultSet.next()) {
                Schedule schedule = new Schedule();
                schedule.setName(resultSet.getString("name"));
                schedule.setTitle(resultSet.getString("title"));
                schedule.setPassword(resultSet.getString("password"));
                schedule.setContents(resultSet.getString("contents"));
                return schedule;
            } else {
                return null;
            }
        }, id);
    }
}
