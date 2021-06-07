package com.soucod.addutil.commons.lang.text.translate;

/**
 * Description:  此类描述
 * Author: LuDaShi
 * Date: 2021-01-27-10:13
 * UpdateDate: 2021-01-27-10:13
 * FileName: AggregateTranslator
 * Version: 0.0.0.1
 * Since: 0.0.0.1
 */

import com.soucod.addutil.commons.lang.ArrayUtils;
import java.io.IOException;
import java.io.Writer;

/**
 * Executes a sequence of translators one after the other. Execution ends whenever
 * the first translator consumes codepoints from the input.
 *
 * @since 3.0
 * @deprecated as of 3.6, use commons-text
 * <a href="https://commons.apache.org/proper/commons-text/javadocs/api-release/org/apache/commons/text/AggregateTranslator.html">
 * AggregateTranslator</a> instead
 */
@Deprecated
public class AggregateTranslator extends CharSequenceTranslator {

    private final CharSequenceTranslator[] translators;

    /**
     * Specify the translators to be used at creation time.
     *
     * @param translators CharSequenceTranslator array to aggregate
     */
    public AggregateTranslator(final CharSequenceTranslator... translators) {
        this.translators = ArrayUtils.clone(translators);
    }

    /**
     * The first translator to consume codepoints from the input is the 'winner'.
     * Execution stops with the number of consumed codepoints being returned.
     * {@inheritDoc}
     */
    @Override
    public int translate(final CharSequence input, final int index, final Writer out) throws IOException {
        for (final CharSequenceTranslator translator : translators) {
            final int consumed = translator.translate(input, index, out);
            if (consumed != 0) {
                return consumed;
            }
        }
        return 0;
    }

}
