package com.example.ormi5projectteam4.repository;

import com.example.ormi5projectteam4.domain.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Integer> {

    List<User> findByEmail(String email);
}
