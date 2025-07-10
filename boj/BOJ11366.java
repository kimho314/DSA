package boj;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BOJ11366 {
    static FastReader SC = new FastReader();
    static int N, K;

    public static void main(String[] args) {
        N = SC.nextInt();
        K = SC.nextInt();
        Queue<Integer> q = new LinkedList<>();
        for (int i = 1; i <= N; i++) {
            q.add(i);
        }

        List<String> list = new ArrayList<>();
        int cnt = 0;
        while (!q.isEmpty()) {
            int x = q.poll();
            ++cnt;
            if (cnt % K == 0) {
                list.add(String.valueOf(x));
                continue;
            }

            q.add(x);
        }

        System.out.print("<");
        System.out.print(String.join(", ", list));
        System.out.println(">");
    }
}
