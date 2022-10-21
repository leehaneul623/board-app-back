package com.mysite.board.Controller;

import com.mysite.board.Entity.Question;
import com.mysite.board.Entity.User;
import com.mysite.board.Form.QuestionForm;
import com.mysite.board.Repository.QuestionRepository;
import com.mysite.board.Repository.UserRepository;
import com.mysite.board.Service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@RequestMapping("/question")
@RestController
public class QuestionController {
    @Autowired
    private QuestionRepository questionRepository;

    @Autowired
    private QuestionService questionService;

    @Autowired
    private UserRepository userRepository;

    // C 생성 ==
    @RequestMapping("/write")
    public String write(String title, String content){
        System.out.println(title);
        if(title == null || title.trim().length() == 0){
            return "제목을 입력해주세요.";
        }
        if(content == null || content.trim().length() == 0){
            return "내용을 입력해주세요.";
        }

        title = title.trim();
        content = content.trim();
        User user = userRepository.findById(1).get();

        Question question = new Question();
        question.setRegDate(LocalDate.now());
        question.setUpdateDate(LocalDateTime.now());
        question.setTitle(title);
        question.setContent(content);
        question.setUser(user);

        questionRepository.save(question);

        return "작성완료";
    }

    // R 읽기 ==
    @GetMapping("/list")
    public List<Question> showList(){
        return questionRepository.findAll();
    }

    @GetMapping("/detail/{postId}")
    public Question getQuestion(@PathVariable Integer postId){
        Question question = questionRepository.findById(postId).get();

        return question;
    }



    // U 수정 ==
    @PostMapping("/modify/{postId}")
    public String modify(@PathVariable Integer postId, @RequestBody QuestionForm questionForm){
        Question questionTemp = questionService.modify(postId, questionForm);

        return "question !! ";
    }


    // D 삭제 ==
    @PostMapping("/delete/{postId}")
    public String delete(@PathVariable Integer postId){

        questionService.deleteById(postId);

        return "%d번 게시물이 삭제 되었습니다.".formatted(postId);
    }
}
