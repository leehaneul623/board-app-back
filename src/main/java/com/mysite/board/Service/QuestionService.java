package com.mysite.board.Service;

import com.mysite.board.Entity.Question;
import com.mysite.board.Form.QuestionForm;
import com.mysite.board.Repository.QuestionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class QuestionService {

    @Autowired
    private QuestionRepository questionRepository;

    public void write(Question question){
        questionRepository.save(question);
    }

    // 게시글 단건 가져오기
    public Question getQuestion(Integer id) {
        Optional<Question> question = this.questionRepository.findById(id);
        return question.orElse(null);
    }

    // 게시글 내용 수정
    public Question modify(Integer id, QuestionForm questionForm){
        Question questionTemp = getQuestion(id);

        questionTemp.setTitle(questionForm.getTitle());
        questionTemp.setContent(questionForm.getContent());

        questionRepository.save(questionTemp);

        return questionTemp;
    }

    public Question deleteById(Integer id) {
        Question question = getQuestion(id);

        questionRepository.deleteById(id);

        return question;
    }


}
