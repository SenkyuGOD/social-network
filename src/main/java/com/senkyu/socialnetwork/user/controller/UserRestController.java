package com.senkyu.socialnetwork.user.controller;

import com.senkyu.socialnetwork.user.dto.UserDto;
import com.senkyu.socialnetwork.user.service.UserService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PagedModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserRestController {

    private final UserService userService;

    public UserRestController(UserService userService) {
        this.userService = userService;
    }


    @GetMapping
    public PagedModel<UserDto> getAll(Pageable pageable) {
        Page<UserDto> userDtos = userService.getAll(pageable);
        return new PagedModel<>(userDtos);
    }
}

