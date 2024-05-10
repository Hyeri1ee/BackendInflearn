package com.group.libraryapp.service.user;

import com.group.libraryapp.dto.User.request.UserCreateRequest;
import com.group.libraryapp.dto.User.request.UserUpdateRequest;
import com.group.libraryapp.dto.User.response.UserResponse;
import com.group.libraryapp.repository.user.UserJdbcRepository;
import com.group.libraryapp.repository.user.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceV1 {

    private final UserJdbcRepository userJdbcRepository;

    public UserServiceV1(UserJdbcRepository userJdbcRepository) {
        this.userJdbcRepository = userJdbcRepository;
    }

    public void saveUser(UserCreateRequest request){
        userJdbcRepository.saveUser(request.getName(),request.getAge());

    }

    public List<UserResponse> getUsers(){
        return userJdbcRepository.getUsers();
    }

    public void updateUser(UserUpdateRequest request){

        if (userJdbcRepository.isUserNotExist(request.getId())){
            throw new IllegalArgumentException();
        }
        userJdbcRepository.updateUserName(request.getName(),request.getId());

    }

    public void deleteUser(String name){

        if (userJdbcRepository.isUserNotExist(name)){
            throw new IllegalArgumentException();
        }
        userJdbcRepository.deleteUser(name);
    }
}
