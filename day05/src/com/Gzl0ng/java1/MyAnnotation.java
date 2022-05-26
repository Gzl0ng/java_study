package com.Gzl0ng.java1;

import java.lang.annotation.*;

import static java.lang.annotation.ElementType.*;

/**
 *
 */
@Inherited
@Repeatable(MyAnnotations.class)
@Target({TYPE, FIELD, METHOD, PARAMETER, CONSTRUCTOR, LOCAL_VARIABLE,TYPE_PARAMETER,TYPE_USE})
@Retention(RetentionPolicy.RUNTIME)
public @interface MyAnnotation{

    String value() default "hello";
}
