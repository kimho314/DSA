package neetcode;

import java.util.*;

public class ValidParentheses {
    public static void main(String[] args) {
        ValidParentheses sol = new ValidParentheses();
        System.out.println(sol.solution("[]"));
        System.out.println(sol.solution("([{}])"));
        System.out.println(sol.solution("[(])"));
    }

    private boolean solution(String s) {
        ArrayDeque<Character> stack = new ArrayDeque<>();
        for (char elem : s.toCharArray()) {
            if (!stack.isEmpty() && elem == ']' && stack.peekLast() == '[') {
                stack.pollLast();
            } else if (!stack.isEmpty() && elem == ')' && stack.peekLast() == '(') {
                stack.pollLast();
            } else if (!stack.isEmpty() && elem == '}' && stack.peekLast() == '{') {
                stack.pollLast();
            } else {
                stack.addLast(elem);
            }
            // System.out.println(elem + " " + stack);
        }

        return stack.isEmpty();
    }
}
