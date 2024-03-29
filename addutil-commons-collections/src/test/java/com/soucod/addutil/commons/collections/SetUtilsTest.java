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
package com.soucod.addutil.commons.collections;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import com.soucod.addutil.commons.collections.SetUtils.SetView;
import com.soucod.addutil.commons.collections.set.PredicatedSet;
import org.junit.Before;
import org.junit.Test;

/**
 * Tests for SetUtils.
 *
 */
public class SetUtilsTest {

    private Set<Integer> setA;
    private Set<Integer> setB;

    @Test
    public void difference() {
        final SetView<Integer> set = SetUtils.difference(setA, setB);
        assertEquals(2, set.size());
        assertTrue(set.contains(1));
        assertTrue(set.contains(2));
        for (final Integer i : setB) {
            assertFalse(set.contains(i));
        }

        final Set<Integer> set2 = SetUtils.difference(setA, SetUtils.<Integer>emptySet());
        assertEquals(setA, set2);

        try {
            SetUtils.difference(setA, null);
            fail("Expecting NullPointerException");
        } catch (final NullPointerException npe) {
            // expected
        }

        try {
            SetUtils.difference(null, setA);
            fail("Expecting NullPointerException");
        } catch (final NullPointerException npe) {
            // expected
        }
    }

    @Test
    public void disjunction() {
        final SetView<Integer> set = SetUtils.disjunction(setA, setB);
        assertEquals(4, set.size());
        assertTrue(set.contains(1));
        assertTrue(set.contains(2));
        assertTrue(set.contains(6));
        assertTrue(set.contains(7));
        assertFalse(set.contains(3));
        assertFalse(set.contains(4));
        assertFalse(set.contains(5));

        final Set<Integer> set2 = SetUtils.disjunction(setA, SetUtils.<Integer>emptySet());
        assertEquals(setA, set2);

        try {
            SetUtils.disjunction(setA, null);
            fail("Expecting NullPointerException");
        } catch (final NullPointerException npe) {
            // expected
        }

        try {
            SetUtils.disjunction(null, setA);
            fail("Expecting NullPointerException");
        } catch (final NullPointerException npe) {
            // expected
        }
    }

    @Test
    public void intersection() {
        final SetView<Integer> set = SetUtils.intersection(setA, setB);
        assertEquals(3, set.size());
        assertTrue(set.contains(3));
        assertTrue(set.contains(4));
        assertTrue(set.contains(5));
        assertFalse(set.contains(1));
        assertFalse(set.contains(2));
        assertFalse(set.contains(6));
        assertFalse(set.contains(7));

        final Set<Integer> set2 = SetUtils.intersection(setA, SetUtils.<Integer>emptySet());
        assertEquals(SetUtils.<Integer>emptySet(), set2);

        try {
            SetUtils.intersection(setA, null);
            fail("Expecting NullPointerException");
        } catch (final NullPointerException npe) {
            // expected
        }

        try {
            SetUtils.intersection(null, setA);
            fail("Expecting NullPointerException");
        } catch (final NullPointerException npe) {
            // expected
        }
    }

    @Before
    public void setUp() {
        setA = new HashSet<>();
        setA.add(1);
        setA.add(2);
        setA.add(3);
        setA.add(4);
        setA.add(5);

        setB = new HashSet<>();
        setB.add(3);
        setB.add(4);
        setB.add(5);
        setB.add(6);
        setB.add(7);
    }

    @Test
    public void testEmptyIfNull() {
        assertTrue(SetUtils.emptyIfNull(null).isEmpty());

        final Set<Long> set = new HashSet<>();
        assertSame(set, SetUtils.emptyIfNull(set));
    }

    @Test
    public void testEquals() {
        final Collection<String> data = Arrays.asList("a", "b", "c");

        final Set<String> a = new HashSet<>(data);
        final Set<String> b = new HashSet<>(data);

        assertEquals(a, b);
        assertTrue(SetUtils.isEqualSet(a, b));
        a.clear();
        assertFalse(SetUtils.isEqualSet(a, b));
        assertFalse(SetUtils.isEqualSet(a, null));
        assertFalse(SetUtils.isEqualSet(null, b));
        assertTrue(SetUtils.isEqualSet(null, null));
    }

    @Test
    public void testHashCode() {
        final Collection<String> data = Arrays.asList("a", "b", "c");

        final Set<String> a = new HashSet<>(data);
        final Set<String> b = new HashSet<>(data);

        assertEquals(a.hashCode(), b.hashCode());
        assertEquals(a.hashCode(), SetUtils.hashCodeForSet(a));
        assertEquals(b.hashCode(), SetUtils.hashCodeForSet(b));
        assertEquals(SetUtils.hashCodeForSet(a), SetUtils.hashCodeForSet(b));
        a.clear();
        assertNotEquals(SetUtils.hashCodeForSet(a), SetUtils.hashCodeForSet(b));
        assertEquals(0, SetUtils.hashCodeForSet(null));
    }

