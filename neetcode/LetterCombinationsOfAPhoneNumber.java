package neetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LetterCombinationsOfAPhoneNumber {

    public static void main(String[] args) {
        LetterCombinationsOfAPhoneNumber sol = new LetterCombinationsOfAPhoneNumber();
        List<String> ret = sol.letterCombinations("34");
        IO.println(ret);
        ret = sol.letterCombinations("");
        IO.println(ret);
    }

    public List<String> letterCombinations(String digits) {
        if (digits.isEmpty() || digits.length() <= 0) {
            return new ArrayList<>();
        }
        Map<Character, List<Character>> map = new HashMap<>();
        map.put('0', new ArrayList<>());
        map.put('1', new ArrayList<>());
        map.put('2', List.of('a', 'b', 'c'));
        map.put('3', List.of('d', 'e', 'f'));
        map.put('4', List.of('g', 'h', 'i'));
        map.put('5', List.of('j', 'k', 'l'));
        map.put('6', List.of('m', 'n', 'o'));
        map.put('7', List.of('p', 'q', 'r', 's'));
        map.put('8', List.of('t', 'u', 'v'));
        map.put('9', List.of('w', 'x', 'y', 'z'));
        List<String> res = new ArrayList<>();
        char[] part = new char[digits.length()];

        dfs(digits, 0, part, res, map);

        return res;
    }

    private void dfs(String digits, int k, char[] part, List<String> res, Map<Character, List<Character>> map) {
        if (k >= digits.length()) {
            res.add(new String(part));
            return;
        }

        List<Character> list = map.get(digits.charAt(k));
        for (Character character : list) {
            part[k] = character;
            dfs(digits, k + 1, part, res, map);
            part[k] = ' ';
        }
    }


}
