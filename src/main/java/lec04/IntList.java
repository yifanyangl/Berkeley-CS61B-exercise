/*
C-level Exercise 1.1
Exercise 2.2.1: The curious reader might object and say that the IntList would be just as easy to
use if we simply wrote an addFirst method. Try to write an addFirst method to the IntList class.
You'll find that the resulting method is tricky as well as inefficient.
 */
package lec04;

public class IntList {

    public int first;
    public IntList rest;

    public IntList(int f, IntList r) {
        first = f;
        rest = r;
    }

    /**
     * Exercise 2.2.1: Try to write an addFirst method to the IntList class.
     */
    public void addFirst(int x) {
        // Can not modify "this" directly so can only add the new integer to the front and move
        // all integers towards the end of list.
        int prevFirst = first;
        this.first = x;

        IntList curList = this;
        int curFirst;
        while (curList.rest != null) {
            curList = curList.rest;
            curFirst = curList.first;
            curList.first = prevFirst;
            prevFirst = curFirst;
        }
        curList.rest = new IntList(prevFirst, null);
    }

    /**
     * Return the size of the list using... recursion!
     */
    public int size() {
        if (rest == null) {
            return 1;
        }
        return 1 + this.rest.size();
    }

    /**
     * Return the size of the list using no recursion!
     */
    public int iterativeSize() {
        IntList p = this;
        int totalSize = 0;
        while (p != null) {
            totalSize += 1;
            p = p.rest;
        }
        return totalSize;
    }

    /**
     * Returns the ith item of this IntList.
     */
    public int get(int i) {
        if (i == 0) {
            return first;
        }
        return rest.get(i - 1);
    }

    public static void main(String[] args) {
        IntList L = new IntList(15, null);
        L = new IntList(10, L);
        L = new IntList(5, L);

        System.out.println(L.get(100));
    }
}
