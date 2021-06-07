package com.soucod.addutil.commons.lang.builder;

/**
 * Description:  此类描述
 * Author: LuDaShi
 * Date: 2021-01-27-10:37
 * UpdateDate: 2021-01-27-10:37
 * FileName: ToStringSummary
 * Version: 0.0.0.1
 * Since: 0.0.0.1
 */

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Use this annotation on the fields to get the summary instead of the detailed
 * information when using {@link ReflectionToStringBuilder}.
 *
 * <p>
 * Notice that not all {@link ToStringStyle} implementations support the
 * appendSummary method.
 * </p>
 *
 * @since 3.8
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface ToStringSummary {
    // empty
}
