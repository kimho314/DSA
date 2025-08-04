package neetcode;

import java.util.HashMap;

public class LongestSubstringWithoutRepeatingCharacters {
    public static void main(String[] args) {
        LongestSubstringWithoutRepeatingCharacters sol =
                new LongestSubstringWithoutRepeatingCharacters();
        System.out.println(sol.lengthOfLongestSubstring("abcabcbb"));
        System.out.println(sol.lengthOfLongestSubstring("bbbbb"));
        System.out.println(sol.lengthOfLongestSubstring("pwwkew"));
    }

    public int lengthOfLongestSubstring(String s) {
        int l = 0;
        int r = 0;
        int len = s.length();
        int res = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        while (l < len) {
            if (l > 0) {
                int cnt = map.getOrDefault(s.charAt(l - 1), 0);
                --cnt;
                map.put(s.charAt(l - 1), cnt);
            }
            while (r < len && map.getOrDefault(s.charAt(r), 0) == 0) {
                map.put(s.charAt(r), 1);
                r++;
            }
            res = Math.max(res, r - l);
            l++;
        }

        return res;
    }
}
