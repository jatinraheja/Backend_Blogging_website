package com.casestudy2.backendblogging.controller;

import com.casestudy2.backendblogging.Modal.Users;
import com.casestudy2.backendblogging.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserRepository usr;
    @GetMapping("/allusers")
    public List<Users> getAllItems()
    {
        return usr.findAll();
    }
//    @PostMapping(value= "/signup",consumes = "application.json")
//    public Users signup(@RequestBody Users user)
//    {
//        user.setActive(1);
//        user.setAuthentication("basic ");
//        usr.save(user);
//        return user;
//    }

}
