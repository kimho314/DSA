package boj;

import java.util.*;

public class BOJ15787 {
    private static FastReader SC = new FastReader();
    private static int[][] TRAINS;
    private static int N, M;

    public static void main(String[] args) {
        input();
        solve();
    }

    private static void solve() {
        while (M > 0) {
            M--;
            int op = SC.nextInt();
            switch (op) {
                case 1:
                    op1(SC.nextInt(), SC.nextInt());
                    break;
                case 2:
                    op2(SC.nextInt(), SC.nextInt());
                    break;
                case 3:
                    op3(SC.nextInt());
                    break;
                case 4:
                    op4(SC.nextInt());
                    break;
            }
            // print();
        }

        int cnt = check();
        System.out.println(cnt);
    }

    private static void print() {
        for (int i = 0; i < N; i++) {
            System.out.println(Arrays.toString(TRAINS[i]));
        }
    }


    private static int check() {
        HashSet<String> list = new HashSet<>();
        for (int i = 0; i < N; i++) {
            String str = convert(TRAINS[i]);
            list.add(str);
        }
        return list.size();
    }

    private static String convert(int[] arr) {
        StringBuilder sb = new StringBuilder();
        for (int elem : arr) {
            String s = elem == 0 ? "X" : "O";
            sb.append(s);
        }
        return sb.toString();
    }

    private static void op4(int i) {
        if (TRAINS[i - 1][0] == 1) {
            TRAINS[i - 1][0] = 0;
        }
        for (int t = 0; t < 19; t++) {
            TRAINS[i - 1][t] = TRAINS[i - 1][t + 1];
            if (TRAINS[i - 1][t + 1] == 1) {
                TRAINS[i - 1][t + 1] = 0;
            }
        }
    }

    private static void op3(int i) {
        if (TRAINS[i - 1][19] == 1) {
            TRAINS[i - 1][19] = 0;
        }
        for (int t = 18; t >= 0; t--) {
            TRAINS[i - 1][t + 1] = TRAINS[i - 1][t];
            if (TRAINS[i - 1][t] == 1) {
                TRAINS[i - 1][t] = 0;
            }
        }
    }

    private static void op2(int i, int x) {
        if (TRAINS[i - 1][x - 1] == 1) {
            TRAINS[i - 1][x - 1] = 0;
        }
    }

    private static void op1(int i, int x) {
        if (TRAINS[i - 1][x - 1] == 0) {
            TRAINS[i - 1][x - 1] = 1;
        }
    }

    private static void input() {
        N = SC.nextInt();
        M = SC.nextInt();
        TRAINS = new int[N][20];
    }
}
