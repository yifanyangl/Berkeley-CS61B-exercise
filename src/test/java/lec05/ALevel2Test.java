package lec05;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.LinkedHashMap;
import java.util.Map;
import org.junit.Before;
import org.junit.Test;

public class ALevel2Test {

    private LengthComparator comparator;

    @Before
    public void setUp() {
        comparator = new LengthComparator();
    }

    @Test
    public void lessThanReturnsNegative() {
        assertTrue(comparator.compare("1", "12") < 0);
        assertTrue(comparator.compare("", "1") < 0);
        assertTrue(comparator.compare(null, "") < 0);
    }

    @Test
    public void equalReturnsZero() {
        assertEquals(comparator.compare("1", "2"), 0);
        assertEquals(comparator.compare("", ""), 0);
        assertEquals(comparator.compare("11", "23"), 0);
        assertEquals(comparator.compare(null, null), 0);
    }

    @Test
    public void largerThanReturnsPositive() {
        assertTrue(comparator.compare("1", "") > 0);
        assertTrue(comparator.compare("12", "1") > 0);
        assertTrue(comparator.compare("", null) > 0);
    }

    @Test
    public void testMax() {
        assertEquals("123", ALevel2.max(new String[]{null, "1", "2", "12", "123"}, comparator));
        assertEquals("123", ALevel2.max(new String[]{"123"}, comparator));
    }

    @Test
    public void testStep() {
        Map<String[][], String[][]> data = new LinkedHashMap<>();
        String[][] arrayParam = new String[][]{
            {null, null, null, null, null, null},
            {null, "a", "cat", "cat", "dogs", null},
            {null, "a", null, "cat", "a", null},
            {null, "a", "ca", "", "ca", null},
            {null, null, null, null, null, null},
        };
        String[][] expected = new String[][]{
            {null, null, null, null, null, null},
            {null, "cat", "cat", "dogs", "dogs", null},
            {null, "cat", "cat", "dogs", "dogs", null},
            {null, "ca", "cat", "cat", "cat", null},
            {null, null, null, null, null, null},
        };
        data.put(arrayParam, expected);
        arrayParam = new String[][]{
            {null, null, null},
            {null, "ab", null},
            {null, null, null},
        };
        expected = new String[][]{
            {null, null, null},
            {null, "ab", null},
            {null, null, null},
        };
        data.put(arrayParam, expected);

        data.forEach((arrParam, exptd) -> assertArrayEquals(exptd, ALevel2.step(arrParam)));
    }
}
