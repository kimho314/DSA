package neetcode;

public class ValidPalindrome {
    public static void main(String[] args) {
        ValidPalindrome sol = new ValidPalindrome();
        System.out.println(sol.isPalindrome("Was it a car or a cat I saw?")); // true
        System.out.println(sol.isPalindrome("tab a cat")); // false
        System.out.println(sol.isPalindrome("123 321")); // true
    }

    public boolean isPalindrome(String s) {
        String tmp = s.replaceAll("[^0-9a-zA-Z]", "").toLowerCase();
        // System.out.println(tmp);
        int l = 0;
        int r = tmp.length() - 1;
        while (l < r) {
            if (tmp.charAt(l) != tmp.charAt(r)) {
                return false;
            }
            l++;
            r--;
        }
        return true;
    }
}
