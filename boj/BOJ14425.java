package boj;

import java.util.HashMap;
import java.util.Map;

public class BOJ14425 {
    static FastReader SC = new FastReader();
    static int N, M;
    static Map<String, Integer> S = new HashMap<>();

    public static void main(String[] args) {
        N = SC.nextInt();
        M = SC.nextInt();
        for (int i = 0; i < N; i++) {
            String s = SC.nextLine();
            S.put(s, 1);
        }

        int cnt = 0;
        for (int i = 0; i < M; i++) {
            String input = SC.nextLine();
            if (S.containsKey(input)) {
                cnt++;
            }
        }
        System.out.println(cnt);
    }
}
