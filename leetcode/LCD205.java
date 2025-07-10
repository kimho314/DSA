package leetcode;

import java.util.*;

public class LCD205 {
    public static void main(String[] args) {
        LCD205 sol = new LCD205();
        System.out.println(sol.isIsomorphic("egg", "add"));
        System.out.println(sol.isIsomorphic("foo", "bar"));
        System.out.println(sol.isIsomorphic("paper", "title"));
        System.out.println(sol.isIsomorphic("badc", "baba"));
    }

    public boolean isIsomorphic(String s, String t) {
        HashMap<Character, Character> map1 = new HashMap<>();
        HashMap<Character, Character> map2 = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            Character ch = map1.getOrDefault(s.charAt(i), null);
            Character ch2 = map2.getOrDefault(t.charAt(i), null);

            if (ch != null && ch != t.charAt(i)) {
                return false;
            }
            if (ch == null && ch2 != null) {
                return false;
            }

            if (ch == null && ch2 == null) {
                map1.put(s.charAt(i), t.charAt(i));
                map2.put(t.charAt(i), s.charAt(i));
            }
        }

        return true;
    }
}
