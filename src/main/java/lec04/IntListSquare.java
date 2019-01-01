/*
A-level Exercise 2:
Modify the IntList class so that every time you add a value
you “square” the IntList.
For example, upon the insertion of 5, the below IntList would transform from:

1 => 2 to 1 => 1 => 2 => 4 => 5

and if 7 was added to the latter IntList, it would become

1 => 1 => 1 => 1 => 2 => 4 => 4 => 16 => 5 => 25 => 7

Additionally, you are provided the constraint that you can only access the size() function one time
during the entire process of adding a node.
 */
package lec04;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class IntListSquare {

    private int first;
    private IntListSquare rest;

    public IntListSquare(int f, IntListSquare r) {
        first = f;
        rest = r;
    }

    public int size() {
        if (rest == null) {
            return 1;
        }
        return 1 + this.rest.size();
    }

    public List<Integer> toList() {
        if (rest == null) {
            return Arrays.asList(first);
        }
        List<Integer> res = new LinkedList<>();
        res.add(first);
        res.addAll(rest.toList());
        return res;
    }

    public void addLast(int x) {
        rest = new IntListSquare(first * first, rest);
        if (rest.rest == null) {
            rest.rest = new IntListSquare(x, null);
            return;
        }
        rest.rest.addLast(x);
    }
}
