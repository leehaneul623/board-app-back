package com.mysite.board.Service;

import com.mysite.board.Entity.Question;
import com.mysite.board.Entity.User;
import com.mysite.board.Form.QuestionForm;
import com.mysite.board.Repository.QuestionRepository;
import com.mysite.board.Repository.UserRepository;
import com.mysite.board.Dto.QuestionDto;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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
    public List<QuestionDto> findAll() {
        List<Question> questions = this.questionRepository.findAll();

        return questions.stream()
                .map(question -> {
                    QuestionDto questionDto = new QuestionDto(question);
                    return questionDto;
                })
                .collect(Collectors.toList());
    }

    public List<QuestionDto> findCategory(String category) {
        List<QuestionDto> questionList = questionRepository.findByCategory(category).orElseGet(null);
        return questionList;
    }

    public List<QuestionDto> questionSearchList(String searchKeyword){
        List<QuestionDto> questions = questionRepository.findByTitleContaining(searchKeyword);
        return questions;
    }


    public QuestionDto getQuestionDto(Integer id) {
        Question question = this.questionRepository.findById(id).orElseThrow();
        QuestionDto questionDto = new QuestionDto(question);
        return questionDto;
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
