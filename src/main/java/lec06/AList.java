/*
Exercise 2.5.1: Try to build an AList class that supports addLast, getLast, get, and size
operations. Your AList should work for any size array up to 100. For starter code, see
https://github.com/Berkeley-CS61B/lectureCode/tree/master/lists4/DIY.

Exercise 2.5.2: Try to write removeLast. Before starting, decide which of size, items, and items[i]
needs to change so that our invariants are preserved after the operation, i.e. so that future calls
to our methods provide the user of the list class with the behavior they expect.

Exercise 2.5.3: Suppose we have an AList in the state shown in the figure below. What will happen
if we call addLast(11)? What should we do about this problem?

Exercise 2.5.4: Try to implement the addLast(int i) method to work with resizing arrays.

Exercise 2.5.5: Suppose we have an array of size 100. If we call insertBack two times, how many
total boxes will we need to create and fill throughout this entire process? How many total boxes
will we have at any one time, assuming that garbage collection happens as soon as the last
reference to an array is lost?

Exercise 2.5.6: Starting from an array of size 100, approximately how many memory boxes get created
and filled if we call addLast 1,000 times?
 */
package lec06;

/**
 * Array based list.
 *
 * @author Josh Hug
 */
public class AList {

    private static int INIT_LEN = 10;
    private static int LEN_MULTIPLIER = 2;
    private int[] array;
    private int size;

    /**
     * Creates an empty list.
     */
    public AList() {
        array = new int[INIT_LEN];
        size = 0;
    }

    /**
     * Inserts X into the back of the list.
     */
    public void addLast(int x) {
        if (size == array.length) {
            expandArray();
        }
        array[size] = x;
        size += 1;
    }

    /**
     * Returns the item from the back of the list.
     */
    public int getLast() {
        if (size == 0) {
            throw new IllegalStateException("List is empty.");
        }
        return array[size - 1];
    }

    /**
     * Gets the ith item in the list (0 is the front).
     */
    public int get(int i) {
        if (i < 0 || i >= size) {
            throw new IndexOutOfBoundsException();
        }
        return array[i];
    }

    /**
     * Returns the number of items in the list.
     */
    public int size() {
        return size;
    }

    /**
     * Deletes item from back of the list and returns deleted item.
     */
    public int removeLast() {
        if (size == 0) {
            throw new IllegalStateException("List is empty.");
        }
        size -= 1;
        return array[size];
    }

    private void expandArray() {
        int[] newArray = new int[array.length * LEN_MULTIPLIER];
        System.arraycopy(array, 0, newArray, 0, size);
        array = newArray;
    }
}
