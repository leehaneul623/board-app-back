package com.mysite.board.Repository;

import com.mysite.board.Domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {
    Optional<User> findByMemberId(String memberId);
}
