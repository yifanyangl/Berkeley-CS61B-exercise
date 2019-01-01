package lec04;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import org.junit.Before;
import org.junit.Test;

public class SLListTest {

    private SLList testList;

    @Before
    public void setUp() {
        testList = new SLList();
    }

    @Test
    public void canDeleteFirstFromNonEmptyList() {
        testList.addLast(3);
        testList.addLast(1);
        testList.addLast(2);
        testList.deleteFirst();
        assertEquals(2, testList.size());
        assertEquals(1, testList.getFirst());
    }

    @Test
    public void canDeleteFirstFromEmptyList() {
        testList.deleteFirst();
        assertEquals(0, testList.size());
    }

    @Test
    public void canBeCreatedWithArray() {
        SLList list = new SLList(new int[]{1, 2, 3});
        assertEquals(3, list.size());
        assertEquals(1, list.getFirst());
    }

    @Test
    public void canConvertToArray() {
        SLList list = new SLList(new int[]{1, 2, 3});
        assertArrayEquals(new int[]{1, 2, 3}, list.toArray());
    }

    @Test
    public void canAddTwoAdjacentNumbers() {
        SLList list = new SLList(new int[]{1, 1, 2, 3});
        list.addAdjacent();
        assertArrayEquals(new int[]{2, 2, 3}, list.toArray());
        list.addAdjacent();
        assertArrayEquals(new int[]{4, 3}, list.toArray());
        list.addAdjacent();
        assertArrayEquals(new int[]{4, 3}, list.toArray());
    }

    @Test
    public void canAddMultipleAdjacentNumbersAtOneTime() {
        SLList list = new SLList(new int[]{1, 1, 2, 3, 3, 4});
        list.addAdjacent();
        assertArrayEquals(new int[]{2, 2, 6, 4}, list.toArray());
    }

    @Test
    public void onlyAddsTwoAdjacentNumbers() {
        SLList list = new SLList(new int[]{1, 3, 3, 3, 4});
        list.addAdjacent();
        assertArrayEquals(new int[]{1, 6, 3, 4}, list.toArray());
    }

    @Test
    public void doesNothingWhenAddingAdjacentNumbersOfListOfSizeLessThanTwo() {
        SLList list = new SLList(new int[]{4});
        list.addAdjacent();
        assertArrayEquals(new int[]{4}, list.toArray());
        list = new SLList();
        list.addAdjacent();
        assertEquals(0, list.size());
    }
}
