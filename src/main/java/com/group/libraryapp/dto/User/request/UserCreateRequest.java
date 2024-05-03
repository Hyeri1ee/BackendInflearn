package com.group.libraryapp.dto.User.request;

public class UserCreateRequest {

    private String name;
    private Integer age; // Integer = NULL 표현 가능

    public String getName() {
        return name;
    }

    public Integer getAge() {
        return age;
    }
}
