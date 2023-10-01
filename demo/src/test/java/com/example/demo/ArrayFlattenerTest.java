package com.example.demo;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class ArrayFlattenerTest {
    private ArrayFlattener flattener = new ArrayFlattener();

    @Test
    public void testFlattenArray() {
        int[][] a_in = {{1,3}, {0}, {4,5,9}};
        int[] expected = {1,3,0,4,5,9};
        assertArrayEquals(expected, flattener.flattenArray(a_in));
    }

    @Test
    public void testFlattenArrayNullInput() {
        assertArrayEquals(null, flattener.flattenArray(null));
    }
}
