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

    public List<String> generateParenthesis2(int n) {
        List<String> res = new ArrayList<>();
        StringBuilder stack = new StringBuilder();
        dfs2(0, 0, n, res, stack);
        return res;
    }

    private void dfs2(int openN, int closedN, int n, List<String> res, StringBuilder stack) {
        if (openN == closedN && openN == n) {
            res.add(stack.toString());
            return;
        }

        if (openN < n) {
            stack.append('(');
            dfs2(openN + 1, closedN, n, res, stack);
            stack.deleteCharAt(stack.length() - 1);
        }
        if (closedN < openN) {
            stack.append(')');
            dfs2(openN, closedN + 1, n, res, stack);
            stack.deleteCharAt(stack.length() - 1);
        }
    }


    private boolean valid(String s) {
        int open = 0;
        for (char c : s.toCharArray()) {
            open += c == '(' ? 1 : -1;
            if (open < 0)
                return false;
        }
        return open == 0;
    }

    private void dfs(String s, List<String> res, int n) {
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
