package com.soucod.addutil.commons.lang.text.translate;

/**
 * Description:  此类描述
 * Author: LuDaShi
 * Date: 2021-01-27-10:32
 * UpdateDate: 2021-01-27-10:32
 * FileName: UnicodeUnpairedSurrogateRemover
 * Version: 0.0.0.1
 * Since: 0.0.0.1
 */

import java.io.IOException;
import java.io.Writer;

/**
 * Helper subclass to CharSequenceTranslator to remove unpaired surrogates.
 *
 * @deprecated as of 3.6, use commons-text
 * <a href="https://commons.apache.org/proper/commons-text/javadocs/api-release/org/apache/commons/text/translate/UnicodeUnpairedSurrogateRemover.html">
 * UnicodeUnpairedSurrogateRemover</a> instead
 */
@Deprecated
public class UnicodeUnpairedSurrogateRemover extends CodePointTranslator {

    /**
     * Implementation of translate that throws out unpaired surrogates.
     * {@inheritDoc}
     */
    @Override
    public boolean translate(final int codepoint, final Writer out) throws IOException {
        if (codepoint >= Character.MIN_SURROGATE && codepoint <= Character.MAX_SURROGATE) {
            // It's a surrogate. Write nothing and say we've translated.
            return true;
        }
        // It's not a surrogate. Don't translate it.
        return false;
    }
}
