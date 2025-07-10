package boj;

import java.util.Arrays;

public class BOJ1475 {
    private static FastReader SC = new FastReader();
    private static int[] NUMS;
    private static int[] A;

    public static void main(String[] args) {
        input();
        solve();
    }

    private static void solve() {
        int cnt = 1;
        for (int i = 0; i < NUMS.length; i++) {
            if (A[NUMS[i]] <= 0) {
                if (NUMS[i] == 6 && A[9] >= 1) {
                    A[9]--;
                }
                else if (NUMS[i] == 9 && A[6] >= 1) {
                    A[6]--;
                }
                else {
                    cnt++;
                    for (int j = 0; j < 10; j++) {
                        A[j]++;
                    }
                    A[NUMS[i]]--;
                }
            }
            else {
                A[NUMS[i]]--;
            }
        }

        System.out.println(cnt);
    }

    private static void input() {
        char[] chs = SC.next().toCharArray();
        NUMS = new int[chs.length];
        for (int i = 0; i < chs.length; i++) {
            NUMS[i] = Integer.parseInt(String.valueOf(chs[i]));
        }
        A = new int[10];
        Arrays.fill(A, 1);
    }
}
