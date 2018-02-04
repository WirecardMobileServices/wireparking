package com.wireparking.repository;

import com.wireparking.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UsersRepository  extends JpaRepository<Users,Integer>{
   // Users findByfirstName(String name);
    Optional<List<Users>> findByfirstName(String name);
}
