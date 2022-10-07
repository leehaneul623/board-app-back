package com.mysite.board.Dto;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity //DB 테이블 의미
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String title;

    @Column(columnDefinition = "TEXT")
    private String content;
    private LocalDateTime regDate;
    private LocalDateTime updateDate;

    @ManyToOne
    private User member;

}
