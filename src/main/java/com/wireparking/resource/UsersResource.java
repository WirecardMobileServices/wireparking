package com.wireparking.resource;

import com.wireparking.entity.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.wireparking.repository.UsersRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/users")
public class UsersResource {

    @Autowired
    UsersRepository usersRepository;

    @GetMapping("all")
    public List<Users> getAll() {
        return usersRepository.findAll();
    }


    @GetMapping(value = "/{fname}")
    public List<Users> getUsers(@PathVariable("fname") final String name){
        Optional<List<Users>> listOptional = usersRepository.findByfirstName(name);

        List<Users> users  = listOptional.orElse(new ArrayList<>());
        return users;
    }

    @GetMapping("id/{id}")
    public Users getUserById(@PathVariable("id") final Integer id) {
        return usersRepository.findOne(id);
    }

    @GetMapping("/update/{id}/{fname}")
    public Users update(@PathVariable("id") final Integer id, @PathVariable("fname") final String name) {

        Users users = getUserById(id);
        users.setFirstName(name);

        return usersRepository.save(users);
    }

    @PostMapping(value = "/load")
    public Users load(@RequestBody final Users users){
        return   usersRepository.save(users);
    }


}
