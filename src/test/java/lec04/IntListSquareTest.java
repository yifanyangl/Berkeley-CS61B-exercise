package lec04;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import org.junit.Before;
import org.junit.Test;

public class IntListSquareTest {

    private IntListSquare testList;

    @Before
    public void setUp() {
        testList = new IntListSquare(1,
            new IntListSquare(2, null));
    }

    @Test
    public void canConvertToList() {
        assertEquals(Arrays.asList(1, 2), testList.toList());
    }

    @Test
    public void squaresListAfterAddLast() {
        testList.addLast(5);
        assertEquals(Arrays.asList(1, 1, 2, 4, 5), testList.toList());
        testList.addLast(7);
        assertEquals(Arrays.asList(1, 1, 1, 1, 2, 4, 4, 16, 5, 25, 7), testList.toList());
    }
}
