package com.lvhongli.service.impl;
import com.lvhongli.configure.ResultMsg;
import com.lvhongli.model.User;
import com.lvhongli.dao.UserRepository;
import com.lvhongli.util.UserUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Field;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

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

    public ResultMsg updateInfo(Map<String,String> map) {
        Set<Map.Entry<String, String>> entries = map.entrySet();
        User user = UserUtil.getUser();
        Class<? extends User> userClass = user.getClass();
        for (Map.Entry<String, String> entry : entries) {
            Field field = null;
            try {
                field = userClass.getDeclaredField(entry.getKey());
                field.set(user,entry.getValue());
                field.setAccessible(true);
            } catch (NoSuchFieldException | IllegalAccessException e) {
                e.printStackTrace();
                continue;
            }
        }
        userRepository.save(user);
      return  ResultMsg.success();
    }
}
