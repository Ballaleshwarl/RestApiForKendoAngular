package com.springRest.demo1.services;

import com.springRest.demo1.dtos.LoginDto;
import com.springRest.demo1.dtos.UserDto;
import com.springRest.demo1.response.LoginMessage;

public interface UserService {
     String addUser(UserDto userDto) ;

    LoginMessage loginUser(LoginDto loginDto);
}
