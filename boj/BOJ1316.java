package boj;

import java.util.HashMap;
import java.util.Map;

public class BOJ1316 {
    static FastReader SC = new FastReader();

    public static void main(String[] args) {
        int n = SC.nextInt();
        int cnt = 0;

        for (int i = 0; i < n; i++) {
            String[] str = SC.nextLine().split("");
            Map<String, Integer> map = new HashMap<>();
            boolean flag = true;
            for (int j = 0; j < str.length; j++) {
                int lastIdx = map.getOrDefault(str[j], -1);
                if (lastIdx == -1) {
                    map.put(str[j], j);
                }
                else {
                    if (lastIdx + 1 != j) {
                        flag = false;
                        break;
                    }
                    map.put(str[j], j);
                }
            }
            if (flag) {
                cnt++;
            }
        }

        System.out.println(cnt);
    }
}
