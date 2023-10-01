package com.example.demo;


import org.junit.Test;

public class ArrayReversorTestCases {
    ArrayReversorTest test = new ArrayReversorTest();

    @Test
    public void runAllTests() {
        test.testReverseArray();
        test.testReverseArrayNullInput();
    }
}
