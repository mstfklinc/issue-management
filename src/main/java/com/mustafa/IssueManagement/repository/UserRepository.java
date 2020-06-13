package com.mustafa.IssueManagement.repository;


import com.mustafa.IssueManagement.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository extends JpaRepository<User, Long> {


    User findByUserName(String username);
}
