package boj;

import java.util.Comparator;
import java.util.PriorityQueue;

public class BOJ11279 {
    static FastReader SC = new FastReader();
    static int N;
    static StringBuilder SB = new StringBuilder();

    public static void main(String[] args) {
        N = SC.nextInt();
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        for (int i = 0; i < N; i++) {
            int input = SC.nextInt();
            if (input == 0) {
                if (pq.isEmpty()) {
                    SB.append(0).append('\n');
                }
                else {
                    SB.append(pq.poll()).append('\n');
                }
            }
            else {
                pq.add(input);
            }
        }

        System.out.println(SB.toString());
    }
}
