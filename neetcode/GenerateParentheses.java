package neetcode;

import java.util.*;

public class GenerateParentheses {
    public static void main(String[] args) {
        GenerateParentheses sol = new GenerateParentheses();
        List<String> res = sol.generateParenthesis(1);
        IO.println(res);
        res = sol.generateParenthesis(3);
        IO.println(res);
    }

    public boolean valid(String s) {
        int open = 0;
        for (char c : s.toCharArray()) {
            open += c == '(' ? 1 : -1;
            if (open < 0)
                return false;
        }
        return open == 0;
    }

    void dfs(String s, List<String> res, int n) {
        if (n * 2 == s.length()) {
            if (valid(s))
                res.add(s);
            return;
        }
        dfs(s + '(', res, n);
        dfs(s + ')', res, n);
    }

    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        dfs("", res, n);
        return res;
    }
}
