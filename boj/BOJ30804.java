package boj;

import java.util.HashMap;

public class BOJ30804 {
    private static FastReader SC = new FastReader();
    private static int N;
    private static int[] S;

    public static void main(String[] args) {
        input();
        solve();
    }

    private static void solve() {
        HashMap<Integer, Integer> fruitsCnt = new HashMap<>();
        int maxLength = 0;
        int left = 0;

        for (int right = 0; right < N; right++) {
            fruitsCnt.put(S[right], fruitsCnt.getOrDefault(S[right], 0) + 1);

            while (fruitsCnt.size() > 2) {
                fruitsCnt.put(S[left], fruitsCnt.get(S[left]) - 1);

                if (fruitsCnt.get(S[left]) == 0) {
                    fruitsCnt.remove(S[left]);
                }

                left++;
            }
            maxLength = Math.max(maxLength, right - left + 1);
        }
        System.out.println(maxLength);
    }


    private static void input() {
        N = SC.nextInt();
        S = new int[N];
        for (int i = 0; i < N; i++) {
            S[i] = SC.nextInt();
        }
    }
}
