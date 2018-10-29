package com.tree.www.minimvc.annotation;

import java.lang.annotation.*;

/**
 * Created by pysh on 2018/10/24.
 */
@Documented
@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface RequestMapping {
    String value();
}
