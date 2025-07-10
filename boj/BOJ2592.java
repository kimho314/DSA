package boj;

import java.util.HashMap;
import java.util.Map;

public class BOJ2592 {
    private static FastReader SC = new FastReader();
    private static int[] NUMS;

    public static void main(String[] args) {
        input();
        solve();
    }

    private static void solve() {
        int avg = 0;
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < 10; i++) {
            avg += NUMS[i];
            map.put(NUMS[i], map.getOrDefault(NUMS[i], 0) + 1);
        }

        System.out.println(avg / 10);

        int max = 0;
        int mode = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() > max) {
                mode = entry.getKey();
                max = entry.getValue();
            }
        }

        System.out.println(mode);
    }

    private static void input() {
        NUMS = new int[10];
        for (int i = 0; i < 10; i++) {
            NUMS[i] = SC.nextInt();
        }
    }
}
