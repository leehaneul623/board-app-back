package com.mysite.board.Controller;

import com.mysite.board.Entity.Question;
import com.mysite.board.Entity.User;
import com.mysite.board.Form.QuestionForm;
import com.mysite.board.Repository.QuestionRepository;
import com.mysite.board.Repository.UserRepository;
import com.mysite.board.Service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.ui.Model;
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
    @GetMapping("/write")
    public String write(@RequestParam  String title, @RequestParam String content){

        this.questionService.write(title, content);

        return "작성완료";
    }

    // R 읽기 ==
    @GetMapping("/list")
    public List<Question> showList(){
        return questionService.findAll();
    }

    @GetMapping("/category")
    public List<Question> categoryList(String category){
        return questionService.findCategory(category);

    }

    @GetMapping("/search")
    public List<Question> search(@RequestParam("keyword") String searchKeyword ){
        List<Question> questions = questionService.questionSearchList(searchKeyword);

        return questions;
    }

    @GetMapping("/detail/{postId}")
    public Question getQuestion(@PathVariable Integer postId){
        Question question = questionService.getQuestion(postId);

        return question;
    }


    // U 수정 ==
    @PostMapping("/modify/{postId}")
    public String modify(@PathVariable Integer postId, @RequestBody QuestionForm questionForm){
        Question questionTemp = questionService.modify(postId, questionForm);

        return "수정 완료";
    }


    // D 삭제 ==
    @PostMapping("/delete/{postId}")
    public String delete(@PathVariable Integer postId){

        questionService.deleteById(postId);

        return "%d번 게시물이 삭제 되었습니다.".formatted(postId);
    }

}
