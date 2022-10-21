package com.mysite.board.Service;

import com.mysite.board.Entity.Answer;
import com.mysite.board.Entity.Question;
import com.mysite.board.Repository.AnswerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class AnswerService {
    private final AnswerRepository answerRepository;

    public void create(Question question, String nickName, String content){
        Answer answer = new Answer();
        answer.setNickName(nickName);
        answer.setContent(content);

        this.answerRepository.save(answer);
    }
}
