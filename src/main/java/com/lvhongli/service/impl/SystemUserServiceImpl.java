package com.lvhongli.service.impl;
import com.lvhongli.model.User;
import com.lvhongli.dao.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SystemUserServiceImpl  {

    @Autowired
    private UserRepository userRepository;

    public User loadUserByUsername(String s) {
        return userRepository.findByName(s);
    }

    public User selectById(Integer adminId) {
        Optional<User> optional = userRepository.findById(adminId);
        if (optional.isPresent()){
            return optional.get();
        }
        return null;
    }
}
