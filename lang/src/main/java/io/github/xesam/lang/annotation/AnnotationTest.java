package io.github.xesam.lang.annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Created by xe on 14-10-24.
 */


@Retention(RetentionPolicy.CLASS)
public @interface AnnotationTest {
    String name();
}


