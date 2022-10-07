package com.mysite.board.Dto;


import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class)
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String memberId;
    private String password;
    private String name;
    private String nickName;
    private LocalDateTime regDate;
    private LocalDateTime updateDate;
    private Integer admin;

    @OneToMany(mappedBy = "member",cascade = CascadeType.REMOVE)
    private List<Question> questionList;
}
