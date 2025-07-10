package boj;

import java.util.ArrayList;

public class BOJ2455 {
    private static FastReader SC = new FastReader();
    private static ArrayList<Data> DATAS = new ArrayList<>();

    private static class Data {
        public int out;
        public int in;

        public Data(int out, int in) {
            this.out = out;
            this.in = in;
        }
    }

    public static void main(String[] args) {
        input();
        solve();
    }

    private static void solve() {
        int res = 0;
        int net = 0;
        for (Data d : DATAS) {
            net = net - d.out + d.in;
            res = Math.max(res, net);
        }

        System.out.println(res);
    }

    private static void input() {
        for (int i = 0; i < 4; i++) {
            int out = SC.nextInt();
            int in = SC.nextInt();
            Data d = new Data(out, in);
            DATAS.add(d);
        }
    }
}
