/*
Exercise of Discussion 3, second-half part.

2.1
Consider a method that inserts item into array arr at the given position. The method should return
the resulting array. For example, if x = [5, 9, 14, 15], item = 6, and position = 2, then the
method should return [5, 9, 6, 14, 15]. If position is past the end of the array, insert item at
the end of the array.

Is it possible to write a version of this method that returns void and changes arr in place
(i.e., destructively)?
Not possible. Array is re-created and the reference value passed as parameter can not be
changed.


2.2
Consider a method that destructively reverses the items in arr.
For example calling reverse on an array [1, 2, 3] should change the array to be [3, 2, 1].

What is the fewest number of iteration steps you need? What is the fewest number of additional
variables you need?

2.3
Write a non-destructive method replicate(int[] arr) that replaces the number at index i with arr[i]
copies of itself. For example, replicate([3, 2, 1]) would return [3, 3, 3, 2, 2, 1].
 */
package lec06;

public class Discussion3Arrays {

    public static int[] insert(int[] arr, int item, int position) {
        if (position < 0) {
            throw new IndexOutOfBoundsException("Position out of bound");
        }
        if (position > arr.length - 1) {
            position = arr.length;
        }
        int[] newArr = new int[arr.length + 1];
        System.arraycopy(arr, 0, newArr, 0, position);
        newArr[position] = item;
        System.arraycopy(arr, position, newArr, position + 1, arr.length - position);
        return newArr;
    }

    public static void reverse(int[] arr) {
        for (int i = 0, j = arr.length - 1; i < j; i++, j--) {
            int temp = arr[j];
            arr[j] = arr[i];
            arr[i] = temp;
        }
    }

    public static int[] replicate(int[] arr) {
        int[] newArr = new int[arr.length];
        int curPos = 0;
        for (int item : arr) {
            // For item <= 0, does not add it to the result.
            // Hence, resulting array might be shorter.
            for (int counter = 0; counter < item; counter++) {
                if (curPos >= newArr.length - 1) {
                    newArr = resizeArray(newArr, newArr.length * 2);
                }
                newArr[curPos] = item;
                curPos++;
            }
        }
        // curPos == size. Removes any extra untouched items.
        return resizeArray(newArr, curPos);
    }

    private static int[] resizeArray(int[] arr, int size) {
        int[] res = new int[size];
        System.arraycopy(arr, 0, res, 0, arr.length > size ? size : arr.length);
        return res;
    }
}
