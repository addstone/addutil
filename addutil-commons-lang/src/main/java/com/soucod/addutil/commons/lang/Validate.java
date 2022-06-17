package com.soucod.addutil.commons.lang;

/**
 * Description:  此类描述
 * Author: LuDaShi
 * Date: 2021-01-27-9:44
 * UpdateDate: 2021-01-27-9:44
 * FileName: Validate
 * Version: 0.0.0.1
 * Since: 0.0.0.1
 */

import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import java.util.regex.Pattern;

/**
 * <p>This class assists in validating arguments. The validation methods are
 * based along the following principles:
 * <ul>
 *   <li>An invalid {@code null} argument causes a {@link NullPointerException}.</li>
 *   <li>A non-{@code null} argument causes an {@link IllegalArgumentException}.</li>
 *   <li>An invalid index into an array/collection/map/string causes an {@link IndexOutOfBoundsException}.</li>
 * </ul>
 *
 * <p>All exceptions messages are
 * <a href="http://docs.oracle.com/javase/1.5.0/docs/api/java/util/Formatter.html#syntax">format strings</a>
 * as defined by the Java platform. For example:</p>
 *
 * <pre>
 * Validate.isTrue(i &gt; 0, "The value must be greater than zero: %d", i);
 * Validate.notNull(surname, "The surname must not be %s", null);
 * </pre>
 *
 * <p>#ThreadSafe#</p>
 * @see java.lang.String#format(String, Object...)
 * @since 2.0
 */
public class Validate extends org.apache.commons.lang3.Validate {

}
