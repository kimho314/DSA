package boj;

import java.util.LinkedList;
import java.util.Queue;

public class BOJ2164 {
    static FastReader SC = new FastReader();
    static int N;

    public static void main(String[] args) {
        N = SC.nextInt();
        Queue<Integer> q = new LinkedList<>();
        for (int i = 1; i <= N; i++) {
            q.add(i);
        }

        while (q.size() > 1) {
            q.remove();
            int second = q.remove();
            q.add(second);
        }
        System.out.println(q.peek());
    }
}
