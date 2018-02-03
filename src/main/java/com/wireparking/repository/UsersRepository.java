package com.wireparking.repository;

import com.wireparking.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsersRepository  extends JpaRepository<Users,Integer>{
}
