package com.mysite.board.Entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
public class Answer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(unique = true, nullable = false)
    private String nickName;

    private String memberId;
    private String content;
    private LocalDateTime regDate;

    @ManyToOne
    private Question question;

}
