package boj;

import java.util.ArrayDeque;

public class BOJ2346 {
    private static FastReader SC = new FastReader();
    private static int N;
    private static ArrayDeque<Data> DQ = new ArrayDeque<>();

    private static class Data {
        public int cur;
        public int next;

        public Data(int cur, int next) {
            this.cur = cur;
            this.next = next;
        }
    }

    public static void main(String[] args) {
        input();
        solve();
    }

    private static void solve() {
        StringBuilder sb = new StringBuilder();

        Data data = DQ.pollFirst();
        sb.append(data.cur).append(" ");
        while (!DQ.isEmpty()) {
            if (data.next > 0) {
                for (int i = 0; i < data.next - 1; i++) {
                    DQ.addLast(DQ.pollFirst());
                }
                data = DQ.pollFirst();
                sb.append(data.cur).append(" ");
                continue;
            }
            if (data.next < 0) {
                for (int i = 0; i < Math.abs(data.next) - 1; i++) {
                    DQ.addFirst(DQ.pollLast());
                }
                data = DQ.pollLast();
                sb.append(data.cur).append(" ");
            }
        }
        System.out.println(sb.toString());
    }

    private static void input() {
        N = SC.nextInt();
        for (int i = 1; i <= N; i++) {
            DQ.addLast(new Data(i, SC.nextInt()));
        }
    }
}
