package com.mysite.board.Service;

import com.mysite.board.Domain.Question;
import com.mysite.board.Repository.QuestionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@RequiredArgsConstructor
@Service
public class QuestionService {

    @Autowired
    private QuestionRepository questionRepository;

    public void write(Question question){
        questionRepository.save(question);
    }

    public void doWrite(String title, String content){
        Question question = new Question();
        question.setTitle(title);
        question.setContent(content);
        question.setRegDate(LocalDate.now());
        this.questionRepository.save(question);
    }
}
