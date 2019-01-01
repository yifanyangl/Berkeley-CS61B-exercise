package lec04;

import static org.junit.Assert.assertEquals;

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
}
