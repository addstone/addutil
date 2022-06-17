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
package com.soucod.addutil.commons.lang;

import java.util.stream.Stream;

/**
 * Provides utility functions, and classes for working with the
 * {@code java.util.stream} package, or more generally, with Java 8 lambdas. More
 * specifically, it attempts to address the fact that lambdas are supposed
 * not to throw Exceptions, at least not checked Exceptions, AKA instances
 * of {@link Exception}. This enforces the use of constructs like
 * <pre>
 *     Consumer&lt;java.lang.reflect.Method&gt; consumer = m -&gt; {
 *         try {
 *             m.invoke(o, args);
 *         } catch (Throwable t) {
 *             throw Functions.rethrow(t);
 *         }
 *    };
 *    stream.forEach(consumer);
 * </pre>
 * Using a {@link FailableStream}, this can be rewritten as follows:
 * <pre>
 *     Streams.failable(stream).forEach((m) -&gt; m.invoke(o, args));
 * </pre>
 * Obviously, the second version is much more concise and the spirit of
 * Lambda expressions is met better than in the first version.
 *
 * @see Stream
 * @see Functions
 * @since 3.10
 * @deprecated Use {@link com.soucod.addutil.commons.lang.stream.Streams}.
 */
@Deprecated
public class Streams extends com.soucod.addutil.commons.lang.stream.Streams {

}
