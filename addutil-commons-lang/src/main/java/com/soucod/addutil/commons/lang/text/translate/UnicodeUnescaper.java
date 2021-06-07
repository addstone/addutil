package com.soucod.addutil.commons.lang.text.translate;

/**
 * Description:  此类描述
 * Author: LuDaShi
 * Date: 2021-01-27-10:33
 * UpdateDate: 2021-01-27-10:33
 * FileName: UnicodeUnescaper
 * Version: 0.0.0.1
 * Since: 0.0.0.1
 */

import java.io.IOException;
import java.io.Writer;

/**
 * Translates escaped Unicode values of the form \\u+\d\d\d\d back to
 * Unicode. It supports multiple 'u' characters and will work with or
 * without the +.
 *
 * @since 3.0
 * @deprecated as of 3.6, use commons-text
 * <a href="https://commons.apache.org/proper/commons-text/javadocs/api-release/org/apache/commons/text/translate/UnicodeUnescaper.html">
 * UnicodeUnescaper</a> instead
 */
@Deprecated
public class UnicodeUnescaper extends CharSequenceTranslator {

    /**
     * {@inheritDoc}
     */
    @Override
    public int translate(final CharSequence input, final int index, final Writer out) throws IOException {
        if (input.charAt(index) == '\\' && index + 1 < input.length() && input.charAt(index + 1) == 'u') {
            // consume optional additional 'u' chars
            int i = 2;
            while (index + i < input.length() && input.charAt(index + i) == 'u') {
                i++;
            }

            if (index + i < input.length() && input.charAt(index + i) == '+') {
                i++;
            }

            if (index + i + 4 <= input.length()) {
                // Get 4 hex digits
                final CharSequence unicode = input.subSequence(index + i, index + i + 4);

                try {
                    final int value = Integer.parseInt(unicode.toString(), 16);
                    out.write((char) value);
                } catch (final NumberFormatException nfe) {
                    throw new IllegalArgumentException("Unable to parse unicode value: " + unicode, nfe);
                }
                return i + 4;
            }
            throw new IllegalArgumentException(
                    "Less than 4 hex digits in unicode value: '" + input.subSequence(index, input.length())
                            + "' due to end of CharSequence");
        }
        return 0;
    }
}
