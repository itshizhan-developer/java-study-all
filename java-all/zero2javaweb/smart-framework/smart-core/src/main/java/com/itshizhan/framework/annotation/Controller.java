package com.itshizhan.framework.annotation;

import java.lang.annotation.*;

/**
 * 控制器注解:
 * 作用在类上
 * 作用于运行时
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface Controller {
}
