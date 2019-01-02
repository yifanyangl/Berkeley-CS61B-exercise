/*
B-Level Exercise 1
 */
package lec05;

import java.util.Arrays;

public class Deck {

    public static int[] cards;

    Deck() {
        cards = new int[]{1, 3, 4, 10};
    }

    public static void main(String[] args) {
        Deck dingie = new Deck();
        dingie.cards[3] = 3;
        // 1, 3, 4, 3
        System.out.println(Arrays.toString(dingie.cards));

        Deck pilates = new Deck();
        pilates.cards[1] = 2;
        // pilates: 1, 2, 4, 10
        // dingie: 1, 2, 4, 10
        System.out.println(Arrays.toString(pilates.cards));
        System.out.println(Arrays.toString(dingie.cards));

        int[] newArrWhoDis = {2, 2, 4, 1, 3};
        dingie.cards = pilates.cards;
        pilates.cards = newArrWhoDis;
        newArrWhoDis = null;
        // pilates: 2, 2, 4, 1, 3
        // dingie: 2, 2, 4, 1, 3
        System.out.println(Arrays.toString(pilates.cards));
        System.out.println(Arrays.toString(dingie.cards));
    }
}
