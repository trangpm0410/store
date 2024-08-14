package com.store.demo.config;

import com.store.demo.entity.Account;
import com.store.demo.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import java.util.NoSuchElementException;
import java.util.stream.Collector;
import java.util.stream.Collectors;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Autowired
    AccountService accountService;

    @Bean
    public PasswordEncoder myPasswordEncode(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    public UserDetailsService myUserDetailsService(PasswordEncoder pe){
        UserDetailsService us = username -> {
            try {
                Account user = accountService.findById(username);
                String password = pe.encode(user.getPassword());
                String[] roles = user.getAuthorities().stream()
                        .map(er -> er.getRole().getId())
                        .collect(Collectors.toList()).toArray(new String[0]);
                return User.withUsername(username).password(password).roles(roles).build();
            }catch (NoSuchElementException e){
                throw new UsernameNotFoundException(username + "not found!");
            }
        };
        return us;
    }

    @Bean
    public SecurityFilterChain mySecurityFilterChain(HttpSecurity httpSecurity) throws Exception{
        httpSecurity.csrf().disable();
        httpSecurity.authorizeRequests()
                .requestMatchers("/order/**").authenticated()
                .requestMatchers("/admin/**").hasAnyRole("STAF", "DIRE")
                .requestMatchers("/rest/authorities").hasRole("DIRE")
                .anyRequest().permitAll();
        httpSecurity.formLogin()
                .loginPage("/security/login/form")
                .loginProcessingUrl("/security/login")
                .defaultSuccessUrl("/security/login/success", false)
                .failureUrl("/security/login/error");
        httpSecurity.rememberMe()
                .tokenValiditySeconds(86400);
        httpSecurity.exceptionHandling()
                .accessDeniedPage("/security/unauthorized");
        httpSecurity.logout()
                .logoutUrl("/security/logout")
                .logoutSuccessUrl("/security/logout/success");
        return httpSecurity.build();
    }
}
