package com.emart2.redirect.auth.api.resolver;

import com.emart2.redirect.auth.entity.AdminUserImpl;
import org.springframework.core.MethodParameter;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

@Component
public class AdminRequiredResolver implements HandlerMethodArgumentResolver {

    private final AdminExtractor adminExtractor;

    public AdminRequiredResolver(AdminExtractor adminExtractor){
        this.adminExtractor = adminExtractor;
    }

    @Override
    public boolean supportsParameter(MethodParameter parameter) {
        return AdminUserImpl.class.isAssignableFrom(parameter.getParameterType()) &&
                parameter.hasParameterAnnotation(AdminRequired.class);
    }

    @Override
    public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer, NativeWebRequest webRequest, WebDataBinderFactory binderFactory) throws Exception {
        return adminExtractor.getUser(webRequest);
    }
}
