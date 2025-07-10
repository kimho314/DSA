package leetcode;

public class LCD125 {
    public static void main(String[] args) {
        LCD125 sol = new LCD125();
        System.out.println(sol.isPalindrome("A man, a plan, a canal: Panama"));
        System.out.println(sol.isPalindrome("race a car"));
        System.out.println(sol.isPalindrome(" "));
    }

    public boolean isPalindrome(String s) {
        int left = 0, right = s.length() - 1;

        while (left < right) {
            char l = s.charAt(left);
            char r = s.charAt(right);

            if (l >= 'A' && l <= 'Z')
                l += 32;
            if (r >= 'A' && r <= 'Z')
                r += 32;

            if (!((l >= 'a' && l <= 'z') || (l >= '0' && l <= '9'))) {
                left++;
                continue;
            }
            if (!((r >= 'a' && r <= 'z') || (r >= '0' && r <= '9'))) {
                right--;
                continue;
            }
            if (l != r)
                return false;
            left++;
            right--;
        }

        return true;
    }
}
