package com.lvhongli.configure;

import com.lvhongli.security.LoginAuthFailHandler;
import com.lvhongli.security.LoginAuthSuccessHandler;
import com.lvhongli.security.LoginUrlEntryPoint;
import com.lvhongli.security.WebSecurityAuthenticationProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;

import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {


    @Autowired
    private WebSecurityAuthenticationProvider authenticationProvider;

    @Autowired
    private LoginUrlEntryPoint loginUrlEntryPoint;

    @Autowired
    private LoginAuthFailHandler loginAuthFailHandler;

    @Autowired
    private LoginAuthSuccessHandler loginAuthSuccessHandler;
    /**
     * http权限控制
     * @param http
     * @throws Exception
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/upload").permitAll()
                .antMatchers("/admin/user/login").permitAll()
                .antMatchers("/client/user/getAuthLoginQRCode").permitAll()
                .antMatchers("/client/user/authLogin").permitAll()
                .antMatchers("/client/user/login").permitAll()
                .antMatchers("/logout").permitAll()
                .antMatchers("/admin/**").hasRole("ADMIN")
                .antMatchers("/client/**").hasAnyRole("ADMIN","USER")
                .and()
                .formLogin()
                .loginProcessingUrl("/login")
                .failureHandler(loginAuthFailHandler)
                .successHandler(loginAuthSuccessHandler)
                .and()
                .logout()
                .logoutSuccessUrl("/logOut/page")
                .deleteCookies("JSESSIONID")
                .invalidateHttpSession(true)
                .and()
                .exceptionHandling()
                .authenticationEntryPoint(loginUrlEntryPoint)
                .accessDeniedPage("/403");

        http.csrf().disable();
        http.headers().frameOptions().sameOrigin();
    }



    @Override
    public void configure(WebSecurity web) {
        web.ignoring().mvcMatchers("/static/**").and();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth)  {
        auth.authenticationProvider(authenticationProvider).eraseCredentials(true);
    }


}
