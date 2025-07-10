package leetcode;

import java.util.HashMap;
import java.util.Map;

public class LCD409 {
    public static void main(String[] args) {
        LCD409 sol = new LCD409();
        System.out.println(sol.longestPalindrome("abccccdd"));
        System.out.println(sol.longestPalindrome("a"));
        System.out.println(sol.longestPalindrome("aa"));
        System.out.println(sol.longestPalindrome("aab"));
        System.out.println(sol.longestPalindrome("ccc"));
    }

    public int longestPalindrome(String s) {
        if (s.length() <= 1) {
            return 1;
        }
        HashMap<Character, Integer> map = new HashMap<>();
        for (char ch : s.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
        int cnt1 = 0;
        int cnt2 = 0;
        for (Map.Entry<Character, Integer> elem : map.entrySet()) {
            int val = elem.getValue();
            if (val == 1) {
                cnt1++;
            } else {
                cnt2 += val / 2;
                cnt1 += val % 2;
            }
        }

        int res = 0;
        if (cnt1 > 0) {
            res += 1;
        }
        res += cnt2 * 2;
        // System.out.println(cnt1 + " " + cnt2);
        return res;
    }
}
