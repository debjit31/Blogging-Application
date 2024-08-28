package com.ecom.app.repository;

import com.ecom.app.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {

    User findByUserName(String username);
}
