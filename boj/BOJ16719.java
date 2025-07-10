package boj;

import java.util.*;

public class BOJ16719 {
    private static FastReader SC = new FastReader();
    private static String STR;
    private static boolean[] VISITED;

    public static void main(String[] args) {
        input();
        solve();
    }

    private static void input() {
        STR = SC.nextLine();
        VISITED = new boolean[STR.length()];
    }

    private static void solve() {
        recFunc(0, STR.length() - 1);
    }

    private static void recFunc(int start, int end) {
        if (end < start) {
            return;
        }

        int idx = start;
        char prev = STR.charAt(start);
        for (int i = start + 1; i <= end; i++) {
            if (prev > STR.charAt(i)) {
                idx = i;
                prev = STR.charAt(i);
            }
        }
        VISITED[idx] = true;

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < STR.length(); i++) {
            if (VISITED[i]) {
                sb.append(STR.charAt(i));
            }
        }
        System.out.println(sb);

        recFunc(idx + 1, end);
        recFunc(start, idx - 1);
    }
}
