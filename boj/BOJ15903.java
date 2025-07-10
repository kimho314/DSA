package boj;

import java.util.PriorityQueue;

public class BOJ15903 {
    static FastReader SC = new FastReader();
    static int N, M;
    static int[] A;

    public static void main(String[] args) {
        N = SC.nextInt();
        M = SC.nextInt();
        A = new int[N];
        for (int i = 0; i < N; i++) {
            A[i] = SC.nextInt();
        }

        PriorityQueue<Long> pq = new PriorityQueue<>();
        for (int i = 0; i < N; i++) {
            pq.add((long) A[i]);
        }

        while (M > 0) {
            long x = pq.poll();
            long y = pq.poll();
            long sum = x + y;
            pq.add(sum);
            pq.add(sum);
            M--;
        }

        long res = 0;
        while (!pq.isEmpty()) {
            res += pq.poll();
        }
        System.out.println(res);
    }
}
