package boj;

import java.util.Comparator;
import java.util.PriorityQueue;

public class BOJ1417 {
    static FastReader SC = new FastReader();
    static int N;
    static int[] A;

    public static void main(String[] args) {
        N = SC.nextInt();
        A = new int[N];
        for (int i = 0; i < N; i++) {
            A[i] = SC.nextInt();
        }

        int no1 = A[0];
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        for (int i = 1; i < N; i++) {
            if (A[i] >= no1) {
                pq.add(A[i]);
            }
        }

        int cnt = 0;
        while (!pq.isEmpty()) {
            int n = pq.poll();
            if (n < no1) {
                continue;
            }
            n--;
            cnt++;
            no1++;
            if (n >= no1) {
                pq.add(n);
            }
        }
        System.out.println(cnt);
    }
}
