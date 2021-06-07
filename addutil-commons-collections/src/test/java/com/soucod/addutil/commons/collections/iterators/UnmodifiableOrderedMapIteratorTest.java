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
package com.soucod.addutil.commons.collections.iterators;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

import com.soucod.addutil.commons.collections.OrderedMap;
import com.soucod.addutil.commons.collections.OrderedMapIterator;
import com.soucod.addutil.commons.collections.Unmodifiable;
import com.soucod.addutil.commons.collections.map.ListOrderedMap;

/**
 * Tests the UnmodifiableOrderedMapIterator.
 *
 */
public class UnmodifiableOrderedMapIteratorTest<K, V> extends AbstractOrderedMapIteratorTest<K, V> {

    public UnmodifiableOrderedMapIteratorTest(final String testName) {
        super(testName);
    }

    @Override
    public OrderedMapIterator<K, V> makeEmptyIterator() {
        return UnmodifiableOrderedMapIterator.unmodifiableOrderedMapIterator(
                ListOrderedMap.listOrderedMap(new HashMap<K, V>()).mapIterator());
    }

    @Override
    public OrderedMapIterator<K, V> makeObject() {
        return UnmodifiableOrderedMapIterator.unmodifiableOrderedMapIterator(getMap().mapIterator());
    }

    @Override
    @SuppressWarnings("unchecked")
    public OrderedMap<K, V> getMap() {
        final OrderedMap<K, V> testMap = ListOrderedMap.listOrderedMap(new HashMap<K, V>());
        testMap.put((K) "A", (V) "a");
        testMap.put((K) "B", (V) "b");
        testMap.put((K) "C", (V) "c");
        return testMap;
    }

    @Override
    @SuppressWarnings("unchecked")
    public Map<K, V> getConfirmedMap() {
        final Map<K, V> testMap = new TreeMap<>();
        testMap.put((K) "A", (V) "a");
        testMap.put((K) "B", (V) "b");
        testMap.put((K) "C", (V) "c");
        return testMap;
    }

    @Override
    public boolean supportsRemove() {
        return false;
    }

    @Override
    public boolean supportsSetValue() {
        return false;
    }

    //-----------------------------------------------------------------------
    public void testOrderedMapIterator() {
        assertTrue(makeEmptyIterator() instanceof Unmodifiable);
    }

    public void testDecorateFactory() {
        OrderedMapIterator<K, V> it = makeObject();
        assertSame(it, UnmodifiableOrderedMapIterator.unmodifiableOrderedMapIterator(it));

        it = getMap().mapIterator();
        assertTrue(it != UnmodifiableOrderedMapIterator.unmodifiableOrderedMapIterator(it));

        try {
            UnmodifiableOrderedMapIterator.unmodifiableOrderedMapIterator(null);
            fail();
        } catch (final NullPointerException ex) {}
    }

}
