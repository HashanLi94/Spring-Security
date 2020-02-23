package com.springboot.springsecurity.Form1.restcontroller;

import org.apache.catalina.authenticator.SavedRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Res
{
    @GetMapping("/")
    public String all(){
        return "welcome all";
    }

    @GetMapping("/admin")
    public String admin(){
        return "welcome admin";
    }

    @GetMapping("/admin/user")
    public String adminUser(){
        return "welcome admin.. now you are in the user page..!!!";
    }

    @GetMapping("/admin/alll")
    public String adminAll(){
        return "welcome admin. now you are in the all";
    }

    @GetMapping("/user")
    public String user(){
        return "welcome user";
    }

    @GetMapping("/admin/all")
    public String userAll(){
        return "welcome user. now you are in the all";
    }


}
