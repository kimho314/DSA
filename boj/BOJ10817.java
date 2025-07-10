package boj;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class BOJ10817 {
    private static FastReader SC = new FastReader();
    private static int A, B, C;

    public static void main(String[] args) {
        input();
        solve();
    }

    private static void solve() {
        ArrayList<Integer> list = new ArrayList<>(Arrays.asList(A, B, C));
        Collections.sort(list);
        System.out.println(list.get(list.size() - 2));
    }

    private static void input() {
        A = SC.nextInt();
        B = SC.nextInt();
        C = SC.nextInt();
    }
}
