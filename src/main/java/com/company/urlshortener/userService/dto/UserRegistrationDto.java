package com.company.urlshortener.userService.dto;

public class UserRegistrationDto {

    private String login;
    private String password;
    private String name;

    public UserRegistrationDto() {
    }

    public UserRegistrationDto(String login, String password, String name) {
        super();
        this.login = login;
        this.password = password;
        this.name = name;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
