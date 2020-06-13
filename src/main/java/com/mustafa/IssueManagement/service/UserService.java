package com.mustafa.IssueManagement.service;


import com.mustafa.IssueManagement.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface UserService {

    User save(User user);
    User getById(Long id);
    Page<User> getAllPageable(Pageable pageable);
    Boolean delete(User user);
    User getByUserName(String userName);
}
