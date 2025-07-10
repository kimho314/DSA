package boj;

import java.util.ArrayList;
import java.util.List;

public class BOJ16198 {
    static FastReader SC = new FastReader();
    static int N;
    static List<Integer> W = new ArrayList<>();
    static int MAX = Integer.MIN_VALUE;

    public static void main(String[] args) {
        N = SC.nextInt();
        for (int i = 0; i < N; i++) {
            W.add(i, SC.nextInt());
        }

        solve(W, 0);
        System.out.println(MAX);
    }

    private static void solve(List<Integer> arr, int sum) {
        if (arr.size() == 2) {
            MAX = Math.max(MAX, sum);
            return;
        }

        for (int i = 1; i < arr.size() - 1; i++) {
            int tmp = arr.get(i);
            int chargeValue = arr.get(i - 1) * arr.get(i + 1);
            arr.remove(i);
            solve(arr, sum + chargeValue);
            arr.add(i, tmp);
        }
    }
}
