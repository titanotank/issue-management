package com.tuncays.issuemanagement.service.impl;

import com.tuncays.issuemanagement.entity.User;
import com.tuncays.issuemanagement.repository.UserRepository;
import com.tuncays.issuemanagement.service.UserService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User save(User user) {

        if(user.getEmail() == null){
            throw new IllegalArgumentException("User e-mail can not be null!");
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
    public User getUserName(String username) {
        return userRepository.findByUsername(username);
    }
}
