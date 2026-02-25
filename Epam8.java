import java.util.*;

/**
 * Palindrome String (Ignoring Special Characters) After converting uppercase letters to lowercase
 * and removing all non-alphanumeric characters, check whether the string is a palindrome. Input: s
 * = "A man, a plan, a canal: Panama" Processed String: amanaplanacanalpanama Output: true
 */
public class Epam8 {
    public static void main(String[] args) {
        Epam8 sol = new Epam8();
        boolean res = sol.solution("A man, a plan, a canal: Panama");
        IO.println(res);
        res = sol.solution("A ");
        IO.println(res);
        res = sol.solution("A man,");
        IO.println(res);
    }

    private boolean solution(String s) {
        String replaced = s.replaceAll("[^a-zA-z0-9]", "").toLowerCase();
        return isPalindrome(replaced);

    }

    private boolean isPalindrome(String s) {
        int l = 0;
        int r = s.length() - 1;
        while (l < r) {
            char cl = s.charAt(l);
            char cr = s.charAt(r);
            // IO.println(s + " " + l + " " + cl + " " + r + " " + cr);
            if (cl != cr) {
                return false;
            }
            l++;
            r--;
        }
        return true;
    }
}
