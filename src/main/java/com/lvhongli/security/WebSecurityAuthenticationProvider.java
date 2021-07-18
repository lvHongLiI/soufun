package com.lvhongli.security;

import com.lvhongli.dao.RoleRepository;
import com.lvhongli.dao.UserRepository;
import com.lvhongli.model.Role;
import com.lvhongli.model.User;
import com.lvhongli.model.UserTypeEnum;
import org.apache.tomcat.util.security.MD5Encoder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationCredentialsNotFoundException;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.Md4PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;


@Component
public class WebSecurityAuthenticationProvider implements AuthenticationProvider {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    private BCryptPasswordEncoder passwordEncoder=new BCryptPasswordEncoder();

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String name = authentication.getName();
        String password = (String) authentication.getCredentials();
        User user = userRepository.findByUsernameAndType(name, UserTypeEnum.base);
        if (user==null){
            throw new AuthenticationCredentialsNotFoundException("用户名不存在");
        }
        if (!passwordEncoder.matches(password,user.getPassword())){
            throw new AuthenticationCredentialsNotFoundException("密码不正确");
        }
        List<Role> roles = roleRepository.findAllByUserId(user.getId());
        List<SimpleGrantedAuthority> authorities =roles.stream().map(v -> new SimpleGrantedAuthority("ROLE_" + v.getName())).collect(Collectors.toList());
        return new UsernamePasswordAuthenticationToken(user,password,authorities);
    }


    /**
     * 将支付宝用户转为Authentication
     * @param user
     * @return
     */
    public Authentication getAliPayAuthenticate(User user){
        List<Role> roles = roleRepository.findAllByUserId(user.getId());
        List<SimpleGrantedAuthority> authorities =roles.stream().map(v -> new SimpleGrantedAuthority("ROLE_" + v.getName())).collect(Collectors.toList());
        return new UsernamePasswordAuthenticationToken(user,user.getPassword(),authorities);
    }


    @Override
    public boolean supports(Class<?> aClass) {
        return true;
    }
}
