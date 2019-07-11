package com.example.landsale.repository;

import com.example.landsale.entit.User;
import com.example.landsale.repository.custom.UserCustom;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long>, UserCustom {
    User findByUsername(String userName);
}
