package com.mysite.board.Dto;

import com.mysite.board.Entity.Answer;
import com.mysite.board.Entity.Question;
import lombok.*;

import javax.persistence.CascadeType;
import javax.persistence.OneToMany;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class QuestionDto {
    private Integer id;
    private String title;
    private String content;
    private LocalDate regDate;
    private LocalDateTime updateDate;
    private String category;
    private Integer memberId;


    private List<AnswerDto> answerList;

    public QuestionDto(Question question) {
        this.id = question.getId();
        this.title = question.getTitle();
        this.content = question.getContent();
        this.regDate = question.getRegDate();
        this.updateDate = question.getUpdateDate();
        this.category = question.getCategory();
        this.memberId = question.getUser().getId();
        this.answerList = new ArrayList<>();
        question.getAnswerList().stream()
                .forEach(answer -> {
                    AnswerDto answerDto = AnswerDto.builder()
                            .id(answer.getId())
                            .nickname(answer.getNickname())
                            .content(answer.getContent())
                            .regDate(answer.getRegDate())
                            .build();
                    this.answerList.add(answerDto);
                });

    }
}
