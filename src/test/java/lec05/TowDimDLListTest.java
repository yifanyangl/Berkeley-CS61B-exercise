package lec05;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class TowDimDLListTest {

    private TwoDimDLList<Integer> testList;

    @Before
    public void setUp() {
        testList = new TwoDimDLList<>(3);
    }

    @Test
    public void canAddListAndKeepEven() {
        DLList<Integer> toAdd = new DLList<>();
        toAdd.addLast(1);
        toAdd.addLast(2);
        toAdd.addLast(3);
        toAdd.addLast(4);
        toAdd.addLast(5);
        testList.addList(0, toAdd);
        assertEquals("[[1,4],[2,5],[3]]", testList.toString());
    }

    @Test
    public void canAddListAtNonZeroPosition() {
        DLList<Integer> toAdd = new DLList<>();
        toAdd.addLast(1);
        toAdd.addLast(2);
        toAdd.addLast(3);
        toAdd.addLast(4);
        toAdd.addLast(5);
        testList.addList(1, toAdd);
        assertEquals("[[3],[1,4],[2,5]]", testList.toString());
    }

    @Test
    public void canAddLongList() {
        DLList<Integer> toAdd = new DLList<>();
        toAdd.addLast(1);
        toAdd.addLast(2);
        toAdd.addLast(3);
        toAdd.addLast(4);
        toAdd.addLast(5);
        toAdd.addLast(6);
        toAdd.addLast(7);
        toAdd.addLast(8);
        toAdd.addLast(9);
        toAdd.addLast(10);
        toAdd.addLast(11);
        testList.addList(2, toAdd);
        assertEquals("[[2,5,8,11],[3,6,9],[1,4,7,10]]", testList.toString());
    }
}
