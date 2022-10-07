package com.mysite.board.Service;

import com.mysite.board.Dto.Question;
import com.mysite.board.Repository.QuestionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class QuestionService {

    @Autowired
    private QuestionRepository questionRepository;

    public void write(Question question){
        questionRepository.save(question);
    }


}
