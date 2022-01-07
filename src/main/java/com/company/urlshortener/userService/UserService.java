package com.company.urlshortener.userService;

import com.company.urlshortener.userService.dto.UserRegistrationDto;
import com.company.urlshortener.userService.model.User;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {

    User save(UserRegistrationDto registrationDto);
}
