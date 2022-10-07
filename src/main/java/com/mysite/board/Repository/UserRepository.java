package com.mysite.board.Repository;

import com.mysite.board.Dto.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
}
