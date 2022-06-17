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

/**
 <p>支持对位图字段的操作。此类的实例可用于在 {@code int}、{@code short} 或
 * {@code byte}.</p>
 *
 <p>每个 {@code BitField} 都由一个掩码值构成，该掩码值指示将用于存储和检索该字段数据的位。例如，掩码 {@code 0xFF} 表示应使用最低有效字节来存储数据。<p>
 *
 <p>举个例子，考虑一个接受整数形式的油漆指令的汽车喷漆机。位字段可用于对此进行编码：<p>
 *<pre>
 蓝色、绿色和红色是存储在三个最低有效字节中的 1 字节值 (0-255)
 *    BitField blue = new BitField(0xFF);
 *    BitField green = new BitField(0xFF00);
 *    BitField red = new BitField(0xFF0000);
 *
 *    // anyColor is a flag triggered if any color is used
 *    BitField anyColor = new BitField(0xFFFFFF);
 *
 *    // isMetallic is a single bit flag
 *    BitField isMetallic = new BitField(0x1000000);
 *</pre>
 *
 * <p>Using these {@code BitField} instances, a paint instruction can be
 * encoded into an integer:</p>
 *
 *<pre>
 *    int paintInstruction = 0;
 *    paintInstruction = red.setValue(paintInstruction, 35);
 *    paintInstruction = green.setValue(paintInstruction, 100);
 *    paintInstruction = blue.setValue(paintInstruction, 255);
 *</pre>
 *
 * <p>Flags and data can be retrieved from the integer:</p>
 *
 *<pre>
 *    // Prints true if red, green or blue is non-zero
 *    System.out.println(anyColor.isSet(paintInstruction));   // prints true
 *
 *    // Prints value of red, green and blue
 *    System.out.println(red.getValue(paintInstruction));     // prints 35
 *    System.out.println(green.getValue(paintInstruction));   // prints 100
 *    System.out.println(blue.getValue(paintInstruction));    // prints 255
 *
 *    // Prints true if isMetallic was set
 *    System.out.println(isMetallic.isSet(paintInstruction)); // prints false
 *</pre>
 *
 * @since 2.0
 */
public class BitField extends org.apache.commons.lang3.BitField {


    /**
     <p>创建一个 BitField 实例。<p> @param 掩码指定哪些位应用于此 BitField。此掩码中设置的位是此 BitField 操作的位
     */
    public BitField(int mask) {
        super(mask);
    }


}
