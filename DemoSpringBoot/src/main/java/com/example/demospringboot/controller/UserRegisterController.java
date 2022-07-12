package com.example.demospringboot.controller;

import com.example.demospringboot.dto.RegisterForm;
import com.example.demospringboot.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/register")
public class UserRegisterController {
    private UserRepository userRepository;
    private PasswordEncoder passwordEncoder;

    public UserRegisterController(UserRepository userRepository,PasswordEncoder passwordEncoder){
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @GetMapping
    public String RegiterForm(){
        return "/registration";
    }

    @PostMapping
    public String processRegister(RegisterForm registerForm){
        userRepository.save(registerForm.toUser(passwordEncoder));
        return "redirect:/login";
    }

}
