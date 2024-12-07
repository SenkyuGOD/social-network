package com.senkyu.socialnetwork.user.service;

import com.senkyu.socialnetwork.user.dto.UserDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface UserService {

    Page<UserDto> getAll(Pageable pageable);
}
