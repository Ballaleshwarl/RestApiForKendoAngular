package com.springRest.demo1.services;

import com.springRest.demo1.dtos.LoginDto;
import com.springRest.demo1.dtos.UserDto;
import com.springRest.demo1.entities.User;
import com.springRest.demo1.repository.UserRepo;
import com.springRest.demo1.response.LoginMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements  UserService{

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private PasswordEncoder passwordEncoder;
    @Override
    public String addUser(UserDto userDto) {
        User user = new User(userDto.getUserId(),userDto.getName(),userDto.getEmail(),this.passwordEncoder.encode(userDto.getPassword()));
        userRepo.save(user);
        return user.getName();
    }

    @Override
    public LoginMessage loginUser(LoginDto loginDto) {

        String msg="";
        User user1 = userRepo.findByEmail(loginDto.getEmail());
        System.out.println(user1);
        if(user1 != null){
            String password = loginDto.getPassword();
            String encodedPassword = user1.getPassword();

            boolean isValid = passwordEncoder.matches(password,encodedPassword);

            if(isValid){
                Optional<User> user = userRepo.findOneByEmailAndPassword(loginDto.getEmail(),encodedPassword);
                if(user.isPresent()){
                    return new LoginMessage("Logged Successfully !",true);
                }else {
                    return new LoginMessage("Login Failed !",false);
                }
            }else {
                return new LoginMessage("Password mismatch",false);
            }
        }else{
            return new LoginMessage("invalid user",false);
        }

    }
}
