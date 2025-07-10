package boj;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class BOJ2910 {
    static FastReader SC = new FastReader();
    static int N, C;
    static int[] A;

    static class Data implements Comparable<Data> {
        public int idx;
        public int cnt;

        public Data(int idx, int cnt) {
            this.idx = idx;
            this.cnt = cnt;
        }

        @Override
        public int compareTo(Data o) {
            if (o.cnt == this.cnt) {
                return this.idx - o.idx;
            }
            return o.cnt - this.cnt;
        }
    }

    static HashMap<Integer, Data> MAP = new HashMap<>();

    public static void main(String[] args) {
        input();
        solve();
    }

    private static void solve() {
        for (int i = 0; i < N; i++) {
            Data d = MAP.getOrDefault(A[i], null);
            if (d == null) {
                d = new Data(i, 1);
            }
            else {
                d.cnt++;
            }
            MAP.put(A[i], d);
        }

        ArrayList<Data> datas = new ArrayList<>(MAP.values());
        Collections.sort(datas);

        StringBuilder sb = new StringBuilder();
        for (Data data : datas) {
            for (int i = 0; i < data.cnt; i++) {
                sb.append(A[data.idx]).append(' ');
            }
        }

        System.out.println(sb.toString());
    }

    private static void input() {
        N = SC.nextInt();
        C = SC.nextInt();
        A = new int[N];
        for (int i = 0; i < N; i++) {
            A[i] = SC.nextInt();
        }
    }
}
