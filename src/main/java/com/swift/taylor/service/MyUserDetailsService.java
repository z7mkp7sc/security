package com.swift.taylor.service;

import com.swift.taylor.domain.Role;
import com.swift.taylor.domain.User;
import com.swift.taylor.mapper.RoleMapper;
import com.swift.taylor.mapper.UserMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @description: 继承UserDetailsService, 自定义用户管理
 * @author: eewjnun
 * @date: Created in 2019/12/26 16:06
 * @version: v1
 * @modified By:
 */
@Service
@Slf4j
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    private UserMapper userMapper;
    @Autowired
    private RoleMapper roleMapper;

    /*获取数据库中的用户信息,
     *并返回给security框架(继承了WebSecurityConfigurerAdapter的自定义核心配置类SecurityConfig)做下一步验证
     */
    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        //查数据库获取用户信息(用户信息+权限点 测试账号密码123456)
        User user = userMapper.loadUserByUsername(userName);
        if (null != user) {
            List<Role> roles = roleMapper.getRolesByUserId(user.getId());
            user.setAuthorities(roles);
        }

        return user;
    }


}
