package com.group.libraryapp.controller.user;

import com.group.libraryapp.dto.User.request.UserCreateRequest;
import com.group.libraryapp.dto.User.request.UserUpdateRequest;
import com.group.libraryapp.dto.User.response.UserResponse;
import com.group.libraryapp.service.user.UserServiceV1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {
    @Autowired
    private UserServiceV1 userServiceV1;

    //    public UserController(UserService userService) {
//
//        this.userService = userService;
//    }

    @PostMapping("/user") //POST /user
    public void saveUser(@RequestBody UserCreateRequest request){
        userServiceV1.saveUser(request);
    }

    @GetMapping("/user")
    public List<UserResponse> getUsers(){
        return userServiceV1.getUsers();
    }

    @PutMapping("/user")
    public void updateUser(@RequestBody UserUpdateRequest request){

        userServiceV1.updateUser(request);

    }

    @DeleteMapping("/user")
    public void deleteUser(@RequestParam String name){

        userServiceV1.deleteUser(name);

    }


}
