import java.util.*;

public class LetterCombinationsofaPhoneNumber {
    private List<String> res;
    private String[] digitToChar =
            {"", "", "abc", "def", "ghi", "jkl", "mno", "qprs", "tuv", "wxyz"};

    public static void main(String[] args) {
        LetterCombinationsofaPhoneNumber sol = new LetterCombinationsofaPhoneNumber();
        List<String> res = sol.letterCombinations("34");
        System.out.println(res);
        res = sol.letterCombinations("");
        System.out.println(res);
    }

    public List<String> letterCombinations(String digits) {
        res = new ArrayList<>();
        if (digits == null || digits.isEmpty()) {
            return res;
        }

        recFunc(0, "", digits);

        return res;
    }

    private void recFunc(int i, String cur, String digits) {
        if (cur.length() == digits.length()) {
            res.add(cur);
            return;
        }

        String chars = digitToChar[digits.charAt(i) - '0'];
        for (char c : chars.toCharArray()) {
            recFunc(i + 1, cur + c, digits);
        }
    }

}
