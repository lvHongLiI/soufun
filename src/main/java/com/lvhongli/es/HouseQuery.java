package com.lvhongli.es;

import java.lang.annotation.*;

@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface HouseQuery {

    String name();

    String type();
}
