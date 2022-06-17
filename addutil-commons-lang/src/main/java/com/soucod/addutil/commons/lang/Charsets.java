package com.soucod.addutil.commons.lang;

/**
 * Description:  此类描述
 * Author: LuDaShi
 * Date: 2021-01-27-11:18
 * UpdateDate: 2021-01-27-11:18
 * FileName: Charsets
 * Version: 0.0.0.1
 * Since: 0.0.0.1
 */

import java.nio.charset.Charset;
import java.nio.charset.UnsupportedCharsetException;

/**
 * Internal use only.
 * <p>
 * Provides utilities for {@link Charset}.
 * </p>
 * <p>
 * Package private since Apache Commons IO already provides a Charsets because {@link Charset} is in
 * {@code java.nio.charset}.
 * </p>
 *
 * @since 3.10
 */
class Charsets extends org.apache.commons.lang3.Charsets {

    /**
     * Returns the given {@code charset} or the default Charset if {@code charset} is null.
     *
     * @param charset a Charset or null.
     * @return the given {@code charset} or the default Charset if {@code charset} is null.
     */
    static Charset toCharset(final Charset charset) {
        return charset == null ? Charset.defaultCharset() : charset;
    }

    /**
     * Returns the given {@code charset} or the default Charset if {@code charset} is null.
     *
     * @param charsetName a Charset or null.
     * @return the given {@code charset} or the default Charset if {@code charset} is null.
     * @throws UnsupportedCharsetException If no support for the named charset is available in this instance of the Java
     *                                     virtual machine
     */
    static Charset toCharset(final String charsetName) {
        return charsetName == null ? Charset.defaultCharset() : Charset.forName(charsetName);
    }

    /**
     * Returns the given {@code charset} or the default Charset if {@code charset} is null.
     *
     * @param charsetName a Charset or null.
     * @return the given {@code charset} or the default Charset if {@code charset} is null.
     */
    static String toCharsetName(final String charsetName) {
        return charsetName == null ? Charset.defaultCharset().name() : charsetName;
    }

}
