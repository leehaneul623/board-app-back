package com.mysite.board.Controller;

import com.mysite.board.Entity.Question;
import com.mysite.board.Service.AnswerService;
import com.mysite.board.Service.QuestionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("/answer")
public class AnswerController {
    private final QuestionService questionService;
    private final AnswerService answerService;

    @PostMapping("/create/{id}")
    public String createAnswer(@PathVariable("id") Integer id, @RequestBody Map<String, String> answer){
        Question question = this.questionService.getQuestion(id);
        this.answerService.create(question, answer.get("nickName"), answer.get("content"));
        return "생성완료";
    }
}
