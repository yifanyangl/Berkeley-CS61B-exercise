package lec07;

import static lec07.NestedArrayEquals.assertNestedArrayEquals;
import static org.junit.Assert.fail;

import org.junit.Test;

public class NestedArrayEqualsTest {

    private static <T extends Throwable> void assertThrows(Class<T> expectedType,
        Runnable runnable
    ) {
        try {
            runnable.run();
        } catch (Throwable e) {
            if (!e.getClass().equals(expectedType)) {
                fail("Does not throw expected " + expectedType + ", but " + e);
            }
        }
    }

    private static void assertDoesNotThrow(Runnable runnable) {
        try {
            runnable.run();
        } catch (Throwable e) {
            fail("Throws unexpected " + e.getClass() + ", but should throw nothing");
        }
    }

    @Test
    public void testNestedArrayEquals() {
        assertDoesNotThrow(() -> assertNestedArrayEquals(
            new Integer[][]{
                {1, 2},
                {2, 3},
                {3, 4}
            },
            new Integer[][]{
                {1, 2},
                {2, 3},
                {3, 4}
            }));
        assertDoesNotThrow(() -> assertNestedArrayEquals(null, null));
        assertDoesNotThrow(() -> assertNestedArrayEquals(
            new Integer[][]{null},
            new Integer[][]{null}));
        assertDoesNotThrow(() -> assertNestedArrayEquals(
            new Integer[][]{},
            new Integer[][]{}));

        assertThrows(AssertionError.class, () -> assertNestedArrayEquals(
            new Integer[][]{null},
            null));
        assertThrows(AssertionError.class, () -> assertNestedArrayEquals(
            null,
            new Integer[]{}));
        assertThrows(AssertionError.class, () -> assertNestedArrayEquals(
            new Integer[][]{{1, 2}},
            new Integer[]{1, 2}));

        assertThrows(AssertionError.class, () -> assertNestedArrayEquals(
            new Integer[][][]{{{1, 2}}, {{2, 3}}},
            new Integer[][][]{{{1}, {2}}, {{2}, {3}}}));
        assertDoesNotThrow(() -> assertNestedArrayEquals(
            new Integer[][][]{{{1, 2}}, {{2, 3}}},
            new Integer[][][]{{{1, 2}}, {{2, 3}}}));

        assertThrows(AssertionError.class, () -> assertNestedArrayEquals(
            new Integer[][]{{1}, {2}},
            new Integer[]{1, 2}));
        assertThrows(AssertionError.class, () -> assertNestedArrayEquals(
            new Integer[]{1, 2},
            new Integer[][]{{1}, {2}}));
    }
}
