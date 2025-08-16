

import java.util.*;

public class GenerateParentheses {
    public static void main(String[] args) {
        GenerateParentheses sol = new GenerateParentheses();
        System.out.println(sol.generateParenthesis(1));
        System.out.println(sol.generateParenthesis(3));
    }

    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        HashMap<Character, Integer> map = new HashMap<>();
        map.put('(', n);
        map.put(')', n);
        dfs(0, "", map, n * 2, res);
        return res;
    }

    private void dfs(int k, String s, Map<Character, Integer> map, int len, List<String> list) {
        if (k == len) {
            // System.out.println(s);
            if (isValid(s)) {
                list.add(s);
            }
        } else {
            for (char elem : map.keySet()) {
                if (map.get(elem) > 0) {
                    map.put(elem, map.get(elem) - 1);
                    dfs(k + 1, s + String.valueOf(elem), map, len, list);
                    map.put(elem, map.get(elem) + 1);
                }
            }
        }
    }

    private boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (char elem : s.toCharArray()) {
            if (!stack.isEmpty() && elem == ')' && stack.peek() == '(') {
                stack.pop();
                continue;
            }
            stack.push(elem);
        }

        return stack.isEmpty();
    }

    public List<String> generateParenthesis2(int n) {
        List<String> res = new ArrayList<>();
        StringBuilder stack = new StringBuilder();
        backtrack(0, 0, n, res, stack);
        return res;
    }

    private void backtrack(int openN, int closedN, int n, List<String> res, StringBuilder stack) {
        if (openN == closedN && openN == n) {
            res.add(stack.toString());
            return;
        }

        if (openN < n) {
            stack.append('(');
            backtrack(openN + 1, closedN, n, res, stack);
            stack.deleteCharAt(stack.length() - 1);
        }
        if (closedN < openN) {
            stack.append(')');
            backtrack(openN, closedN + 1, n, res, stack);
            stack.deleteCharAt(stack.length() - 1);
        }
    }
}
