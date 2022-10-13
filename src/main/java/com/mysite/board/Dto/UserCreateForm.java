package com.mysite.board.Dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserCreateForm {
    private String memberId;

    private String password;

    private String passwordConfirm;

    private String name;

    private String nickname;
}
