package lec06;

import lec04.SLList;

public class SpeedTestSLList {

    public static void main(String[] args) {
        SLList L = new SLList();
        int i = 0;
        while (i < 10000000) {
            L.addFirst(i);
            i = i + 1;
        }
    }
}
