package com.ecample.operator.bitwise;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class BitwiseOperatorTest {

    //& Bitwise AND
    //| Bitwise OR
    //^ Bitwise XOR
    //~ Bitwise NOT (Complement)
    //<< Left Shift
    //>> Signed Right Shift
    //>>> Unsigned Right Shift



    //<< Left Shift
    /**
     *
     */

    @Test
    @DisplayName("Left Shift Operator Test")
    void TestLeftShift(){
        int a = 5;//0 101
        int result =  a << 2;//0 10100 --> 20
        assertEquals(20, result, "testing left shift operator - positive integer");

        int aNegative = -5;//1 101
        int resultNegative =  aNegative << 2;//0 10100 --> 20
        assertEquals(-20, resultNegative, "testing left shift operator - negative integer");
    }
    //>> Signed Right Shift
    @Test
    @DisplayName("Signed Right Shift Operator Test")
    void testSignedRightShift(){
        int a = 20;//0 10100
        int result = a >> 2;//0 101 --> 5
        assertEquals(5, result);

        int aNegative = -20;//1 10100
        int resultNegative = aNegative >> 2;//
        assertEquals(-5, resultNegative);
    }
    //>>> Unsigned Right Shift

    /**
     * For unsigned right shift, it will work as usual for positive number, but for negative number it will fill the leftover bits with 0, and the result will be a large for a small negative
     * Integer.
     */
    @Test
    @DisplayName("Unsigned Right Shift Oprator Test")
    void testUnsignedRightShift(){
        int inputNumbber = 20;
        int result = inputNumbber >>> 2;
        assertEquals(5, result, "Positive integer as input");
        int inputNumbberNegative = -20;
        int resultNegative = inputNumbberNegative >>> 2;
        assertEquals(1073741819, resultNegative, "Negative integer as input");// TODO: need to understand the result better.

    }

}
