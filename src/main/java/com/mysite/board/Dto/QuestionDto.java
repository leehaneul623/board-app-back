package com.mysite.board.Dto;

import com.mysite.board.Entity.Question;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

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

    public QuestionDto(Question question) {
        this.id = question.getId();
        this.title = question.getTitle();
        this.content = question.getContent();
        this.regDate = question.getRegDate();
        this.updateDate = question.getUpdateDate();
        this.category = question.getCategory();
        this.memberId = question.getUser().getId();
    }
}
