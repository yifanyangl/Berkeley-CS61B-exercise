package lec05;

/**
 * Interface defined in A-level exercise 2
 */
public interface NullSafeStringComparator {

    /**
     * Returns a negative number if s1 is 'less than' s2, 0 if 'equal', and a positive number
     * otherwise. Null is considered less than any string. If both inputs are null, return 0.
     */
    int compare(String s1, String s2);
}
