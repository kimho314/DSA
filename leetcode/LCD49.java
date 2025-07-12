package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class LCD49 {
    public static void main(String[] args) {
        LCD49 sol = new LCD49();
        System.out.println(
                sol.groupAnagrams(new String[] {"eat", "tea", "tan", "ate", "nat", "bat"}));
        System.out.println(sol.groupAnagrams(new String[] {""}));
        System.out.println(sol.groupAnagrams(new String[] {"a"}));
    }

    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, ArrayList<String>> map = new HashMap<>();

        for (String elem : strs) {
            char[] chars = elem.toCharArray();
            Arrays.sort(chars);
            String tmp = new String(chars);

            if (!map.containsKey(tmp)) {
                map.put(tmp, new ArrayList<>());
            }
            map.get(tmp).add(elem);
        }

        return new ArrayList<>(map.values());
    }
}
