package boj;

import java.util.PriorityQueue;

public class BOJ1715 {
    static FastReader SC = new FastReader();
    static int N;
    static int[] A;

    public static void main(String[] args) {
        N = SC.nextInt();
        A = new int[N];
        for (int i = 0; i < N; i++) {
            A[i] = SC.nextInt();
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < N; i++) {
            pq.add(A[i]);
        }
        int sum = 0;
        while (pq.size() > 1) {
            int n1 = pq.remove();
            int n2 = pq.remove();
            sum += (n1 + n2);
            pq.add(n1 + n2);
        }
        System.out.println(sum);
    }
}
