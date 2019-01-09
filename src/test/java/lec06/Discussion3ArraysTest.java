package lec06;

import static org.junit.Assert.assertArrayEquals;

import org.junit.Before;
import org.junit.Test;

public class Discussion3ArraysTest {

    private int[] testArr;

    @Before
    public void setUp() {
        testArr = new int[]{5, 9, 14, 15};
    }

    @Test
    public void insert() {
        int[] got = Discussion3Arrays.insert(testArr, 6, 2);
        assertArrayEquals(new int[]{5, 9, 6, 14, 15}, got);
    }

    @Test
    public void insertAfterEnd() {
        int[] got = Discussion3Arrays.insert(testArr, 6, 4);
        assertArrayEquals(new int[]{5, 9, 14, 15, 6}, got);
        got = Discussion3Arrays.insert(testArr, 6, 7);
        assertArrayEquals(new int[]{5, 9, 14, 15, 6}, got);
    }

    @Test
    public void insertToFront() {
        int[] got = Discussion3Arrays.insert(testArr, 7, 0);
        assertArrayEquals(new int[]{7, 5, 9, 14, 15}, got);
    }

    @Test
    public void insertToEmptyArray() {
        int[] arr = new int[]{};
        int[] got = Discussion3Arrays.insert(arr, 7, 0);
        assertArrayEquals(new int[]{7}, got);
    }
}