package com.mysite.board.Dto;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class)
public class UserDto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(unique = true, nullable = false)
    private String memberId;

    @Column(unique = true, nullable = false)
    private String nickname;

    private String password;
    private String name;
    private LocalDateTime regDate;
    private LocalDateTime updateDate;

    @OneToMany(mappedBy = "userDto",cascade = CascadeType.REMOVE)
    private List<QuestionDto> questionDtoList;
}
