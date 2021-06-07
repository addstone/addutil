/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.soucod.addutil.commons.beanutils.converters;

import java.time.ZoneOffset;

import com.soucod.addutil.commons.beanutils.ConversionException;
import com.soucod.addutil.commons.beanutils.Converter;

import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Test Case for the ZoneOffsetConverter class.
 *
 */
public class ZoneOffsetConverterTestCase extends TestCase {

    public static TestSuite suite() {
        return new TestSuite(ZoneOffsetConverterTestCase.class);
    }



    private Converter converter = null;



    public ZoneOffsetConverterTestCase(final String name) {
        super(name);
    }

    protected Class<?> getExpectedType() {
        return ZoneOffset.class;
    }

    protected Converter makeConverter() {
        return new ZoneOffsetConverter();
    }



    @Override
    public void setUp() throws Exception {
        converter = makeConverter();
    }

    @Override
    public void tearDown() throws Exception {
        converter = null;
    }



    public void testSimpleConversion() throws Exception {
        final String[] message= {
            "from String",
            "from String",
            "from String",
            "from String",
            "from String",
            "from String",
            "from String",
            "from String",
        };

        final Object[] input = {
            "-12:00",
            "+14:00",
            "+02:00"
        };

        final ZoneOffset[] expected = {
                ZoneOffset.of("-12:00"),
                ZoneOffset.of("+14:00"),
                ZoneOffset.of("+02:00")
        };

        for(int i=0;i<expected.length;i++) {
            assertEquals(message[i] + " to URI",expected[i],converter.convert(ZoneOffset.class,input[i]));
            assertEquals(message[i] + " to null type",expected[i],converter.convert(null,input[i]));
        }

        for(int i=0;i<expected.length;i++) {
            assertEquals(input[i] + " to String", input[i], converter.convert(String.class, expected[i]));
        }
    }

    /**
     * Tests a conversion to an unsupported type.
     */
    public void testUnsupportedType() {
        try {
            converter.convert(Integer.class, "http://www.apache.org");
            fail("Unsupported type could be converted!");
        } catch (final ConversionException cex) {
            // expected result
        }
    }
}

