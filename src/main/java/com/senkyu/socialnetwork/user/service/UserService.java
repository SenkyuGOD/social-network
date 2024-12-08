package com.senkyu.socialnetwork.user.service;

import com.fasterxml.jackson.databind.JsonNode;
import com.senkyu.socialnetwork.user.dto.UserDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.io.IOException;

public interface UserService {

    Page<UserDto> getAll(Pageable pageable);

    UserDto create(UserDto dto);

    UserDto update(Long id, UserDto dto);

    UserDto delete(Long id);

    UserDto patch(Long id, JsonNode patchNode) throws IOException;
}
