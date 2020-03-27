package com.htnova.security.service;

import com.htnova.common.constant.ResultStatus;
import com.htnova.common.exception.ServiceException;
import com.htnova.security.entity.UserDetail;
import com.htnova.system.manage.entity.User;
import com.htnova.system.manage.service.UserService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Objects;

@Service
public class AuthUserDetailService implements UserDetailsService {

    @Resource
    private UserService userService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userService.getByUsername(username);
        if(Objects.isNull(user)) {
            throw new ServiceException(ResultStatus.USER_NOT_EXIST);
        }
        return UserDetail.createByUser(user);
    }
}