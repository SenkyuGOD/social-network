package com.senkyu.socialnetwork.user.dto;

import com.senkyu.socialnetwork.user.model.User;
import jakarta.validation.constraints.Email;

/**
 * DTO for {@link User}
 */
public record UserDto(Long id, String username, @Email String email) {
}