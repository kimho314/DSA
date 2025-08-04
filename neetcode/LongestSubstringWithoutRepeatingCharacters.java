package neetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

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

    public int lengthOfLongestSubstring2(String s) {
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            Set<Character> charSet = new HashSet<>();
            for (int j = i; j < s.length(); j++) {
                if (charSet.contains(s.charAt(j))) {
                    break;
                }
                charSet.add(s.charAt(j));
            }
            res = Math.max(res, charSet.size());
        }
        return res;
    }

    public int lengthOfLongestSubstring3(String s) {
        HashMap<Character, Integer> mp = new HashMap<>();
        int l = 0, res = 0;

        for (int r = 0; r < s.length(); r++) {
            if (mp.containsKey(s.charAt(r))) {
                l = Math.max(mp.get(s.charAt(r)) + 1, l);
            }
            mp.put(s.charAt(r), r);
            res = Math.max(res, r - l + 1);
        }
        return res;
    }
}
