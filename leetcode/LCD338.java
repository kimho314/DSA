package leetcode;

import java.util.Arrays;

public class LCD338 {
    public static void main(String[] args) {
        LCD338 sol = new LCD338();
        System.out.println(Arrays.toString(sol.countBits(2)));
        System.out.println(Arrays.toString(sol.countBits(5)));
    }

    /**
     * If ( i ) is even, the number of 1s in ( i ) is the same as the number of 1s in ( i/2 )
     * (right-shifting an even number halves it without adding a new 1). If ( i ) is odd, the number
     * of 1s in ( i ) is the number of 1s in ( i - 1 ) plus one additional 1 (as adding 1 to an even
     * number makes it odd).
     */
    public int[] countBits(int n) {

        int[] arr = new int[n + 1];

        arr[0] = 0;

        for (int i = 1; i < n + 1; i++) {
            arr[i] = arr[i >> 1] + (i & 1);
        }

        return arr;
    }
}
