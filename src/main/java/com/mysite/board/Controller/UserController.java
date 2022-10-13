package com.mysite.board.Controller;

import com.mysite.board.Dto.UserCreateForm;
import com.mysite.board.Service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/join")
    public String getUser(@RequestBody UserCreateForm userCreateForm) {

        userService.join(userCreateForm);

        return "user";
    }

}
