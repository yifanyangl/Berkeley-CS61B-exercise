/*
A-Level Exercise 2: Complete problem 7 from midterm 1 from Spring 2015 here
(https://tbp.berkeley.edu/exams/4695/download/#page=9)

Question (b) (c)
 */
package lec05;

public class ALevel2 {

    public static String max(String[] a, NullSafeStringComparator sc) {
        String maxStr = a[0];
        for (int i = 1; i < a.length; i++) {
            if (sc.compare(a[i], maxStr) > 0) {
                maxStr = a[i];
            }
        }
        return maxStr;
    }

    public static String[][] step(String[][] arr) {
        String[][] stepped = new String[arr.length][arr[0].length];

        for (int i = 1; i < arr.length - 1; i++) {
            for (int j = 1; j < arr[0].length - 1; j++) {
                String[] temp = new String[9];
                int n = 0;
                for (int k = -1; k <= 1; k += 1) {
                    for (int m = -1; m <= 1; m += 1) {
                        temp[n] = arr[i + k][j + m];
                        n += 1;
                    }
                }
                stepped[i][j] = max(temp, new LengthComparator());
            }
        }
        return stepped;
    }
}
