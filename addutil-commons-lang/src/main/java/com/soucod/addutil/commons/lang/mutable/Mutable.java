package com.soucod.addutil.commons.lang.mutable;

/**
 * Description:  此类描述
 * Author: LuDaShi
 * Date: 2021-01-27-11:16
 * UpdateDate: 2021-01-27-11:16
 * FileName: Mutable
 * Version: 0.0.0.1
 * Since: 0.0.0.1
 */

/**
 * Provides mutable access to a value.
 * <p>
 * {@code Mutable} is used as a generic interface to the implementations in this package.
 * <p>
 * A typical use case would be to enable a primitive or string to be passed to a method and allow that method to
 * effectively change the value of the primitive/string. Another use case is to store a frequently changing primitive in
 * a collection (for example a total in a map) without needing to create new Integer/Long wrapper objects.
 *
 * @param <T> the type to set and get
 * @since 2.1
 */
public interface Mutable<T> {

    /**
     * Gets the value of this mutable.
     *
     * @return the stored value
     */
    T getValue();

    /**
     * Sets the value of this mutable.
     *
     * @param value
     *            the value to store
     * @throws NullPointerException
     *             if the object is null and null is invalid
     * @throws ClassCastException
     *             if the type is invalid
     */
    void setValue(T value);

}
