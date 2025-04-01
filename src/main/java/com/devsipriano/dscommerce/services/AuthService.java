package com.devsipriano.dscommerce.services;

import com.devsipriano.dscommerce.entities.User;
import com.devsipriano.dscommerce.services.exceptions.ForbiddenException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class AuthService {

    @Autowired
    private UserService userService;

    public void validateSelfOrAdmin(Long userId) {
        User me = userService.authenticated();
        if ((!me.hasRole("ROLE_ADMIN")) && (!Objects.equals(me.getId(), userId))) {
            throw new ForbiddenException("Not allowed");
        }
    }

}
