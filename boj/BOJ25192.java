package boj;

import java.util.HashMap;
import java.util.Map;

public class BOJ25192 {
    static FastReader SC = new FastReader();
    static int N;

    public static void main(String[] args) {
        N = SC.nextInt();
        Map<String, Integer> map = new HashMap<>();

        int cnt = 0;
        for (int i = 0; i < N; i++) {
            String input = SC.nextLine();
            if (input.equals("ENTER")) {
                map.clear();
            }
            else {
                if (!map.containsKey(input)) {
                    cnt++;
                }
                map.put(input, map.getOrDefault(input, 0) + 1);
            }
        }
        System.out.println(cnt);
    }
}
