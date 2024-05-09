package com.group.libraryapp.service.user;

import com.group.libraryapp.dto.User.request.UserCreateRequest;
import com.group.libraryapp.dto.User.request.UserUpdateRequest;
import com.group.libraryapp.dto.User.response.UserResponse;
import com.group.libraryapp.repository.user.UserRepository;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class UserService {

    private final UserRepository userRepository;

    public UserService(JdbcTemplate jdbcTemplate) {
        userRepository  = new UserRepository(jdbcTemplate);
    }

    public void saveUser(UserCreateRequest request){
        userRepository.saveUser(request.getName(),request.getAge());

    }

    public List<UserResponse> getUsers(){
        return userRepository.getUsers();
    }

    public void updateUser(UserUpdateRequest request){

        if (userRepository.isUserNotExist(request.getId())){
            throw new IllegalArgumentException();
        }
        userRepository.updateUserName(request.getName(),request.getId());

    }

    public void deleteUser(String name){

        if (userRepository.isUserNotExist(name)){
            throw new IllegalArgumentException();
        }
        userRepository.deleteUser(name);
    }
}
