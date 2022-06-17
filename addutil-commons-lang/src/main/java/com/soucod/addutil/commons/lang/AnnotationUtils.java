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

import java.lang.annotation.Annotation;

/**
 * <p>使用 {@link Annotation} 实例的辅助方法。<p>
 *
 <p>这个类包含各种实用方法，使使用注释更简单。<p>
 *
 <p>{@link Annotation} 实例总是代理对象；不幸的是，不能依赖动态代理来知道如何以与“自然”{@link Annotation} 相同的方式实现某些方法。
 此类中提供的方法可用于避免这种可能性。当然，动态代理也可以实际委托他们的
 * e.g. {@link Annotation#equals(Object)}/{@link Annotation#hashCode()}/
 * {@link Annotation#toString()} implementations to {@link AnnotationUtils}.</p>
 *
 * <p>#ThreadSafe#</p>
 *
 * @since 3.0
 */
public class AnnotationUtils extends org.apache.commons.lang3.AnnotationUtils {

}
