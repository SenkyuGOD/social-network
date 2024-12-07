package com.senkyu.socialnetwork.user.service.impl;

import com.senkyu.socialnetwork.user.dto.UserDto;
import com.senkyu.socialnetwork.user.dto.UserMapper;
import com.senkyu.socialnetwork.user.model.User;
import com.senkyu.socialnetwork.user.repository.UserRepository;
import com.senkyu.socialnetwork.user.service.UserService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    private final UserMapper userMapper;

    public UserServiceImpl(UserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    @Override
    public Page<UserDto> getAll(Pageable pageable) {
        Page<User> users = userRepository.findAll(pageable);
        return users.map(userMapper::toUserDto);
    }
}
