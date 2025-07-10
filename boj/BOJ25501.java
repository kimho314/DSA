package boj;

public class BOJ25501 {
    static FastReader SC = new FastReader();
    static StringBuilder SB = new StringBuilder();
    static int T, CNT;

    public static void main(String[] args) {
        T = SC.nextInt();
        while (T > 0) {
            T--;
            CNT = 0;
            String s = SC.nextLine();
            int res = isPalindrome(s);
            SB.append(res).append(' ').append(CNT).append('\n');
        }
        System.out.println(SB.toString());
    }

    private static int recursion(String s, int l, int r) {
        CNT++;
        if (l >= r) {
            return 1;
        }
        else if (s.charAt(l) != s.charAt(r)) {
            return 0;
        }
        else {
            return recursion(s, l + 1, r - 1);
        }
    }

    private static int isPalindrome(String s) {
        return recursion(s, 0, s.length() - 1);
    }
}
