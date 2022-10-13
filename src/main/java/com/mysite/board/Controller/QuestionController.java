package com.mysite.board.Controller;

import com.mysite.board.Domain.Question;
import com.mysite.board.Domain.User;
import com.mysite.board.Repository.QuestionRepository;
import com.mysite.board.Repository.UserRepository;
import com.mysite.board.Service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Controller
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
    @ResponseBody
    public String write(String title, String content){
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
        question.setMember(user);

        questionRepository.save(question);

        return "%d번 게시물 생성이 완료 되었습니다.".formatted(question.getId());
    }

    // R 읽기 ==
    @GetMapping("/list")
    public List<Question> showList(){
        return questionRepository.findAll();
    }

    @GetMapping("/detail")
    public Question getQuestion(Integer id){
        Question question = questionRepository.findById(id).get();

        return question;
    }

    // U 수정 ==
    @RequestMapping("/modify")
    @ResponseBody
    public Question modify(Integer id, String title, String content){

        Question question = questionRepository.findById(id).get(); //조건에 맞는 데이터 가져오기
        if(title != null){
            question.setTitle(title);
        }
        if(content != null){
            question.setContent(content); // 불러온 데이터 수정
        }
        question.setUpdateDate(LocalDateTime.now());
        questionRepository.save(question); // 수정된 데이터 DB에 저장

        return question;
    }


    // D 삭제 ==
    @RequestMapping("/delete")
    @ResponseBody
    public String delete(Integer id){
        if(questionRepository.existsById(id) == false){
            return "%d번 게시물은 이미 삭제 되었거나 존재하지 않습니다.".formatted(id);
        }
        questionRepository.deleteById(id);

        return "%d번 게시물이 삭제 되었습니다.".formatted(id);
    }
}
