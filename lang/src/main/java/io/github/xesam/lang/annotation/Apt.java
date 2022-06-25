package io.github.xesam.lang.annotation;

import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.RoundEnvironment;
import javax.lang.model.element.TypeElement;
import java.util.Set;

/**
 * Created by xe xesamguo@gmail.com on 15-6-4.
 */
public class Apt {
    public static void main(String[] args) {
        AbstractProcessor abstractProcessor = new AbstractProcessor() {
            @Override
            public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnv) {
                return false;
            }
        };

    }
}
