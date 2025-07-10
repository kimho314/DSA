package boj;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.stream.Collectors;

public class BOJ1158 {
    private static FastReader SC = new FastReader();
    private static int N, K;
    private static ArrayDeque<Integer> NUMS = new ArrayDeque<>();

    public static void main(String[] args) {
        input();
        solve();
    }

    private static void solve() {
        int cnt = 0;
        ArrayList<Integer> res = new ArrayList<>();

        while (!NUMS.isEmpty()) {
            cnt++;
            int remove = NUMS.pollFirst();
            if (cnt % K == 0) {
                res.add(remove);
                continue;
            }

            NUMS.addLast(remove);
        }

        String join = res.stream().map(it -> String.valueOf(it)).collect(Collectors.joining(", "));
        String str = "<" + join + ">";
        System.out.println(str);
    }

    private static void input() {
        N = SC.nextInt();
        K = SC.nextInt();
        for (int i = 1; i <= N; i++) {
            NUMS.addLast(i);
        }
    }
}
