package com.mysite.board.Domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity 
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String title;

    @Column(columnDefinition = "TEXT")
    private String content;
    private LocalDate regDate;
    private LocalDateTime updateDate;

    @ManyToOne
    private User member;

}
