package boj;

public class BOJ10988 {
    static FastReader SC = new FastReader();

    public static void main(String[] args) {
        String str = SC.nextLine();

        int res = isPalindrome(str);
        System.out.println(res);
    }

    private static int isPalindrome(String str) {
        boolean isPalindrome = true;
        for (int i = 0; i < str.length() / 2; i++) {
            if (str.charAt(i) != str.charAt(str.length() - 1 - i)) {
                isPalindrome = false;
                break;
            }
        }

        if (isPalindrome) {
            return 1;
        }
        else {
            return 0;
        }
    }
}
