package com.mybatis.review.util;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 *<p> Description: 自定义注解 </p>
 *<p> Copyright: Copyright(c) 2018/12/19 </p>
 *<p> Company: 7qb </p>
 *
 *@author JinJiacheng
 *@Version 1.0 2018/12/19 16:21
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
public @interface Namespace {

    String value() default "";

}
