package boj;

import java.util.Arrays;
import java.util.HashMap;

public class BOJ16943 {
    private static FastReader SC = new FastReader();
    private static int[] A;
    private static int B;
    private static int MAX = -1;
    private static HashMap<Integer, Integer> MAP;

    public static void main(String[] args) {
        input();
        solve();
    }

    private static void solve() {
        MAP = new HashMap<>();
        for (int i = 0; i < A.length; i++) {
            MAP.put(A[i], MAP.getOrDefault(A[i], 0) + 1);
        }

        Arrays.sort(A);

        recFunc(0, "");

        System.out.println(MAX);
    }

    private static void recFunc(int k, String s) {
        if (k == A.length) {
            int num = Integer.parseInt(s);
            if (num < B) {
                MAX = Math.max(MAX, num);
            }
        } else {
            for (int i = 0; i < A.length; i++) {
                if (k == 0 && A[i] == 0) {
                    continue;
                }
                if (MAP.get(A[i]) <= 0) {
                    continue;
                }

                MAP.put(A[i], MAP.get(A[i]) - 1);
                recFunc(k + 1, s + A[i]);
                MAP.put(A[i], MAP.get(A[i]) + 1);
            }
        }
    }

    private static void input() {
        char[] ch = SC.next().toCharArray();
        A = new int[ch.length];
        for (int i = 0; i < A.length; i++) {
            A[i] = Integer.parseInt(String.valueOf(ch[i]));
        }
        B = SC.nextInt();
    }
}
