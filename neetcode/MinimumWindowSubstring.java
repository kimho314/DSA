package neetcode;

import java.util.*;

public class MinimumWindowSubstring {
    public static void main(String[] args) {
        MinimumWindowSubstring sol = new MinimumWindowSubstring();
        System.out.println(sol.minWindow("ADOBECODEBANC", "ABC"));
        System.out.println(sol.minWindow("a", "a"));
        System.out.println(sol.minWindow("a", "aa"));
    }

    public String minWindow(String s, String t) {
        if (s.length() < t.length()) {
            return "";
        }

        HashMap<Character, Integer> countT = new HashMap<>();
        for (char elem : t.toCharArray()) {
            countT.put(elem, countT.getOrDefault(elem, 0) + 1);
        }

        String res = "";
        for (int i = 0; i < s.length(); i++) {
            for (int j = i; j < s.length(); j++) {
                String sub = s.substring(i, j + 1);
                HashMap<Character, Integer> countS = new HashMap<>();
                for (char elem : sub.toCharArray()) {
                    countS.put(elem, countS.getOrDefault(elem, 0) + 1);
                }

                boolean isIncluded = true;
                for (char elem : t.toCharArray()) {
                    int cnt1 = countT.get(elem);
                    int cnt2 = countS.getOrDefault(elem, 0);

                    if (cnt1 > cnt2) {
                        isIncluded = false;
                        break;
                    }
                }

                if (isIncluded) {
                    if (res.equals("") || (!res.equals("") && res.length() > sub.length())) {
                        res = sub;
                    }
                }
            }

        }

        return res;
    }
}
