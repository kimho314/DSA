package boj;

import java.util.Arrays;

public class BOJ1356 {
    private static FastReader SC = new FastReader();
    private static char[] N;

    public static void main(String[] args) {
        input();
        solve();
    }

    private static void solve() {
        boolean flag = false;

        if (N.length == 1) {
            System.out.println("NO");
            return;
        }
        for (int i = 0; i < N.length - 1; i++) {
            char[] arr1 = Arrays.copyOfRange(N, 0, i + 1);
            char[] arr2 = Arrays.copyOfRange(N, i + 1, N.length);

            long mul1 = 1;
            for (int j = 0; j < arr1.length; j++) {
                mul1 *= Integer.parseInt(String.valueOf(arr1[j]));
            }
            long mul2 = 1;
            for (int j = 0; j < arr2.length; j++) {
                mul2 *= Integer.parseInt(String.valueOf(arr2[j]));
            }

            if (mul1 == mul2) {
                flag = true;
                break;
            }
        }

        if (flag) {
            System.out.println("YES");
        }
        else {
            System.out.println("NO");
        }
    }

    private static void input() {
        N = SC.nextLine().toCharArray();
    }
}
