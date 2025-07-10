package boj;

import java.util.Arrays;

public class BOJ9237 {
    static FastReader SC = new FastReader();
    static int N;
    static int[] TREES;

    public static void main(String[] args) {
        N = SC.nextInt();
        TREES = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            TREES[i] = SC.nextInt();
        }
        Arrays.sort(TREES);
        int[] copyTrees = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            copyTrees[i] = TREES[N - i + 1];
        }

        int max = Integer.MIN_VALUE;
        for (int i = 1; i <= N; i++) {
            int days = i + copyTrees[i];
            max = Math.max(max, days);
        }
        System.out.println(max + 1);
    }
}
