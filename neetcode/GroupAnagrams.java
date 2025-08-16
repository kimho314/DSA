

import java.util.*;
import java.io.*;
import java.math.*;

/**
 * https://neetcode.io/problems/anagram-groups?list=neetcode150
 */
public class GroupAnagrams {
    public static void main(String[] args) {
        GroupAnagrams sol = new GroupAnagrams();
        System.out.println(
                sol.groupAnagrams(new String[] {"act", "pots", "tops", "cat", "stop", "hat"})); // [["hat"],["act",
                                                                                                // "cat"],["stop",
                                                                                                // "pots",
                                                                                                // "tops"]]
        System.out.println(sol.groupAnagrams(new String[] {"x"})); // [["x"]]
        System.out.println(sol.groupAnagrams(new String[] {""})); // [[""]]
    }

    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<>();

        for (String elem : strs) {
            char[] arr = elem.toCharArray();
            Arrays.sort(arr);
            String s = new String(arr);
            map.putIfAbsent(s, new ArrayList<>());
            map.get(s).add(elem);
        }

        return new ArrayList<>(map.values());
    }
}
