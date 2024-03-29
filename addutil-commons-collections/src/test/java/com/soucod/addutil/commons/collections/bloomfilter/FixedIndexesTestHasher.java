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
package com.soucod.addutil.commons.collections.bloomfilter;

import com.soucod.addutil.commons.collections.bloomfilter.hasher.HashFunctionIdentity;
import com.soucod.addutil.commons.collections.bloomfilter.hasher.Hasher;
import com.soucod.addutil.commons.collections.bloomfilter.hasher.Shape;

import java.util.Arrays;
import java.util.PrimitiveIterator.OfInt;

/**
 * A Hasher implementation to return fixed indexes. Duplicates are allowed.
 * The shape is ignored when generating the indexes.
 *
 * <p><strong>This is not a real hasher and is used for testing only</strong>.
 */
class FixedIndexesTestHasher implements Hasher {
    /** The shape. */
    private final Shape shape;
    /** The indexes. */
    private final int[] indexes;

    /**
     * Create an instance.
     *
     * @param shape the shape
     * @param indexes the indexes
     */
    FixedIndexesTestHasher(final Shape shape, final int... indexes) {
        this.shape = shape;
        this.indexes = indexes;
    }

    @Override
    public OfInt iterator(final Shape shape) {
        if (!this.shape.equals(shape)) {
            throw new IllegalArgumentException(
                String.format("shape (%s) does not match internal shape (%s)", shape, this.shape));
        }
        return Arrays.stream(indexes).iterator();
    }

    @Override
    public HashFunctionIdentity getHashFunctionIdentity() {
        return shape.getHashFunctionIdentity();
    }
}
