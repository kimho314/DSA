package boj;

import java.util.HashSet;

public class BOJ2052 {
    private static FastReader SC = new FastReader();
    private static int[] NUMS;

    public static void main(String[] args) {
        input();
        solve();
    }

    private static void solve() {
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < 10; i++) {
            set.add(NUMS[i] % 42);
        }

        System.out.println(set.size());
    }

    private static void input() {
        NUMS = new int[10];
        for (int i = 0; i < 10; i++) {
            NUMS[i] = SC.nextInt();
        }
    }
}
