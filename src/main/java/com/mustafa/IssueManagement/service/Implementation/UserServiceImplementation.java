package com.mustafa.IssueManagement.service.Implementation;

import com.mustafa.IssueManagement.entity.User;
import com.mustafa.IssueManagement.repository.UserRepository;
import com.mustafa.IssueManagement.service.UserService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImplementation implements UserService {

    private final UserRepository userRepository;

    public UserServiceImplementation(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @Override
    public User save(User user) {

        if(user.getEmail() == null){
            throw new IllegalArgumentException("Username cannot be null!");
        }

        user = userRepository.save(user);
        return user;
    }

    @Override
    public User getById(Long id) {
        return userRepository.getOne(id);
    }

    @Override
    public Page<User> getAllPageable(Pageable pageable) {
        return userRepository.findAll(pageable);
    }

    @Override
    public Boolean delete(User user) {
        return null;
    }

    @Override
    public User getByUserName(String username) {
        return userRepository.findByUserName(username);
    }
}
