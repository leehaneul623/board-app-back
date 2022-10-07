package com.mysite.board.Repository;

import com.mysite.board.Dto.Answer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AnswerRepository extends JpaRepository<Answer, Integer> {
}
