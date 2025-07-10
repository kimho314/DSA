package boj;

import java.util.ArrayDeque;
import java.util.ArrayList;

public class BOJ2161 {
    private static FastReader SC = new FastReader();
    private static int N;

    public static void main(String[] args) {
        input();
        solve();
    }

    private static void solve() {
        ArrayDeque<Integer> deque = new ArrayDeque<>();
        for (int i = 1; i <= N; i++) {
            deque.add(i);
        }

        ArrayList<Integer> list = new ArrayList<>();

        while (deque.size() > 1) {
            int n1 = deque.pollFirst();
            list.add(n1);

            int n2 = deque.pollFirst();
            deque.addLast(n2);
        }

        StringBuilder sb = new StringBuilder();
        for (int i : list) {
            sb.append(i).append(' ');
        }
        sb.append(deque.peek()).append(' ');
        System.out.println(sb);
    }

    private static void input() {
        N = SC.nextInt();
    }
}
