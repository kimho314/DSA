package boj;

import java.util.*;

public class BOJ2075 {
    private static FastReader SC = new FastReader();
    private static int N;
    private static PriorityQueue<Integer> PQ = new PriorityQueue<>(Comparator.reverseOrder());;

    public static void main(String[] args) {
        input();
        solve();
    }

    private static void input() {
        N = SC.nextInt();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                PQ.add(SC.nextInt());
            }
        }
    }

    private static void solve() {
        int res = 0;
        while (N > 0) {
            N--;
            res = PQ.poll();
        }

        System.out.println(res);
    }
}
