package com.example.demo;

import java.util.Arrays;

public class ArrayFlattener {
    public int[] flattenArray(int[][] a_in) {
        if (a_in == null) return null;
        return Arrays.stream(a_in)
                     .flatMapToInt(Arrays::stream)
                     .toArray();
    }
}
