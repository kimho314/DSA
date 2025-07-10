package boj;

import java.util.HashMap;
import java.util.Map;

public class BOJ11478 {
    static FastReader SC = new FastReader();

    public static void main(String[] args) {
        String s = SC.nextLine();
        Map<String, Integer> map = new HashMap<>();

        for (int len = 1; len <= s.length(); len++) {
            for (int i = 0; i < s.length() - len + 1; i++) {
                String subString = s.substring(i, i + len);
                Integer num = map.getOrDefault(subString, 0);
                if (num == 0) {
                    map.put(subString, 1);
                }
                else {
                    map.put(subString, num + 1);
                }
            }
        }
        System.out.println(map.size());
    }
}
