package com.example.demo;

public class ArrayReversor {
    private ArrayFlattenerService service;

    public ArrayReversor(ArrayFlattenerService service) {
        this.service = service;
    }

    public int[] reverseArray(int[][] a_in) {
        int[] flattenedArray = service.flattenArray(a_in);
        if (flattenedArray == null) return null;
        int start = 0, end = flattenedArray.length - 1;
        while (start < end) {
            int temp = flattenedArray[start];
            flattenedArray[start] = flattenedArray[end];
            flattenedArray[end] = temp;
            start++;
            end--;
        }
        return flattenedArray;
    }
}
