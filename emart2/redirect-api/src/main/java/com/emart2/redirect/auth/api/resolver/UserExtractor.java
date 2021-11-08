package com.emart2.redirect.auth.api.resolver;

import com.emart2.redirect.auth.entity.UserImpl;
import com.emart2.redirect.auth.service.AuthService;
import com.emart2.redirect.common.security.service.JwtTokenResolver;
import com.emart2.redirect.user.entity.UserEntity;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.context.request.NativeWebRequest;

@Component
public class UserExtractor {

    private final JwtTokenResolver jwtTokenResolver;
    private final AuthService authService;


    public UserExtractor(JwtTokenResolver jwtTokenResolver, AuthService authService) {
        this.jwtTokenResolver = jwtTokenResolver;
        this.authService = authService;
    }

    public UserImpl getUser(NativeWebRequest req){
        String username = jwtTokenResolver.getUsername(req);
        if(!StringUtils.hasText(username)){
            return null;
        }
        UserEntity user = authService.getUserByUsername(username);

        return new UserImpl(user);
    }
}
