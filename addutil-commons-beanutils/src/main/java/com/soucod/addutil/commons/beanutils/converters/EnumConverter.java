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

/**
 * {@link com.soucod.addutil.commons.beanutils.Converter} implementation that handles conversion
 * to and from <b>java.lang.Enum</b> objects.
 * <p>
 * Can be configured to either return a <i>default value</i> or throw a
 * {@code ConversionException} if a conversion error occurs.
 * </p>
 *
 * @since 2.0
 * @see java.lang.Enum
 */
public final class EnumConverter extends AbstractConverter {

    /**
     * Constructs a <b>java.lang.Enum</b> <i>Converter</i> that throws
     * a {@code ConversionException} if an error occurs.
     */
    public EnumConverter() {
    }

    /**
     * Constructs a <b>java.lang.Enum</b> <i>Converter</i> that returns
     * a default value if an error occurs.
     *
     * @param defaultValue The default value to be returned
     * if the value to be converted is missing or an error
     * occurs converting the value.
     */
    public EnumConverter(final Object defaultValue) {
        super(defaultValue);
    }

    /**
     * Gets the default type this {@code Converter} handles.
     *
     * @return The default type this {@code Converter} handles.
     * @since 2.0
     */
    @Override
    protected Class<?> getDefaultType() {
        return Enum.class;
    }

    /**
     * <p>Converts a java.lang.Enum or object into a String.</p>
     *
     * @param <T> Target type of the conversion.
     * @param type Data type to which this value should be converted.
     * @param value The input value to be converted.
     * @return The converted value.
     * @throws Throwable if an error occurs converting to the specified type
     * @since 2.0
     */
    @SuppressWarnings({ "rawtypes" })
    @Override
    protected <T> T  convertToType(final Class<T> type, final Object value) throws Throwable {
        if (Enum.class.isAssignableFrom(type)) {
            final String enumValue = String.valueOf(value);
            final T[] constants = type.getEnumConstants();
            if (constants == null) {
                throw conversionException(type, value);
            }
            for (final T candidate : constants) {
                if (((Enum)candidate).name().equalsIgnoreCase(enumValue)) {
                    return candidate;
                }
            }
        }

        throw conversionException(type, value);
    }

}
