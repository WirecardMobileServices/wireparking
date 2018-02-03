package com.wireparking.resource;

import com.wireparking.entity.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.wireparking.repository.UsersRepository;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UsersResource {

    @Autowired
    UsersRepository usersRepository;

    @GetMapping("all")
    public List<Users> getAll(){
      return  usersRepository.findAll();
    }

}
