package boj;

public class BOJ1120 {
    static FastReader SC = new FastReader();
    static String A, B;

    public static void main(String[] args) {
        A = SC.next();
        B = SC.next();

        int res = A.length();
        for (int i = 0; i < B.length() - A.length() + 1; i++) {
            int cnt = 0;
            for (int j = 0; j < A.length(); j++) {
                if (A.charAt(j) != B.charAt(j + i)) {
                    cnt++;
                }
            }
            res = Math.min(res, cnt);
        }

        System.out.println(res);
    }

}
