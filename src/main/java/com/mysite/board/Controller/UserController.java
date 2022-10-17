package com.mysite.board.Controller;

import com.mysite.board.Form.UserCreateForm;
import com.mysite.board.Service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api/v1/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/join")
    public String join(@RequestBody UserCreateForm userCreateForm) {
        System.out.println("nickname: " + userCreateForm.getNickname());
        userService.join(userCreateForm);

        return "user";
    }

    @PostMapping("/login")
    public UserCreateForm login(@RequestBody Map<String,String> user) throws Exception{
        UserCreateForm loginedUser = userService.login(user);

        return loginedUser;
    }
}
