package lec06;

import static org.junit.Assert.assertArrayEquals;

import org.junit.Before;
import org.junit.Test;

public class SLListTest {

    private SLList testList;

    @Before
    public void setUp() {
        testList = new SLList(5, 6, 2);
    }

    @Test
    public void testInsert() {
        testList.insert(10, 1);
        assertArrayEquals(new int[]{5, 10, 6, 2}, testList.toArray());
    }

    @Test
    public void testInsertAfterEnd() {
        testList.insert(3, 3);
        assertArrayEquals(new int[]{5, 6, 2, 3}, testList.toArray());
        testList.insert(6, 6);
        assertArrayEquals(new int[]{5, 6, 2, 3, 6}, testList.toArray());
    }

    @Test
    public void testInsertToEmpty() {
        SLList list = new SLList();
        list.insert(5, 0);
        assertArrayEquals(new int[]{5}, list.toArray());

        list = new SLList();
        list.insert(6, 1);
        assertArrayEquals(new int[]{6}, list.toArray());
    }

    @Test
    public void testReverse() {
        testList.reverse();
        assertArrayEquals(new int[]{2, 6, 5}, testList.toArray());
    }

    @Test
    public void testReverseEmpty() {
        SLList list = new SLList();
        list.reverse();
        assertArrayEquals(new int[]{}, list.toArray());
    }

    @Test
    public void testReverseListWithOneItem() {
        SLList list = new SLList();
        list.addLast(4);
        list.reverse();
        assertArrayEquals(new int[]{4}, list.toArray());
    }

    @Test
    public void testReverseRecursive() {
        testList.reverseRecursive();
        assertArrayEquals(new int[]{2, 6, 5}, testList.toArray());
    }

    @Test
    public void testReverseRecursiveEmpty() {
        SLList list = new SLList();
        list.reverseRecursive();
        assertArrayEquals(new int[]{}, list.toArray());
    }

    @Test
    public void testReverseRecursiveListWithOneItem() {
        SLList list = new SLList();
        list.addLast(4);
        list.reverseRecursive();
        assertArrayEquals(new int[]{4}, list.toArray());
    }
}
