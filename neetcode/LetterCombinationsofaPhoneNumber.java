import java.util.*;

public class LetterCombinationsofaPhoneNumber {
    private List<String> res = new ArrayList<>();
    private String[] digitToChar =
            {"", "", "abc", "def", "ghi", "jkl", "mno", "qprs", "tuv", "wxyz"};

    public static void main(String[] args) {
        LetterCombinationsofaPhoneNumber sol = new LetterCombinationsofaPhoneNumber();
        List<String> ret = sol.letterCombinations("34");
        IO.println(ret);
        ret = sol.letterCombinations("");
        IO.println(ret);
    }

    public List<String> letterCombinations(String digits) {
        res = new ArrayList<>();
        if (digits.isEmpty()) {
            return res;
        }

        dfs(0, "", digits);

        return res;
    }

    private void dfs(int i, String curStr, String digits) {
        if (curStr.length() == digits.length()) {
            res.add(curStr);
            return;
        }

        String chars = digitToChar[digits.charAt(i) - '0'];
        for (char c : chars.toCharArray()) {
            dfs(i + 1, curStr + c, digits);
        }
    }

}
