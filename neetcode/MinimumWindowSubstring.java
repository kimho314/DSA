

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

    public String minWindow2(String s, String t) {
        if (t.isEmpty())
            return "";

        Map<Character, Integer> countT = new HashMap<>();
        Map<Character, Integer> window = new HashMap<>();
        for (char c : t.toCharArray()) {
            countT.put(c, countT.getOrDefault(c, 0) + 1);
        }

        int have = 0, need = countT.size();
        int[] res = {-1, -1};
        int resLen = Integer.MAX_VALUE;
        int l = 0;

        for (int r = 0; r < s.length(); r++) {
            char c = s.charAt(r);
            window.put(c, window.getOrDefault(c, 0) + 1);

            if (countT.containsKey(c) && window.get(c).equals(countT.get(c))) {
                have++;
            }

            while (have == need) {
                if ((r - l + 1) < resLen) {
                    resLen = r - l + 1;
                    res[0] = l;
                    res[1] = r;
                }

                char leftChar = s.charAt(l);
                window.put(leftChar, window.get(leftChar) - 1);
                if (countT.containsKey(leftChar) && window.get(leftChar) < countT.get(leftChar)) {
                    have--;
                }
                l++;
            }
        }

        return resLen == Integer.MAX_VALUE ? "" : s.substring(res[0], res[1] + 1);
    }
}
