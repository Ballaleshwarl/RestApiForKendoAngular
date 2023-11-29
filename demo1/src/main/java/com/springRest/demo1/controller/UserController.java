package com.springRest.demo1.controller;


import com.springRest.demo1.dtos.LoginDto;
import com.springRest.demo1.dtos.UserDto;
import com.springRest.demo1.response.LoginMessage;
import com.springRest.demo1.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping(path = "/save")
    public String saveUser(@RequestBody UserDto userDto){
        String id = userService.addUser(userDto);
        return id;
    }

    @PostMapping(path = "/login")
    public ResponseEntity<LoginMessage> loginUser(@RequestBody LoginDto loginDto){

        LoginMessage loginMessage = userService.loginUser(loginDto);
        return ResponseEntity.ok(loginMessage);

    }
}
