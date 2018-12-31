package lec04;

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
    }
}
