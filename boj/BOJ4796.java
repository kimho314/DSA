package boj;

public class BOJ4796 {
    static FastReader SC = new FastReader();
    static int L, P, V;
    static StringBuilder SB = new StringBuilder();

    public static void main(String[] args) {
        int cnt = 1;
        for (; ; ) {
            L = SC.nextInt();
            P = SC.nextInt();
            V = SC.nextInt();
            if (L == 0 && P == 0 && V == 0) {
                break;
            }

            int quotient = V / P;
            int remainder = V % P;
            int days = quotient * L + Math.min(remainder, L);
            SB.append("Case ").append(cnt).append(": ").append(days).append("\n");
            cnt++;
        }
        System.out.println(SB);
    }
}
