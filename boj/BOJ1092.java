package boj;

import java.util.*;

public class BOJ1092 {
    private static FastReader SC = new FastReader();
    private static int N, M;
    private static ArrayList<Integer> CRANE = new ArrayList<>();
    private static ArrayList<Integer> BOX = new ArrayList<>();

    public static void main(String[] args) {
        input();
        solve();
    }

    private static void input() {
        N = SC.nextInt();
        for (int i = 0; i < N; i++) {
            CRANE.add(SC.nextInt());
        }
        M = SC.nextInt();
        for (int i = 0; i < M; i++) {
            BOX.add(SC.nextInt());
        }
    }

    private static void solve() {
        CRANE.sort(Collections.reverseOrder());
        BOX.sort(Collections.reverseOrder());

        if (CRANE.get(0) < BOX.get(0)) {
            System.out.println(-1);
            return;
        }

        int day = 0;
        while (!BOX.isEmpty()) {
            int boxIdx = 0;
            int craneIdx = 0;

            while (craneIdx < N) {
                if (boxIdx == BOX.size()) {
                    break;
                } else if (CRANE.get(craneIdx) >= BOX.get(boxIdx)) {
                    BOX.remove(boxIdx);
                    craneIdx++;
                } else {
                    boxIdx++;
                }
            }

            day++;
        }

        System.out.println(day);
    }
}
