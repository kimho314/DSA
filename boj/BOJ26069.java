package boj;

import java.util.HashMap;
import java.util.Map;

public class BOJ26069 {
    static FastReader SC = new FastReader();
    static int N;
    static String startName = "ChongChong";

    public static void main(String[] args) {
        N = SC.nextInt();

        Map<String, Integer> map = new HashMap<>();
        int cnt = 0;

        for (int i = 0; i < N; i++) {
            String input1 = SC.next();
            String input2 = SC.next();


            if (input1.equals(startName) && !map.containsKey(input1) && !map.containsKey(input2)) {
                cnt += 2;
                map.put(input1, 1);
                map.put(input2, 1);
            } else if (input2.equals(startName) && !map.containsKey(input2)
                    && !map.containsKey(input1)) {
                cnt += 2;
                map.put(input1, 1);
                map.put(input2, 1);
            } else if (map.containsKey(input1) && !map.containsKey(input2)) {
                map.put(input2, 1);
                cnt++;
            } else if (map.containsKey(input2) && !map.containsKey(input1)) {
                map.put(input1, 1);
                cnt++;
            }
        }

        System.out.println(cnt);
    }
}
