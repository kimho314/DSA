package boj;

import java.util.PriorityQueue;

public class BOJ11286 {
    static FastReader SC = new FastReader();
    static int N;
    static int[] X;

    public static void main(String[] args) {
        input();
        solve();
    }

    private static void solve() {
        StringBuilder sb = new StringBuilder();
        PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> {
            int abs1 = Math.abs(o1);
            int abs2 = Math.abs(o2);

            if (abs1 == abs2) {
                return o1 - o2;
            }
            return abs1 - abs2;
        });

        for (int i = 0; i < N; i++) {
            int n = X[i];
            if (n == 0) {
                int num = pq.isEmpty() ? 0 : pq.poll();
                sb.append(num).append('\n');
            }
            else {
                pq.add(n);
            }
        }

        System.out.println(sb.toString());
    }

    private static void input() {
        N = SC.nextInt();
        X = new int[N];
        for (int i = 0; i < N; i++) {
            X[i] = SC.nextInt();
        }
    }
}
