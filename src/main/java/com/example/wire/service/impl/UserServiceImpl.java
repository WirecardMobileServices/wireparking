package com.example.wire.service.impl;

import com.example.wire.dao.repository.UserRepository;
import com.example.wire.domain.User;
import com.example.wire.service.BaseService;
import com.example.wire.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;


@Service("userService")
@Transactional
public class UserServiceImpl extends BaseServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;


    @Override
    protected UserRepository getRepository() {
        return userRepository;
    }
}
