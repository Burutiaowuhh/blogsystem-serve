package com.mao.blogredissystem.core.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @Classname UserOperationAnnotation
 * @Date 2022/10/8 15:57
 * @Created by mao
 * @Description
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD, ElementType.TYPE})
public @interface UserOperationAnnotation {
}
