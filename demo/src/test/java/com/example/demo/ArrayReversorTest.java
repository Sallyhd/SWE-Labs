package com.example.demo;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.Assert.assertArrayEquals;
import static org.mockito.Mockito.*;

public class ArrayReversorTest {
    private ArrayFlattenerService service = mock(ArrayFlattenerService.class);
    private ArrayReversor reversor = new ArrayReversor(service);

    @Test
    public void testReverseArray() {
        int[][] a_in = {{1,3}, {0}, {4,5,9}};
        when(service.flattenArray(a_in)).thenReturn(new int[]{1,3,0,4,5,9});
        int[] expected = {9,5,4,0,3,1};
        assertArrayEquals(expected, reversor.reverseArray(a_in));
        verify(service, times(1)).flattenArray(a_in);
    }

    @Test
    public void testReverseArrayNullInput() {
        when(service.flattenArray(null)).thenReturn(null);
        assertArrayEquals(null, reversor.reverseArray(null));
        verify(service, times(1)).flattenArray(null);
    }
}
