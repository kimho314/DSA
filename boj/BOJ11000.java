package boj;

import java.util.*;

public class BOJ11000 {
    private static FastReader SC = new FastReader();
    private static int N;
    private static int[][] CLASS;

    public static void main(String[] args) {
        input();
        solve();
    }

    private static void input() {
        N = SC.nextInt();
        CLASS = new int[N][2];
        for (int i = 0; i < N; i++) {
            CLASS[i][0] = SC.nextInt();
            CLASS[i][1] = SC.nextInt();
        }
    }

    private static void solve() {
        Arrays.sort(CLASS, (o1, o2) -> {
            if (o1[0] == o2[0]) {
                return o1[1] - o2[1];
            }
            return o1[0] - o2[0];
        });

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int res = 0;

        for (int i = 0; i < N; i++) {
            if (pq.isEmpty()) {
                res++;
                pq.add(CLASS[i][1]);
            } else {
                int time = pq.peek();
                if (time <= CLASS[i][0]) {
                    pq.poll();
                    pq.add(CLASS[i][1]);
                } else {
                    res++;
                    pq.add(CLASS[i][1]);
                }
            }
        }

        System.out.println(res);
    }
}
