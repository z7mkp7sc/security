package com.swift.taylor.config;

import com.swift.taylor.service.MyUserDetailsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.util.DigestUtils;

/**
 * @description: 基于web的security, 加入特定的web安全设置
 * @author: eewjnun
 * @date: Created in 2019/12/26 16:36
 * @version: v1
 * @modified By:
 */
@Configuration
@EnableWebSecurity
@Slf4j
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private MyUserDetailsService userService;

    //配置全局身份认证管理
    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {

        //校验用户
        auth.userDetailsService(userService).passwordEncoder(new PasswordEncoder() {
            //对密码进行加密
            @Override
            public String encode(CharSequence charSequence) {
//                log.info(charSequence.toString());
                return DigestUtils.md5DigestAsHex(charSequence.toString().getBytes());
            }

            //对密码进行判断匹配
            @Override
            public boolean matches(CharSequence charSequence, String s) {
                String encode = DigestUtils.md5DigestAsHex(charSequence.toString().getBytes());
                return s.equals(encode);
            }
        });

    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                //不需要权限认证的url
                .antMatchers("/", "/index", "/login", "/login-error", "/401", "/css/**", "/js/**").permitAll()
                //其余所有url都需要权限认证
                .anyRequest().authenticated()
                .and()
                //指定登录页url和失败页url
                .formLogin().loginPage("/login").failureUrl("/login-error")
                .and()
                //认证过的用户访问无权限资源时跳转的url
                .exceptionHandling().accessDeniedPage("/401");
        //退出登录成功后回到首页
        http.logout().logoutSuccessUrl("/");
    }


}
