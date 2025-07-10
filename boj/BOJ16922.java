package boj;

import java.util.ArrayList;
import java.util.List;

public class BOJ16922 {
    static FastReader SC = new FastReader();
    static int N;
    static int[] NUMS = new int[]{1, 5, 10, 50};
    static List<Integer> SUMS;
    static boolean[] USED;
    static int CNT = 0;

    public static void main(String[] args) {
        N = SC.nextInt();
        SUMS = new ArrayList<>();
        USED = new boolean[50 * 20 + 1];

        recFunc(1, 0, 0);
        System.out.println(SUMS);
        System.out.println(CNT);
    }

    private static void recFunc(int k, int start, int sum) {
        if (k == N + 1) {
            if (!USED[sum]) {
                CNT++;
                SUMS.add(sum);
                USED[sum] = true;
            }
        }
        else {
            for (int i = start; i < 4; i++) {
                recFunc(k + 1, i, sum + NUMS[i]);
            }
        }
    }
}