    @Test
    public void testHashSet() {
        final Set<?> set1 = SetUtils.unmodifiableSet();
        assertTrue("set is empty", set1.isEmpty());

        final Set<Integer> set2 = SetUtils.hashSet(1, 2, 2, 3);
        assertEquals("set has 3 elements", 3, set2.size());
        assertTrue("set contains 1", set2.contains(1));
        assertTrue("set contains 2", set2.contains(2));
        assertTrue("set contains 3", set2.contains(3));

        final Set<String> set3 = SetUtils.hashSet("1", "2", "2", "3");
        assertEquals("set has 3 elements", 3, set3.size());
        assertTrue("set contains 1", set3.contains("1"));
        assertTrue("set contains 2", set3.contains("2"));
        assertTrue("set contains 3", set3.contains("3"));

        final Set<?> set4 = SetUtils.hashSet(null, null);
        assertEquals("set has 1 element", 1, set4.size());
        assertTrue("set contains null", set4.contains(null));

        final Set<?> set5 = SetUtils.hashSet((Object[]) null);
        assertNull("set is null", set5);
    }

    @Test
    public void testNewIdentityHashSet() {
        final Set<String> set = SetUtils.newIdentityHashSet();
        final String a = new String("a");
        set.add(a);
        set.add(new String("b"));
        set.add(a);

        assertEquals(2, set.size());

        set.add(new String("a"));
        assertEquals(3, set.size());

        set.remove(a);
        assertEquals(2, set.size());
    }

    @Test
    public void testpredicatedSet() {
        final Predicate<Object> predicate = o -> o instanceof String;
        final Set<Object> set = SetUtils.predicatedSet(new HashSet<>(), predicate);
        assertTrue("returned object should be a PredicatedSet", set instanceof PredicatedSet);
        try {
            SetUtils.predicatedSet(new HashSet<>(), null);
            fail("Expecting NullPointerException for null predicate.");
        } catch (final NullPointerException ex) {
            // expected
        }
        try {
            SetUtils.predicatedSet(null, predicate);
            fail("Expecting NullPointerException for null set.");
        } catch (final NullPointerException ex) {
            // expected
        }
    }

    @Test
    public void testUnmodifiableSet() {
        final Set<?> set1 = SetUtils.unmodifiableSet();
        assertTrue("set is empty", set1.isEmpty());

        final Set<Integer> set2 = SetUtils.unmodifiableSet(1, 2, 2, 3);
        assertEquals("set has 3 elements", 3, set2.size());
        assertTrue("set contains 1", set2.contains(1));
        assertTrue("set contains 2", set2.contains(2));
        assertTrue("set contains 3", set2.contains(3));

        final Set<String> set3 = SetUtils.unmodifiableSet("1", "2", "2", "3");
        assertEquals("set has 3 elements", 3, set3.size());
        assertTrue("set contains 1", set3.contains("1"));
        assertTrue("set contains 2", set3.contains("2"));
        assertTrue("set contains 3", set3.contains("3"));

        final Set<?> set4 = SetUtils.unmodifiableSet(null, null);
        assertEquals("set has 1 element", 1, set4.size());
        assertTrue("set contains null", set4.contains(null));

        final Set<?> set5 = SetUtils.unmodifiableSet((Object[]) null);
        assertNull("set is null", set5);
    }

    @Test
    public void testUnmodifiableSetWrap() {
        final Set<Integer> set1 = SetUtils.unmodifiableSet(1, 2, 2, 3);
        final Set<Integer> set2 = SetUtils.unmodifiableSet(set1);
        assertSame(set1, set2);
    }

    @Test
    public void union() {
        final SetView<Integer> set = SetUtils.union(setA, setB);
        assertEquals(7, set.size());
        assertTrue(set.containsAll(setA));
        assertTrue(set.containsAll(setB));

        final Set<Integer> set2 = SetUtils.union(setA, SetUtils.<Integer>emptySet());
        assertEquals(setA, set2);

        try {
            SetUtils.union(setA, null);
            fail("Expecting NullPointerException");
        } catch (final NullPointerException npe) {
            // expected
        }

        try {
            SetUtils.union(null, setA);
            fail("Expecting NullPointerException");
        } catch (final NullPointerException npe) {
            // expected
        }
    }

}
