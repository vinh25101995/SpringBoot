package com.example.demospringboot.security;

import com.example.demospringboot.entity.User;
import com.example.demospringboot.repository.UserRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public PasswordEncoder passwordEncoder(){
        return  new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {
        return httpSecurity
                .authorizeRequests()
                    .antMatchers("/design", "/order").hasRole("USER")
                    .antMatchers("/","/**").permitAll()
                .anyRequest().authenticated()
                .and()
                    .formLogin()
                        .loginPage("/login")
                        .defaultSuccessUrl("/design")
                .and()
                .csrf().disable()
//                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
//                .and()
                .build();
    }

    @Bean
    public UserDetailsService userDetailsService(UserRepository userRepo) {
        return (username) -> {
            User user = userRepo.findByUsername(username);
            if (user != null) return user;
            throw new UsernameNotFoundException("User '" + username + "' not found");
        };
    }

}
