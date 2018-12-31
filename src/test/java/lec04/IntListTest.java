package lec04;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class IntListTest {

    private IntList testList;

    @Before
    public void setUp() {
        testList = new IntList(15, null);
    }

    @Test
    public void canAddFirst() {
        testList.addFirst(1);
        assertEquals(1, testList.get(0));
        assertEquals(15, testList.get(1));
        testList.addFirst(-1);
        assertEquals(-1, testList.get(0));
        assertEquals(1, testList.get(1));
        assertEquals(15, testList.get(2));
    }
}
