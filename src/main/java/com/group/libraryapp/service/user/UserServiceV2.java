package com.group.libraryapp.service.user;

import com.group.libraryapp.domain.User;
import com.group.libraryapp.repository.user.UserRepository;
import com.group.libraryapp.dto.User.request.UserCreateRequest;
import com.group.libraryapp.dto.User.request.UserUpdateRequest;
import com.group.libraryapp.dto.User.response.UserResponse;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceV2 {
    private final UserRepository userRepository;

    public UserServiceV2(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void saveUser(UserCreateRequest request){
        userRepository.save(new User(request.getName(),request.getAge()));
    }// INSERT SQL 이 자동으로 날라감.

    public List<UserResponse> getUser(){
        return userRepository.findAll().stream()
                .map(UserResponse::new )
                .collect(Collectors.toList());
    }

    public void updateUser(UserUpdateRequest request){
       User user =  userRepository.findById(request.getId())
                .orElseThrow(IllegalArgumentException::new);

       user.updateName(request.getName());
       userRepository.save(user);
    }
}
