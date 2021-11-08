package com.emart2.redirect.auth.api.resolver;

import com.emart2.redirect.auth.entity.UserImpl;
import org.springframework.core.MethodParameter;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

@Component
public class LoginRequiredResolver implements HandlerMethodArgumentResolver {

    private final UserExtractor userExtractor;

    public LoginRequiredResolver(UserExtractor userExtractor){
        this.userExtractor = userExtractor;
    }

    @Override
    public boolean supportsParameter(MethodParameter parameter) {
        return UserImpl.class.isAssignableFrom(parameter.getParameterType()) &&
                parameter.hasParameterAnnotation(LoginRequired.class);
    }

    @Override
    public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer, NativeWebRequest webRequest, WebDataBinderFactory binderFactory) throws Exception {
        return userExtractor.getUser(webRequest);
    }
}
