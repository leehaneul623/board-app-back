package com.mysite.board.Service;

import com.mysite.board.Entity.Answer;
import com.mysite.board.Entity.Question;
import com.mysite.board.Repository.AnswerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@RequiredArgsConstructor
@Service
public class AnswerService {
    private final AnswerRepository answerRepository;

    public void create(Question question, String nickName, String content){
        Answer answer = new Answer();
        answer.setNickname(nickName);
        answer.setContent(content);
        answer.setRegDate(LocalDateTime.now());
        answer.setQuestion(question);

        this.answerRepository.save(answer);
    }
}
