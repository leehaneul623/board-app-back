package com.mysite.board.Service;

import com.mysite.board.Domain.User;
import com.mysite.board.Form.UserCreateForm;
import com.mysite.board.Repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    public void join(UserCreateForm userCreateForm) {
        User user = new User();
        user.setMemberId(userCreateForm.getMemberId());
        user.setPassword(userCreateForm.getPassword());
        user.setName(userCreateForm.getName());
        user.setNickName(userCreateForm.getNickname());
        user.setAdmin(1);
        user.setRegDate(LocalDateTime.now());
        user.setUpdateDate(LocalDateTime.now());
        userRepository.save(user);
    }

    public User login(User user) {
        Optional<User> opUser = userRepository.findByMemberId(user.getMemberId());
        if(opUser.isPresent()){
            User loginedUser = opUser.get();
            if(loginedUser.getPassword().equals(user.getPassword())){
                return loginedUser;
            }
                return null;
        }
        return null;
    }
}
