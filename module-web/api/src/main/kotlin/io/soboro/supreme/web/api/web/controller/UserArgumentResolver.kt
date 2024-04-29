package io.soboro.supreme.web.api.web.controller

import io.soboro.supreme.core.application.AuthService
import io.soboro.supreme.core.model.user.entity.User
import io.soboro.supreme.web.api.support.annotation.Login
import org.springframework.core.MethodParameter
import org.springframework.stereotype.Component
import org.springframework.web.bind.support.WebDataBinderFactory
import org.springframework.web.context.request.NativeWebRequest
import org.springframework.web.method.support.HandlerMethodArgumentResolver
import org.springframework.web.method.support.ModelAndViewContainer

@Component
class UserArgumentResolver(private val authService: AuthService) : HandlerMethodArgumentResolver {

    override fun supportsParameter(parameter: MethodParameter): Boolean {
        return parameter.getParameterAnnotation(Login::class.java) != null &&
            parameter.parameterType == User::class.java
    }

    override fun resolveArgument(
        parameter: MethodParameter,
        mavContainer: ModelAndViewContainer?,
        webRequest: NativeWebRequest,
        binderFactory: WebDataBinderFactory?,
    ): User? {
        val token = webRequest.getHeader("Authorization")?.substring("Bearer ".length)
        return token?.let { authService.getUserFromToken(it) }
    }
}
