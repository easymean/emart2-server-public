package com.emart2.redirect.auth.api.resolver;

import com.emart2.redirect.auth.entity.AdminUserImpl;
import com.emart2.redirect.auth.service.AuthService;
import com.emart2.redirect.common.security.service.JwtTokenResolver;
import com.emart2.redirect.user.entity.UserEntity;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.context.request.NativeWebRequest;

@Component
public class AdminExtractor {

    private final JwtTokenResolver jwtTokenResolver;
    private final AuthService authService;

    public AdminExtractor(JwtTokenResolver jwtTokenResolver, AuthService authService) {
        this.jwtTokenResolver = jwtTokenResolver;
        this.authService = authService;
    }

    public AdminUserImpl getUser(NativeWebRequest req){
        String username = jwtTokenResolver.getUsername(req);
        if(!StringUtils.hasText(username)){
            return null;
        }

        UserEntity user = authService.getUserByUsername(username);
        String role = user.getRole();
        if(!StringUtils.hasText(role) || !role.equals("ADMIN")){
            return null;
        }
        return new AdminUserImpl(user);

    }

}
