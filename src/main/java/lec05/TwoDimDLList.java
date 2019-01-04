/*
B-Level Exercise 2
Say we have a 2 dimensional DList. We want this 2-D DList to be as even as possible.
To do this we will try to fill up rows as uniformly as possible- meaning that not row will have
a greater size than any other row by more than 1 element.

Write a method that will take in a sub DList and add the given element if it fulfills the
constraints. If the constraints are not fulfilled, the item will be attempted to be put in the
DList below the one you attempted to insert in originally and so forth until the bottom most DList
is reached in which case move to the top DList.
 */
package lec05;

public class TwoDimDLList<T> {

    private DLList<DLList<T>> list;
    private int minSize;
    private int numMinSize;

    public TwoDimDLList(int size) {
        list = new DLList<>();
        for (int i = 0; i < size; i++) {
            list.addLast(new DLList<>());
        }
        minSize = 0;
        numMinSize = size;
    }

    public void addList(int posToAdd, DLList<T> listToAdd) {
        if (posToAdd < 0 || posToAdd >= list.size()) {
            throw new IndexOutOfBoundsException(String.format("Index %d out of bound", list.size()));
        }

        for (int i = 0; i < listToAdd.size(); i++) {
            T item = listToAdd.get(i);
            int posToAddEven = posToAdd;
            while (!addIfCanKeepEven(posToAddEven, item)) {
                posToAddEven = (posToAddEven + 1) % list.size();
            }
        }
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[");
        for (int i = 0; i < list.size(); i++) {
            stringBuilder.append(list.get(i).toList().toString());
            if (i != list.size() - 1) {
                stringBuilder.append(",");
            }
        }
        stringBuilder.append("]");
        return stringBuilder.toString().replace(" ", "");
    }

    /**
     * If adding an element to the specified position in the list can keep the list even, do it and
     * returns true, otherwise does nothing and returns false.
     *
     * <p>Uses two variables minSize and numMinSize to cache the information of whether the list is
     * even or not.
     *
     * <p>Without caching, the approach would be to iterate the list once to find out if it is even
     * or not.
     */
    private boolean addIfCanKeepEven(int pos, T item) {
        DLList<T> targetSubList = list.get(pos);
        if (list.get(pos).size() == minSize) {
            targetSubList.addLast(item);
            numMinSize -= 1;
            if (numMinSize == 0) {
                minSize += 1;
                numMinSize = list.size();
            }
            return true;
        } else {
            return false;
        }
    }
}
