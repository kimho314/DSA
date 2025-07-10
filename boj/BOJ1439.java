package boj;

public class BOJ1439 {
    static FastReader SC = new FastReader();
    static String S;

    public static void main(String[] args) {
        S = SC.nextLine();

        int cntOne = 0;
        int cntZero = 0;
        char cur = S.charAt(0);
        if (cur == '0') {
            cntZero++;
        }
        else {
            cntOne++;
        }
        
        for (int i = 1; i < S.length(); i++) {
            if (cur != S.charAt(i)) {
                cur = S.charAt(i);
                if (cur == '0') {
                    cntZero++;
                }
                else {
                    cntOne++;
                }
            }
        }

        System.out.println(Math.min(cntOne, cntZero));
    }
}
