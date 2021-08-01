package com.lvhongli.service.impl;
import com.lvhongli.configure.ResultMsg;
import com.lvhongli.model.User;
import com.lvhongli.dao.UserRepository;
import com.lvhongli.security.WebSecurityAuthenticationProvider;
import com.lvhongli.util.UserUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

@Service
@Slf4j
public class SystemUserServiceImpl  {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private WebSecurityAuthenticationProvider authenticationProvider;

    private BCryptPasswordEncoder encoder=new BCryptPasswordEncoder();

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
                if (field.getName().equals("password"))
                    entry.setValue(encoder.encode(entry.getValue()));
                field.setAccessible(true);
                field.set(user,entry.getValue());
            } catch (NoSuchFieldException | IllegalAccessException e) {
               log.error(e.getMessage());
                continue;
            }
        }
        userRepository.save(user);
      return  ResultMsg.success();
    }

    public ResultMsg sendCode(String phone) {
        User user = userRepository.findByPhoneNumber(phone);
        if (user==null){
            return ResultMsg.fail("该用户不存在，请注册后再登录");
        }
        //发送短信
        String code=null;
        return ResultMsg.success(code);
    }



    public void login(String phone, String code,HttpServletResponse response) throws IOException {
        User user = userRepository.findByPhoneNumber(phone);
        if (user==null){
            response.sendRedirect("/client/client/user/login?error=登录失败");
        }
        //校验code

        //生成getAliPayAuthenticate
        SecurityContextHolder.getContext().setAuthentication(authenticationProvider.getAliPayAuthenticate(user));
        response.sendRedirect("/index");
    }
}
