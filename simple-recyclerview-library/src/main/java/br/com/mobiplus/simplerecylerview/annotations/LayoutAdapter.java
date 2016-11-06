package br.com.mobiplus.simplerecylerview.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by luisfernandez on 2/10/16.
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface LayoutAdapter {

    int layoutResId() default 0;
    int [] arrayClickableResIds() default {};
}
