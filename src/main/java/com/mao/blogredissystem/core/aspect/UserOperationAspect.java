package com.mao.blogredissystem.core.aspect;

import cn.hutool.core.util.StrUtil;
import com.mao.blogredissystem.entity.User;
import com.mao.blogredissystem.service.UserService;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * @Classname UserOperationAspect
 * @Date 2022/10/8 15:58
 * @Created by mao
 * @Description
 */
@Aspect
@Component
public class UserOperationAspect {

    @Autowired
    private UserService userService;

    @Around(value = "@annotation(com.mao.blogredissystem.core.annotations.UserOperationAnnotation)")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        Object[] args = joinPoint.getArgs();
        RequestAttributes ra = RequestContextHolder.getRequestAttributes();
        ServletRequestAttributes sra = (ServletRequestAttributes) ra;
        HttpServletRequest request = sra.getRequest();
        String token = request.getHeader("token");
        if (StrUtil.isBlank(token)) {
            throw new RuntimeException("无token");
        }
        for (int i = 0; i < args.length; i++) {
            Object arg = args[i];
            if (arg instanceof User) {
                User user = userService.getUserByToken(token);
                if (user == null) {
                    throw new RuntimeException("用户不存在");
                } else {
                    args[i] = user;
                }
                break;
            }
        }
        return joinPoint.proceed(args);
    }

}
