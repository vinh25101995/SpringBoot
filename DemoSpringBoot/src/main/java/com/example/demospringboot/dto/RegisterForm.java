package com.example.demospringboot.dto;

import com.example.demospringboot.entity.User;
import lombok.Data;
import org.springframework.security.crypto.password.PasswordEncoder;

@Data
public class RegisterForm {
    private String username;

    private String fullname;

    private String password;

    private String street;

    private String city;

    private String state;

    private String zip;

    private String phone;

    public User toUser(PasswordEncoder passwordEncoder){
        return new User(username,passwordEncoder.encode(password), fullname, street,city,state,zip, phone);
    }
}
