package boj;

import java.util.*;

public class BOJ1991 {
    private static FastReader SC = new FastReader();
    private static int N;
    private static char[][] MAP;
    private static StringBuilder SB = new StringBuilder();

    public static void main(String[] args) {
        input();
        solve();
    }

    private static void input() {
        N = SC.nextInt();
        MAP = new char['Z' - 'A' + 1][2];
        for (int i = 0; i < N; i++) {
            char root = SC.next().charAt(0);
            char left = SC.next().charAt(0);
            char right = SC.next().charAt(0);
            MAP[root - 'A'][0] = left;
            MAP[root - 'A'][1] = right;
        }
    }

    private static void solve() {
        preOrder('A');
        SB.append('\n');
        inOrder('A');
        SB.append('\n');
        postOrder('A');

        System.out.println(SB);
    }

    private static void postOrder(char ch) {
        if (ch == '.') {
            return;
        }
        int idx = ch - 'A';
        int l = MAP[idx][0];
        int r = MAP[idx][1];
        postOrder((char) l);
        postOrder((char) r);
        SB.append(ch);
    }

    private static void inOrder(char ch) {
        if (ch == '.') {
            return;
        }
        int idx = ch - 'A';
        int l = MAP[idx][0];
        int r = MAP[idx][1];
        inOrder((char) l);
        SB.append(ch);
        inOrder((char) r);
    }

    private static void preOrder(char ch) {
        if (ch == '.') {
            return;
        }
        SB.append(ch);
        int idx = ch - 'A';
        // System.out.println(ch + " " + idx);
        int l = MAP[idx][0];
        int r = MAP[idx][1];
        preOrder((char) (l));
        preOrder((char) (r));
    }
}
