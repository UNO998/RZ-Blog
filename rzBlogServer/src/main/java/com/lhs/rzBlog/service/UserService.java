package com.lhs.rzBlog.service;

import com.lhs.rzBlog.bean.Role;
import com.lhs.rzBlog.bean.User;
import com.lhs.rzBlog.mapper.RoleMapper;
import com.lhs.rzBlog.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Author:  Haotao Lai (Eric)
 * Date:    2019-12-05
 * E-mail:  haotao.lai@gmail.com
 * Website: http://laihaotao.me
 */

@Service
@Transactional
public class UserService implements UserDetailsService {

    @Autowired
    UserMapper userMapper;

    @Autowired
    RoleMapper roleMapper;

    @Override
    public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {
        User user = userMapper.loadUserByName(name);
        if (user == null) {
            user = new User();
        }
        List<Role> roles = roleMapper.getRolesByUid(user.getId());
        user.setRoles(roles);
        return user;
    }
}
