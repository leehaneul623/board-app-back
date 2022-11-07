package com.mysite.board.Service;

import com.mysite.board.Entity.Question;
import com.mysite.board.Entity.User;
import com.mysite.board.Form.QuestionForm;
import com.mysite.board.Repository.QuestionRepository;
import com.mysite.board.Repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class QuestionService {

    @Autowired
    private QuestionRepository questionRepository;

    @Autowired
    private UserRepository userRepository;

    public void write(String title, String content, String category, String memberId) {
        User user = userRepository.findByMemberId(memberId).get();

        Question question = new Question();
        question.setTitle(title);
        question.setContent(content);
        question.setCategory(category);
        question.setRegDate(LocalDate.now());
        question.setUpdateDate(LocalDateTime.now());
        question.setUser(user);

        this.questionRepository.save(question);
    }

    // 게시글 리스트 조회
    public List<Question> findAll() {
        return this.questionRepository.findAll();
    }

    public List<Question> findCategory(String category) {
        List<Question> questionList = questionRepository.findByCategory(category).orElseGet(null);
        return questionList;
    }

    public List<Question> questionSearchList(String searchKeyword){
        List<Question> questions = questionRepository.findByTitleContaining(searchKeyword);
        return questions;
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
