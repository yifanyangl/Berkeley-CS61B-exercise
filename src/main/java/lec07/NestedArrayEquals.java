/*
C-Level Exercise 1: In general, is it good to write tests that test your entire program?
                    How about for specific functions?
  Sometimes we only care about if the whole program works or not, so it is good and enough to only
  write tests to test the whole program. Testing for specific functions is more like to give you
  confidence when you are coding.

B-Level Exercise 1: Write a testing method that will take in 2 arrays and see if they are equal.
                    These arrays can have nested arrays and those nested arrays can have nested
                    arrays and so forth.
  Implemented below.
*/
package lec07;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class NestedArrayEquals {

    public static void assertNestedArrayEquals(Object[] expected, Object[] actual) {
        boolean isExpectedNull = expected == null;
        boolean isActualNull = actual == null;
        if (isExpectedNull && isActualNull) {
            return;
        } else if (isExpectedNull && !isActualNull) {
            fail("Expects null but actually not.");
        } else if (!isExpectedNull && isActualNull) {
            fail("Actual is null.");
        }

        if (expected.length != actual.length) {
            fail("Two arrays are not of same length.");
        } else if (expected.length == 0) {
            return;
        }

        boolean isExpectedNestedArray = expected[0] instanceof Object[];
        boolean isActualNestedArray = actual[0] instanceof Object[];
        if (isExpectedNestedArray && isActualNestedArray) {
            for (int i = 0; i < expected.length; i++) {
                assertNestedArrayEquals((Object[]) expected[i], (Object[]) actual[i]);
            }
        } else if (!isActualNestedArray && !isExpectedNestedArray) {
            for (int i = 0; i < expected.length; i++) {
                assertEquals(expected[i], actual[i]);
            }
        } else if (!isActualNestedArray && isExpectedNestedArray) {
            fail("Expects an array but actually not.");
        } else {
            fail("Expects an object but actually an array.");
        }
    }


}
