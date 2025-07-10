package boj;

import java.util.Arrays;

public class BOJ5545 {
    static FastReader SC = new FastReader();
    static int N;
    static int A, B;
    static int C;
    static int[] D;

    public static void main(String[] args) {
        input();
        solve();
    }

    private static void solve() {
        Arrays.sort(D);

        int res = C / A;
        int price = A;
        int calories = C;
        for (int i = N - 1; i >= 0; i--) {
            price += B;
            calories += D[i];
//            System.out.println(price + " " + calories + " " + calories / price);
            if (calories / price >= res) {
                res = calories / price;
            }
            else {
                break;
            }
        }

        System.out.println(res);
    }

    private static void input() {
        N = SC.nextInt();
        A = SC.nextInt();
        B = SC.nextInt();
        C = SC.nextInt();
        D = new int[N];
        for (int i = 0; i < N; i++) {
            D[i] = SC.nextInt();
        }
    }
}
