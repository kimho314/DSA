package boj;

import java.util.PriorityQueue;

public class BOJ1927 {
    static FastReader SC = new FastReader();
    static int N;
    static StringBuilder SB = new StringBuilder();

    public static void main(String[] args) {
        N = SC.nextInt();
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < N; i++) {
            int input = SC.nextInt();
            if (input == 0) {
                int x = pq.isEmpty() ? 0 : pq.poll();
                SB.append(x).append('\n');
            }
            else {
                pq.offer(input);
            }
        }
        System.out.println(SB.toString());
    }
}
