package com.company.urlshortener.userService.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class UserRegistrationDto {

    private String login;
    private String password;
    private String name;

    public UserRegistrationDto(String login, String password, String name) {
        super();
        this.login = login;
        this.password = password;
        this.name = name;
    }
}
