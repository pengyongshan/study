package com.tree.www.minimvc.annotation;

import java.lang.annotation.*;

/**
 * Created by pysh on 2018/10/24.
 */
@Documented
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Qualifier {
    String value();
}
