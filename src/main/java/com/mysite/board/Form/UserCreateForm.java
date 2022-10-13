package com.mysite.board.Form;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;

@Getter
@Setter
public class UserCreateForm {

    @Column(unique = true, nullable = false)
    private String memberId;

    @Column(unique = true, nullable = false)
    private String nickname;

    private String password;

    private String passwordConfirm;

    private String name;


}
