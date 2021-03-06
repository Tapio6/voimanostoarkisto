package com.example.arkisto.web;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;


@Configuration
@EnableWebSecurity

public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
        .authorizeRequests().antMatchers("/").permitAll()
        .and()
        .authorizeRequests().anyRequest().authenticated()
        .and()
      .formLogin()
          .defaultSuccessUrl("/tuloslista", true)
          .permitAll()
          .and()
      .logout()
          .permitAll();
    }
    
    //Käyttäjä: Admin, salasana: admin
    ////Käyttäjä: user, salasana: user
    
    @Bean
    @Override
    public UserDetailsService userDetailsService() {
        List<UserDetails> users = new ArrayList();

        PasswordEncoder passwordEncoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();

        UserDetails user = User
        		.withUsername("user")
        		.password(passwordEncoder.encode("user"))
        		.roles("USER")
        		.build();

        users.add(user);

        user = User
        		.withUsername("admin")
        		.password(passwordEncoder.encode("admin"))
        		.roles("USER", "ADMIN")
        		.build();

    	users.add(user);

        return new InMemoryUserDetailsManager(users);
    }
   
    
}
