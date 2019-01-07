/*
A-Level Exercise 2: Complete problem 7 from midterm 1 from Spring 2015 here
(https://tbp.berkeley.edu/exams/4695/download/#page=9)

Question (a)
 */
package lec05;

/**
 * Interface implementation required in A-level exercise 2
 */
public class LengthComparator implements NullSafeStringComparator {

    /**
     * As defined in the exercise, comparison is based on length.
     */
    @Override
    public int compare(String s1, String s2) {
        if (s1 == null) {
            if (s2 == null) {
                return 0;
            } else {
                return Integer.MIN_VALUE;
            }
        } else {
            if (s2 == null) {
                return Integer.MAX_VALUE;
            } else {
                return s1.length() - s2.length();
            }
        }
    }
}
