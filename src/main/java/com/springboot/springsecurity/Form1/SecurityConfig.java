package com.springboot.springsecurity.Form1;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    // Authentication


    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("any")
                .password("any")
                .roles("any")
                .and()

                .withUser("user")
                .password("user")
                .roles("user")
                .and()

                .withUser("admin")
                .password("admin")
                .roles("admin");


    }

    @Bean
    public PasswordEncoder getPasswordEncoder(){
        return NoOpPasswordEncoder.getInstance();
    }

    //Authorization

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                //pattern that can use to any API and mention the role
//                .antMatchers("/**").hasAnyRole()
//                .antMatchers("/**").hasRole("user")
                //.antMatchers("/**").hasRole("admin")
                //.and().formLogin();

        //higher request holders are in the top
//        .antMatchers("/admin").hasRole("admin")
//        .antMatchers("/user").hasRole("user")
//        .antMatchers("/").permitAll()
//        .and().formLogin();

        //allow to access the user thinhs to admin
        .antMatchers("/admin").hasRole("admin")
        .antMatchers("/user").hasAnyRole("admin", "user")
        .antMatchers("/").permitAll()
        .and().formLogin();

    }
}
