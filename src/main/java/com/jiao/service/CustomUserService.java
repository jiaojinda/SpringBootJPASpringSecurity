package com.jiao.service;

import com.jiao.SysUserRepository;
import com.jiao.vo.SysUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

/**
 * Created by Administrator on 2018/2/26.
 */
public class CustomUserService implements UserDetailsService {
    @Autowired
    SysUserRepository userRepository;
    @Override
    public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {
        SysUser user = userRepository.findByUsername(name);
        if (user == null) {
            throw new UsernameNotFoundException("用户名不存在");
        }
        System.out.println("name:"+name);
        System.out.println("username:"+user.getUsername()+";password:"+user.getPassword());
        return user;
    }
}
